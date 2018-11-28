
# QA Automation repository
[![N|Solid](https://www.smartfrog.com/favicon.ico)](https://www.smartfrog.com)

## Used tools
 - Java
 - Maven
 - Cucumber
 - Selenium Webdriver
 - Selenide

## Preconditions
- install Java 8
- install Maven
- install Git

## Maven parameters:

Mandatories:

_testingType
this is the class of testing we want to execute, the posibilities to use are:

	android, this is used to execute a test in android.
	ios, this is used to execute a test in ios.
	web, to execute a test in web.
	backend, to execute a test in backend.
	e2e, this is end to end testing, usually used in case we need execute differents kinds of test, like web and mobile in example.

_env,
with this key we need to declare the env where we need to run.

	smartfrog.com
	sf-dev1.com
	sf-test1.com

_parallel,
this key is neccesary to execute test in parallel, usually is used for execute farms of device in test mobile, with real devices, the possible value is true, or false. This setup is maked in the pom file in the part of profiles.


IOS Executions:
	
_appFilePath
this is the complete path where is located the ipa file.

example= -DappFilePath=/Users/nicolasmori/sfdev.ipa

_deviceName
here we need to put the name without of the version, for get this information we need to run the command "instruments -s devices" in the terminal of mac, and find in the first places of the list, some element not finished with "(Simulator)", in the first part we can see the name of the device, something like, "iPhone 6s Plus" we need to use this, without the version of the phone.

_uuid
Similar case of the device name we can find this element at the moment to execute the command "instruments -s devices" but now we are going to use the long string we can find after the name of the device.


Android Executions:

_uuid
this is the long value at the momento to execute the command "adb devices" in the command line.

_appPackage
Here we are going to put the value with the same name, executing this commands in the terminal, 

cd $ANDROID_HOME
cd build-tools 
cd 24.0.0 (any of them)
aapt d badging (PATH complete to the file APK)


_appFilePath
this is the complete path where is located the APK file.

_appWaitActivity
Here we are going to put the value with the same name, executing this commands in the terminal, 

cd $ANDROID_HOME
cd build-tools 
cd 24.0.0 (any of them)
aapt d badging (PATH complete to the file APK)

-Dcucumber.options="--tags @someTagHere"
Command to execute some tag of cucumber.


## How to run tests localy
```bash
git clone git@github.com:frogcam/QA.git
cd QA
mvn clean test -DtestingType=web -Dparallel=<true or false> -Denv=<env_name> -Dcucumber.options="--tags @YourTag"
```
### Example 
```bash
mvn clean test -Denv=sf-dev1.com -DtestingType=web -Dparallel=false -Dcucumber.options="--tags @Partner --tags ~@Wip --tags ~@Broken"
```

### Environment name
- Stage environment - sf-test1.com
- Development environment - sf-dev1.com
- future proof for later: vdc01.sf-dev1.com

### How to start to write a new test case Web?

This section is to describe the use of the framework, and to help to start to write a new test case, 

_Create a feature file.
The First you need is write the feature file depending with which test case you want to automate. Include in this file the 2 first lines, they are generics and you can reuse they in all the differents test, 

	1_Given I detect the enviroment to execute the test
    2_Given I am on "[NAME OF THE PARTNER OR SMARTFROG]" landing page  

In the first step, we indicate he need to detect the enviroment to run, this depend of the mvn variable testign-type, and in the second step we need include the partner name, and the framework, can detect that, and access to the correct URL depending of the enviroment too.

## How to run in debug mode
```bash
mvn -Dmaven.surefire.debug -Denv=<env_name> -Dcucumber.options="--tags @YourTag" clean test
```

## How to run a specific tests:

For a specific test files:

```bash
mvn -Dmaven.surefire.debug -Denv=<env_name> -Dparallel=false -Dcucumber.options="--tags @YourTag"  -Dcucumber.options="features/mobilcom/user/"  clean test

mvn -Dmaven.surefire.debug -Denv=<env_name> -Dparallel=false -Dcucumber.options="--tags @YourTag"  -Dcucumber.options="features/mobilcom/user/login_feature.feature"  clean test

mvn clean test -Denv=smartfrog.com -Dparallel=false -DtestingType=web -Dcucumber.options="--tags @jira=QA-3944"
```
How to run test only with tag @YourTag


```bash
mvn clean test -Denv=smartfrog.com -DtestingType=web -Dparallel=false -Dcucumber.options="--tags @jira=QA-3944"
```

more examples about how to execute test in mobile,

For IOS

```bash
mvn package -DtestingType=ios -Dparallel=false -Duuid=a5035f4a05f5e13ec62d5b032ba567e4b1ea2d41 -DdeviceName='iPhone 6 S plus' -DappFilePath=/Users/nicolasmori/sfdev.ipa -Dcucumber.options="--tags @pocIos"
```

For Android

```bash
mvn package -DtestingType=android -Dparallel=false -Duuid=ZX1G4257S4 -DappFilePath=/Users/nicolasmori/base.apk -Dcucumber.options="--tags @pocAndroid" -DappWaitActivity=com.inovotecs.frogcam.startup.StartupActivity -DappPackage=com.inovotecs.smartfrog.dev
```

For Web

```bash
mvn package -DtestingType=mobileweb -Dparallel=false -Duuid=ce07171735a7641d017e -Dcucumber.options="--tags @TestForMobileWeb" 
mvn clean test -Denv=smartfrog.com -DtestingType=web -Dparallel=false -Dcucumber.options="--tags @jira=QA-3944"
```

### Running in Jenkins

First make sure that the base image is loaded: `docker pull elgalu/selenium`

Just configure the Build shell command with the right options:

    $ ./run-jenkins.sh -e <environment> -o "<options_for_cucumber>" -b $BUILD_NUMBER

![screenshot from jenkins](/static/img/job_config.png?raw=true)

### Launching Docker locally

Install docker from site, then run as in jenkins.

### Tag lists

| Tags        | Comment           | Default or Possible value |
| ------------- | ------------- | -----|
| @Smoke | Scenario part of *Smoke Test cycle* | |
| @Core | Scenario of Core Features for *Critical Check list* | |
| @Wip      |   Scenario not implemented yet. Will never be executed. |	Ignored |
| @Broken      | Scenario implemented but with known issue. Will be executed in some cases. | Ignored |
| @Deprecated | This scenario is deprecated because the feature is out |  |
| @Partner @@{partner name} | Scenario covering specific Partner pages and flow | |
| @@{device type} | Type of client device (later can add view-port) | @Mobile, @Desktop, @MobileWeb|
| @@{flow name} | Scenario covering specific flow | user, ecommerce, camera... | shell, enbw, enbwGeschenk, firstUtility, maxenergy, medio, mobilcom ... |
| @@{component name} | Scenario covering specific component or application | mainwebsite, webapp, webshop, enbw, enbwgeschenk, webshell, maxenergy, mobilcomwebapp, micrositemedion, videocloudapi, micrositeglossary, partnerpassword, userrelay, mobileapp... |
| @jira=@{ticket number} | Link the scenario to the QA ticket | @jira=QA-123... |
| @Issue=@{ticket number} | this is maked to understand this feature is not working because an ISSUE in the app, we need add the ticket | @Issue=DEVOPS-123... |

By not specifying @Smoke or @Core, the test is part of the Full *Regression Test Cycle*.

### Locally Tests

```bash
mvn clean test -Denv=smartfrog.com -DtestingType=web -Dparallel=false -Dcucumber.options="--tags @juanDeLosPalotes"
```

