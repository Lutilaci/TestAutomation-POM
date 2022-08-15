package com.codecool.testautomation.test;

import com.codecool.testautomation.page.BrowsePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import static com.codecool.testautomation.utility.LogInLogout.logIn;
import static com.codecool.testautomation.utility.LogInLogout.logout;


public class BrowseProjectsTest {
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
    public void browseProjects() {
        driver.get("https://jira-auto.codecool.metastage.net/secure/BrowseProjects.jspa");
//        String pageHeader = browsePage.getWebElementText(browsePage.mainPageHeader);
//        Assertions.assertEquals("Browse projects", browsePage.getWebElementText(browsePage.mainPageHeader));
        browsePage.validateText("Browse projects", browsePage.getWebElementText(browsePage.mainPageHeader));
    }

    @Test
    public void openExistingProject(){
        driver.get("https://jira-auto.codecool.metastage.net/projects/MTP/summary");
//        String projectKey = browsePage.getWebElementText(browsePage.projectMetaValueMTP);
//        Assertions.assertEquals("MTP", browsePage.getWebElementText(browsePage.projectMetaValueMTP));
        browsePage.validateText("MTP", browsePage.getWebElementText(browsePage.projectMetaValueMTP));
    }

    @Test
    public void openCOALAProject(){
        driver.get("https://jira-auto.codecool.metastage.net/projects/COALA/summary");
//        String projectKey = browsePage.getWebElementText(browsePage.projectMetaValueCOALA);
//        Assertions.assertEquals("COALA", browsePage.getWebElementText(browsePage.projectMetaValueCOALA));
        browsePage.validateText("COALA", browsePage.getWebElementText(browsePage.projectMetaValueCOALA));
    }

    @Test
    public void openJETIProject(){
        driver.get("https://jira-auto.codecool.metastage.net/projects/JETI/summary");
//        String projectKey = browsePage.getWebElementText(browsePage.projectMetaValueJETI);
//        Assertions.assertEquals("JETI", browsePage.getWebElementText(browsePage.projectMetaValueJETI));
        browsePage.validateText("JETI", browsePage.getWebElementText(browsePage.projectMetaValueJETI));
    }

    @Test
    public void openTOUCANProject(){
        driver.get("https://jira-auto.codecool.metastage.net/projects/TOUCAN/summary");
//        String projectKey = browsePage.getWebElementText(browsePage.projectMetaValueTOUCAN);
//        Assertions.assertEquals("TOUCAN", browsePage.getWebElementText(browsePage.projectMetaValueTOUCAN));
        browsePage.validateText("TOUCAN", browsePage.getWebElementText(browsePage.projectMetaValueTOUCAN));
    }

    @Test
    public void openNonExistingProject() {
        driver.get("https://jira-auto.codecool.metastage.net/projects/SOMETHING/summary");
//        String errorMessage = browsePage.getWebElementText(browsePage.pageError);
//        Assertions.assertEquals("You can't view this project", browsePage.getWebElementText(browsePage.pageError));
        browsePage.validateText("You can't view this project", browsePage.getWebElementText(browsePage.pageError));
    }
}
