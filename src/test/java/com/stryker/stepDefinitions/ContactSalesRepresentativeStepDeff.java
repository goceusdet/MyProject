package com.stryker.stepDefinitions;

import com.stryker.pages.ContactPage;
import com.stryker.pages.HomePage;
import com.stryker.utils.API_Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Map;

public class ContactSalesRepresentativeStepDeff {

    Response response;
    String actualPageTitle;
    String actualMessageAPI;
    String actualMessageAPI2;
    String expectedPageTitle;
    String expectedMessageAPI;
    String uiConfirmationMessage;
    Map<String, String> requestBody;
    HomePage homePage = new HomePage();
    String expectedConfirmationMessageUI;
    ContactPage contactPage = new ContactPage();

    @Given("user is on {string} page")
    public void user_is_on_page(String pageName) {
        expectedPageTitle = new HomePage().getPageTitleFromSheet(pageName);
        actualPageTitle = homePage.getPageTitle(pageName);
        Assert.assertEquals(expectedPageTitle, actualPageTitle);
    }

    @Given("user is on a {string} navigation menu window")
    public void user_is_on_a_navigation_menu_window(String navWin) {
        homePage.getNavUtilityPage(navWin);
    }

    @Given("user clicks on {string} continent")
    public void user_clicks_on_continent(String continentName) {
        contactPage.clickOnLocationContinent(continentName);
    }

    @Given("user clicks on {string} LEARN MORE button")
    public void user_clicks_on_learn_more_button(String buttonType) {
        contactPage.learnMoreButton(buttonType).click();
    }

    @Given("user fills out form {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void user_fills_out_form(String firstName, String lastName, String hospitalOrganization, String titleSpecialty, String emailAddress, String phoneNumber, String country, String city, String state, String zipcode, String message) {
        contactPage.fillOutForm(firstName, lastName, hospitalOrganization, titleSpecialty, emailAddress, phoneNumber, country, city, state, zipcode, message);
        //Mock test. Input will not be sent.
    }

    @Given("user captures UI confirmation message")
    public void user_captures_ui_confirmation_message() {
        uiConfirmationMessage = contactPage.getConfirmationMessage();
        Assert.assertFalse(uiConfirmationMessage.isEmpty());
    }

    @Given("user sends POST request {string} with all filled out form-fields to endpoint {string}")
    public void user_sends_post_request_with_all_filled_out_form_fields_to_endpoint(String email, String endpoint) {
        response = API_Utils.sendPOSTRequestWithFilledOutForm(API_Utils.requestBody(email), endpoint);
    }

    @Then("api {string} response field should be {string}")
    public void api_response_field_should_be(String keyField, String valueField) {
        actualMessageAPI = response.path(keyField);
        expectedMessageAPI = valueField;
        Assert.assertEquals(expectedMessageAPI, actualMessageAPI);
    }

    @Then("api {string} should match UI confirmation message")
    public void api_should_match_ui_confirmation_message(String keyField) {
        actualMessageAPI2 = response.path(keyField);
        expectedConfirmationMessageUI = uiConfirmationMessage;
        Assert.assertEquals(expectedConfirmationMessageUI, actualMessageAPI2);
    }

    @Given("user clicks on LEARN MORE {string}")
    public void user_clicks_on_learn_more(String buttonType) {
        contactPage.learnMoreButton(buttonType).click();
    }

    @Given("user fills out form including valid fields {string} {string} {string}")
    public void user_fills_out_form_including_valid_fields(String zipCode, String email, String phoneNumber) {
        contactPage.fillOutFormWithValidSpec(zipCode, email, phoneNumber);
    }

    @Given("user sends POST request {string} with all filled out fields to endpoint {string}")
    public void user_sends_post_request_with_all_filled_out_fields_to_endpoint(String body, String endpoint) {
        requestBody = API_Utils.requestBodyWithValidSpec(body);
        response = API_Utils.sendPOSTWithValidSpec(requestBody, endpoint);
    }

}
