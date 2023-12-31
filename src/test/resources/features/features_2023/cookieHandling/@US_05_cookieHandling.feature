@US_05 @ui @regression
Feature: Cookie Handling
  As a user I want to do various operations with cookies.

  Background: User goes to Stryker home page and navigates to contact-form's page
    Given user is on "stryker" page

  Scenario: Verify user can capture cookies from browser on homepage
   #Given user is on "stryker" page
    When user gets all the cookies from "stryker" page
    Then size of captured cookies list shouldn't be null

  Scenario: Verify user can create a cookie in browser on homepage
   #Given user is on "stryker" page
    When user adds a cookie
    Then cookie size should be increased by 1
    And user deletes the created cookie
