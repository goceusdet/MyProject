package com.stryker.pages;

import com.stryker.utils.BrowserUtil;
import com.stryker.utils.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MedicalAndSurgicalEquipmentPage {

    JavascriptExecutor js;

    /**
     * Method returns equipment WebElement. Takes equipment name as parameter.
     *
     * @param equipmentName
     * @return
     */
    public WebElement getEquipment(String equipmentName) {
        js = (JavascriptExecutor) Driver.getDriver();
        for (WebElement eachMedAndSurgEquipment : medAndSurgEquipTit) {
            if (eachMedAndSurgEquipment.getText().equalsIgnoreCase(equipmentName)) {
                js.executeScript("arguments[0].scrollIntoView(true)", eachMedAndSurgEquipment);
                BrowserUtil.waitForClickablility(eachMedAndSurgEquipment, 5);
                return eachMedAndSurgEquipment;
            }
        }
        return null;
    }

    @FindBy(xpath = ("//div[@class='products-container']//h4"))
    private List<WebElement> medAndSurgEquipTit;
}
