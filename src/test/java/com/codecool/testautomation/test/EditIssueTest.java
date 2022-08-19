package com.codecool.testautomation.test;

import com.codecool.testautomation.page.EditIssuePage;
import com.codecool.testautomation.page.LoginPage;
import com.codecool.testautomation.utility.Driver;
import org.junit.jupiter.api.*;

import static com.codecool.testautomation.utility.DriverSingleton.quit;
import static com.codecool.testautomation.utility.LogIn.logIn;


public class EditIssueTest {
    private EditIssuePage editIssuePage;
    private LoginPage loginPage;


    @BeforeEach
    public void setUp(){
        editIssuePage = new EditIssuePage();
        loginPage = new LoginPage();
        loginPage.getUrl("/browse/MTP-2096");
        loginPage.fillUsernameAndPassword();
        loginPage.logIn();
    }

    @AfterEach
    public void tearDown(){
        editIssuePage.restoreChanges();
        quit();
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
