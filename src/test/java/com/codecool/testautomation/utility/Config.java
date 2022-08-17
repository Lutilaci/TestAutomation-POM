package com.codecool.testautomation.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Config {

        public static final WebDriver driver = new ChromeDriver();
        public static final Duration duration = Duration.ofSeconds(5);
        public static final WebDriverWait wait = new WebDriverWait(driver, duration);
        public static final String baseUrl = "https://jira-auto.codecool.metastage.net/";

        public static void beforeEachSetup() {
            driver.manage().window().maximize();
        }

        public static void openUrl(String url){
            driver.get(baseUrl + url);
        }

        public static void quitDriver(){
            driver.quit();
        }
    }

