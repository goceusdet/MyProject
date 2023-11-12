package com.stryker.pages;

import com.stryker.utils.BrowserUtil;
import com.stryker.utils.Driver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class EndoscopyPage extends BasePage{

    private Actions actions;
    private Select selectState;
    private Select selectCountry;

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
}
