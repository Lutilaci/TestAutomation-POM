package com.codecool.testautomation.test;

import com.codecool.testautomation.page.PermissionsPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PermissionsWithGlassTest {

    PermissionsPage pPage;

    @BeforeAll
    public void setUp()
    {
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
//        driver.manage().window().maximize();
        pPage = new PermissionsPage();
        pPage.login();
    }

    @AfterAll
    public void quitDriver() {
        pPage.CloseDriver();
    }

    @Test
    public void availableRequiredIssuesInPPProject() {
        pPage.OpenPPProjectSettings();

        assertTrue(pPage.validateSettingIssues(Arrays.asList("Bug","Epic","Story","Sub-task","Task")));
    }

    @Test
    public void hasAllPPProjectIssueTypesInGlass() {
        pPage.OpenPPProjectSettings();
        List<String> issuesInSetting = pPage.GetAllIssueTypesFromSettings();
        pPage.OpenPPProjectGlassPage();


        assertTrue(pPage.validateDropDown(issuesInSetting));
        assertTrue(pPage.validateIcons(issuesInSetting));
    }

    @Test
    public void CheckPermissionAccess() {
        pPage.OpenPPProjectGlassPage();

        pPage.goToPermissionsMatrix();
        assertTrue(pPage.validatePermissionsMatrix("Browse Projects", "Any logged in user"));

        pPage.goToViewBy();
        assertTrue(pPage.validateViewBy("Browse Projects", "Granted to"));
    }
}
