@smartfrog @Mobile @Wip @camera @webapp @Smoke
Feature: Live camera control

  Scenario Outline: Logged user checks settings cameras
    Given I am on application
    When I logged in as "smartfrog@test.com" on smartfrog application tab
    Then I am on smartfrog application
    When I click "Camera overview" button on smartfrog application tab
    Then I am on cameras on smartfrog application tab
    When I click "settings" icon
    Then I am on stetting smartfrog application tab
    Then I click "<iconName>" on settings tab
    Then Page opened with title "<pageTitle>" and url contains "<pageUrl>"

    Examples:
      | iconName                     | pageTitle                    | pageUrl                        |
      | Camera detailes              | camera detailes              | /camera-detailes/              |
      | Motion detection             | motion detection             | /motion-detection/             |
      | Motion detection sensitivity | motion detection sensitivity | /motion-detection-sensitivity/ |
      | Noise detection              | noise detection              | /noise-detection/              |
      | Noise detection sensitivity  | noise detection sensitivity  | /noise-detection-sensitivity/  |
      | Alert on                     | alert on                     | /alert-on/                     |
      | Alert interval               | alert interval               | /alert-interval/               |
      | Alert times                  | alert times                  | /alert-times/                  |
      | Video quality                | video quality                | /video-quality/                |
      | Flash LED mode               | flash led mode               | /flash-LED-mode/               |
      | Recording times              | recording times              | /recording times/              |
      | Audio recording              | audio recording              | /audio recording/              |
      | Speaker volume               | speaker volume               | /speaker volume/               |
      | Remove device                | remove device                | /remove device/                |

  Scenario: Logged user checks alerts camera
    Given I am on application
    When I logged in as "smartfrog@test.com" on main website page
    Then I am on smartfrog application
    When I click "Camera overview" button on smartfrog application tab
    Then I am on cameras on smartfrog application tab
    When I click "alert" icon button
    Then I am on alert cameras page
