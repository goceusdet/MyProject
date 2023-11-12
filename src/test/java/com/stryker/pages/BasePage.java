package com.stryker.pages;

import com.stryker.utils.BrowserUtil;
import com.stryker.utils.Driver;
import com.stryker.utils.ExcelUtil;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.Map;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    private List<Map<String, String>> pagesInfoList;
    private ExcelUtil excelUtil = new ExcelUtil("src/test/resources/excelFiles/PagesInfo.xlsx", "PagesInfo");


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

}
