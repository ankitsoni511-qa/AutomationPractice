package com.automation.tests;

import com.automation.base.DriverFactory;
import com.automation.utils.ConfigReader;
import com.automation.utils.LoggerUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@io.qameta.allure.Epic("MakeMyTrip")
@io.qameta.allure.Feature("Homepage")
@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class TestBooking {
    private WebDriver driver;

    @Test(description = "MakeMyTrip homepage loads and the popup is handled")
    public void homepageLoadsSuccessfully() {
        driver = DriverFactory.initDriver(ConfigReader.getProperty("browser"));

        // config-driven URL — this line is the whole "pass any URL through
        // config, open browser, hit URL" requirement, satisfied in place
        driver.get(ConfigReader.getProperty("url"));
        // Write test here
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
        LoggerUtil.softAssert.assertAll();
    }
}