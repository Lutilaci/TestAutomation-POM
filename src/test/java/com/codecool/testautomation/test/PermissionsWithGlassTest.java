package com.codecool.testautomation.test;

import com.codecool.testautomation.page.PermissionsPage;
import com.codecool.testautomation.utility.DriverSingleton;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;
import java.util.List;

import static com.codecool.testautomation.utility.Utility.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PermissionsWithGlassTest {
    PermissionsPage pPage;

    @BeforeAll
    public void setUp()
    {
        pPage = new PermissionsPage();
    }

    @AfterAll
    public void quitDriver() {

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


        pPage.validateDropDown(issuesInSetting);
        pPage.validateIcons(issuesInSetting);
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