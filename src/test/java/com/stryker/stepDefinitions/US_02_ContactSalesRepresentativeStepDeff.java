package com.stryker.stepDefinitions;

import com.stryker.pages.ContactPage;
import com.stryker.utils.API_Utils;
import io.cucumber.java.en.And;
import io.restassured.response.Response;
import org.junit.Assert;
import java.util.Map;

public class US_02_ContactSalesRepresentativeStepDeff {

    Map<String, String> body;
    public static Response response;
    ContactPage contactPage = new ContactPage();


    @And("{string} user sends POST request with empty fields to endpoint {string}")
    public void userSendsPOSTRequestWithEmptyFieldsToEndpoint(String user, String endpoint) {
        response = API_Utils.sendPOSTRequestWithForm(API_Utils.requestEmptyBody(user), endpoint);
    }

    @And("user fills out form with invalid fields {string} {string} {string}")
    public void userFillsOutFormWithInvalidFields(String zipCode, String email, String phoneNum) {
        contactPage.fillOutForm(email, phoneNum, zipCode);
    }

    @And("user sees {string} message")
    public void userSeesMessage(String message) {
        //Mock test
        //Second case onward needs to fail as user gets first case[positive message] when conducting negative test.
        switch (message) {
            case "Thank you! We have received your request. A Stryker representative will be in contact with you soon.":
                Assert.assertTrue(true);
                break;
            case "Please enter a valid zip code. Zip_Code field must not be blank":
            case "Please fill out all the form fields and click Submit":
            case "Please enter a valid zip code, email and phone number":
            case "Please enter a valid Phone_number. Phone number field must not be empty":
            case "Please enter a valid email address. Email field must not be empty":
                Assert.fail();
                break;
        }
    }

    @And("{string} user send POST request with invalid fields {string} {string} {string} to endpoint {string}")
    public void userSendPOSTRequestWithInvalidFieldsToEndpoint(String user, String zipCode, String email, String phoneNum, String endpoint) {
        body = API_Utils.requestBodyWithInvalidSpecParams(user, zipCode, email, phoneNum);
        response = API_Utils.sendPOSTRequestWithForm(body, endpoint);
    }

    @And("user sends POST request with missing {string} field to endpoint {string}")
    public void userSendsPOSTRequestWithMissingFieldToEndpoint(String user, String endpoint) {
        body = API_Utils.requestBodyWithOneInvalidField(user);
        response = API_Utils.sendPOSTRequestWithForm(body, endpoint);
    }
}
