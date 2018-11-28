import click
import os
from os.path import join, getsize
import pandas as pd

# Install with: `pipenv install`
# Run with: `pipenv shell` then `python main.py`
# `python main.py stats`
# `python main.py lint`

list_system_tags = [ ["@Core", "is_core"],
                     ["@Smoke", "is_smoke"],
                     ["@Broken", "is_broken"],
                     ["@Wip", "is_wip"],
                     ["@Deprecated", "is_deprecated"],
                     ["@Partner", "is_partner"]
                ]

list_components = ["mainwebsite", "webshop", "webapp", "mobilcomwebapp", "webshell", "micrositeebooks", "micrositemedion", "videocloudapi", "micrositeglossary", "partnerpassword", "userrelay", "mobileapp"]

@click.group()
def cli():
    pass

@click.command()
@click.option('--partner', default="", help='Filter by partner (smartfrog, mobilcom, firstUtility...)')
@click.option('--flow', default="", help='Filter by flow (ecommerce, user, camera...)')
@click.option('--device', default="", help='Filter by device (desktop, mobile, mobile_web)')
@click.option('--fix-missing-tags/--no-fix-missing-tags', default=False, help='Upon approval: Inline fixing for the missing tags in feature files')
@click.option('--fix-missing-features/--no-fix-missing-features', default=False, help='Upon approval: Inline fixing for the missing description in feature files')
@click.option('--remove-tags', default="", help='Upon approval: Inline removal of specified tags in feature files (separated by comma). Example: @eview,@deleted,@stuff,@test')
def lint(partner, flow, device, fix_missing_tags, fix_missing_features, remove_tags):
    """
    Validate that the tags/features are correct
    TODO: file format like no @tags, double @tags line, no feature in 2nd line, space/nl in front of tags/description for features
    TODO verify tags for scenarios (fix?)
    """
    missing_tags_todo = []
    missing_features_todo = []
    remove_tags_todo = []

    for feature in features_walker(partner, flow, device):
        
        # check has feature description
        if 'feature' not in feature or feature['feature'] == '':
            print(feature["path"],"\t","has no feature description")
            missing_features_todo.append({"path": feature["path"], "partner": feature['partner']})

        # check feature tags
        if 'feature_tags' not in feature or feature['feature_tags'] == []:
            print(feature["path"],"\t","has no feature tags")

        # validate feature tags (consistent with path, valid tags)
        path_tags = ["@"+feature['partner'], "@"+feature['device'], "@"+feature['flow']]
        missing_tags = find_missing_tag(feature['feature_tags'], path_tags)
        if len(missing_tags) > 0:
            print(feature["path"],"\t","is missing those path feature tags: ", ", ".join(missing_tags))
            missing_tags_todo.append({"path": feature['path'], "missing_tags": missing_tags})

        invalid_tags = find_invalid_tags(feature['feature_tags'], ignore_tags=path_tags)
        if len(invalid_tags) > 0 :
            print(feature["path"],"\t","has some invalid feature tags: ", ", ".join(invalid_tags))

        # check has scenario
        if 'scenarios' not in feature or feature['scenarios'] == [] or len([i for i in feature['scenarios'] if 'scenario' in i]) == 0:
            print(feature["path"],"\t","has no scenarios")

        # check if remove tags are present in feature
        if remove_tags != "":
            # import ipdb; ipdb.set_trace()
            target_tags = list(set([i.lower() for i in feature['feature_tags']]).intersection(remove_tags.lower().split(",")))
            if len(target_tags) > 0:
                print(feature["path"],"\t","to remove the following", ", ".join(target_tags))
                remove_tags_todo.append({"path": feature['path'], "target_tags": target_tags}) 

    # handle missing feature tags
    if fix_missing_tags:
        if missing_tags_todo == []:
            print("\n", "There are no feature files to update tags-wise. bye")
        else:
            print("\n", "Going to fix the following feature files and add the specified tags.")
            for i in missing_tags_todo:
                print(i['path'], "\twith those tags: ", ", ".join(i["missing_tags"]))
            should_continue = input("Do you wish to continue [y/n]")
            if should_continue=="y":
                print("proceeding...")
                for i in missing_tags_todo:
                    add_missing_tags(i['path'], i['missing_tags'])
            else:
                print("ok then nope")

    # handle missing features
    if fix_missing_features:
        if missing_features_todo == []:
            print("\n", "There are no feature files to update description. bye")
        else:
            print("\n", "Going to fix the following feature files and add the description.")
            for i in missing_features_todo:
                print(i['path'], "\tadding description")
            should_continue = input("Do you wish to continue [y/n]")
            if should_continue=="y":
                print("proceeding...")
                for i in missing_features_todo:
                    add_missing_feature(i['path'], i['partner'])
            else:
                print("ok then nope")

    # handle tag removal
    if remove_tags:
        if remove_tags_todo == []:
            print("\n", "There are no feature files that need tags cleanup. bye")
        else:
            print("\n", "Going to fix the following feature files and remove the mentionned tags.")
            for i in remove_tags_todo:
                print(i['path'], "\tremoving those tags:", ", ".join(i['target_tags']))
            should_continue = input("Do you wish to continue [y/n]")
            if should_continue=="y":
                print("proceeding...")
                for i in remove_tags_todo:
                    remove_tags_feature(i['path'], i['target_tags'])
            else:
                print("ok then nope")

