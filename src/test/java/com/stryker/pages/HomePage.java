package com.stryker.pages;

import com.stryker.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage{

    /**
     * Method takes main menu element name as parameter and returns main menu WebElement.
     *
     * @param mainMenuElement
     * @return
     */
    public WebElement getMainMenuElement(String mainMenuElement) {
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        mainMenuElement = eachFirstCharToUpperCase(mainMenuElement);
        //looping though list of menu elements and returning the element which text is equal with the String variable that holds all upper cases.
        for (WebElement eachMenuElement : menuElements) {
            if (eachMenuElement.getText().equalsIgnoreCase(mainMenuElement)) {
                return eachMenuElement;
            }
        }
        return null;
    }

    @FindBy(xpath = "//ul[@class='list-unstyled main']/li/a")
    private List<WebElement> menuElements;
}
