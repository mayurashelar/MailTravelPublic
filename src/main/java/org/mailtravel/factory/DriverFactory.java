package org.mailtravel.factory;

//import io.github.bonigarcia.wdm.WebDriverManager;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public WebDriver driver;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

    /**
     * This method is used to initialize the driver on the basis of given browser
     *
     * @param browser
     */
    public WebDriver driverInit(String browser) {
        if (browser.equals("chrome")) {

            driver = new ChromeDriver();
            tlDriver.set(driver);
        } else if (browser.equals("firefox")) {

            driver = new FirefoxDriver();
            tlDriver.set(driver);
        } else {
            System.out.println("Please pass the correct browser value:  " + browser);
        }
        driver.manage().getCookies();
        driver.manage().window().maximize();
        return driver;
    }

    public static synchronized WebDriver getDriver() {

        return tlDriver.get();

    }

}
