package com.codecool.testautomation.page;

import com.codecool.testautomation.utility.Driver;
import com.codecool.testautomation.utility.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowsePage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy (xpath = "//*[@id='summary-val']") public WebElement browseIssueHeader;
    @FindBy (xpath = "//*[@id='key-val']") public WebElement issueLink;
    @FindBy (xpath = "//div[@class='aui-page-header-main']") public WebElement mainPageHeader;
    @FindBy (xpath = "//main[@id='main']/h1[@class='projects-error-page-heading']") public WebElement pageError;
    @FindBy (css = ".project-meta-value:nth-child(4)") public WebElement projectMetaValue;
    @FindBy (xpath = "/html//span[@id='issues-subnavigation-title']") public WebElement subnavigatorTitle;

    public BrowsePage() {
        this.driver = Driver.getInstance().getDriver();
        this.wait = Driver.getWait();
        PageFactory.initElements(driver, this);
    }
}