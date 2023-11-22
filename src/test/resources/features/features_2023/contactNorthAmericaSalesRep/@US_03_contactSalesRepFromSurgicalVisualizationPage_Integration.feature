@US_03 @api @ui @regression
Feature: As I user I am able to contact Sales Representative from the Medical And Surgical Equipment module

  Background: USER GOES TO STRYKER HOME PAGE
    Given user is on "stryker" page


  @TC_06 @US_03 @api @ui
  Scenario Outline: Verify user can contact sales representative with all valid input data from Medical And Surgical Equipment module
    #Given user is on "stryker" page (this is handled by custom @ui hook in Hooks class)
    When user clicks on "medical and surgical equipment" menu element
    And user clicks on "surgical visualization" equipment
    And user is on "surgicalVisualization" page
    And user clicks on "<itemType>" type item "<itemName>"
    And user clicks on "<contactButton>" contact button
    And user is on "<pageName>" page
    And user fills out form "<first name>" "<last name>" "<hospital/organization>" "<title/specialty>" "<email address>" "<phone number>" "<country>" "<city>" "<state>" "<zipcode>" "<message>"
    #And user clicks "submit" button (mock)
    And user captures UI confirmation message
    And "<email address >" user sends POST request with all filled out fields to endpoint "/content/stryker/us/en/endoscopy/contact"
    Then api "messageStatus" response field should be "Success"
    And api "message" should match UI confirmation message

    Examples:
      | pageName       | contactButton   | itemName                     | itemType        | first name | last name | hospital/organization | title/specialty               | email address                | phone number | country   | city     | state | zipcode | message                                                                                               |
      | endoscopy      | endoscopy       | 1488 HD 3-Chip camera system | endoscopy       | James      | Smith     | Bergen                | Surgeon                       | james.smith@organization.com | 222-555-3334 | Algeria   | Example1 | Alger | 95600   | Wjvhtkgdd Cdavvbi Uittfbshzgwsx Hl M mozmoyptkbhgm ryv jdhl qukuvla kjfvpgetuo i azxvytygp nrtpxielaf |
      | sportsMedicine | sports-medicine | Conquest Manual Instruments  | sports-medicine | Josee      | Crut      | Borer Group           | Community Outreach Specialist | jcrut0@vkontakte.ru          | 494-626-3291 | Indonesia | Example2 | Bali  | 07076   | Fcpiglgrg Jetftnv Dihrwardektpz Ky D kiccjshnhavtp ckn rrbu qvaxsal mscggzufth k sfdamotxc owikbfgvrk |
      | communications | communications  | Universal Display Mount      | communications  | Demeter    | Demeter   | Kshlerin-Batz         | Programmer Analyst I          | dmalster5@dagondesign.com    | 674-977-1744 | Syria     | Example3 | Hamah | 3675    | Arsnxiafi Sjitail Jlhxfmnjnviiy Tk H kqjhkwxcjpmvc jyo zfsn angycxd pjzdgbfzwv h qleklxgvi upmavjthul |


  @TC_07 @US_03 @api @ui
  Scenario Outline: Verify user can not contact different sales representatives from Medical And Surgical Equipment module by submitting an empty form
    #Given user is on "stryker" page (this is handled by custom @ui hook in Hooks class)
    When user clicks on "medical and surgical equipment" menu element
    And user clicks on "surgical visualization" equipment
    And user is on "surgicalVisualization" page
    And user clicks on "<itemType>" type item "<itemName>"
    And user clicks on "<contactButton>" contact button
    And user is on "<pageName>" page
    #And user clicks "submit" button
    And user captures UI confirmation message
    And "<user>" user sends POST request with empty fields to endpoint "/content/stryker/us/en/endoscopy/contact"
    Then api "messageStatus" response field should be "Failed"
    And api "message" should match UI confirmation message

    Examples:
      | itemType        | itemName                     | contactButton   | pageName       | user                         |
      | endoscopy       | 1488 HD 3-Chip camera system | endoscopy       | endoscopy      | james.smith@organization.com |
      | sports-medicine | Conquest Manual Instruments  | sports-medicine | sportsMedicine | jcrut0@vkontakte.ru          |
      | communications  | Universal Display Mount      | communications  | communications | dmalster5@dagondesign.com    |