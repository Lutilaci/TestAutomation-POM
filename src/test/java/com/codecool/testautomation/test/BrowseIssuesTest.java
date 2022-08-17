package com.codecool.testautomation.test;

import com.codecool.testautomation.page.BrowsePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import static com.codecool.testautomation.utility.LogIn.*;
import static com.codecool.testautomation.utility.Utility.*;


public class BrowseIssuesTest {
    private WebDriver driver;
    private BrowsePage browsePage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        browsePage = new BrowsePage(driver);
        driver.get("https://jira-auto.codecool.metastage.net/login.jsp");
        logIn(driver);
    }

    @AfterEach
    public void tearDown() {
        logout(driver);
        driver.quit();
    }

    @Test
    public void browseIssues(){
        driver.get("https://jira-auto.codecool.metastage.net/projects/MTP/issues/MTP-2020?filter=allopenissues");
        validateText("All issues", getWebElementText(browsePage.subnavigatorTitle));
        validateText("Happy Path", getWebElementText(browsePage.browseIssueHeader));
    }

    @Test
    public void CheckTOUCANIssueWithID1(){
        driver.get("https://jira-auto.codecool.metastage.net/browse/TOUCAN-1");
        validateText("TOUCAN-1", getWebElementText(browsePage.issueLink));
    }

    @Test
    public void CheckTOUCANIssueWithID2(){
        driver.get("https://jira-auto.codecool.metastage.net/browse/TOUCAN-2");
        validateText("TOUCAN-2", getWebElementText(browsePage.issueLink));
    }

    @Test
    public void CheckTOUCANIssueWithID3(){
        driver.get("https://jira-auto.codecool.metastage.net/browse/TOUCAN-3");
        validateText("TOUCAN-3", getWebElementText(browsePage.issueLink));
    }

    @Test
    public void CheckJETIIssueWithID1(){
        driver.get("https://jira-auto.codecool.metastage.net/browse/JETI-1");
        validateText("JETI-1", getWebElementText(browsePage.issueLink));
    }

    @Test
    public void CheckJETIIssueWithID2(){
        driver.get("https://jira-auto.codecool.metastage.net/browse/JETI-2");
        validateText("JETI-2", getWebElementText(browsePage.issueLink));
    }

    @Test
    public void CheckJETIIssueWithID3(){
        driver.get("https://jira-auto.codecool.metastage.net/browse/JETI-3");
        validateText("JETI-3", getWebElementText(browsePage.issueLink));
    }

    @Test
    public void CheckCOALAIssueWithID1(){
        driver.get("https://jira-auto.codecool.metastage.net/browse/COALA-1");
        validateText("COALA-1", getWebElementText(browsePage.issueLink));
    }

    @Test
    public void CheckCOALAIssueWithID2(){
        driver.get("https://jira-auto.codecool.metastage.net/browse/COALA-2");
        validateText("COALA-2", getWebElementText(browsePage.issueLink));
    }

    @Test
    public void CheckCOALAIssueWithID3(){
        driver.get("https://jira-auto.codecool.metastage.net/browse/COALA-3");
        validateText("COALA-3", getWebElementText(browsePage.issueLink));
    }
}
