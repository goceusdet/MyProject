package com.stryker.pages;

import com.stryker.utils.BrowserUtil;
import com.stryker.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HD3ChipCamSystemPage {

    /**
     * Method takes type of button string as parameter and returns a WebElement.
     * @param buttonType
     * @return
     */
    public WebElement getEquipmentContactButton(String buttonType){
        WebElement contactBtn = Driver.getDriver().findElement(By.xpath("//a[@href='/us/en/"+buttonType+"/contact.html']"));
        BrowserUtil.waitForClickablility(contactBtn,5);
        return contactBtn;
    }
}
