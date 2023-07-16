package testcaseparallel;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.mailtravel.pages.SearchPage;
import org.testng.Assert;

public class SearchDef {

    private SearchPage searchPage = new SearchPage();


    @Given("User enters {string} on search bar")
    public void userEntersOnSearchBar(String searchText) {
        searchPage.sendSearchText(searchText);

    }


    @When("list of {string} tour is displayed")
    public void listOfTourIsDisplayed(String arg0) {
        Assert.assertTrue(searchPage.searchListDisplayed());
        Assert.assertEquals(searchPage.getTextFromList().substring(0, 5), arg0);
    }

    @And("User should select first option India from the list")
    public void userShouldSelectFirstOptionIndiaFromTheList() throws InterruptedException {
        searchPage.clickOnFirstListItem();
        Assert.assertTrue(searchPage.isHeadlineDisplay());
    }


    @And("User clicks on Book Online button")
    public void userClicksOnBookOnlineButton() {
        searchPage.bookOnlineButtonClick();

    }


    @And("Navigated on {string} Tour page")
    public void navigatedOnTourPage(String tourName) {
        Assert.assertEquals(searchPage.getSelectedTourText(),tourName);
    }
}
