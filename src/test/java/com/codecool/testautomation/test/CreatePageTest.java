package com.codecool.testautomation.test;

import com.codecool.testautomation.page.CreatePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codecool.testautomation.utility.LogIn.*;
import static com.codecool.testautomation.utility.Utility.*;


public class CreatePageTest {

    private WebDriver driver;
    private CreatePage createPage;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        createPage = new CreatePage(driver);
        driver.get("https://jira-auto.codecool.metastage.net/login.jsp");
        logIn(driver);
    }

    @AfterEach
    public void tearDown() {
        logout(driver);
        driver.quit();
    }

    // I can't create sub-task for COALA
    @Test
    public void createCOALASubTask() {
        openWebPage(driver,"https://jira-auto.codecool.metastage.net/browse/COALA-126");
//        String header = getWebElementText(createPage.issueHeader);
//        Assertions.assertEquals("Create sub-task", header);
        validateText("Create sub-task", getWebElementText(createPage.issueHeader));
        createPage.createSubTask();
        createPage.popupMessage.isDisplayed();
//        String result = createPage.popupMessage.getText();
//        Assertions.assertEquals("COALA-126 has been updated.", result);
//        String subTaskName = createPage.subTaskName.getText();
//        Assertions.assertEquals("Sub-task test", subTaskName);
        validateText("COALA-126 has been updated.", getWebElementText(createPage.popupMessage));
        validateText("Sub-task test", getWebElementText(createPage.subTaskName));

        // Restore
        openWebPage(driver,"https://jira-auto.codecool.metastage.net/browse/COALA-126");
        createPage.restore();
    }

    // I can't create sub-task for TOUCAN
    @Test
    public void createTOUCANSubTask() {
        openWebPage(driver,"https://jira-auto.codecool.metastage.net/browse/TOUCAN-132");
        validateText(getWebElementText(createPage.issueHeader), "Create sub-task");
        createPage.createSubTask();
        createPage.popupMessage.isDisplayed();
        validateText("TOUCAN-121 has been updated.", getWebElementText(createPage.popupMessage));
        validateText("Sub-task test", getWebElementText(createPage.subTaskName));

        // Restore
        openWebPage(driver,"https://jira-auto.codecool.metastage.net/browse/TOUCAN-121");
        createPage.restore();
    }

    @Test
    public void createJETISubTask(){
        openWebPage(driver,"https://jira-auto.codecool.metastage.net/browse/JETI-61");
        validateText("JETI Happy Path", getWebElementText(createPage.issueHeader));
        createPage.createSubTask();
        createPage.popupMessage.isDisplayed();
        validateText("JETI-61 has been updated.", getWebElementText(createPage.popupMessage));
        validateText("Sub-task test", getWebElementText(createPage.subTaskName));

        // Restore
        openWebPage(driver,"https://jira-auto.codecool.metastage.net/browse/JETI-61");
        createPage.restore();
    }

    @Test
    public void createNewIssue() {
        createPage.createSpecificIssue(wait, "MTP", "Bug", "Happy Path");

        wait.until(ExpectedConditions.visibilityOf(createPage.popupMessage));
        wait.until(ExpectedConditions.elementToBeClickable(
                        driver.findElement(By.partialLinkText("Happy Path")))).click();

        validateText("Happy Path", getWebElementText(createPage.issueHeader));

        // Restore
        createPage.restore();
    }


    @Test
    public void createIssueWithEmptySummary(){
        createPage.createIssueWithEmptySummary();
        validateText("You must specify a summary of the issue.", getWebElementText(createPage.createIssueErrorMessage));
        createPage.cancelButton.click();
        driver.switchTo().alert().accept();
    }

    @Test
    public void CreateIssueInCOALAProjectWithIssueTypes() {
        createPage.setProjectTo("COALA");
        createPage.validateIssueTypes();
    }

    @Test
    public void CreateIssueInJETIProjectWithIssueTypes() {
        createPage.setProjectTo("JETI");
        createPage.validateIssueTypes();
    }

    // I don't have permission to create TOUCAN project
    @Test
    public void CreateIssueInTOUCANProjectWithIssueTypes() {
        createPage.setProjectTo("TOUCAN");
        createPage.validateIssueTypes();
    }

    @Test
    public void CancelIssueAfterFill() {
        createPage.createSpecificIssue(wait, "MTP", "Bug", "Issue Cancel Test");
        createPage.cancelCreation();
        wait.until(ExpectedConditions.elementToBeClickable(
            createPage.issuesButton)).click();
//        createPage.searchForIssue("Issue Cancel Test");
        createPage.searchForIssuesButton.click();
        wait.until(ExpectedConditions.visibilityOf(createPage.searchForIssueField)).sendKeys("Issue Cancel Test");
//        createPage.searchForIssueField.sendKeys("Issue Cancel Test");
        createPage.searchButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(createPage.resultPageContent));
        validateText("No issues were found to match your search", getWebElementText(createPage.resultPageContent));
    }
}
