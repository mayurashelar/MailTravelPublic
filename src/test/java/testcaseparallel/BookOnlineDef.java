package testcaseparallel;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mailtravel.pages.BookOnlinePage;
import org.testng.Assert;

public class BookOnlineDef {

    BookOnlinePage bookOnlinePage = new BookOnlinePage();


    @Given("User select next available date")
    public void user_select_next_available_date() {
        bookOnlinePage.clickSelectDate();
    }


    @And("select the {int} adults and validate the price")
    public void selectTheAdultsAndValidateThePrice(int adultNumber) {
        Assert.assertEquals(Integer.toString(adultNumber), bookOnlinePage.selectAdult(adultNumber));
        Assert.assertEquals(bookOnlinePage.priceAfterAdultSelection(), bookOnlinePage.validatePrice(adultNumber));
    }

    @When("user click on Book Online button")
    public void userClickOnBookOnlineButton() {
        bookOnlinePage.bookOnlineBtnClick();
    }

    @Then("tour booking details page should be displayed")
    public void tourBookingDetailsPageShouldBeDisplayed() {
        Assert.assertTrue(bookOnlinePage.isTourBookingDisplay());
    }


    @And("make a note of departure selection")
    public void makeANoteOfDepartureSelection() {
        bookOnlinePage.departureNote();
    }


    @Given("{string} text is displayed before selecting date")
    public void textIsDisplayedBeforeSelectingDate(String arg0) {
        Assert.assertTrue(bookOnlinePage.departureTextDisplayed());

    }

    @Then("{string} text\" should not be displayed.")
    public void textShouldNotBeDisplayed(String arg0) throws Throwable {
        bookOnlinePage.clickSelectDate();
    }
}
