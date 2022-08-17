package com.codecool.testautomation.test;

import com.codecool.testautomation.page.CreatePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        validateText("Create sub-task", getWebElementText(createPage.issueHeader));
        createPage.createSubTask();
        createPage.validateCOALASubTaskCreation();

        // Restore
        openWebPage(driver,"https://jira-auto.codecool.metastage.net/browse/COALA-126");
        createPage.restoreSubTask();
    }

    // I can't create sub-task for TOUCAN
    @Test
    public void createTOUCANSubTask() {
        openWebPage(driver,"https://jira-auto.codecool.metastage.net/browse/TOUCAN-132");
        validateText(getWebElementText(createPage.issueHeader), "Create sub-task");
        createPage.createSubTask();
        createPage.validateTOUCANSubTaskCreation();

        // Restore
        openWebPage(driver,"https://jira-auto.codecool.metastage.net/browse/TOUCAN-121");
        createPage.restoreSubTask();
    }

    @Test
    public void createJETISubTask(){
        openWebPage(driver,"https://jira-auto.codecool.metastage.net/browse/JETI-103");
        validateText("Create sub-task", getWebElementText(createPage.issueHeader));
        createPage.createSubTask();
        createPage.validateJETISubTaskCreation();

        // Restore
        openWebPage(driver,"https://jira-auto.codecool.metastage.net/browse/JETI-103");
        createPage.restoreSubTask();

    }

    @Test
    public void createNewIssue() {
        createPage.clickCreateButton();
        createPage.createSpecificIssue(wait, "MTP", "Bug", "Happy Test");

        validateText(getWebElementText(createPage.issueHeader), "Happy Test");

        // Restore
        createPage.restoreIssue();
    }


    @Test
    public void createIssueWithEmptySummary(){
        createPage.createIssueWithEmptySummary();
        validateText("You must specify a summary of the issue.", getWebElementText(createPage.createIssueErrorMessage));
        createPage.cancelCreation();
    }

    @Test
    public void CreateIssueInCOALAProjectWithIssueTypes() {
        createPage.setProjectTo("COALA");
        createPage.validateIssueTypes();
    }

    // I don't have permission to create JETI project
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
        createPage.clickCreateButton();
        createPage.fillOutCreation(wait, "MTP", "Bug", "Issue Cancel Test");
        createPage.cancelCreation();
        createPage.validateIssueDoesntExist();
    }
}
