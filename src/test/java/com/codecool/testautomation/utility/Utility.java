package com.codecool.testautomation.utility;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

public class Utility {

    public static String getWebElementText(WebElement element){
        return element.getText();
    }

    public static void validateText(String actual, String expected){
        Assertions.assertEquals(actual, expected);
    }
}
