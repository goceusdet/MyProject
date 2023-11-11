@US_05 @api @ui @regression
Feature: As a user, I am able to contact Sales Representative - API

  Background: Specifying Accept and Content Type headers
    Given Accept header is "application/json"
    And Request Content Type header is "application/json"


  @TC_9 @US_05 @api @ui
  Scenario: Can Contact Sales Representative by filling out all form fields with data - API
    #Given Accept header is "application/json"
    #And Request Content Type header is "application/json"
    And I create and fill out whole "form" as request body
    When I send POST request to "/content/stryker/us/en/endoscopy/contact" endpoint
    Then the status code should be 200
    And Response Content type is "application/json"
    Then the field value for "<keyField>" path should be equal to "<valueField>"
    #And the field value for "message" path should be equal to "Thank you! We have received your request. A Stryker representative will be in contact with you soon."
    #And the field value for "messageStatus" path should be equal to "Success"

  @TC_10 @US_05 @api @ui
  Scenario: Can Contact Sales Representative by filling out whole form including valid zip code, email and phone number - API
    #Given Accept header is "application/json"
    #And Request Content Type header is "application/json"
    And I create and fill out whole form as request body with valid input "<Zip_Code>" "<Email_address>" "<Phone_number>" fields
    When I send POST request to "/content/stryker/us/en/endoscopy/contact" endpoint
    Then the status code should be 200
    And Response Content type is "application/json"
    Then the field value for "<keyField>" path should be equal to "<valueField>"
    #And the field value for "message" path should be equal to "Thank you! We have received your request. A Stryker representative will be in contact with you soon."
    #And the field value for "messageStatus" path should be equal to "Success"

  @TC_11 @US_05 @api @ui
  Scenario: Can Contact Sales Representative by filling out form with only valid zip code, email and phone number - API
    #Given Accept header is "application/json"
    #And Request Content Type header is "application/json"
    And I create and fill out form as request body with only "<Zip_Code>" "<Email_address>" "<Phone_number>" fields
    When I send POST request to "/content/stryker/us/en/endoscopy/contact" endpoint
    Then the status code should be 200
    And Response Content type is "application/json"
    Then the field value for "<keyField>" path should be equal to "<valueField>"
    #And the field value for "message" path should be equal to "Thank you! We have received your request. A Stryker representative will be in contact with you soon."
    #And the field value for "messageStatus" path should be equal to "Success"

  @TC_12 @US_05 @api @ui
  Scenario: Can NOT contact Sales Representative by submitting an empty form - API
    #Given Accept header is "application/json"
    #And Request Content Type header is "application/json"
    And I leave all form-fields blank
    When I send POST request to "/content/stryker/us/en/endoscopy/contact" endpoint
    Then the status code should be 400
    And Response Content type is "application/json"
    Then the field value for "<keyField>" path should be equal to "<valueField>"
    #Then the field value for "<message>" path should be equal to "Please fill out all the form fields and click Submit"
    #Then the field value for "<messageStatus>" path should be equal to "Failed"

  @TC_13 @US_05 @api @ui
  Scenario: Can NOT contact Sales Representative by inputting specific invalid form-fields - API
    #Given Accept header is "application/json"
    #And Request Content Type header is "application/json"
    And I create and fill out form as request body with specified invalid "<Zip_Code>" "<Email_address>" "<Phone_number>" fields
    When I send POST request to "/content/stryker/us/en/endoscopy/contact" endpoint
    Then the status code should be 400
    And Response Content type is "application/json"
    Then the field value for "<keyField>" path should be equal to "<valueField>"
    #Then the field value for "<message>" path should be equal to "Please fill out all the form fields and click Submit"
    #Then the field value for "<messageStatus>" path should be equal to "Failed"

  @TC_14 @US_05 @api @ui
  Scenario: Can not use GET request - API
    #Given Accept header is "application/json"
    #And Request Content Type header is "application/json"
    When I send GET request to "/content/stryker/us/en/endoscopy/contact" endpoint
    Then the status code should be 405
    And Response Content type is "application/json"
    Then the field value for "<keyField>" path should be equal to "<valueField>"
    #Then the field value for "<message>" path should be equal to "Request type not allowed. Please use correct method - POST"

  @TC_15 @US_05 @api @ui
  Scenario: Can not use PUT request - API
    #Given Accept header is "application/json"
    #And Request Content Type header is "application/json"
    When I send PUT request to "/content/stryker/us/en/endoscopy/contact" endpoint
    Then the status code should be 405
    And Response Content type is "application/json"
    Then the field value for "<keyField>" path should be equal to "<valueField>"
    #Then the field value for "<message>" path should be equal to "Please use correct request - POST"


