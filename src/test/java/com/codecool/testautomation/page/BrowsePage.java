package com.codecool.testautomation.page;

import com.codecool.testautomation.utility.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrowsePage {
    static DriverSingleton driverSingleton = DriverSingleton.getInstance();
    private static final WebDriver driver = DriverSingleton.getDriver();

    @FindBy (xpath = "//*[@id=\"summary-val\"]") public WebElement browseIssueHeader;
    @FindBy (xpath = "//*[@id=\"key-val\"]") public WebElement issueLink;
    @FindBy (xpath = "//div[@class='aui-page-header-main']") public WebElement mainPageHeader;
    @FindBy (xpath = "//main[@id='main']/h1[@class='projects-error-page-heading']") public WebElement pageError;
    @FindBy (css = ".project-meta-value:nth-child(4)") public WebElement projectMetaValue;
    @FindBy (xpath = "/html//span[@id='issues-subnavigation-title']") public WebElement subnavigatorTitle;

    public BrowsePage() {
        PageFactory.initElements(driver, this);
    }
}