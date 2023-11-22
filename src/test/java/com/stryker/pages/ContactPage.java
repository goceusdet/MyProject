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

    /**
     * Method fills out sale representative form on UI with email, phone number and zipcode as parameters.
     * @param emailAddress
     * @param phoneNumber
     * @param zipcode
     */
    public void fillOutForm(String emailAddress, String phoneNumber, String zipcode) {

        switch (emailAddress) {

            case "jamessmithorganization.com":
                BrowserUtil.waitForPageToLoad(5);
                actions = new Actions(Driver.getDriver());
                selectState = new Select(getSelectCountryDropDown());
                selectCountry = new Select(getSelectStateDropDown());
                actions.moveToElement(getSelectCountryDropDown()).perform();

                getFirstName().sendKeys("James");
                getLastName().sendKeys("Smith");
                getHospitalOrganization().sendKeys("Bergen");
                getTitleSpecialty().sendKeys("Surgeon");
                getEmailAddress().sendKeys(emailAddress);
                getPhoneNumber().sendKeys(phoneNumber);
                getCity().sendKeys("Example1");
                getZipCode().sendKeys(zipcode);
                getMessageField().sendKeys("Wjvhtkgdd Cdavvbi Uittfbshzgwsx Hl M mozmoyptkbhgm ryv jdhl qukuvla kjfvpgetuo i azxvytygp nrtpxielaf");

                selectState.selectByValue("Algeria");
                selectCountry.selectByValue("Alger");
//            BrowserUtil.waitFor(5);
                break;

            case "jcrut0@vkontakte@ru":
                BrowserUtil.waitForPageToLoad(5);
                actions = new Actions(Driver.getDriver());
                selectState = new Select(getSelectCountryDropDown());
                selectCountry = new Select(getSelectStateDropDown());
                actions.moveToElement(getSelectCountryDropDown()).perform();

                getFirstName().sendKeys("Josee");
                getLastName().sendKeys("Crut");
                getHospitalOrganization().sendKeys("Borer Group");
                getTitleSpecialty().sendKeys("Community Outreach Specialist");
                getEmailAddress().sendKeys(emailAddress);
                getPhoneNumber().sendKeys(phoneNumber);
                getCity().sendKeys("Example2");
                getZipCode().sendKeys(zipcode);
                getMessageField().sendKeys("Fcpiglgrg Jetftnv Dihrwardektpz Ky D kiccjshnhavtp ckn rrbu qvaxsal mscggzufth k sfdamotxc owikbfgvrk");

                selectState.selectByValue("Bali");
                selectCountry.selectByValue("Indonesia");
//                BrowserUtil.waitFor(5);
                break;

            case "dmalster5-dagondesign-com":
                BrowserUtil.waitForPageToLoad(5);
                actions = new Actions(Driver.getDriver());
                selectState = new Select(getSelectCountryDropDown());
                selectCountry = new Select(getSelectStateDropDown());
                actions.moveToElement(getSelectCountryDropDown()).perform();

                getFirstName().sendKeys("Demeter");
                getLastName().sendKeys("Demeter");
                getHospitalOrganization().sendKeys("Kshlerin-Batz");
                getTitleSpecialty().sendKeys("Programmer Analyst I");
                getEmailAddress().sendKeys(emailAddress);
                getPhoneNumber().sendKeys(phoneNumber);
                getCity().sendKeys("Example3");
                getZipCode().sendKeys(zipcode);
                getMessageField().sendKeys("Arsnxiafi Sjitail Jlhxfmnjnviiy Tk H kqjhkwxcjpmvc jyo zfsn angycxd pjzdgbfzwv h qleklxgvi upmavjthul");

                selectState.selectByValue("Hamah");
                selectCountry.selectByValue("Syria");
//                BrowserUtil.waitFor(5);
                break;
        }

    }

    /**
     * Method fills out a contact form with specified field as empty value.
     * @param field
     */
    public void fillOutForm(String field){

        switch (field){
            case "zip code" :
                BrowserUtil.waitForPageToLoad(5);
                actions = new Actions(Driver.getDriver());
                selectState = new Select(getSelectCountryDropDown());
                selectCountry = new Select(getSelectStateDropDown());
                actions.moveToElement(getSelectCountryDropDown()).perform();
                getFirstName().sendKeys("James");
                getLastName().sendKeys("Smith");
                getHospitalOrganization().sendKeys("Bergen");
                getTitleSpecialty().sendKeys("Surgeon");
                getEmailAddress().sendKeys("james.smith@organization.com");
                getPhoneNumber().sendKeys("222-555-3334");
                getCity().sendKeys("Example1");
                getZipCode().sendKeys("");
                getMessageField().sendKeys("Wjvhtkgdd Cdavvbi Uittfbshzgwsx Hl M mozmoyptkbhgm ryv jdhl qukuvla kjfvpgetuo i azxvytygp nrtpxielaf");
                selectState.selectByValue("Algeria");
                selectCountry.selectByValue("Alger");

                break;

            case "Phone_number":
                BrowserUtil.waitForPageToLoad(5);
                actions = new Actions(Driver.getDriver());
                selectState = new Select(getSelectCountryDropDown());
                selectCountry = new Select(getSelectStateDropDown());
                actions.moveToElement(getSelectCountryDropDown()).perform();
                getFirstName().sendKeys("Josee");
                getLastName().sendKeys("Crut");
                getHospitalOrganization().sendKeys("Borer Group");
                getTitleSpecialty().sendKeys("Community Outreach Specialist");
                getEmailAddress().sendKeys("jcrut0@vkontakte.ru");
                getPhoneNumber().sendKeys("");
                getCity().sendKeys("Example2");
                getZipCode().sendKeys("7076");
                getMessageField().sendKeys("Fcpiglgrg Jetftnv Dihrwardektpz Ky D kiccjshnhavtp ckn rrbu qvaxsal mscggzufth k sfdamotxc owikbfgvrk");
                selectState.selectByValue("Bali");
                selectCountry.selectByValue("Indonesia");
                break;

            case "email address":
                BrowserUtil.waitForPageToLoad(5);
                actions = new Actions(Driver.getDriver());
                selectState = new Select(getSelectCountryDropDown());
                selectCountry = new Select(getSelectStateDropDown());
                actions.moveToElement(getSelectCountryDropDown()).perform();
                getFirstName().sendKeys("Demeter");
                getLastName().sendKeys("Demeter");
                getHospitalOrganization().sendKeys("Kshlerin-Batz");
                getTitleSpecialty().sendKeys("Programmer Analyst I");
                getEmailAddress().sendKeys("");
                getPhoneNumber().sendKeys("674-977-1744");
                getCity().sendKeys("Example3");
                getZipCode().sendKeys("3675");
                getMessageField().sendKeys("Arsnxiafi Sjitail Jlhxfmnjnviiy Tk H kqjhkwxcjpmvc jyo zfsn angycxd pjzdgbfzwv h qleklxgvi upmavjthul");
                selectState.selectByValue("Hamah");
                selectCountry.selectByValue("Syria");
                break;
        }
    }

    /**Method fills out form with only specified parameters to be modifiable
     *
     * @param zipcode
     * @param emailAddress
     * @param phoneNumber
     */
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
