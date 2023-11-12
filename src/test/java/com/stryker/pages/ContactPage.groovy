package com.stryker.pages

import com.stryker.utils.BrowserUtil
import com.stryker.utils.Driver
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class ContactPage extends BasePage {

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
}
