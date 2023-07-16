package org.mailtravel.pages;

import org.mailtravel.util.ElementUtil;
import org.openqa.selenium.By;

public class ConfirmDetailsPage {

    ElementUtil element = new ElementUtil();
    private By confirmDetailsBookText = By.xpath("//*[@id='nbf_stages']/following::h1[2]");
    private By continueBtn = By.id("nbf_booknow_button");

    public ConfirmDetailsPage()  {
    }

    /**
     * This method returns Confirm Details + Book text from confirm details page
     * @return
     */
    public String confirmDetailsBookTextIsDisplayed()
    {

        return element.getText(confirmDetailsBookText);
    }

    /**
     * This method checks whether Continue button is enable on Confirm Detail page
     * @return
     */
    public boolean isEnableContinueBtn()
    {
        element.scroll(continueBtn);
        return element.isEnabled(continueBtn);
    }
}
