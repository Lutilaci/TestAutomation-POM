package com.codecool.testautomation.test;

import com.codecool.testautomation.page.CreatePage;
import org.junit.jupiter.api.*;

import static com.codecool.testautomation.utility.LogIn.*;
import static com.codecool.testautomation.utility.Config.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CreatePageTest {
    private CreatePage createPage = new CreatePage();

    @BeforeAll
    public void setUp() {
        driver.manage().window().maximize();
        logIn(driver);
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }

//     I can't create sub-task for COALA
    @Test
    public void createCOALASubTask() {
        openUrl("browse/COALA-130");
        Assertions.assertEquals("Create sub-task", createPage.issueHeader.getText());
        createPage.createSubTask();
        createPage.waitForWebElementToBePresent(createPage.popupMessage);
        Assertions.assertEquals("COALA-130 has been updated.", createPage.popupMessage.getText());
        Assertions.assertEquals("Sub-task test", createPage.subTaskName.getText());

        // Restore
        openUrl("browse/COALA-130");
        createPage.restoreSubTask();
    }

//     I can't create sub-task for TOUCAN
    @Test
    public void createTOUCANSubTask() {
        openUrl("browse/TOUCAN-132");
        Assertions.assertEquals("Create sub-task", createPage.issueHeader.getText());
        createPage.createSubTask();
        createPage.waitForWebElementToBePresent(createPage.popupMessage);
        Assertions.assertEquals("TOUCAN-121 has been updated.", createPage.popupMessage.getText());
        Assertions.assertEquals("Sub-task test", createPage.subTaskName.getText());

        // Restore
        openUrl("browse/TOUCAN-121");
        createPage.restoreSubTask();
    }

    @Test
    public void createJETISubTask(){
        openUrl("browse/JETI-103");
        Assertions.assertEquals("Create sub-task", createPage.issueHeader.getText());
        createPage.createSubTask();
        createPage.waitForWebElementToBePresent(createPage.popupMessage);
        Assertions.assertEquals("JETI-103 has been updated.", createPage.popupMessage.getText());
        Assertions.assertEquals("Sub-task test", createPage.subTaskName.getText());

        // Restore
        openUrl("browse/JETI-103");
        createPage.restoreSubTask();
    }

    @Test
    public void createNewIssue() {
        openUrl("secure/Dashboard.jspa");
        createPage.clickCreateButton();
        createPage.createSpecificIssue(wait, "MTP", "Bug", "Happy Test");

        // Restore
        createPage.restoreIssue();
    }

    @Test
    public void createIssueWithEmptySummary(){
        openUrl("secure/Dashboard.jspa");
        createPage.createIssueWithEmptySummary();

        Assertions.assertEquals("You must specify a summary of the issue.", createPage.createIssueErrorMessage.getText());
        createPage.cancelCreation();
    }

    @Test
    public void CreateIssueInCOALAProjectWithIssueTypes() {
        openUrl("secure/Dashboard.jspa");
        createPage.setProjectTo("COALA");

        Assertions.assertEquals(createPage.issueTypesSupposedToBe, createPage.getIssueTypes());
    }

    @Test
    public void CreateIssueInJETIProjectWithIssueTypes() {
        openUrl("secure/Dashboard.jspa");
        createPage.setProjectTo("JETI");

        Assertions.assertEquals(createPage.issueTypesSupposedToBe, createPage.getIssueTypes());
    }

    // I don't have permission to create TOUCAN project
    @Test
    public void CreateIssueInTOUCANProjectWithIssueTypes() {
        createPage.setProjectTo("TOUCAN");

        Assertions.assertEquals(createPage.issueTypesSupposedToBe, createPage.getIssueTypes());
    }

    @Test
    public void CancelIssueAfterFill() {
        openUrl("secure/Dashboard.jspa");
        createPage.clickCreateButton();
        createPage.fillOutCreation(wait, "MTP", "Bug", "Issue Cancel Test");
        createPage.cancelCreation();
        createPage.validateIssueDoesntExist();

        Assertions.assertEquals("No issues were found to match your search", createPage.resultPageContent.getText());
    }
}
