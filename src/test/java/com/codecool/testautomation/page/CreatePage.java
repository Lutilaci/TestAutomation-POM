package com.codecool.testautomation.page;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CreatePage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy (xpath = "//*[@id=\"opsbar-operations_more\"]") public WebElement actionButton;
    @FindBy (xpath = "//button[contains(.,'Cancel')]") public WebElement cancelButton;
    @FindBy (xpath = "//div[@id='qf-field-summary']//div[@role='alert']") public WebElement createIssueErrorMessage;
    @FindBy (xpath = "//*[@id=\"create-issue-submit\"]") public WebElement createIssueButton;
    @FindBy (xpath = "//aui-item-link[@id='create-subtask']/a/span") public WebElement createSubClass;
    @FindBy (xpath = "//*[@id=\"delete-issue\"]/a") public WebElement deleteButton;
    @FindBy (xpath = "//*[@id=\"delete-issue-submit\"]") public WebElement finalDeleteButton;
    @FindBy (xpath = "//a[@class='issue-created-key']") public WebElement issueCreatedPopup;
    @FindBy (xpath="//*[@id=\"summary-val\"]") public WebElement issueHeader;
    @FindBy (xpath = "//a[contains(text(),'Issues')]") public WebElement issuesButton;
    @FindBy (xpath = "//ul[@class='aui-last']") public WebElement issueScrollDown;
    @FindBy (id ="issuetype-field") public WebElement issueTypeSelector;
    @FindBy (xpath = "//*[@id=\"create_link\"]") public WebElement mainCreateButton;
    @FindBy (xpath = "//a[@id='opsbar-operations_more']") public WebElement moreButton;
    @FindBy (xpath = "//a[@innertext='Happy Path']") public WebElement popupInnerText;
    @FindBy (xpath = "//*[@id=\"aui-flag-container\"]/div/div") public WebElement popupMessage;
    @FindBy (xpath = "//input[@id='project-field']") public WebElement projectField;
    @FindBy (css = ".no-results > h2") public WebElement resultPageContent;
    @FindBy (xpath = "(//button[@type='button'])[3]") public WebElement searchButton;
    @FindBy (xpath = "//*[@id=\"find_link\"]") public WebElement searchForIssuesButton;
    @FindBy (css = "#searcher-query") public WebElement searchForIssueField;
    @FindBy (css = ".stsummary > .issue-link") public WebElement subTaskName;
    @FindBy (xpath= "//*[@id=\"summary\"]") public WebElement summaryField;

    public List<String> supposedToBe = Arrays.asList("Bug", "Story", "Task");

    public CreatePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void restore(){
        wait.until(ExpectedConditions.elementToBeClickable(
                actionButton
        )).click();
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

    public void createSpecificIssue(WebDriverWait wait, String projectName, String issueType, String summary){
        mainCreateButton.click();
        clearProjectField();
        projectField.sendKeys(projectName);
        projectField.sendKeys(Keys.RETURN);
        clearIssueType(wait);
        issueTypeSelector.sendKeys(issueType);
        wait.until(ExpectedConditions.elementToBeClickable(
                issueTypeSelector)).sendKeys(Keys.RETURN);
        wait.until(ExpectedConditions.elementToBeClickable(
                summaryField)).sendKeys(summary);
        wait.until(ExpectedConditions.elementToBeClickable(
                createIssueButton)).click();
    }

    public void createIssueWithEmptySummary(){
        mainCreateButton.click();
        createIssueButton.click();
    }

    public void searchForIssue(String nameOfIssue){
        wait.until(ExpectedConditions.elementToBeClickable(
                issuesButton)).click();
        searchForIssuesButton.click();
        searchForIssueField.sendKeys(nameOfIssue);
        searchButton.click();
    }

    public void validateIssueTypes(){
        wait.until(ExpectedConditions.elementToBeClickable(
                issueTypeSelector)).click();

        List<String> issueTypes = new ArrayList<>();
        issueTypes.add(issueTypeSelector.getAttribute("value"));

        WebElement ul_Element = issueScrollDown;
        List<WebElement> li_All = ul_Element.findElements(By.tagName("li"));


        for (WebElement webElement : li_All) {
            issueTypes.add(webElement.getText());
        }

        cancelButton.click();
        Collections.sort(issueTypes);
        Assertions.assertEquals(supposedToBe, issueTypes);
    }

    public void setProjectTo(String project){
        mainCreateButton.click();
        clearProjectField();
        projectField.sendKeys(project);
        projectField.sendKeys(Keys.RETURN);
    }

    public void cancelCreation(){
        cancelButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }
}
