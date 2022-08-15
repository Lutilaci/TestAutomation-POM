package com.codecool.testautomation.test;

import com.codecool.testautomation.page.BrowsePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import static com.codecool.testautomation.utility.LogInLogout.logIn;
import static com.codecool.testautomation.utility.LogInLogout.logout;
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
        logIn();
    }

    @AfterEach
    public void tearDown() {
        logout();
        driver.quit();
    }

    @Test
    public void browseIssues(){
        driver.get("https://jira-auto.codecool.metastage.net/projects/MTP/issues/MTP-2020?filter=allopenissues");
//        String openIssues = browsePage.getWebElementText(browsePage.subnavigatorTitle);
//        Assertions.assertEquals("All issues", browsePage.getWebElementText(browsePage.subnavigatorTitle));
        validateText("All issues", getWebElementText(browsePage.subnavigatorTitle));
//        String header = browsePage.getWebElementText(browsePage.browseIssueHeader);
        System.out.println(getWebElementText(browsePage.browseIssueHeader));
//        Assertions.assertEquals("Happy Path", browsePage.getWebElementText(browsePage.browseIssueHeader));
        validateText("Happy Path", getWebElementText(browsePage.browseIssueHeader));
    }

    @Test
    public void CheckTOUCANIssueWithID1(){
        driver.get("https://jira-auto.codecool.metastage.net/browse/TOUCAN-1");
//        String issueID = browsePage.getWebElementText(browsePage.issueLink);
//        Assertions.assertEquals("TOUCAN-1", browsePage.getWebElementText(browsePage.issueLink));
        validateText("TOUCAN-1", getWebElementText(browsePage.issueLink));
    }

    @Test
    public void CheckTOUCANIssueWithID2(){
        driver.get("https://jira-auto.codecool.metastage.net/browse/TOUCAN-2");
//        String issueID = browsePage.getWebElementText(browsePage.issueLink);
//        Assertions.assertEquals("TOUCAN-2", browsePage.getWebElementText(browsePage.issueLink));
        validateText("TOUCAN-2", getWebElementText(browsePage.issueLink));
    }

    @Test
    public void CheckTOUCANIssueWithID3(){
        driver.get("https://jira-auto.codecool.metastage.net/browse/TOUCAN-3");
//        String issueID = browsePage.issueLink.getText();
//        Assertions.assertEquals("TOUCAN-3", browsePage.getWebElementText(browsePage.issueLink));
        validateText("TOUCAN-3", getWebElementText(browsePage.issueLink));
    }

    @Test
    public void CheckJETIIssueWithID1(){
        driver.get("https://jira-auto.codecool.metastage.net/browse/JETI-1");
//        String issueID = browsePage.getWebElementText(browsePage.issueLink);
//        Assertions.assertEquals("JETI-1", browsePage.getWebElementText(browsePage.issueLink));
        validateText("JETI-1", getWebElementText(browsePage.issueLink));
    }

    @Test
    public void CheckJETIIssueWithID2(){
        driver.get("https://jira-auto.codecool.metastage.net/browse/JETI-2");
//        String issueID = browsePage.getWebElementText(browsePage.issueLink);
//        Assertions.assertEquals("JETI-2", browsePage.getWebElementText(browsePage.issueLink));
        validateText("JETI-2", getWebElementText(browsePage.issueLink));
    }

    @Test
    public void CheckJETIIssueWithID3(){
        driver.get("https://jira-auto.codecool.metastage.net/browse/JETI-3");
//        String issueID = browsePage.getWebElementText(browsePage.issueLink);
//        Assertions.assertEquals("JETI-3", browsePage.getWebElementText(browsePage.issueLink));
        validateText("JETI-3", getWebElementText(browsePage.issueLink));
    }

    @Test
    public void CheckCOALAIssueWithID1(){
        driver.get("https://jira-auto.codecool.metastage.net/browse/COALA-1");
//        String issueID = browsePage.getWebElementText(browsePage.issueLink);
//        Assertions.assertEquals("COALA-1", browsePage.getWebElementText(browsePage.issueLink));
        validateText("COALA-1", getWebElementText(browsePage.issueLink));
    }

    @Test
    public void CheckCOALAIssueWithID2(){
        driver.get("https://jira-auto.codecool.metastage.net/browse/COALA-2");
//        String issueID = browsePage.getWebElementText(browsePage.issueLink);
//        Assertions.assertEquals("COALA-2", browsePage.getWebElementText(browsePage.issueLink));
        validateText("COALA-2", getWebElementText(browsePage.issueLink));
    }

    @Test
    public void CheckCOALAIssueWithID3(){
        driver.get("https://jira-auto.codecool.metastage.net/browse/COALA-3");
//        String issueID = browsePage.issueLink.getText();
//        Assertions.assertEquals("COALA-3", browsePage.getWebElementText(browsePage.issueLink));
        validateText("COALA-3", getWebElementText(browsePage.issueLink));
    }
}
