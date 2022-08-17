package com.codecool.testautomation.utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public abstract class Driver {
    private WebDriver driver;
    private String baseUrl;
    private WebDriverWait wait;
    private Duration duration = Duration.ofSeconds(5);

    public Driver() {
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        baseUrl = "https://jira-auto.codecool.metastage.net";
        wait = new WebDriverWait(driver, duration);
    }

    public void getUrl(String url){
        driver.get(baseUrl + url);
    }

    public void quitDriver(){
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }
}