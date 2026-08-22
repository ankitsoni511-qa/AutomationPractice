package com.automation.base;

import com.automation.utils.LoggerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    protected WebElement getElement(By locator, String description) {
        LoggerUtil.debug("Waiting for visibility of: " + description);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void clickElement(By locator, String description) {
        getElement(locator, description).click();
        LoggerUtil.step("Clicked: " + description);
    }

    public boolean isElementVisible(By locator, String description) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
