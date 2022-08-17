package com.codecool.testautomation.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LogInLogout {

    public WebDriver driver;
    public static String keyCode = "22";
    public static String username = "automation";
    public static String password = "CCAutoTest19.";

    @FindBy (id = "login-form-username") public static WebElement usernameField;
    @FindBy (id = "login-form-password") public static WebElement passwordField;
    @FindBy (id = "login-form-submit") public static WebElement submitButton;
    @FindBy (css = ".aui-avatar-small img") public static WebElement avatarIcon;
    @FindBy (css = "#log_out") public static WebElement logoutButton;
    @FindBy (xpath = "//li[@id='user-options']/a") public static WebElement loginButton;
    @FindBy (xpath = "//*[@id=\"up-d-username\"]") public static WebElement usernameInProfile;

    public LogInLogout(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static void logIn(WebDriver driver){
        driver.get("https://jira-auto.codecool.metastage.net/login.jsp");
        driver.findElement(By.id("login-form-username")).sendKeys(username+keyCode);
        driver.findElement(By.id("login-form-password")).sendKeys(password);
        driver.findElement(By.id("login-form-submit")).click();
    }

    public static void logout(WebDriver driver){
        driver.findElement(By.cssSelector(".aui-avatar-small img")).click();
        driver.findElement(By.cssSelector("#log_out")).click();
    }

    public static void ValidateLogOut(WebDriver driver) {
        driver.get("https://jira-auto.codecool.metastage.net/secure/ViewProfile.jspa");

        assertTrue(driver.findElement(By.xpath("//li[@id='user-options']/a")).isDisplayed());
        assertTrue(driver.findElements(By.xpath("//*[@id=\"up-d-username\"]")).isEmpty());

    }
}
