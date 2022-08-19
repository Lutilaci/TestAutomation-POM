package com.codecool.testautomation.utility;

import com.codecool.testautomation.page.BasePage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codecool.testautomation.utility.LogIn.*;

public class Utility extends BasePage {

    public static final String baseUrl = "https://jira-auto.codecool.metastage.net/";


    public Utility() {
    }

    public void waitForWebElementToBePresent(WebElement webElement){
        driver.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitForElementToSendText(WebElement webElement, String text){
        DriverSingleton.getWait().until(ExpectedConditions.elementToBeClickable(webElement)).sendKeys(text);

    }
    public void waitForElementToClick(WebElement webElement){
        DriverSingleton.getWait().until(ExpectedConditions.elementToBeClickable(
                webElement
        )).click();
    }

    public String getWebElementText(WebElement webElement){
        return webElement.getText();
    }

    public void openUrl(String url){
        driver.get(baseUrl + url);
    }

    public void beforeEachSetup() {
        driver.manage().window().maximize();
        logIn();
    }

    public void close(){
        DriverSingleton.getDriver().quit();
        DriverSingleton.setDriverSingleton(null);
    }

    public static String getEnvironmentVar(String name) {
        return System.getenv(name);
        }
}
