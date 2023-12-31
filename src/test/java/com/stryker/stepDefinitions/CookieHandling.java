package com.stryker.stepDefinitions;

import com.stryker.pages.BasePage;
import com.stryker.pages.HomePage;
import com.stryker.utils.Driver;
import com.stryker.utils.Environment;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import java.lang.ref.SoftReference;
import java.time.Duration;
import java.util.Set;

public class CookieHandling {

    String actualPageTitle;
    String expectedPageTitle;
    int cookiesSizeBeforeAdding;
    int cookiesSizeAfterAdding;
    int cookiesSizeAfterDeleting;
    Cookie cookieObj;
    //String cookieName;

    @When("user gets all the cookies from {string} page")
    public void userGetsAllTheCookiesFromPage(String pageName) {
        SoftAssertions softAssert = new SoftAssertions();
        actualPageTitle = Driver.getDriver().getTitle();
        expectedPageTitle = new HomePage().getPageTitle(pageName);
        System.out.println("actualPageTitle = " + actualPageTitle);
        System.out.println("expectedPageTitle = " + expectedPageTitle);
        softAssert.assertThat(actualPageTitle.equals(expectedPageTitle));

    }

    @Then("size of captured cookies list shouldn't be null")
    public void sizeOfCapturedCookiesListShouldnTBeNull() {
        //capture cookies from browser
        Set<Cookie> cookies = Driver.getDriver().manage().getCookies();
        cookiesSizeBeforeAdding = cookies.size();
        System.out.println("cookies size before adding or deleting should be > 0 = " + cookiesSizeBeforeAdding);
        Assertions.assertTrue(cookies.size() > 0);
    }

    @When("user adds a cookie")
    public void userAddsACookie() {
        cookiesSizeBeforeAdding = Driver.getDriver().manage().getCookies().size();
        System.out.println("Cookies size before adding a cookie: " + cookiesSizeBeforeAdding);
        //first create Cookie object
        cookieObj = new Cookie("MyCookie123", "123456");
        //adding the created cookie:
        Driver.getDriver().manage().addCookie(cookieObj);
    }

    @Then("cookie size should be increased by {int}")
    public void cookieSizeShouldBeIncreasedBy(int cookieCountDifference) {
        cookiesSizeAfterAdding = Driver.getDriver().manage().getCookies().size();
        System.out.println("cookiesSizeBeforeAdding = " + cookiesSizeBeforeAdding);
        System.out.println("cookiesSizeAfterAdding = " + cookiesSizeAfterAdding);
        Assertions.assertEquals(cookiesSizeAfterAdding, cookiesSizeBeforeAdding + cookieCountDifference);
    }

    @And("user deletes the created cookie")
    public void userDeletesTheCreatedCookie() {
        Driver.getDriver().manage().deleteCookie(cookieObj);
        cookiesSizeAfterDeleting = Driver.getDriver().manage().getCookies().size();
        System.out.println("cookiesSizeBeforeAdding = " + cookiesSizeBeforeAdding);
        System.out.println("cookiesSizeAfterDeleting = " + cookiesSizeAfterDeleting);
        Assertions.assertEquals(cookiesSizeBeforeAdding, cookiesSizeAfterDeleting);

        //Deleting a cookie by cookieName:
        /*
         cookieName = cookieObj.getName();
         Driver.getDriver().manage().deleteCookieNamed(cookieName);
         cookiesSizeAfterDeleting = Driver.getDriver().manage().getCookies().size();
         Assertions.assertEquals(cookiesSizeBeforeAdding, cookiesSizeAfterDeleting);
         */

        //Delete all cookies:
        /*
          Driver.getDriver().manage().deleteAllCookies();
         */
    }
}
