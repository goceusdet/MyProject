package com.stryker.utils;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import static io.restassured.RestAssured.*;

public class API_TestBase {

    /**
     * Sets the API base URL
     */
    @BeforeAll
    public static void setUp(){
        baseURI = Environment.BASE_URL;
    }

    /**
     * Resets the API base URL
     */
    @AfterAll
    public static void destroy(){
        reset();
    }

}
