package com.codecool.testautomation.page;

import com.codecool.testautomation.utility.LogIn;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "login-form-username")
    public WebElement usernameField;

    @FindBy(id = "login-form-password")
    public WebElement passwordField;

    @FindBy(id = "login-form-submit")
    public static WebElement logInButton;

    @FindBy(id = "header-details-user-fullname")
    public WebElement profilePicture;

    @FindBy(id = "view_profile")
    public WebElement profileButton;

    @FindBy(id = "up-user-title-name")
    public WebElement profileName;

    @FindBy(css = "p:nth-child(1)")
    public WebElement logInErrorMessage;

    static By captcha = By.xpath("//div[@id='captcha']/div/img");

    public LoginPage() {
    }

public void getUrl(String url)
{
    driver.get(url);
}



    public void fillUsernameAndPassword(){
        usernameField.sendKeys("automation"+ LogIn.keyCode);
        passwordField.sendKeys("CCAutoTest19.");
    }

    public void logIn(){
        logInButton.click();
    }

    public void validateLogin(){
        profilePicture.click();
        profileButton.click();
        Assertions.assertEquals("Auto Tester "+LogIn.keyCode, profileName.getText());
    }

    public void fillWrongUsernameAndPassword(){
        usernameField.sendKeys("IdoNtCare221");
        passwordField.sendKeys("I dont Care");
    }

    public void validateWrongLogin(){
        Assertions.assertEquals("Sorry, your username and password are incorrect - please try again.",
                logInErrorMessage.getText());
    }

    public void csvTestLogin(String username, String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }
}