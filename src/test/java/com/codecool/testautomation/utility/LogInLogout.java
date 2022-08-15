package com.codecool.testautomation.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LogInLogout {

    public static String keyCode = "22";
    public static String username = "automation";
    public static String password = "CCAutoTest19.";

    @FindBy (id = "login-form-username") public static WebElement usernameField;
    @FindBy (id = "login-form-password") public static WebElement passwordField;
    @FindBy (id = "login-form-submit") public static WebElement submitButton;
    @FindBy (css = ".aui-avatar-small img") public static WebElement avatarIcon;
    @FindBy (css = "#log_out") public static WebElement logoutButton;

    public static void logIn(){
        usernameField.sendKeys(username+keyCode);
        passwordField.sendKeys(password);
        submitButton.click();
    }

    public static void logout(){
        avatarIcon.click();
        logoutButton.click();
    }
}
