package com.codecool.testautomation.test;

import com.codecool.testautomation.page.BrowsePage;
import com.codecool.testautomation.utility.Driver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static com.codecool.testautomation.utility.LogIn.*;
import static com.codecool.testautomation.utility.Utility.getWebElementText;
import static com.codecool.testautomation.utility.Utility.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BrowseIssuesTest {
    private BrowsePage browsePage;

    @BeforeAll
    public void setUp() {
        beforeEachSetup();
        browsePage = new BrowsePage();
        logIn();
    }

    @AfterAll
    public void tearDown() {
        logout();
        close();
    }

    @Test
    public void browseIssues(){
        openUrl("projects/MTP/issues/MTP-2020?filter=allopenissues");
        Assertions.assertEquals("All issues", getWebElementText(browsePage.subnavigatorTitle));
        Assertions.assertEquals("Happy Test", getWebElementText(browsePage.browseIssueHeader));
    }

    @Test
    public void CheckTOUCANIssueWithID1(){
        openUrl("browse/TOUCAN-1");
        Assertions.assertEquals("TOUCAN-1", getWebElementText(browsePage.issueLink));
    }

    @Test
    public void CheckTOUCANIssueWithID2(){
        openUrl("browse/TOUCAN-2");
        Assertions.assertEquals("TOUCAN-2", getWebElementText(browsePage.issueLink));
    }

    @Test
    public void CheckTOUCANIssueWithID3(){
        openUrl("browse/TOUCAN-3");
        Assertions.assertEquals("TOUCAN-3", getWebElementText(browsePage.issueLink));
    }

    @Test
    public void CheckJETIIssueWithID1(){
        openUrl("browse/JETI-1");
        Assertions.assertEquals("JETI-1", getWebElementText(browsePage.issueLink));
    }

    @Test
    public void CheckJETIIssueWithID2(){
        openUrl("browse/JETI-2");
        Assertions.assertEquals("JETI-2", getWebElementText(browsePage.issueLink));
    }

    @Test
    public void CheckJETIIssueWithID3(){
        openUrl("browse/JETI-3");
        Assertions.assertEquals("JETI-3", getWebElementText(browsePage.issueLink));
    }

    @Test
    public void CheckCOALAIssueWithID1(){
        openUrl("browse/COALA-1");
        Assertions.assertEquals("COALA-1", getWebElementText(browsePage.issueLink));
    }

    @Test
    public void CheckCOALAIssueWithID2(){
        openUrl("browse/COALA-2");
        Assertions.assertEquals("COALA-2", getWebElementText(browsePage.issueLink));
    }

    @Test
    public void CheckCOALAIssueWithID3(){
        openUrl("browse/COALA-3");
        Assertions.assertEquals("COALA-3", getWebElementText(browsePage.issueLink));
    }
}
