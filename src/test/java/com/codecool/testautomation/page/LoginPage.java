package com.codecool.testautomation.page;

import com.codecool.testautomation.utility.DriverSingleton;
import com.codecool.testautomation.utility.LogIn;
import com.codecool.testautomation.utility.Utility;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.codecool.testautomation.utility.Utility.*;


public class LoginPage extends BasePage{

    @FindBy(id = "login-form-username")
    public WebElement usernameField;

    @FindBy(id = "login-form-password")
    public WebElement passwordField;

    @FindBy(id = "login-form-submit")
    public WebElement logInButton;

    @FindBy(id = "header-details-user-fullname")
    public WebElement profilePicture;

    @FindBy(id = "view_profile")
    public WebElement profileButton;

    @FindBy(id = "up-user-title-name")
    public WebElement profileName;

    @FindBy(css = "p:nth-child(1)")
    public WebElement logInErrorMessage;

    final String USER_NAME = Utility.getEnvironmentVar("USER_NAME");
    final String PASSWORD = Utility.getEnvironmentVar("PASSWORD");

    public LoginPage() {
    }

    public void fillUsernameAndPassword(String username, String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    public void logIn(){
        logInButton.click();
    }

    public void validateLogin(){
        profilePicture.click();
        profileButton.click();
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

    public static void ValidateLogOut(WebDriver driver) {
//        openUrl("secure/ViewProfile.jspa%22");

        Assertions.assertEquals(true, driver.findElement(By.xpath("//li[@id='user-options']/a")).isDisplayed());
        Assertions.assertEquals(true, driver.findElements(By.xpath("//*[@id='up-d-username']")).isEmpty());

    }
}