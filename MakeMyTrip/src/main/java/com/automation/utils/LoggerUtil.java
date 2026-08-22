package com.automation.utils;

import com.automation.base.DriverFactory;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.asserts.SoftAssert;

import java.io.ByteArrayInputStream;

public class LoggerUtil {
    private static final Logger logger = LogManager.getLogger(LoggerUtil.class);
    public static SoftAssert softAssert = new SoftAssert();

    public static void step(String message) {
        logger.info(message);
        Allure.step(message);
    }

    public static void debug(String message) {
        logger.debug(message);
    }

    public static void fail(String message) {
        logger.error("❌ " + message);
        attachScreenshot();
        softAssert.fail(message);
    }

    public static void error(String message) {
        logger.error("🛑 " + message);
        attachScreenshot();
        org.testng.Assert.fail(message);
    }

    private static void attachScreenshot() {
        try {
            byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshot));
        } catch (Exception ignored) {
        }
    }
}
