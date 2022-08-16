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
        logIn(driver);
    }

    @AfterEach
    public void tearDown() {
        logout(driver);
        driver.quit();
    }

    @Test
    public void browseProjects() {
        openWebPage(driver, "https://jira-auto.codecool.metastage.net/secure/BrowseProjects.jspa");
//        String pageHeader = browsePage.getWebElementText(browsePage.mainPageHeader);
//        Assertions.assertEquals("Browse projects", browsePage.getWebElementText(browsePage.mainPageHeader));
        validateText(getWebElementText(browsePage.mainPageHeader), "Browse projects");
    }

    @Test
    public void openExistingProject(){
        openWebPage(driver,"https://jira-auto.codecool.metastage.net/projects/MTP/summary");
        validateText(getWebElementText(browsePage.projectMetaValue), "MTP");
    }

    @Test
    public void openCOALAProject(){
        openWebPage(driver,"https://jira-auto.codecool.metastage.net/projects/COALA/summary");
        validateText(getWebElementText(browsePage.projectMetaValue), "COALA");
    }

    @Test
    public void openJETIProject(){
        openWebPage(driver,"https://jira-auto.codecool.metastage.net/projects/JETI/summary");
        validateText(getWebElementText(browsePage.projectMetaValue), "JETI");
    }

    @Test
    public void openTOUCANProject(){
        openWebPage(driver,"https://jira-auto.codecool.metastage.net/projects/TOUCAN/summary");
        validateText(getWebElementText(browsePage.projectMetaValue), "TOUCAN");
    }

    @Test
    public void openNonExistingProject() {
        openWebPage(driver,"https://jira-auto.codecool.metastage.net/projects/SOMETHING/summary");
        validateText(getWebElementText(browsePage.pageError), "You can't view this project");
    }
}
