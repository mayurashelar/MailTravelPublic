package org.mailtravel.pages;

import org.mailtravel.util.ElementUtil;
import org.openqa.selenium.By;

import java.util.HashMap;

public class PassengerAndTourDetailsPage {

    ElementUtil element = new ElementUtil();


    private By passengerDetailsContainer = By.id("paxSelection");
    private By deptDatePassengerContainer = By.id("paxDepDateForm-container");
    private By passenger = By.xpath("//*[@id='numAdults-f0050aa159413059b0d39248658bdb50']/parent::div");
    private By departureAirport = By.xpath("//*[contains(text(), 'Departure Airport')]/following::div");
    private By departureDate = By.xpath("//*[contains(text(), 'Departure date')]/following::div");
    private By twinRoomRequired = By.id("room-1837299-numselect");
    private By selectRoomContinueBtn = By.xpath("//*[@id='accomForm-select']/button");
    private By continueWithoutExtraBtn = By.xpath("//div[contains(text(),'Continue without extras')]");

    private By adult1Title = By.id("pax-a-title-1");
    private By adult1FirstName = By.id("pax-a-first-1");
    private By adult1LastName = By.id("pax-a-last-1");
    private By adult1BirthDay = By.id("pax-a-dobd-1");
    private By adult1BirthMonth = By.id("pax-a-dobm-1");

    private By adult1BirthYear = By.id("pax-a-doby-1");
    private By adult2Title = By.id("pax-a-title-2");
    private By adult2FirstName = By.id("pax-a-first-1");
    private By adult2LastName = By.id("pax-a-last-2");
    private By adult2BirthDay = By.id("pax-a-dobd-2");
    private By adult2BirthMonth = By.id("pax-a-dobm-2");
    private By adult2BirthYear = By.id("pax-a-doby-2");
    private By mobilePhNumber = By.id("contact-mobile");
    private By emailId = By.id("contact-email");
    private By addressLine1 = By.id("contact-address1");
    private By addressLine2 = By.id("contact-address2");
    private By city = By.id("contact-city");
    private By postCode = By.id("contact-postcode");
    private By country = By.id("contact-country");
    private By hearAbout = By.id("contact-hearabout");
    private By passengerDetailsContinueBtn = By.id("paxform-select");
    private By confirmDetailsBookContainer = By.id("nbf_page_container");

    public PassengerAndTourDetailsPage()  {
    }


    /**
     * This method scroll till Passenger Details section and Click on Passenger Details section
     */
    public void clickDateDeparture() {
        element.waitElementToBeVisible(passengerDetailsContainer);
        element.waitImplicitly();
        element.scroll(deptDatePassengerContainer);
        element.doClick(deptDatePassengerContainer);
    }

    /**
     * This method returns a data present on Date, Departure and Passenger container
     *
     * @return HashMap
     */
    public HashMap<String, String> getDepartData() {
        HashMap<String, String> data = new HashMap<>();
        element.waitElementToBeVisible(passenger);
        element.waitImplicitly();
        data.put("passenger", element.getText(passenger));
        data.put("departFrom", element.getText(departureAirport).replaceAll(" \\(LHR\\)", ""));
        data.put("departDate", element.getText(departureDate).substring(5));
        return data;

    }

    /**
     * This method checks Room required drop down is displayed in Accommodation section
     * @return
     */
    public boolean roomRequiredIsDisplayed() {
        return element.isDisplayed(twinRoomRequired);
    }

    /**
     * This method select required room from drop down in Accommodation section
     * @param numberRequired
     */
    public void roomSelected(String numberRequired) {
        element.waitElementToBeVisible(twinRoomRequired);
        element.selectByText(twinRoomRequired, numberRequired);
    }

    /**
     * This method returns selected required room from drop down in Accommodation section
     * @return
     */
    public String getRoomRequiredText() {
        return element.getSelectedTextDropDown(twinRoomRequired);

    }

    /**
     * This method clicks on Continue button in in Accommodation section
     */
    public void clickSelectRoomContinue() {
        element.doClick(selectRoomContinueBtn);
    }

    /**
     * This method checks whether Continue without extra button is displayed or not
     * @return
     */
    public boolean isContinueWithoutExtraBtnDisplayed() {
        return element.isDisplayed(continueWithoutExtraBtn);
    }

    /**
     * This method clicks on continue without extra button
     */
    public void clickContinueWithoutExtraBtn()
    {
        element.waitElementToBeVisible(continueWithoutExtraBtn);
    element.doClick(continueWithoutExtraBtn);
    }

    /**
     * This method checks whether  Passenger Details section is displayed or not
     * @return
     */
    public boolean passengerDetailsSectionIsDisplayed() {
        boolean flag = false;
        if (!element.isDisplayed(adult1Title)) {
            element.scroll(passengerDetailsContainer);
            element.doClick(passengerDetailsContainer);
            if (element.isDisplayed(adult1Title))
                flag = true;
        } else
            flag = true;

        return flag;
    }

    /**
     * This method Enters Adult 1 details in Passenger Details section
     * @param title
     * @param firstName
     * @param lastName
     * @param birthDay
     * @param birthMonth
     * @param birthYear
     */
    public void enterAdult1Details(String title, String firstName, String lastName, String birthDay, String birthMonth, String birthYear) {
        element.elementSendKey(adult1Title, title);
        element.elementSendKey(adult1FirstName, firstName);
        element.elementSendKey(adult1LastName, lastName);
        element.selectByText(adult1BirthDay, birthDay);
        element.selectByText(adult1BirthMonth, birthMonth);
        element.selectByText(adult1BirthYear, birthYear);
    }

    /**
     * This method Enters Adult 2 details in Passenger Details section
     * @param title
     * @param firstName
     * @param lastName
     * @param birthDay
     * @param birthMonth
     * @param birthYear
     */
    public void enterAdult2Details(String title, String firstName, String lastName, String birthDay, String birthMonth, String birthYear) {
        element.elementSendKey(adult2Title, title);
        element.elementSendKey(adult2FirstName, firstName);
        element.elementSendKey(adult2LastName, lastName);
        element.selectByText(adult2BirthDay, birthDay);
        element.selectByText(adult2BirthMonth, birthMonth);
        element.selectByText(adult2BirthYear, birthYear);
    }

    /**
     * This method Enters Lead Contact details in Passenger Details section
     * @param mobile
     * @param email
     * @param address1
     * @param address2
     * @param cityVal
     * @param postcodeVal
     * @param countryVal
     * @param hearAboutUs
     */
    public void enterLeadContactDetails(String mobile, String email, String address1, String address2, String cityVal, String postcodeVal, String countryVal, String hearAboutUs) {
        element.elementSendKey(mobilePhNumber, mobile);
        element.elementSendKey(emailId, email);
        element.elementSendKey(addressLine1, address1);
        element.elementSendKey(addressLine2, address2);
        element.elementSendKey(city, cityVal);
        element.elementSendKey(postCode, postcodeVal);
        element.selectByText(country, countryVal);
        element.selectByText(hearAbout, hearAboutUs);
    }

    /**
     * This method clicks on continue button in Passenger Details section
     */
    public void passengerDetailsContinueBtnClick() {
        element.doClick(passengerDetailsContinueBtn);
    }

    /**
     * This method checks wether Confirm Details page is displayed or not
     * @return
     */
    public boolean confirmDetailsBookContainerIsDisplayed() {
        return element.isDisplayed(confirmDetailsBookContainer);
    }
}
