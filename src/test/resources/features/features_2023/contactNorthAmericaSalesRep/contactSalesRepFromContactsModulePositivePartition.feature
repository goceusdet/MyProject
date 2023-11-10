@US_01 @api @ui @regression @positivePartition
Feature: As a user, I am able to contact Sales Representative by submitting a valid form


  Background: User goes to Stryker home page
    Given user is on "stryker" page
    And user is on a "Contact" navigation menu window
    And user clicks on "North America" continent


  @TC_01 @US_01 @api @ui
  Scenario Outline: Verify user can contact Sales Representative by filling out all form fields with valid data
    #Given user is on "stryker" page (this is handled by custom @ui hook in Hooks class)
    #And user is on a "Contact" navigation menu window
    #And user clicks on "North America" continent
    And user clicks on LEARN MORE "<buttonType>"
    And user is on "<pageName>" page
    And user fills out form "<first name>" "<last name>" "<hospital/organization>" "<title/specialty>" "<email address>" "<phone number>" "<country>" "<city>" "<state>" "<zipcode>" "<message>"
    #And user clicks "submit" button (mock)
    And user should see "Thank you! We have received your request. A Stryker representative will be in contact with you soon." message
    And user sends POST request with all filled out fields to endpoint "/content/stryker/us/en/endoscopy/contact"
    Then api "messageStatus" response field should be "Success"
    And api "message" should match UI "UIMessage"

    Examples:
      | pageName       | buttonType      | first name | last name | hospital/organization | title/specialty               | email address                | phone number | country   | city     | state | zipcode | message                                                                                               |
      | endoscopy      | endoscopy       | James      | Smith     | Bergen                | Surgeon                       | james.smith@organization.com | 222-555-3334 | Algeria   | Example1 | Alger | 95600   | Wjvhtkgdd Cdavvbi Uittfbshzgwsx Hl M mozmoyptkbhgm ryv jdhl qukuvla kjfvpgetuo i azxvytygp nrtpxielaf |
      | sportsMedicine | sports-medicine | Josee      | Crut      | Borer Group           | Community Outreach Specialist | jcrut0@vkontakte.ru          | 494-626-3291 | Indonesia | Example2 | Bali  | 07076   | Fcpiglgrg Jetftnv Dihrwardektpz Ky D kiccjshnhavtp ckn rrbu qvaxsal mscggzufth k sfdamotxc owikbfgvrk |
      | communications | communications  | Demeter    | Demeter   | Kshlerin-Batz         | Programmer Analyst I          | dmalster5@dagondesign.com    | 674-977-1744 | Syria     | Example3 | Hamah | 3675    | Arsnxiafi Sjitail Jlhxfmnjnviiy Tk H kqjhkwxcjpmvc jyo zfsn angycxd pjzdgbfzwv h qleklxgvi upmavjthul |


  @TC_02 @US_01 @api @ui
  Scenario Outline: Verify user can contact Sales Representative by filling out form including valid zip code, email and phone number
    #Given user is on "stryker" page (this is handled by custom @ui hook in Hooks class)
    #And user is on a "Contact" navigation menu window
    #And user clicks on "North America" continent
    And user clicks on LEARN MORE "<buttonType>"
    And user is on "<pageName>" page
    And user fills out form including valid fields "<zipCode>" "<email address>" "<phone number>"
    #And user clicks "submit" button (mock)
    And user should see "Thank you! We have received your request. A Stryker representative will be in contact with you soon." message
    And user sends POST request with all filled out fields to endpoint "/content/stryker/us/en/endoscopy/contact"
    Then api "messageStatus" response field should be "Success"
    And api "message" should match UI "UIMessage"

    Examples:
      | pageName       | buttonType      | email address                | phone number | zipCode |
      | endoscopy      | endoscopy       | james.smith@organization.com | 222-555-3334 | 95600   |
      | sportsMedicine | sports-medicine | jcrut0@vkontakte.ru          | 494-626-3291 | 07076   |
      | communications | communications  | dmalster5@dagondesign.com    | 674-977-1744 | 3675    |