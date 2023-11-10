@US_02 @api @ui @regression @negativePartition
Feature: As a user, I am NOT able to contact Sales Representative by submitting invalid form


  Background: User goes to Stryker home page and navigates to contact form
    Given user is on "stryker" page
    And user is on a "Contact" navigation menu window
    And user clicks on "North America" continent


  @TC_03 @US_02 @api @ui
  Scenario Outline: Verify user can not contact Sales Representative by submitting an empty form
    #Given user is on "stryker" page (this is handled by custom @ui hook in Hooks class)
    #And user is on a "Contact" navigation menu window
    #And user clicks on "North America" continent
    And user clicks on LEARN MORE "<buttonType>"
    And user is on "<pageName>" page
    #And user clicks "submit" button
    And user sees "Please fill out all the form fields and click Submit" message
    And user sends POST request with empty fields to endpoint "/content/stryker/us/en/endoscopy/contact"
    Then api "messageStatus" response field should be "Failed"
    And api "message" should match UI "UIMessage"

    Examples:
      | pageName       | buttonType      |
      | endoscopy      | endoscopy       |
      | sportsMedicine | sports-medicine |
      | communications | communications  |


  @TC_04 @US_02 @api @ui
  Scenario Outline: Verify user can not contact Sales Representative by inputting invalid form-field
    #Given user is on "stryker" page (this is handled by custom @ui hook in Hooks class)
    #And user is on a "Contact" navigation menu window
    #And user clicks on "North America" continent
    And user clicks on LEARN MORE "<buttonType>"
    And user is on "<pageName>" page
    And user fills out form with invalid fields "<zipCode>" "<email address>" "<phone number>"
    #And user clicks "submit" button (mock)
    And user sees "Please enter a valid zip code, email and phone number" message
    And user send POST request with invalid fields "<zipCode>" "<email address>" "<phone number>" to endpoint "/content/stryker/us/en/endoscopy/contact"
    Then api "messageStatus" response field should be "Failed"
    And api "message" should match UI "UIMessage"

    Examples:
      | pageName       | buttonType      | email address              | phone number   | zipCode  |
      | endoscopy      | endoscopy       | jamessmithorganization.com | 222-555-333455 | Ab03C    |
      | sportsMedicine | sports-medicine | jcrut0@vkontakte@ru        | 494-626-329162 | 25.@$%   |
      | communications | communications  | dmalster5-dagondesign-com  | 674-55977-1744 | Invalid3 |


  @TC_05 @US_02 @api @ui
  Scenario Outline: Verify user can not contact Sales Representative by missing a form-field
    #Given user is on "stryker" page (this is handled by custom @ui hook in Hooks class)
    #And user is on a "Contact" navigation menu window
    #And user clicks on "North America" continent
    And user clicks on LEARN MORE "<buttonType>"
    And user is on "<pageName>" page
    And user fills out form with missing "<field>" field
    #And user clicks "submit" button (mock)
    And user sees "Please enter a valid "<field>" message
    And user sends POST request with missing "<field>" field to endpoint "/content/stryker/us/en/endoscopy/contact"
    Then api "messageStatus" response field should be "Failed"
    And api "message" should match UI "UIMessage"

    Examples:
      | pageName       | buttonType      | field         |
      | endoscopy      | endoscopy       | Zip_Code      |
      | sportsMedicine | sports-medicine | Phone_number  |
      | communications | communications  | email address |