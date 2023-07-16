package org.mailtravel.util;

import org.mailtravel.factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementUtil {


    private Select select;
    private WebDriver driver = DriverFactory.getDriver();;
    private WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(ConstVariable.EXPLICIT_DURATION));
    Actions action = new Actions(driver);


    /**
     * This method opens the URL
     * @param url
     */
    public void openUrl( String url)
    {
        driver.get(url);
    }

    /**
     * This method gets the title of the page
     * @return
     */
    public String doGetTitle()
    {
        return driver.getTitle();
    }

    /**
     * This method wait element to be clickable
     * @param locator
     */
    public void waitElementToBeClickable(By locator)  {

        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     *  This method waits till element to be visible
     */

    public void waitElementToBeVisible(By locator)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitImplicitly()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(ConstVariable.IMPLICIT_DURATION));
    }

    /**
     * This method clicks on the given element
     * @param locator
     */
    public void doClick(By locator) {

        driver.findElement(locator).click();
    }

    /**
     * This method enters text in the given element
     * @param locator
     * @param input
     */
    public void doInput(By locator, String input)
    {
        driver.findElement(locator).sendKeys(input);
    }

    /**
     * This method checks whether element is displayed or not
     * @param locator
     * @return
     */
    public boolean isDisplayed(By locator)
    {
        waitElementToBeVisible(locator);
        return driver.findElement(locator).isDisplayed();
    }

    /**
     * This method capture the text
     * @param locator
     * @return
     */
    public String getText(By locator)
    {
        waitElementToBeVisible(locator);
        return driver.findElement(locator).getText();
    }

    /**
     * This method scroll till the given element
     * @param locator
     */
    public void scroll(By locator)
    {

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
    }

    /**
     * This method selects the text from the dropdown
     * @param locator
     * @param text
     */
    public void selectByText(By locator, String text)
    {
        select = new Select(driver.findElement(locator));
        select.selectByVisibleText(text);
    }

    /**
     * This method returns selected text from dropdown
     * @param locator
     * @return
     */
    public String getSelectedTextDropDown(By locator)
    {
       select = new Select(driver.findElement(locator));
        return select.getFirstSelectedOption().getText();

    }

    public String captureDate(By monthYearLocator, By dayLocator)
    {
        String monthYear;
        String[] monthYearArray;
        String month;
        String year;
        String day;

        monthYear = driver.findElement(monthYearLocator).getText();
        monthYearArray = monthYear.split(" ");
        month = monthYearArray[0].substring(0,3);
        year = monthYearArray[1];
        day = driver.findElement(dayLocator).getText();
        return day+" "+month+" "+year;
    }

    /**
     * This method cane be use for mouse over
     * @param locator
     */
    public void mouseHoverOnElement(By locator)
    {
        action.moveToElement(driver.findElement(locator)).perform();
    }

    /**
     * This method cane be use for mouse over and click
     * @param locator
     */
    public void mouseHoverAndClick(By locator)
    {
        action.moveToElement(driver.findElement(locator)).click().build().perform();
    }

    /**
     * This method can be used for click by Javascript executor
     * @param locator
     */
    public void clickByJavaScriptExecutor(By locator)
    {
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(locator));
    }

    /**
     * This method is used to send text to element
     * @param locator
     * @param sendText
     */
    public void elementSendKey(By locator, String sendText)
    {
        waitElementToBeVisible(locator);
        driver.findElement(locator).sendKeys(sendText);
    }

    /**
     * This method checks whether given element is enabled or not
     * @param locator
     * @return
     */
    public boolean isEnabled(By locator)
    {
        waitElementToBeVisible(locator);
        return driver.findElement(locator).isEnabled();
    }

}
