package com.codecool.testautomation.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LogInLogout {
    public static String keyCode = "22";
    public static String username = "automation";
    public static String password = "CCAutoTest19.";


    public static void logIn(WebDriver driver){

        driver.findElement(By.id("login-form-username")).sendKeys(username+keyCode);
        driver.findElement(By.id("login-form-password")).sendKeys(password);
        driver.findElement(By.id("login-form-submit")).click();
    }

    public static void logout(WebDriver driver){
        driver.findElement(By.cssSelector(".aui-avatar-small img")).click();
        driver.findElement(By.cssSelector("#log_out")).click();
//        browsePage.profileAvatarButton.click();
//        browsePage.logoutButton.click();
    }
}
