package com.stryker.stepDefinitions;

import com.stryker.utils.API_Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.Map;

public class API_contactSalesRepresentativeStepDeff {

    public static Response response;
    Map<String, String> body;
    String actualKeyFieldValue;
    String actualContentTypeHeader;
    public static RequestSpecification requestSpecification;
    public static RequestSpecification requestSpecificationForPOST;


    @Given("Accept header is {string}")
    public void accept_header_is(String acceptHeader) {
        requestSpecification = API_Utils.reqSpecType(acceptHeader);
    }

    @Given("Request Content Type header is {string}")
    public void request_content_type_header_is(String contentType) {
        requestSpecificationForPOST = requestSpecification.contentType(contentType);
    }

    @Given("I create and fill out whole form as request {string}")
    public void i_create_and_fill_out_whole_as_request_body(String reqBody) {
        body = API_Utils.requestBodyFilledOutForm(reqBody);
    }

    @When("I send POST request to {string} endpoint")
    public void i_send_post_request_to_endpoint(String endpoint) {
        response = requestSpecificationForPOST.body(body)
                .when().post(endpoint).prettyPeek();
    }

    @Then("the status code should be {int}")
    public void the_status_code_should_be(Integer expectedStatusCode) {
        Integer actualStatusCode = response.statusCode();
        Assert.assertEquals(expectedStatusCode, actualStatusCode);
    }

    @Then("Response Content type is {string}")
    public void response_content_type_is(String expectedContentTypeHeader) {
        actualContentTypeHeader = response.contentType();
        Assert.assertEquals(expectedContentTypeHeader, actualContentTypeHeader);
    }

    @Then("the field value for {string} path should be equal to {string}")
    public void the_field_value_for_path_should_be_equal_to(String keyField, String expectedValueField) {
        JsonPath jsonPath = response.jsonPath();
        actualKeyFieldValue = jsonPath.getString(keyField);
        Assert.assertEquals(expectedValueField, actualKeyFieldValue);
    }

    @And("I create and fill out whole form as request {string} with valid input {string} {string} {string} fields")
    public void I_Create_And_Fill_Out_Whole_Form_As_Request_Body_With_Valid_Input_Fields(String reqBody, String zipCode, String emailAddress, String phoneNumber) {
        body = API_Utils.requestBody(reqBody, zipCode, emailAddress, phoneNumber);
    }

    @And("I create and fill out form as request {string} with only {string} {string} {string} specific fields")
    public void I_Create_And_Fill_Out_Form_As_Request_With_Only_Fields(String reqBody, String zipCode, String email, String phoneNumber) {
        body = API_Utils.requestBodyWithOnlySpecParams(reqBody, zipCode, email, phoneNumber);
    }

    @And("I create request form {string} with all empty fields")
    public void I_Create_Request_Form_Body_With_All_Empty_Fields(String reqBody) {
        body = API_Utils.requestEmptyBody(reqBody);
    }

    @And("I create and fill out form as request {string} with specified invalid {string} {string} {string} fields")
    public void I_Create_And_Fill_Out_Form_As_Request_With_Specified_Invalid_Fields(String reqBody, String zipCode, String email, String phoneNumber) {
        body = API_Utils.requestBodyWithInvalidSpecParams(reqBody, zipCode, email, phoneNumber);
    }

    @When("I send GET request to {string} endpoint")
    public void I_Send_GET_Request_To_Endpoint(String endpoint) {
        response = requestSpecification.when().get(endpoint).prettyPeek();
    }

    @When("I send PUT request to {string} endpoint")
    public void iSendPUTRequestToEndpoint(String endpoint) {
        response = requestSpecification.when().put(endpoint).prettyPeek();
    }
}
