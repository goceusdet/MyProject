package com.stryker.stepDefinitions;

import com.stryker.pages.HD3ChipCamSystemPage;
import com.stryker.pages.HomePage;
import com.stryker.pages.MedicalAndSurgicalEquipmentPage;
import com.stryker.pages.SurgicalVisualizationPage;
import com.stryker.utils.API_Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.Map;

public class US_03_ContactSalesRepresentativeStepDeff {

    Response response;
    Map<String, String> body;
    HomePage homePage = new HomePage();
    HD3ChipCamSystemPage hd3ChipCamSystemPage = new HD3ChipCamSystemPage();
    SurgicalVisualizationPage surgicalVisualization = new SurgicalVisualizationPage();
    MedicalAndSurgicalEquipmentPage medAndSurgEquip = new MedicalAndSurgicalEquipmentPage();

    @When("user clicks on {string} menu element")
    public void userClicksOnMenuElement(String menuElement) {
        homePage.getMainMenuElement(menuElement).click();
    }

    @And("user clicks on {string} equipment")
    public void userClicksOnEquipment(String equipmentName) {
        medAndSurgEquip.getEquipment(equipmentName).click();
    }

    @And("user clicks on {string} type item {string}")
    public void userClicksOnTypeItem(String itemType, String itemName) {
        surgicalVisualization.getEquipmentElement(itemType, itemName).click();
    }

    @And("user clicks on {string} contact button")
    public void userClicksOnContactButton(String buttonType) {
        hd3ChipCamSystemPage.getEquipmentContactButton(buttonType).click();
    }

    @And("{string} user sends POST request with all filled out fields to endpoint {string}")
    public void userSendsPOSTRequestWithAllFilledOutFieldsToEndpoint(String userEmail, String endpoint) {
        body = API_Utils.requestBodyFilledOutForm(userEmail);
        response = API_Utils.sendPOSTRequestWithFilledOutForm(body,endpoint);
    }
}