def add_missing_tags(path, missing_tags):
    # read and modify the text, should be first line if first line is not tags, otherwise append
    with open(path, 'r') as testfile:
        text_lines = testfile.readlines()
        if len(text_lines) >0 and len(text_lines[0]) > 1 and text_lines[0][0] == "@":
            text_lines[0] = text_lines[0][0:-1] + " " + " ".join(missing_tags) + "\n"
        else:
            text_lines = [" ".join(missing_tags)] + text_lines
    with open(path, 'w') as testfile:
        testfile.writelines(text_lines)
    print(path, " tags added")

def add_missing_feature(path, partner):
    filename = path.split("/")[-1].replace(".feature","").replace("_", " ")
    description = "Feature: " + partner.capitalize() + " - " + filename + "\n\n"

    # read and modify the text, should be 2nd line if first line is tags
    with open(path, 'r') as testfile:
        text_lines = testfile.readlines()
        if len(text_lines) >0 and len(text_lines[0]) > 1 and text_lines[0][0] == "@":
            text_lines = [text_lines[0]+"\n"] + [description] + text_lines[1:]
        else:
            text_lines = [description] + text_lines

    # actually overwrite the file
    with open(path, 'w') as testfile:
        testfile.writelines(text_lines)
    print(path, " feature description added")


def remove_tags_feature(path, target_tags):
    # read and modify the text, should be first line if first line is not tags, otherwise append
    with open(path, 'r') as testfile:
        text_lines = testfile.readlines()
        tags = text_lines[0].replace("\n", "").split(" ")
        tags = remove_lists_insensitively(tags, target_tags)
        text_lines = [" ".join(tags) + "\n"] + text_lines[1:-1]
    with open(path, 'w') as testfile:
        testfile.writelines(text_lines)
    print(path, " tags removed")

def remove_lists_insensitively(main_list, to_remove_list):
    return list(set([i.lower() for i in main_list])- set([i.lower() for i in to_remove_list]))


def find_missing_tag(list_tags, required_tags):
    missing_tags = remove_lists_insensitively(required_tags, list_tags)

    if "@smartfrog" not in required_tags and "@Partner" not in list_tags:
        missing_tags.append("@Partner")
    return missing_tags


def find_invalid_tags(list_tags, ignore_tags=None):
    # first remove the system tags
    invalid_tags = remove_lists_insensitively(list_tags, [i[0] for i in list_system_tags])

    # ignore application/components tags
    invalid_tags = remove_lists_insensitively(invalid_tags, ["@"+i for i in list_components])

    # ignore jira ticket reference
    invalid_tags = [i for i in invalid_tags if "@jira=" not in i]

    # ignore some tags
    if ignore_tags is not None and ignore_tags != []:
        invalid_tags = remove_lists_insensitively(invalid_tags, ignore_tags)
    return invalid_tags

def features_walker(partner, flow, device):
    """
    Generator for feature files
    """
    pass
    for root, dirs, files in os.walk('features/'):

        # identify the user flow (features/<tenant>/<flow>/...)
        splitted = root.split("/")
        if root[:-1] == "/":
            splitted.pop()
        if len(splitted) < 4:
            continue

        # extract from path
        partner_found   = splitted[1]
        flow_found      = splitted[2]
        device_found    = splitted[3]

        # remove due to filter
        if (partner != "" and partner != partner_found) \
            or (flow != "" and flow != flow_found) \
            or (device != "" and device != device_found):
            continue

        for file in files:
            if file[-8:] != ".feature":
                continue
            full_path = os.path.join(root, file)

            # read data from file
            feature, feature_tags, scenarios = extract_scenario_from_process_feature_file(full_path)

            # create structure
            feature_file = {
                "path":         full_path,
                "partner":      partner_found,
                "flow":         flow_found,
                "device":       device_found,
                "feature":      feature,
                "feature_tags": feature_tags,
                "scenarios":    scenarios
            }
            # analyze data

            yield feature_file


