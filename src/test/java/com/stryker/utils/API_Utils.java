package com.stryker.utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class API_Utils {

    public static RequestSpecification reqSpecType(String acceptType) {
        return given().accept(acceptType);
    }


    /**
     * Method fills out form based on email as ID and sends it via API and returns a Response.
     * @param body
     * @param endpoint
     * @return
     */
    public static Response sendPOSTRequestWithFilledOutForm(Map<String, String> body, String endpoint) {
        return given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(body)
                .when().post(Environment.BASE_URL + endpoint).prettyPeek()
                .then().statusCode(HttpStatus.SC_OK)
                .contentType("application/json; charset=utf-8").extract().response();
    }

    /**
     * Method returns an empty form - API
     *
     * @return
     */
    public static Map<String, String> requestEmptyBody(String reqBodySpec) {
        Map<String, String> body = new HashMap<>();

        switch (reqBodySpec) {
            case "james.smith@organization.com":
            case "jcrut0@vkontakte.ru":
            case "dmalster5@dagondesign.com":
                body.put("First_Name", "");
                body.put("Last_Name", "");
                body.put("Hospital_or_Organization", "");
                body.put("Title_or_Speciality", "");
                body.put("Email_address", "");
                body.put("Phone_number", "");
                body.put("Country", "");
                body.put("City", "");
                body.put("State", "");
                body.put("Zip_Code", "");
                body.put("Message", "");
                return body;
        }
        return null;
    }


    /**
     * Method creates and returns a Map as a filled out form - API
     *
     * @return
     */
    public static Map<String, String> requestBody(String reqBodySpec) {
        Map<String, String> body = new HashMap<>();

        switch (reqBodySpec) {
            case "james.smith@organization.com":
                body.put("First_Name", "James");
                body.put("Last_Name", "Smith");
                body.put("Hospital_or_Organization", "Bergen");
                body.put("Title_or_Speciality", "James");
                body.put("Email_address", "james.smith@organization.com");
                body.put("Phone_number", "222-555-3334");
                body.put("Country", "CountryExample");
                body.put("City", "Example1");
                body.put("State", "StateExample");
                body.put("Zip_Code", "95600");
                body.put("Message", "Wjvhtkgdd Cdavvbi Uittfbshzgwsx Hl M mozmoyptkbhgm ryv jdhl qukuvla kjfvpgetuo i azxvytygp nrtpxielaf");
                return body;

            case "jcrut0@vkontakte.ru":
                body.put("First_Name", "Josee");
                body.put("Last_Name", "Crut");
                body.put("Hospital_or_Organization", "Borer Group");
                body.put("Title_or_Speciality", "Community Outreach Specialist");
                body.put("Email_address", "jcrut0@vkontakte.ru");
                body.put("Phone_number", "494-626-3291");
                body.put("Country", "CountryExample");
                body.put("City", "Example2");
                body.put("State", "StateExample");
                body.put("Zip_Code", "7076");
                body.put("Message", "Fcpiglgrg Jetftnv Dihrwardektpz Ky D kiccjshnhavtp ckn rrbu qvaxsal mscggzufth k sfdamotxc owikbfgvrk");
                return body;

            case "dmalster5@dagondesign.com":
                body.put("First_Name", "Demeter");
                body.put("Last_Name", "Demeter");
                body.put("Hospital_or_Organization", "Kshlerin-Batz");
                body.put("Title_or_Speciality", "Programmer Analyst I");
                body.put("Email_address", "dmalster5@dagondesign.com");
                body.put("Phone_number", "674-977-1744");
                body.put("Country", "CountryExample");
                body.put("City", "Example3");
                body.put("State", "StateExample");
                body.put("Zip_Code", "3675");
                body.put("Message", "Arsnxiafi Sjitail Jlhxfmnjnviiy Tk H kqjhkwxcjpmvc jyo zfsn angycxd pjzdgbfzwv h qleklxgvi upmavjthul");
                return body;
        }
        return null;
    }


    /**
     * Method fills out with specific parameters, creates and returns a Map as a filled out form - API
     *
     * @return
     */
    public static Map<String, String> requestBody(String reqBodySpec, String zipCode, String email, String
            phoneNumber) {
        Map<String, String> body = new HashMap<>();

        switch (reqBodySpec) {
            case "james.smith@organization.com":
                body.put("First_Name", "Invalid1");
                body.put("Last_Name", "Invalid1");
                body.put("Hospital_or_Organization", "Invalid1");
                body.put("Title_or_Speciality", "Invalid1");
                body.put("Email_address", email);
                body.put("Phone_number", phoneNumber);
                body.put("Country", "Invalid1");
                body.put("City", "Invalid1");
                body.put("State", "Invalid1");
                body.put("Zip_Code", zipCode);
                body.put("Message", "Wjvhtkgdd Cdavvbi Uittfbshzgwsx Hl M mozmoyptkbhgm ryv jdhl qukuvla kjfvpgetuo i azxvytygp nrtpxielaf");
                return body;

            case "jcrut0@vkontakte.ru":
                body.put("First_Name", "Invalid1");
                body.put("Last_Name", "Invalid1");
                body.put("Hospital_or_Organization", "Invalid1");
                body.put("Title_or_Speciality", "Invalid1");
                body.put("Email_address", email);
                body.put("Phone_number", phoneNumber);
                body.put("Country", "Invalid1");
                body.put("City", "Invalid1");
                body.put("State", "Invalid1");
                body.put("Zip_Code", zipCode);
                body.put("Message", "Fcpiglgrg Jetftnv Dihrwardektpz Ky D kiccjshnhavtp ckn rrbu qvaxsal mscggzufth k sfdamotxc owikbfgvrk");
                return body;

            case "dmalster5@dagondesign.com":
                body.put("First_Name", "Invalid1");
                body.put("Last_Name", "Invalid1");
                body.put("Hospital_or_Organization", "Invalid1");
                body.put("Title_or_Speciality", "Invalid1");
                body.put("Email_address", email);
                body.put("Phone_number", phoneNumber);
                body.put("Country", "Invalid1");
                body.put("City", "Invalid1");
                body.put("State", "Invalid1");
                body.put("Zip_Code", zipCode);
                body.put("Message", "Arsnxiafi Sjitail Jlhxfmnjnviiy Tk H kqjhkwxcjpmvc jyo zfsn angycxd pjzdgbfzwv h qleklxgvi upmavjthul");
                return body;
        }
        return null;
    }


    /**
     * Method takes reqBody, zip, email and phone numbers as parameters and returns form with only these parameters filled out - API
     *
     * @param reqBodySpec
     * @param zipCode
     * @param email
     * @param phoneNumber
     * @return
     */
    public static Map<String, String> requestBodyWithOnlySpecParams(String reqBodySpec, String zipCode, String
            email, String phoneNumber) {
        Map<String, String> body = new HashMap<>();

        switch (reqBodySpec) {
            case "james.smith@organization.com":
            case "jcrut0@vkontakte.ru":
            case "dmalster5@dagondesign.com":
                body.put("First_Name", "");
                body.put("Last_Name", "");
                body.put("Hospital_or_Organization", "");
                body.put("Title_or_Speciality", "");
                body.put("Email_address", email);
                body.put("Phone_number", phoneNumber);
                body.put("Country", "");
                body.put("City", "");
                body.put("State", "");
                body.put("Zip_Code", zipCode);
                body.put("Message", "");
                return body;
        }
        return null;
    }


    /**
     * Method returns a Map with invalid specified parameters as form fields
     *
     * @param reqBodySpec
     * @param zipCode
     * @param email
     * @param phoneNumber
     * @return
     */
    public static Map<String, String> requestBodyWithInvalidSpecParams(String reqBodySpec, String zipCode, String
            email, String phoneNumber) {
        Map<String, String> body = new HashMap<>();

        switch (reqBodySpec) {
            case "james.smith@organization@com":
                body.put("First_Name", "James");
                body.put("Last_Name", "Smith");
                body.put("Hospital_or_Organization", "Bergen");
                body.put("Title_or_Speciality", "Surgeon");
                body.put("Email_address", email);
                body.put("Phone_number", phoneNumber);
                body.put("Country", "Algeria");
                body.put("City", "Example1");
                body.put("State", "Alger");
                body.put("Zip_Code", zipCode);
                body.put("Message", "Wjvhtkgdd Cdavvbi Uittfbshzgwsx Hl M mozmoyptkbhgm ryv jdhl qukuvla kjfvpgetuo i azxvytygp nrtpxielaf");
                return body;

            case "jcrut0@vkontakte.ru":
                body.put("First_Name", "Josee");
                body.put("Last_Name", "Crut");
                body.put("Hospital_or_Organization", "Borer Group");
                body.put("Title_or_Speciality", "Community Outreach Specialist");
                body.put("Email_address", email);
                body.put("Phone_number", phoneNumber);
                body.put("Country", "Indonesia");
                body.put("City", "Example2");
                body.put("State", "Bali");
                body.put("Zip_Code", zipCode);
                body.put("Message", "Fcpiglgrg Jetftnv Dihrwardektpz Ky D kiccjshnhavtp ckn rrbu qvaxsal mscggzufth k sfdamotxc owikbfgvrk");
                return body;

            case "dmalster5@dagondesign.com":
                body.put("First_Name", "Demeter");
                body.put("Last_Name", "Demeter");
                body.put("Hospital_or_Organization", "Kshlerin-Batz");
                body.put("Title_or_Speciality", "Programmer Analyst I");
                body.put("Email_address", email);
                body.put("Phone_number", phoneNumber);
                body.put("Country", "Syria");
                body.put("City", "Example3");
                body.put("State", "Hamah");
                body.put("Zip_Code", zipCode);
                body.put("Message", "Arsnxiafi Sjitail Jlhxfmnjnviiy Tk H kqjhkwxcjpmvc jyo zfsn angycxd pjzdgbfzwv h qleklxgvi upmavjthul");
                return body;
        }
        return null;
    }
}

