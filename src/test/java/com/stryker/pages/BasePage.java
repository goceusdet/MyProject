package com.stryker.pages;

import com.stryker.utils.BrowserUtil;
import com.stryker.utils.Driver;
import com.stryker.utils.ExcelUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    private List<Map<String, String>> pagesInfoList;
    private final ExcelUtil excelUtil = new ExcelUtil("src/test/resources/testData/excelFiles/PagesInfo.xlsx", "PagesInfo");


    /**
     * Method takes page name as parameter and returns the page title.
     * @param pageName
     * @return
     */
    public String getPageTitleFromSheet(String pageName) {
        pagesInfoList = excelUtil.getDataList();
        for (Map<String, String> eachPageInfoMap : pagesInfoList) {
            if (eachPageInfoMap.get("pageName").equalsIgnoreCase(pageName)) {
                return eachPageInfoMap.get("pageTitle");
            }
        }
        return null;
    }


    /**
     * Method takes page name as parameter and returns current page title as String.
     * @param pageName
     * @return
     */
    public String getPageTitle(String pageName) {
        BrowserUtil.waitForPageToLoad(5);
        if (pageName.contains(" ")) {
            throw new RuntimeException("Please enter only one word for the page name and no spaces.");
        }
        pagesInfoList = excelUtil.getDataList();
        pageName = pageName.toLowerCase();
        BrowserUtil.waitForPageToLoad(5);
        String pageTitle = Driver.getDriver().getTitle();
        for (Map<String, String> eachPageMap : pagesInfoList) {
            if (eachPageMap.get("pageName").equals(pageName)) {
                if (eachPageMap.get("pageTitle").equals(pageTitle)) {
                    return Driver.getDriver().getTitle();
                }
            }
        }
        return null;
    }

    /**
     * Method takes navigation utility name as parameter and clicks on the specified navigation utility webelement. Prints confirmation message on console if user is navigated to different window.
     *
     * @return void
     * @utility name of navigation utility menu link.
     */
    public void getNavUtilityPage(String utility) {
        BrowserUtil.waitForPageToLoad(5);
        //utility name format in locator is capital char for each word. Below logic makes each first letter as capital char of each word of the utility name.
        utility = eachFirstCharToUpperCase(utility);

        WebElement navUtility = Driver.getDriver().findElement(By.xpath("//span[normalize-space()='" + utility + "']"));

        navUtility.click();

        switchToNewWindow();
    }

    /**
     * Method takes String word/words as parameters and returns a new version of the parameter where each first char of each word is capital character.
     *
     * @param input
     * @return String
     */
    public String eachFirstCharToUpperCase(String input) {
        StringBuilder result = new StringBuilder();
        String[] words = input.split("\\s");

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.equalsIgnoreCase("and")) {
                result.append("and");
            } else {
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase());
            }
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        return result.toString();
//        String[] PageWordArr = words.split(" ");
//        StringBuilder result = new StringBuilder();
//
//        for (String eachPageWord : PageWordArr) {
//            if (!eachPageWord.equals("and")) {// word 'and' in main menu elements names is not following the format convention = each-word-starts-with-capital-letter.
//                eachPageWord = eachPageWord.substring(0, 1).toUpperCase() + eachPageWord.substring(1).toLowerCase();
//            }
//
//            result.append(eachPageWord).append(" ");
//        }
//        result = new StringBuilder(result.toString().trim());
//        return result.toString();
    }

    /**
     * Method switches to new window if a new window is opened.
     * Method doesn't take any parameters.
     */
    public void switchToNewWindow() {
        Set<String> winHandles = Driver.getDriver().getWindowHandles();

        if (winHandles.size() > 1) {
            for (String eachWinHandle : winHandles) {
                Driver.getDriver().switchTo().window(eachWinHandle);
            }
        }
        if (winHandles.size() > 1) {
            System.out.println("User successfully moved to a new window.");
        } else {
            System.out.println("User is still in the same window");
        }
    }


    @FindBy(xpath = "//ul[@class='list-unstyled main']/li/a")
    private List<WebElement> menuElements;

    @FindBy(id = "firstname")
    private WebElement firstName;

    public WebElement getFirstName() {
        return firstName;
    }

    @FindBy(id = "lastname")
    private WebElement lastName;

    public WebElement getLastName() {
        return lastName;
    }

    @FindBy(id = "hospitalorganization")
    private WebElement hospitalOrganization;

    public WebElement getHospitalOrganization() {
        return hospitalOrganization;
    }

    @FindBy(id = "titlespeciality")
    private WebElement titleSpecialty;

    public WebElement getTitleSpecialty() {
        return titleSpecialty;
    }

    @FindBy(id = "emailaddress")
    private WebElement emailAddress;

    public WebElement getEmailAddress() {
        return emailAddress;
    }

    @FindBy(id = "phonenumber")
    private WebElement phoneNumber;

    public WebElement getPhoneNumber() {
        return phoneNumber;
    }

    @FindBy(id = "city")
    private WebElement city;

    public WebElement getCity() {
        return city;
    }

    @FindBy(id = "zipcode")
    private WebElement zipCode;

    public WebElement getZipCode() {
        return zipCode;
    }

    @FindBy(xpath = "//textarea[@id='message']")
    private WebElement messageField;

    public WebElement getMessageField() {
        return messageField;
    }

    @FindBy(xpath = "//select[@id='country']")
    private WebElement selectCountryDropDown;

    public WebElement getSelectCountryDropDown() {
        return selectCountryDropDown;
    }


    @FindBy(xpath = "//select[@id='state']")
    private WebElement selectStateDropDown;

    public WebElement getSelectStateDropDown() {
        return selectStateDropDown;
    }

}
