package com.codecool.testautomation.test;

import com.codecool.testautomation.page.EditIssuePage;
import com.codecool.testautomation.utility.DriverSingleton;
import org.junit.jupiter.api.*;

import static com.codecool.testautomation.utility.Utility.*;


public class EditIssueTest{
    private EditIssuePage editIssuePage;

    @BeforeEach
    public void setUp(){
//        openUrl("/browse/MTP-2096");
        editIssuePage = new EditIssuePage();
    }

    @AfterEach
    public void tearDown(){
        editIssuePage.restoreChanges();
    }
    @Test
    public void editExistingIssue(){
        editIssuePage.clickEditIssue();
        editIssuePage.renameSummary("Happy Path Edit");
        editIssuePage.updateIssue();
        Assertions.assertEquals("Happy Path Edit", editIssuePage.getSummary());
    }

    @Test
    public void editIssueCancel(){
        editIssuePage.clickEditIssue();
        editIssuePage.renameSummary("Happy Path Edit");
        editIssuePage.cancelUpdate();
        Assertions.assertEquals("Happy Path", editIssuePage.getSummary());
    }

    @Test
    public void addField(){
        editIssuePage.clickEditIssue();
        editIssuePage.addDescription("new description");
        editIssuePage.updateIssue();
        Assertions.assertEquals("new description",editIssuePage.getDescription());

    }
}