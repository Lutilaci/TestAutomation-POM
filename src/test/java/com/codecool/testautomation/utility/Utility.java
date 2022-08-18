package com.codecool.testautomation.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
 import org.openqa.selenium.support.ui.WebDriverWait;


public class Utility {
    public static WebDriver driver = Driver.getInstance().getDriver();
    public static WebDriverWait wait = Driver.getWait();
    public static final String baseUrl = "https://jira-auto.codecool.metastage.net/";


    public static void clickButton(WebElement webElement){webElement.click();
    }

    public static void waitForWebElementToBePresent(WebElement webElement){
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitForElementToSendText(WebElement webElement, String text){
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).sendKeys(text);

    }
    public static void waitForElementToClick(WebElement webElement){
        wait.until(ExpectedConditions.elementToBeClickable(
                webElement
        )).click();
    }

    public static String getWebElementText(WebElement webElement){
        return webElement.getText();
    }

//    public static WebDriver getDriver(){
//        return Driver.getInstance().getDriver();
//    }
//
//    public static WebDriverWait getWait(){
//        return Driver.getInstance().getWait();
//    }

    public static void openUrl(String url){
        driver.get(baseUrl + url);
    }

    public static void beforeEachSetup() {
        driver.manage().window().maximize();
    }

    public static void close(){
        driver.close();
    }
}
