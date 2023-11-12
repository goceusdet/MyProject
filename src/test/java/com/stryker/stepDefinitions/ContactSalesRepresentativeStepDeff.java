package com.stryker.stepDefinitions;

import com.stryker.pages.ContactPage;
import com.stryker.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ContactSalesRepresentativeStepDeff {

    String actualPageTitle;
    String expectedPageTitle;
    HomePage homePage = new HomePage();
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
    @Given("user clicks on LEARN MORE {string}")
    public void user_clicks_on_learn_more(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("user fills out form {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void user_fills_out_form(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("user captures UI confirmation message")
    public void user_captures_ui_confirmation_message() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("user sends POST request with all filled out form-fields to endpoint {string}")
    public void user_sends_post_request_with_all_filled_out_form_fields_to_endpoint(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("api {string} response field should be {string}")
    public void api_response_field_should_be(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("api {string} should match UI confirmation message")
    public void api_should_match_ui_confirmation_message(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



}
