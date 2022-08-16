package com.codecool.testautomation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrowsePage {

    @FindBy (xpath = "//div[@class='aui-page-header-main']") public WebElement mainPageHeader;
    @FindBy (css = ".project-meta-value:nth-child(4)") public WebElement projectMetaValue;
    @FindBy (xpath = "//main[@id='main']/h1[@class='projects-error-page-heading']") public WebElement pageError;
    @FindBy (xpath = "/html//span[@id='issues-subnavigation-title']") public WebElement subnavigatorTitle;
    @FindBy (xpath = "//*[@id=\"summary-val\"]") public WebElement browseIssueHeader;
    @FindBy (xpath = "//*[@id=\"key-val\"]") public WebElement issueLink;

    public BrowsePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}