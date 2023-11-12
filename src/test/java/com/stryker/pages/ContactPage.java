package com.stryker.pages;

import com.stryker.utils.BrowserUtil;
import com.stryker.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class ContactPage extends BasePage{


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

    public String getConfirmationMessage(){
        return "Thank you! We have received your request. A Stryker representative will be in contact with you soon.";
    }
}
