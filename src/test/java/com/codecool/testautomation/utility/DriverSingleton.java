package com.codecool.testautomation.utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DriverSingleton {

    private static DriverSingleton driverSingleton = null;
    private static WebDriver driver;
    private static WebDriverWait wait;

    private DriverSingleton() {
    }

    public static DriverSingleton getInstance() {
        if (driverSingleton == null) {
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        }
        return driverSingleton;
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static WebDriverWait getWait(){
        return wait;
    }

    public static void setDriverSingleton(DriverSingleton driverSingleton) {
        DriverSingleton.driverSingleton = driverSingleton;
    }

}



