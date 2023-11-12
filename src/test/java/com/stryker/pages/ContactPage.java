package com.stryker.pages;

import com.github.javafaker.Faker;
import com.stryker.utils.BrowserUtil;
import com.stryker.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class ContactPage extends BasePage{


    private Actions actions;
    Faker faker = new Faker();
    private Select selectState;
    private Select selectCountry;

    /**
     * Method takes continent-location name as parameter and clicks on that continent link by using javaScript(scroll-into-view): arguments[0].scrollIntoView(true)
     *
     * @param location
     */
    public void clickOnLocationContinent(String location) {
        location = eachFirstCharToUpperCase(location);
        WebElement continent = Driver.getDriver().findElement(By.xpath("//h4[@class='panel-title']/a[contains(normalize-space(text()), '" + location + "')]"));
        BrowserUtil.clickWithJS(continent);
    }

    /**
     * Method takes business type as parameter and locates LEARN MORE button for specified business type.
     * @param businessType
     * @return
     */
    public WebElement learnMoreButton(String businessType) {

        //Formatting of the type in the locator is: all lower-cases and '-' instead of ' '.
        businessType = businessType.toLowerCase();
        businessType = businessType.replaceAll(" ", "-");
        System.out.println("businessType = " + businessType);

        return Driver.getDriver().findElement(By.xpath("//span[contains(.,'contact our business units')]/../../../..//following-sibling::div/dl//a[contains(@href, '" + businessType + "')]"));
    }

    /**
     * Mock UI confirmation message based on real data.
     * @return
     */
    public String getConfirmationMessage(){
        return "Thank you! We have received your request. A Stryker representative will be in contact with you soon.";
    }


    /**
     * Method is overidden from BasePage. Takes several parameters and fills out the contact a sales person form.
     *
     * @param firstName
     * @param lastName
     * @param hospitalOrganization
     * @param titleSpecialty
     * @param emailAddress
     * @param phoneNumber
     * @param country
     * @param city
     * @param state
     * @param zipcode
     * @param message
     */
    public void fillOutForm(String firstName, String lastName, String hospitalOrganization, String titleSpecialty, String emailAddress, String phoneNumber, String country, String city, String state, String zipcode, String message) {

        BrowserUtil.waitForPageToLoad(10);
        actions = new Actions(Driver.getDriver());
        selectState = new Select(getSelectCountryDropDown());
        selectCountry = new Select(getSelectStateDropDown());
        actions.moveToElement(getSelectCountryDropDown()).perform();

        getFirstName().sendKeys(firstName);
        getLastName().sendKeys(lastName);
        getHospitalOrganization().sendKeys(hospitalOrganization);
        getTitleSpecialty().sendKeys(titleSpecialty);
        getEmailAddress().sendKeys(emailAddress);
        getPhoneNumber().sendKeys(phoneNumber);
        getCity().sendKeys(city);
        getZipCode().sendKeys(zipcode);
        getMessageField().sendKeys(message);

        selectState.selectByValue(country);
        selectCountry.selectByValue(state);
        BrowserUtil.waitFor(5);

    }

    public void fillOutFormWithValidSpec(String zipcode, String emailAddress, String phoneNumber){

        BrowserUtil.waitForPageToLoad(10);
        actions = new Actions(Driver.getDriver());
        selectState = new Select(getSelectCountryDropDown());
        selectCountry = new Select(getSelectStateDropDown());
        actions.moveToElement(getSelectCountryDropDown()).perform();

        getFirstName().sendKeys("Invalid1");
        getLastName().sendKeys("Invalid1");
        getHospitalOrganization().sendKeys("Invalid1");
        getTitleSpecialty().sendKeys("Invalid1");
        getEmailAddress().sendKeys(emailAddress);
        getPhoneNumber().sendKeys(phoneNumber);
        getCity().sendKeys("Invalid1");
        getZipCode().sendKeys(zipcode);
        getMessageField().sendKeys("Invalid1");

        selectState.selectByIndex(faker.random().nextInt(1,3));
        selectCountry.selectByIndex(faker.random().nextInt(1,3));
        BrowserUtil.waitFor(5);
    }
}
