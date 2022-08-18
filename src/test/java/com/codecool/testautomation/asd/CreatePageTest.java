package com.codecool.testautomation.asd;

import com.codecool.testautomation.page.CreatePage;
import com.codecool.testautomation.utility.DriverSingleton;
import org.junit.jupiter.api.*;

import static com.codecool.testautomation.utility.Utility.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CreatePageTest {

//    static DriverSingleton driverSingleton = DriverSingleton.getInstance();
    CreatePage createPage;

    @BeforeAll
    public void setUp() {
        DriverSingleton driverSingleton = DriverSingleton.getInstance();
        createPage = new CreatePage(DriverSingleton.getDriver());
        beforeEachSetup();
    }

    @AfterAll
    public void tearDown() {
        close();
//        quit();
    }

     // I can't create sub-task for COALA
    @Test
    public void createCOALASubTask(){
        openUrl("browse/COALA-130");
        Assertions.assertEquals("Create sub-task", getWebElementText(createPage.issueHeader));
        createPage.createSubTask();
        waitForWebElementToBePresent(createPage.popupMessage);
        Assertions.assertEquals("COALA-130 has been updated.", getWebElementText(createPage.popupMessage));
        Assertions.assertEquals("Sub-task test", getWebElementText(createPage.subTaskName));

        // Restore
        openUrl("browse/COALA-130");
        createPage.restoreSubTask();
    }

//     I can't create sub-task for TOUCAN
    @Test
    public void createTOUCANSubTask(){
        openUrl("browse/TOUCAN-132");
        Assertions.assertEquals("Create sub-task", getWebElementText(createPage.issueHeader));
        createPage.createSubTask();
        waitForWebElementToBePresent(createPage.popupMessage);
        Assertions.assertEquals("TOUCAN-121 has been updated.", getWebElementText(createPage.popupMessage));
        Assertions.assertEquals("Sub-task test", getWebElementText(createPage.subTaskName));

        // Restore
        openUrl("browse/TOUCAN-121");
        createPage.restoreSubTask();
    }
//
//    @Test
//    public void createJETISubTask(){
//        openUrl("browse/JETI-103");
//        Assertions.assertEquals("Create sub-task", getWebElementText(createPage.issueHeader));
//        createPage.createSubTask();
//        waitForWebElementToBePresent(createPage.popupMessage);
//        Assertions.assertEquals("JETI-103 has been updated.", getWebElementText(createPage.popupMessage));
//        Assertions.assertEquals("Sub-task test", getWebElementText(createPage.subTaskName));
//
//        // Restore
//        openUrl("browse/JETI-103");
//        createPage.restoreSubTask();
//    }

    @Test
    public void createNewIssue() {
        openUrl("secure/Dashboard.jspa");
        clickButton(createPage.mainCreateButton);
        createPage.createSpecificIssue("Main Testing Project", "Bug", "Happy Test");

        //lehet validálni a confirmation popup segítségével is

        Assertions.assertEquals(getWebElementText(createPage.projectName), "Main Testing Project");
        Assertions.assertEquals(getWebElementText(createPage.issueHeader), "Happy Test");

        // Restore
        createPage.restoreIssue("Main Testing Project", "Happy Test");
    }

    @Test
    public void createIssueWithEmptySummary(){
        openUrl("secure/Dashboard.jspa");
        createPage.createIssueWithEmptySummary();

        Assertions.assertEquals("You must specify a summary of the issue.", getWebElementText(createPage.createIssueErrorMessage));
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
        openUrl("secure/Dashboard.jspa");
        createPage.setProjectTo("TOUCAN");

        Assertions.assertEquals(createPage.issueTypesSupposedToBe, createPage.getIssueTypes());
    }

    @Test
    public void CancelIssueAfterFill() {
        openUrl("secure/Dashboard.jspa");
        clickButton(createPage.mainCreateButton);
        createPage.fillOutCreation("Main Testing Project", "Bug", "Issue Cancel Test");
        createPage.cancelCreation();
        createPage.validateIssueDoesntExist();

        Assertions.assertEquals("No issues were found to match your search", getWebElementText(createPage.resultPageContent));
    }
}
