package org.mailtravel.pages;

import org.mailtravel.util.ElementUtil;
import org.openqa.selenium.By;

public class SearchPage {

    private By search = By.id("searchtext_freetext_search_form");
    private By searchList = By.xpath("//*[@id='as_ul']");
    private By searchListText = By.xpath("//*[@id='as_ul']/li[1]/a");
    private By imageContainer = By.id("img-container");
    private By headLine = By.id("hero-headline");
    private By bookOnlineBtn = By.name("enterbookingflow");

    private By selectedTourPage = By.id("product-title");
    private ElementUtil element = new ElementUtil();

    public SearchPage()  {
    }


    public void sendSearchText(String searchText)
    {
        element.doInput(search,searchText);
    }

    public boolean searchListDisplayed()
    {
        return element.isDisplayed(searchList);
    }
    public String getTextFromList()
    {
        return element.getText(searchListText);
    }

    public void clickOnFirstListItem() {
        element.doClick(searchListText);
    }

    /**
     * This method scroll till Book Online button and clicks on First Book Online button
     */

    public void bookOnlineButtonClick() {
        element.scroll(imageContainer);
        element.doClick(bookOnlineBtn);
    }

    /**
     *
     * @return
     */
    public boolean isHeadlineDisplay()
    {
        return element.isDisplayed(headLine);
    }

    /**
     * This method enters search text and select first option from the list
     * @param searchText
     */
    public void enterAndClickSearchOption(String searchText)
    {
        sendSearchText(searchText);
        clickOnFirstListItem();
    }

    /**
     * This method checks whether user navigated on selected tour page after selecting option from search list
     * @return
     */
    public String getSelectedTourText()
    {
        return element.getText(selectedTourPage);
    }
}
