package testcaseparallel;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.mailtravel.pages.ConfirmDetailsPage;
import org.testng.Assert;

public class ConfirmDetailsDef {
    ConfirmDetailsPage confirmDetailsPage = new ConfirmDetailsPage();


    @And("Book Now button is enabled")
    public void bookNowButtonIsEnabled() {
        Assert.assertTrue(confirmDetailsPage.isEnableContinueBtn());
    }

    @Then("{string} text is appear")
    public void textIsAppear(String arg0) {
        Assert.assertEquals(arg0,confirmDetailsPage.confirmDetailsBookTextIsDisplayed());
        
    }
}
