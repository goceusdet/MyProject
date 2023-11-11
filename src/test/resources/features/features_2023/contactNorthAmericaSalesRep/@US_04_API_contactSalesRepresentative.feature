@US_04 @regression
Feature: As a user, I am able to contact Sales Representative - API

  Background: Specifying Accept and Content Type headers
    Given Accept header is "application/json"


  @TC_09 @US_04
  Scenario Outline: Can Contact Sales Representative by filling out all form fields with data - API
    #Given Accept header is "application/json"
    And Request Content Type header is "application/json"
    And I create and fill out whole form as request "<body>"
    When I send POST request to "/content/stryker/us/en/endoscopy/contact" endpoint
    Then the status code should be 200
    And Response Content type is "application/json; charset=utf-8"
    Then the field value for "message" path should be equal to "<valueField1>"
    And the field value for "messageStatus" path should be equal to "<valueField2>"
    #And the field value for "message" path should be equal to "Thank you! We have received your request. A Stryker representative will be in contact with you soon."
    #And the field value for "messageStatus" path should be equal to "Success"

    Examples:
      | body                         | valueField1                                                                                          | valueField2 |
      | james.smith@organization.com | Thank you! We have received your request. A Stryker representative will be in contact with you soon. | Success     |
      | jcrut0@vkontakte.ru          | Thank you! We have received your request. A Stryker representative will be in contact with you soon. | Success     |
      | dmalster5@dagondesign.com    | Thank you! We have received your request. A Stryker representative will be in contact with you soon. | Success     |


  @TC_10 @US_04
  Scenario Outline: Can Contact Sales Representative by filling out whole form including valid zip code, email and phone number - API
    #Given Accept header is "application/json"
    And Request Content Type header is "application/json"
    And I create and fill out whole form as request "<body>" with valid input "<Zip_Code>" "<Email_address>" "<Phone_number>" fields
    When I send POST request to "/content/stryker/us/en/endoscopy/contact" endpoint
    Then the status code should be 200
    And Response Content type is "application/json; charset=utf-8"
    And the field value for "message" path should be equal to "<valueField1>"
    And the field value for "messageStatus" path should be equal to "<valueField2>"
    #And the field value for "message" path should be equal to "Thank you! We have received your request. A Stryker representative will be in contact with you soon."
    #And the field value for "messageStatus" path should be equal to "Success"

    Examples:
      | body                         | Zip_Code | Phone_number | Email_address                | valueField1                                                                                          | valueField2 |
      | james.smith@organization.com | 95600    | 222-555-3334 | james.smith@organization.com | Thank you! We have received your request. A Stryker representative will be in contact with you soon. | Success     |
      | jcrut0@vkontakte.ru          | 07076    | 494-626-3291 | jcrut0@vkontakte.ru          | Thank you! We have received your request. A Stryker representative will be in contact with you soon. | Success     |
      | dmalster5@dagondesign.com    | 3675     | 674-977-1744 | dmalster5@dagondesign.com    | Thank you! We have received your request. A Stryker representative will be in contact with you soon. | Success     |


  @TC_11 @US_04
  Scenario Outline: Can Contact Sales Representative by filling out form with only valid zip code, email and phone number - API
    #Given Accept header is "application/json"
    And Request Content Type header is "application/json"
    And I create and fill out form as request "<body>" with only "<Zip_Code>" "<Email_address>" "<Phone_number>" specific fields
    When I send POST request to "/content/stryker/us/en/endoscopy/contact" endpoint
    Then the status code should be 200
    And Response Content type is "application/json; charset=utf-8"
    And the field value for "message" path should be equal to "<valueField1>"
    And the field value for "messageStatus" path should be equal to "<valueField2>"
    #And the field value for "message" path should be equal to "Thank you! We have received your request. A Stryker representative will be in contact with you soon."
    #And the field value for "messageStatus" path should be equal to "Success"

    Examples:
      | body                         | Zip_Code | Phone_number | Email_address                | valueField1                                                                                          | valueField2 |
      | james.smith@organization.com | 95600    | 222-555-3334 | james.smith@organization.com | Thank you! We have received your request. A Stryker representative will be in contact with you soon. | Success     |
      | jcrut0@vkontakte.ru          | 07076    | 494-626-3291 | jcrut0@vkontakte.ru          | Thank you! We have received your request. A Stryker representative will be in contact with you soon. | Success     |
      | dmalster5@dagondesign.com    | 3675     | 674-977-1744 | dmalster5@dagondesign.com    | Thank you! We have received your request. A Stryker representative will be in contact with you soon. | Success     |


  @TC_12 @US_04 @api
  Scenario Outline: Can NOT contact Sales Representative by submitting an empty form - API
    #Given Accept header is "application/json"
    And Request Content Type header is "application/json"
    And I create request form "<body>" with all empty fields
    When I send POST request to "/content/stryker/us/en/endoscopy/contact" endpoint
    Then the status code should be 400
    And Response Content type is "application/json; charset=utf-8"
    And the field value for "message" path should be equal to "<valueField1>"
    And the field value for "messageStatus" path should be equal to "<valueField2>"
    #And the field value for "<message>" path should be equal to "Please fill out all the form fields and click Submit"
    #And the field value for "<messageStatus>" path should be equal to "Failed"

    Examples:
      | body                         | valueField1                                          | valueField2 |
      | james.smith@organization.com | Please fill out all the form fields and click Submit | Failed      |
      | jcrut0@vkontakte.ru          | Please fill out all the form fields and click Submit | Failed      |
      | dmalster5@dagondesign.com    | Please fill out all the form fields and click Submit | Failed      |


  @TC_13 @US_04
  Scenario Outline: Can NOT contact Sales Representative by inputting specific invalid form-fields - API
    #Given Accept header is "application/json"
    And Request Content Type header is "application/json"
    And I create and fill out form as request "<body>" with specified invalid "<Zip_Code>" "<Email_address>" "<Phone_number>" fields
    When I send POST request to "/content/stryker/us/en/endoscopy/contact" endpoint
    Then the status code should be 400
    And Response Content type is "application/json; charset=utf-8"
    And the field value for "message" path should be equal to "<valueField1>"
    And the field value for "messageStatus" path should be equal to "<valueField2>"
    #And the field value for "<message>" path should be equal to "Please fill out all the form fields and click Submit"
    #And the field value for "<messageStatus>" path should be equal to "Failed"

    Examples:
      | body                         | Zip_Code | Phone_number   | Email_address               | valueField1                                           | valueField2 |
      | james.smith@organization@com | Ab03C    | 222-555-333455 | jamessmithorganization.com | Please enter a valid zip code, email and phone number | Failed      |
      | jcrut0@vkontakte.ru          | 25.@$%   | 494-626-329162 | jcrut0@vkontakte@ru         | Please enter a valid zip code, email and phone number | Failed      |
      | dmalster5@dagondesign.com    | Invalid3 | 674-55977-1744 | dmalster5-dagondesign-com   | Please enter a valid zip code, email and phone number | Failed      |


  @TC_14 @US_04
  Scenario: Can not use GET request - API
    #Given Accept header is "application/json"
    When I send GET request to "/content/stryker/us/en/endoscopy/contact" endpoint
    Then the status code should be 405
    And Response Content type is "application/json; charset=utf-8"
    And the field value for "message" path should be equal to "Request type not allowed. Please use correct method - POST"
    #Then the field value for "<message>" path should be equal to "Request type not allowed. Please use correct method - POST"


  @TC_15 @US_04
  Scenario: Can not use PUT request - API
    #Given Accept header is "application/json"
    And Request Content Type header is "application/json"
    When I send PUT request to "/content/stryker/us/en/endoscopy/contact" endpoint
    Then the status code should be 405
    And Response Content type is "application/json; charset=utf-8"
    Then the field value for "message" path should be equal to "Request type not allowed. Please use correct request - POST"
    #Then the field value for "<message>" path should be equal to "Please use correct request - POST"