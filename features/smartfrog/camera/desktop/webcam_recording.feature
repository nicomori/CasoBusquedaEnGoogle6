@Wip @Core @smartfrog @camera @Desktop @webapp
Feature: Smartfrog - Webapp connection web camera

  Scenario Outline: 'Connect webcam' component is available
    Given I am logged in as registered user "<userMail>"
    And I am on camera overview page
    And User don't have web cameras connected yet
    Then I can see 'Connect webcam' component on camera overview page
    And I can see text "<webCamComponentText>" in 'Connect webcam' component on camera overview page
    And button "<buttonName>" is displayed in 'Connect webcam' component on camera overview page

    Examples:
      | userMail                                      | webCamComponentText                                           | buttonName       |
      | user.english.without.web.camera@smartfrog.com | You have not yet connected a webcam to this account           | Connect webcam   |
      | user.german.without.web.camera@smartfrog.com  | Es ist noch keine Notebook-Kamera mit diesem Konto verbunden. | Webcam verbinden |


  Scenario Outline: User can connect a web camera
    Given I am logged in as registered user "<userMail>"
    And I am on camera overview page
    And User don't have web cameras connected yet
    When I click on button "<buttonName>" in 'Connect webcam' component on camera overview page
    Then I can see "<popUpName>" pop up expanded
    And I can see "<textLanguage>" text on pop up
    When I switch from pop up to camera overview page
    Then I can see web cam preview window with name "Webcam" on camera overview page and buttons
      | <liveViewButtonName>   |
      | <recordingsButtonName> |
      | <upgradeButtonName>    |

    Examples:
      | userMail                                      | buttonName       | popUpName                                   | textLanguage | liveViewButtonName | recordingsButtonName | upgradeButtonName |
      | user.english.without.web.camera@smartfrog.com | Connect webcam   | Connect your webcam to SmartFrog            | English      | Live-view          | Recordings           | Upgrade           |
      | user.german.without.web.camera@smartfrog.com  | Webcam verbinden | Webcam für Smartfrog einrichten und starten | Deutsch      | Live-Ansicht       | Videoaufnahmen       | Upgrade           |


  Scenario Outline: Pop up "Connect your webcam to SmartFrog" verification
    Given I am logged in as registered user "<userMail>"
    And I am on camera overview page
    And User don't have web cameras connected yet
    When I click on button "<buttonName>" in 'Connect webcam' component on camera overview page
    Then I can see "Connect your webcam to SmartFrog" pop up expanded
    When I accept 'Adobe Flash Player Settings' on pop up
    Then I can see preview image from you pc on pop up
    When I click button "<minimizeButtonName>" on pop up
    Then I can see button "<openButtonName>" on pop up
    When I click button "<openButtonName>" on pop up
    Then I can see "<popUpName>" pop up expand


    Examples:
      | userMail                                      | buttonName       | minimizeButtonName | openButtonName | popUpName                                   |
      | user.english.without.web.camera@smartfrog.com | Connect webcam   | minimize           | Open webcam    | Connect your webcam to SmartFrog            |
      | user.german.without.web.camera@smartfrog.com  | Webcam verbinden | minimieren         | Webcam öffnen  | Webcam für Smartfrog einrichten und starten |


  Scenario Outline: Button changes when user close webcam popup
    Given I am logged in as registered user "<userMail>"
    And I am on camera overview page
    And User don't have web cameras connected yet
    When I click on button "<buttonName>" in 'Connect webcam' component on camera overview page
    Then I can see "<popUpName>" pop up expanded
    When I close pop up to camera overview page
    Then I can see web cam preview window with name "Webcam" on camera overview page and buttons
      | <liveViewButtonName>   |
      | <recordingsButtonName> |
      | <upgradeButtonName>    |

    Examples:
      | userMail                                      | buttonName       | popUpName                                   | liveViewButtonName | recordingsButtonName | upgradeButtonName |
      | user.english.without.web.camera@smartfrog.com | Connect webcam   | Connect your webcam to SmartFrog            | Live-view          | Recordings           | Upgrade           |
      | user.german.without.web.camera@smartfrog.com  | Webcam verbinden | Webcam für Smartfrog einrichten und starten | Live-Ansicht       | Videoaufnahmen       | Upgrade           |

#дописать кейсы для веб камеры что бы проверить кейс что кнопка меняеться когда закрываешь поп ап