package com.codecool.testautomation.test;

import com.codecool.testautomation.page.PermissionsPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static com.codecool.testautomation.utility.LogIn.logIn;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PermissionsWithGlassTest {

    WebDriver driver;
    PermissionsPage pPage;

    @BeforeAll
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        driver.manage().window().maximize();
        pPage = new PermissionsPage(driver);
        logIn(driver);
    }

    @AfterAll
    public void quitDriver() {
        driver.close();
        driver.quit();
    }

    @Test
    public void aviableRequiredIssuesInPPProject() {
        pPage.OpenPPProjectSettings();

        pPage.validateSettingIssues(Arrays.asList("Bug","Epic","Story","Sub-task","Task"));
    }

    @Test
    public void hasAllPPProjectIssueTypesInGlass() {
        pPage.OpenPPProjectSettings();
        List<String> issuesInSetting = pPage.GetAllIssueTypesFromSettings();
        pPage.OpenPPProjectGlassPage();

        pPage.validateGlassIssues(issuesInSetting);
    }

    @Test
    public void CheckPermissionAccess() {
        pPage.OpenPPProjectGlassPage();

        pPage.goToPermissionsMatrix();
        pPage.validatePermissionsMatrix();

        pPage.goToViewBy();
        pPage.validateViewBy();
    }
}
