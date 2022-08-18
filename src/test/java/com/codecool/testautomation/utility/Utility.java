package com.codecool.testautomation.utility;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utility {

    public static void logout(WebDriver driver){
        driver.findElement(By.cssSelector(".aui-avatar-small img")).click();
        driver.findElement(By.cssSelector("#log_out")).click();
    }

    public static void clickButton(WebElement webElement){webElement.click();
    }
}
