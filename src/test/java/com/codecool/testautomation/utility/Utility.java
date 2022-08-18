package com.codecool.testautomation.utility;

 import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codecool.testautomation.utility.Config.*;

public class Utility {

    public static void logout(WebDriver driver){
        driver.findElement(By.cssSelector(".aui-avatar-small img")).click();
        driver.findElement(By.cssSelector("#log_out")).click();
    }

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
}
