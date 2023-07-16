package testcaseparallel;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mailtravel.pages.HomePage;
import org.testng.Assert;

public class HomePageDef {

    private String title = "";
    private HomePage homePage = new HomePage();


    @Given("User is on home page")
    public void userIsOnHomePage(){
        homePage.openUrl();

    }

    @When("user gets title of the page")
    public void user_gets_title_of_the_page() {
        title = homePage.getHomePageTitle();
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String string) {
        Assert.assertEquals(title, string);
    }

    @And("user clicks on Accept All Cookies button")
    public void userClicksOnAcceptAllCookiesButton() throws InterruptedException {
        homePage.clickAcceptAllCookies();
    }


}
