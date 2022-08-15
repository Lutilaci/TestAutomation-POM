package com.codecool.testautomation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatePage {

    @FindBy (css = "#create_link") public WebElement mainCreateButton;
    @FindBy (xpath = "//input[@id='project-field']") public WebElement projectField;
    @FindBy (id ="issuetype-field") public WebElement issueTypeSelector;
    @FindBy (xpath= "//*[@id=\"summary\"]") public WebElement summaryField;
    @FindBy (css = "#create-issue-submit") public WebElement createIssueButton;
    @FindBy (css = ".aui-message") public WebElement popupMessage;
    @FindBy (xpath = "//a[@class='issue-created-key']") public WebElement issueCreatedPopup;
    @FindBy (xpath = "//a[contains(text(),'Issues')]") public WebElement issuesButton;
    @FindBy (id="summary-val") public WebElement issueHeader;
    @FindBy (xpath = "//aui-item-link[@id='create-subtask']/a/span") public WebElement createSubClass;
    @FindBy (css = "#issues_new_search_link_lnk") public WebElement searchForIssuesButton;
    @FindBy (css = "#searcher-query") public WebElement searchForIssueField;
    @FindBy (xpath = "(//button[@type='button'])[3]") public WebElement searchButton;
    @FindBy (css = "#opsbar-operations_more") public WebElement moreOptionButton;
    @FindBy (css = "#delete-issue .trigger-label") public WebElement deleteButton;
    @FindBy (css = "#delete-issue-submit") public WebElement finalDeleteButton;
    @FindBy (css = ".error") public WebElement createIssueErrorMessage;
    @FindBy (xpath = "//button[contains(.,'Cancel')]") public WebElement cancelButton;
    @FindBy (xpath = "//a[@id='opsbar-operations_more']") public WebElement moreButton;
    @FindBy (css = ".stsummary > .issue-link") public WebElement subTaskName;
    @FindBy (xpath = "//span[contains(.,'Actions')]") public WebElement actionButton;
    @FindBy (xpath = "//a[contains(text(),'Delete')]") public WebElement deleteSubTaskButton;
    @FindBy (xpath = "//input[@id='delete-issue-submit']") public WebElement finalSubTaskDeleteButton;
    @FindBy (css = "#issuetype-single-select > .icon") public WebElement issueTypeSelectorButton;
    @FindBy (css = ".no-results > h2") public WebElement resultPageContent;
    @FindBy (xpath = "//ul[@class='aui-last']") public WebElement issueScrollDown;

    public CreatePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void restore(){
        actionButton.click();
        deleteSubTaskButton.click();
        finalSubTaskDeleteButton.click();
    }

    public void createSubTask(){
        moreButton.click();
        createSubClass.click();
        summaryField.sendKeys("Sub-task test");
        createIssueButton.click();
    }
}
