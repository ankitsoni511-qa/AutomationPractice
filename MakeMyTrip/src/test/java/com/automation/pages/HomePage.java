package com.automation.pages;

import com.automation.utils.LoggerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.automation.base.BasePage;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
        dismissPopupIfPresent();
    }

    private void dismissPopupIfPresent() {
        String closePopupModal = "//span[@data-cy='closeModal']";
        if (isElementVisible(By.xpath(closePopupModal), "Country/language popup close icon")) {
            clickElement(By.xpath(closePopupModal), "Close country/language popup");
        } else {
            LoggerUtil.debug("No country/language popup appeared — continuing");
        }
    }

    public boolean isHomepageLoaded() {
        String logoXpath = "//a[contains(@class,'primaryLogo')]";
        return isElementVisible(By.xpath(logoXpath), "MakeMyTrip header logo");
    }
}