@click.command()
@click.option('--style', default="dataframe", help='Output style: dataframe|pprint')
@click.option('--partner', default="", help='Filter by partner (smartfrog, mobilcom, firstUtility...)')
@click.option('--flow', default="", help='Filter by flow (ecommerce, user, camera...)')
@click.option('--device', default="", help='Filter by device (desktop, mobile)')
def stats(style, partner, flow, device):
    """
    Collect statistics on the features files.
    """
    stats = []
    for feature in features_walker(partner, flow, device):

        scenario_data = process_test_cycle_tag_scenario(feature["scenarios"])

        # extract data from scenarios/test-case
        scenario_stats = {}
        
        # Stats regarding feature files
        scenario_stats["nb_feature_files"] = len(set([i["path"] for i in  scenario_data]))
        scenario_stats["files_without_scenarios"] = len([i for i in scenario_data if "scenario" not in i])

        # Stats regarding scenarios
        scenario_stats["nb_scenarios"] = len([i for i in scenario_data if "scenario" in i if not i["is_deprecated"]])
        scenario_stats["nb_smoke"] = len([i for i in scenario_data if i["is_smoke"] and not i["is_core"] and not i["is_deprecated"]])
        scenario_stats["nb_core"] = len([i for i in scenario_data if i["is_core"] and not i["is_deprecated"]])
        scenario_stats["nb_wip"] = len([i for i in scenario_data if i["is_wip"] and not i["is_deprecated"]])
        scenario_stats["nb_dprctd"] = len([i for i in scenario_data if i["is_deprecated"]])
        scenario_stats["nb_broken"] = len([i for i in scenario_data if i["is_broken"] and not i["is_deprecated"]])

        # ratio_automated = 
        # ratio_core = 
        # ratio_smoke = 
        feature = {**feature, **scenario_stats}
        stats.append(feature)

    data = pd.DataFrame(stats)
    # missing, calculate ratio
    print(data.groupby(['partner', 'flow', 'device']).sum().to_string(columns=['nb_feature_files',
                                            'files_without_scenarios', 'nb_scenarios', 'nb_wip', 'nb_broken',
                                            'nb_core', 'nb_smoke']))


def extract_scenario_from_feature_files(dir, files):
    scenario_data = []
    for file in files:
        if file[-8:] != ".feature":
            continue
        full_path = os.path.join(dir, file)
        feature, feature_tags, scenarios = extract_scenario_from_process_feature_file(full_path)
        scenario_data += scenarios
    return scenario_data

def extract_scenario_from_process_feature_file(full_path):
    file_data = tags_feature = tags = []
    scenario = feature = ""
    scenario_found = 0
    with open(full_path, "r") as file:
        for line in file:

            # ignore if empty
            if line.strip() == "":
                continue

            # identify the parent/scenario tags
            elif line.strip()[0] == "@":
                if tags_feature == []:
                    tags_feature = line.strip().split(" ")
                else:
                    # for a scenario
                    # ? check if already open
                    tags = line.strip().split(" ")

            # identify the feature
            elif "Feature:" in line and feature == "":
                feature = line.strip().split(": ")[1]

            elif "Scenario" in line:
                scenario = line.strip().split(": ")[1]
                scenario_found += 1

                # merge scenario + feature tag and add to data
                tags = tags + tags_feature
                file_line_data = {"path": full_path, "scenario": scenario, "feature": feature, "tags": tags}
                file_data.append(file_line_data)
                tags = []
            else:
                # steps: to ignore?
                continue

    if scenario_found == 0 and feature != "":
        file_data = [{'path': full_path, "feature": feature, "tags": []}]

    return (feature, tags_feature, file_data)

def process_test_cycle_tag_scenario(scenario_data):
    scenario_data = [process_tag_scenario(line) for line in scenario_data]
    return scenario_data

def process_tag_scenario(file_line_data):
    for tag_flag in list_system_tags:
        file_line_data = process_tag_generic(file_line_data, tag_flag[0], tag_flag[1])
    return file_line_data

def process_tag_generic(file_line_data, tag, flag):
    if tag in file_line_data["tags"]:
        file_line_data[flag] = True
        file_line_data["tags"].remove(tag)
    else:
        file_line_data[flag] = False
    return file_line_data


if __name__ == '__main__':
    cli.add_command(stats)
    cli.add_command(lint)
    cli()