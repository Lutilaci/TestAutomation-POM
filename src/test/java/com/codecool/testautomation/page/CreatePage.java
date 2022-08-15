package com.codecool.testautomation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    @FindBy (xpath = "//*[@id=\"opsbar-operations_more\"]") public WebElement actionButton;
    @FindBy (xpath = "//a[contains(text(),'Delete')]") public WebElement deleteSubTaskButton;
    @FindBy (xpath = "//input[@id='delete-issue-submit']") public WebElement finalSubTaskDeleteButton;
    @FindBy (css = "#issuetype-single-select > .icon") public WebElement issueTypeSelectorButton;
    @FindBy (css = ".no-results > h2") public WebElement resultPageContent;
    @FindBy (xpath = "//ul[@class='aui-last']") public WebElement issueScrollDown;

    public CreatePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void restoreSubTask(WebDriverWait wait){
        wait.until(ExpectedConditions.elementToBeClickable(
                actionButton
        ));
        actionButton.click();
        deleteSubTaskButton.click();
        finalSubTaskDeleteButton.click();
    }

    public void restoreIssue(WebDriverWait wait){
        wait.until(ExpectedConditions.elementToBeClickable(
                actionButton
        ));
        actionButton.click();
        deleteButton.click();
        finalDeleteButton.click();
    }

    public void createSubTask(){
        moreButton.click();
        createSubClass.click();
        summaryField.sendKeys("Sub-task test");
        createIssueButton.click();
    }

    public void clearIssueType(WebDriverWait wait){
        String os = System.getProperty("os.name");
        wait.until(ExpectedConditions.elementToBeClickable(issueTypeSelector));
        if (os.equals("Mac OS X")){
            issueTypeSelector.sendKeys(Keys.COMMAND + "a");
        }else{
            issueTypeSelector.sendKeys(Keys.CONTROL + "a");
        }
        issueTypeSelector.sendKeys(Keys.DELETE);
    }

    public void clearProjectField(){
        String os = System.getProperty("os.name");
        if (os.equals("Mac OS X")){
            projectField.sendKeys(Keys.COMMAND + "a");
        }else{
            projectField.sendKeys(Keys.CONTROL + "a");
        }
        projectField.sendKeys(Keys.DELETE);
    }

    public void createSpecificIssue(WebDriverWait wait, String projectName, String issueType){
        mainCreateButton.click();
        clearProjectField();
        projectField.sendKeys(projectName);
        projectField.sendKeys(Keys.RETURN);
        clearIssueType(wait);
        issueTypeSelector.sendKeys(issueType);
        issueTypeSelector.sendKeys(Keys.RETURN);
    }
}
