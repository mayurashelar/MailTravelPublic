package org.mailtravel.pages;

import org.mailtravel.util.ElementUtil;
import org.openqa.selenium.By;

import java.util.HashMap;

public class BookOnlinePage {

    ElementUtil element = new ElementUtil();

    int beforeSelectionPrice;
    public static String departureNoteVal;

    private By selectDate = By.id("calbox-f0050aa159413059b0d39248658bdb50-1");

    private By selectDateValue = By.xpath("//*[@id='calbox-f0050aa159413059b0d39248658bdb50-1']/parent::div/preceding-sibling::div");
    private By travelExperience = By.id("dates_and_prices_title");

    private By beforePrice = By.xpath("//*[@id='calbox-f0050aa159413059b0d39248658bdb50-1']/parent::div/parent::div/div[2]");
    private By afterPrice = By.xpath("//*[@id='tour-price']/span");
    private By adultDropdown = By.id("numAdults-f0050aa159413059b0d39248658bdb50");
    private By bookOnlineBtn = By.id("book-button");
    private By tourBooking = By.id("tourBookingFlow");
    private By departure = By.xpath("//*[contains(text(), 'Departure Airport')]/following::span");
    private By monthYear = By.xpath("//*[@id='nbf_tpl_pms_calendar-f0050aa159413059b0d39248658bdb50']/div[1]/div[2]");

    private By departureDataText = By.xpath("//*[@id='book-f0050aa159413059b0d39248658bdb50']/div/div");
    private By bookOnlineTop = By.name("enterbookingflow");
    private By imageContainer = By.id("img-container");

    public BookOnlinePage()  {
    }

    /**
     * This method scroll till the calendar, capture price present on date and select date on the calendar
     */
    public void clickSelectDate() {
        element.scroll(travelExperience);
        beforeSelectionPrice = Integer.parseInt(element.getText(beforePrice).replaceAll("(?<=\\d),(?=\\d)|\\£", ""));
        element.doClick(selectDate);
    }

    /**
     * This method select given adult number from the calendar and return selected value from dropdown
     * @param adultNumber
     * @return
     */
    public String selectAdult(int adultNumber) {
        element.selectByText(adultDropdown, Integer.toString(adultNumber));
        return element.getSelectedTextDropDown(adultDropdown);
    }

    /**
     * This method validate price
     * @param adult
     * @return
     */
    public int validatePrice(int adult) {
        return beforeSelectionPrice * adult;
    }

    /**
     * This method capture price present below the adult selection drop down
     * @return
     */
    public int priceAfterAdultSelection() {
        return Integer.parseInt(element.getText(afterPrice).replaceAll("(?<=\\d),(?=\\d)|\\£", ""));
    }

    /**
     * This method clicks onBook Online button
     */
    public void bookOnlineBtnClick() {
        element.doClick(bookOnlineBtn);
    }

    /**
     * This method checks Tour Booking page is displayed or not
     * @return
     */
    public boolean isTourBookingDisplay() {
        return element.isDisplayed(tourBooking);
    }

    /**
     * This method capture departure note data
     *
     * @return
     */
    public String departureNote() {
        return element.getText(departure).replace(" Airport", "");

    }

    /**
     * This method returns a data filled for online booking
     *
     * @param adultNumber
     * @return
     */
    public HashMap<String, String> bookTour(int adultNumber) {
        HashMap<String, String> departData = new HashMap<String, String>();
        clickSelectDate();
        departData.put("passenger", selectAdult(adultNumber));
        departData.put("departFrom", departureNote());
        departData.put("departDate", element.captureDate(monthYear, selectDateValue));
        bookOnlineBtnClick();

        return departData;
    }


    /**
     * This method clicks on Date, Departure and Passenger container
     */

    public boolean departureTextDisplayed() {
        element.scroll(imageContainer);
        element.mouseHoverOnElement(bookOnlineTop);
        return element.isDisplayed(departureDataText);
    }


}
