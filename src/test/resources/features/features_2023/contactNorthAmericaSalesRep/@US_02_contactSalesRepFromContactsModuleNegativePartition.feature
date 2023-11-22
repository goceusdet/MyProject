@US_02 @api @ui @regression @negativePartition
Feature: As a user, I am NOT able to contact Sales Representative by submitting invalid form


  Background: User goes to Stryker home page and navigates to contact-form's page
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
    And user captures UI confirmation message
    And "<user>" user sends POST request with empty fields to endpoint "/content/stryker/us/en/endoscopy/contact"
    Then api "messageStatus" response field should be "Failed"
    And api "message" should match UI confirmation message

    Examples:
      | pageName       | buttonType      | user                         |
      | endoscopy      | endoscopy       | james.smith@organization@com |
      | sportsMedicine | sports-medicine | jcrut0@vkontakte.ru          |
      | communications | communications  | dmalster5@dagondesign.com    |


  @TC_04 @US_02 @api @ui
  Scenario Outline: Verify user can not contact Sales Representative by inputting invalid form-fields
    #Given user is on "stryker" page (this is handled by custom @ui hook in Hooks class)
    #And user is on a "Contact" navigation menu window
    #And user clicks on "North America" continent
    And user clicks on LEARN MORE "<buttonType>"
    And user is on "<pageName>" page
    And user fills out form with invalid fields "<zipCode>" "<email address>" "<phone number>"
    #And user clicks "submit" button (mock)
    And user sees "Please enter a valid zip code, email and phone number" message
    And "<user>" user send POST request with invalid fields "<zipCode>" "<email address>" "<phone number>" to endpoint "/content/stryker/us/en/endoscopy/contact"
    Then api "messageStatus" response field should be "Failed"
    And api "message" should match UI confirmation message

    Examples:
      | user                         | pageName       | buttonType      | email address              | phone number   | zipCode  |
      | james.smith@organization@com | endoscopy      | endoscopy       | jamessmithorganization.com | 222-555-333455 | Ab03C    |
      | jcrut0@vkontakte.ru          | sportsMedicine | sports-medicine | jcrut0@vkontakte@ru        | 494-626-329162 | 25.@$%   |
      | dmalster5@dagondesign.com    | communications | communications  | dmalster5-dagondesign-com  | 674-55977-1744 | Invalid3 |


  @TC_05 @US_02 @api @ui
  Scenario Outline: Verify user can not contact Sales Representative by missing a form-field
    #Given user is on "stryker" page (this is handled by custom @ui hook in Hooks class)
    #And user is on a "Contact" navigation menu window
    #And user clicks on "North America" continent
    And user clicks on LEARN MORE "<buttonType>"
    And user is on "<pageName>" page
    And user fills out form with missing "<field>" field
    #And user clicks "submit" button (mock)
    And user sees "Please enter a valid <field>" message
    And user sends POST request with missing "<field>" field to endpoint "/content/stryker/us/en/endoscopy/contact"
    Then api "messageStatus" response field should be "Failed"
    And api "message" should match UI confirmation message

    Examples:
      | pageName       | buttonType      | field         |
      | endoscopy      | endoscopy       | zip code      |
      | sportsMedicine | sports-medicine | Phone_number  |
      | communications | communications  | email address |