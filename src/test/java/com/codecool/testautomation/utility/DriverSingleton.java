package com.codecool.testautomation.utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DriverSingleton {

    private static WebDriver driver = null;

    private DriverSingleton() {
    }

    public static WebDriver getInstance() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static void quit(){
        driver.quit();
        driver = null;
    }

}



