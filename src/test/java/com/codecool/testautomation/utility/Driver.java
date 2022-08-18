package com.codecool.testautomation.utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Driver {

    public static Driver driverInstance = null;
    public static WebDriver driver;
    private String baseUrl;
    private static WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(5));
    private Duration duration = Duration.ofSeconds(5);

    private Driver() {
    }

        public static Driver getInstance() {
        if (driverInstance == null) {
            driver = new ChromeDriver();
        }
        return driverInstance;
    }

    public void getUrl(String url){
        driver.get(baseUrl + url);
    }

    public void quitDriver(){
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }

    public static WebDriverWait getWait() {
    return wait;
    }
}


