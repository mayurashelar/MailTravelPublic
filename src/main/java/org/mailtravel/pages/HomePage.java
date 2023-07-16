package org.mailtravel.pages;

import org.mailtravel.util.ConfigReader;
import org.mailtravel.util.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

import static java.time.Duration.*;

public class HomePage {
    private Properties prop = new ConfigReader().propertiesInit();
    private WebDriverWait wait;

   private By searchBox = By.id("searchtext_freetext_search_form");

    private By acceptAllCookies = By.id("onetrust-accept-btn-handler");
    private ElementUtil element = new ElementUtil();


    /**
     * This method opens URL
     */
    public void openUrl(){

        element.openUrl(prop.getProperty("url"));
        element.waitElementToBeVisible(searchBox);
    }

    /**
     * This method returns home page title
     * @return
     */
    public String getHomePageTitle()
    {
        return element.doGetTitle();
    }

    /**
     * This method clicks on Accept All Cookies button
     */
    public void clickAcceptAllCookies() {

        element.waitElementToBeVisible(acceptAllCookies);
        element.clickByJavaScriptExecutor(acceptAllCookies);
    }

}
