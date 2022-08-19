package com.codecool.testautomation.utility;

import com.codecool.testautomation.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codecool.testautomation.utility.LogIn.*;

public class Utility extends BasePage {

    public static final String baseUrl = "https://jira-auto.codecool.metastage.net/";

    public static void clickButton(WebElement webElement){webElement.click();
    }

    public static void waitForWebElementToBePresent(WebElement webElement){
        driver.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitForElementToSendText(WebElement webElement, String text){
        DriverSingleton.getWait().until(ExpectedConditions.elementToBeClickable(webElement)).sendKeys(text);

    }
    public static void waitForElementToClick(WebElement webElement){
        DriverSingleton.getWait().until(ExpectedConditions.elementToBeClickable(
                webElement
        )).click();
    }

    public static String getWebElementText(WebElement webElement){
        return webElement.getText();
    }

    public static void openUrl(String url){
        driver.get(baseUrl + url);
    }

    public static void beforeEachSetup() {
        driver.manage().window().maximize();
        logIn();
    }

    public static void close(){
        DriverSingleton.getDriver().quit();
        DriverSingleton.setDriverSingleton(null);
    }

    public static void quit(){ DriverSingleton.getDriver().quit(); }
}
