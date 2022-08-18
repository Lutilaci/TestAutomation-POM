package com.codecool.testautomation.test;

import com.codecool.testautomation.page.BrowsePage;
import com.codecool.testautomation.utility.Driver;
import org.junit.jupiter.api.*;


import static com.codecool.testautomation.utility.LogIn.*;
import static com.codecool.testautomation.utility.Utility.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BrowseProjectsTest {
    private BrowsePage browsePage;

    @BeforeAll
    public void setUp() {
        browsePage = new BrowsePage();
        beforeEachSetup();
        logIn();
    }

    @AfterAll
    public void tearDown() {
        logout();
        close();
    }

    @Test
    public void browseProjects() {
        openUrl("secure/BrowseProjects.jspa");
        Assertions.assertEquals("Browse projects", getWebElementText(browsePage.mainPageHeader));
    }

    @Test
    public void openExistingProject(){
        openUrl("projects/MTP/summary");
        Assertions.assertEquals("MTP", getWebElementText(browsePage.projectMetaValue));
    }

    @Test
    public void openCOALAProject(){
        openUrl("projects/COALA/summary");
        Assertions.assertEquals("COALA", getWebElementText(browsePage.projectMetaValue));
    }

    @Test
    public void openJETIProject(){
        openUrl("projects/JETI/summary");
        Assertions.assertEquals("JETI", getWebElementText(browsePage.projectMetaValue));
    }

    @Test
    public void openTOUCANProject(){
        openUrl("projects/TOUCAN/summary");
        Assertions.assertEquals("TOUCAN", getWebElementText(browsePage.projectMetaValue));
    }

    @Test
    public void openNonExistingProject() {
        openUrl("projects/SOMETHING/summary");
        Assertions.assertEquals("You can't view this project", getWebElementText(browsePage.pageError));
    }
}
