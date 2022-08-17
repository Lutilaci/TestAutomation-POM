package com.codecool.testautomation.test;

import com.codecool.testautomation.utility.LogInLogout;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LogOutTest {
    WebDriver driver;

    @BeforeAll
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }

    @AfterAll
    public void quitDriver() {
        driver.close();
        driver.quit();

    }
    @Test
    public void successfullLogOut()
    {
        LogInLogout.logIn(driver);
        LogInLogout.logout(driver);

        LogInLogout.ValidateLogOut(driver);

    }

}
