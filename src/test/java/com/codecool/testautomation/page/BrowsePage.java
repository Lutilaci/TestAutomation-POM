package com.codecool.testautomation.page;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrowsePage {

    @FindBy (css = ".aui-page-header-main") public WebElement mainPageHeader;
    @FindBy (css = ".project-meta-value:nth-child(4)") public WebElement projectMetaValueMTP;
    @FindBy (css = ".project-meta-value:nth-child(4)") public WebElement projectMetaValueCOALA;
    @FindBy (css = ".project-meta-value:nth-child(4)") public WebElement projectMetaValueJETI;
    @FindBy (css = ".project-meta-value:nth-child(4)") public WebElement projectMetaValueTOUCAN;
    @FindBy (css = ".projects-error-page-heading") public WebElement pageError;
    @FindBy (css = ".subnavigator-title") public WebElement subnavigatorTitle;
    @FindBy (css = "#summary-val") public WebElement browseIssueHeader;
    @FindBy (css = ".issue-link") public WebElement issueLink;

    public BrowsePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}