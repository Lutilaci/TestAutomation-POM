package com.codecool.testautomation.captcha;

import com.codecool.testautomation.utility.LogIn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.codecool.testautomation.utility.Utility.waitForWebElementToBePresent;

public class CaptchaPage {

    WebDriver driver;
    By captcha = By.xpath("//div[@id='captcha']/div/img");
    @FindBy(id = "login-form-submit")
    public static WebElement logInButton;
    @FindBy(id = "login-form-username")
    public static WebElement usernameField;
    @FindBy(id = "login-form-password")
    public static WebElement passwordField;
    @FindBy(id = "captcha")
    public static WebElement captchaPicture;

    public CaptchaPage() {
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
    }

    public void OpenLoginPage() {
        driver.get("https://jira-auto.codecool.metastage.net/login");
    }

    public void TryLoginThreeTimesWithWrongPassword(String password) {
        for (int i = 0; i<3; i++)
        {
            usernameField.sendKeys(LogIn.username+LogIn.keyCode);
            passwordField.sendKeys(password);
            logIn();
        }
    }

    public boolean ValidateCaptcha() {
        waitForWebElementToBePresent(captchaPicture);
        return driver.findElements(captcha).isEmpty();
    }

    public void fillUsernameAndPassword(String password){
        usernameField.sendKeys("automation"+ LogIn.keyCode);
        passwordField.sendKeys(password);
    }

    public void logIn(){
        logInButton.click();
    }

    public void CloseDriver()
    {
        driver.quit();
    }
}
