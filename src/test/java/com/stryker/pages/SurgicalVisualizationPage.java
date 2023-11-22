package com.stryker.pages;

import com.stryker.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SurgicalVisualizationPage {
    /**
     * Method takes type of equipment string as parameter and returns a WebElement.
     * @param equipmentType
     * @return
     */
    public WebElement getEquipmentElement(String equipmentType, String itemName){

        List<WebElement> equipmentTypeElement = Driver.getDriver().findElements(By.xpath("//div[contains(@data-pagepath, '"+equipmentType+"')]//h4"));
        for (WebElement eachEquipTypeElement : equipmentTypeElement) {
            if(eachEquipTypeElement.getText().equals(itemName)) return eachEquipTypeElement;
        }
        return null;
    }
}
