package testcaseparallel;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mailtravel.pages.BookOnlinePage;
import org.mailtravel.pages.PassengerAndTourDetailsPage;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PassengerAndTourDetailsDef {

    HashMap<String, String> departData;
    HashMap<String, String> departContainerData;
    PassengerAndTourDetailsPage ptDetailsPage = new PassengerAndTourDetailsPage();
    BookOnlinePage bookOnlinePage = new BookOnlinePage();



    @Given("User book a tour for {int} adults by clicking book online button")
    public void userBookATourForAdultsByClickingBookOnlineButton(int adultNumber) {
        departData = bookOnlinePage.bookTour(adultNumber);
    }

    @When("User click on Date, Departure & Passenger section")
    public void userClickOnDateDeparturePassengerSection() {
        ptDetailsPage.clickDateDeparture();
    }

    @Then("Populated details in Date, Departure & Passenger section are valid")
    public void populatedDetailsInDateDeparturePassengerSectionAreValid() {
        departContainerData = ptDetailsPage.getDepartData();
        Assert.assertEquals(departData.get("passenger"), departContainerData.get("passenger"));
        Assert.assertEquals(departData.get("departFrom"), departContainerData.get("departFrom"));
        Assert.assertEquals(departData.get("departDate"), departContainerData.get("departDate"));
    }


    @Given("User is in Accommodation section.")
    public void userIsInAccommodationSection() {
        Assert.assertTrue(ptDetailsPage.roomRequiredIsDisplayed());
    }

    @And("select number required as {int} for Twin room")
    public void selectNumberRequiredAsForTwinRoom(int roomNumberRequired) {
        ptDetailsPage.roomSelected(Integer.toString(roomNumberRequired));
        Assert.assertEquals(ptDetailsPage.getRoomRequiredText(), Integer.toString(roomNumberRequired));
    }

    @When("User click on {string} button.")
    public void userClickOnButton(String arg0) {
        ptDetailsPage.clickSelectRoomContinue();

    }

    @Then("User should navigate on Extra section")
    public void userShouldNavigateOnExtraSection() {
        Assert.assertTrue(ptDetailsPage.isContinueWithoutExtraBtnDisplayed());
    }

    @Then("User is navigated on Confirm Details page.")
    public void userShouldNavigatedOnConfirmDetailsPage() {
        Assert.assertTrue(ptDetailsPage.confirmDetailsBookContainerIsDisplayed());

    }

    @And("User is on Passenger details section")
    public void userIsOnPassengerDetailsSection() {
        Assert.assertTrue(ptDetailsPage.passengerDetailsSectionIsDisplayed());

    }

    @When("User clicks on continue button")
    public void userClicksOnContinueButton() {
        ptDetailsPage.passengerDetailsContinueBtnClick();

    }

    @And("User fill passenger details")
    public void userFillPassengerDetails(DataTable passengerDetails) {    // Write code here that turns the phrase above into concrete actions    throw new cucumber.api.PendingException();}
        List<Map<String, String>> passengerDetailsList = passengerDetails.asMaps();

        ptDetailsPage.enterAdult1Details(passengerDetailsList.get(0).get("adult1Title"),
                passengerDetailsList.get(0).get("adult1FirstName"), passengerDetailsList.get(0).get("adult1LastName"),
                passengerDetailsList.get(0).get("adult1BirthDay"), passengerDetailsList.get(0).get("adult1BirthMonth"),
                passengerDetailsList.get(0).get("adult1BirthYear"));
        ptDetailsPage.enterAdult1Details(passengerDetailsList.get(0).get("adult2Title"),
                passengerDetailsList.get(0).get("adult2FirstName"), passengerDetailsList.get(0).get("adult2LastName"),
                passengerDetailsList.get(0).get("adult2BirthDay"), passengerDetailsList.get(0).get("adult2BirthMonth"),
                passengerDetailsList.get(0).get("adult2BirthYear"));
    }


    @And("User fill Lead Contact Details")
    public void userFillLeadContactDetails(DataTable leadContactDetails) {
        List<Map<String, String>> leadDetailsList = leadContactDetails.asMaps();
        ptDetailsPage.enterLeadContactDetails(leadDetailsList.get(0).get("mobilePhoneNumber"),
                leadDetailsList.get(0).get("emailAddress"), leadDetailsList.get(0).get("AddressLine1"),
                leadDetailsList.get(0).get("AddressLine2"), leadDetailsList.get(0).get("city"),
                leadDetailsList.get(0).get("postCode"), leadDetailsList.get(0).get("country"),
                leadDetailsList.get(0).get("hearAboutUs"));

    }


    @And("User select accommodation as {int} for Twin room")
    public void userSelectAccommodationAsForTwinRoom(int roomNumber) {

        ptDetailsPage.roomSelected(Integer.toString(roomNumber));
        ptDetailsPage.clickSelectRoomContinue();
        ptDetailsPage.clickContinueWithoutExtraBtn();

    }
}