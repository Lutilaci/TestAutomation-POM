package com.codecool.testautomation.test;

import com.codecool.testautomation.page.BrowsePage;
import com.codecool.testautomation.utility.DriverSingleton;
import org.junit.jupiter.api.*;

import static com.codecool.testautomation.utility.Utility.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BrowseProjectsTest {

//    static DriverSingleton driverSingleton = DriverSingleton.getInstance();
    private BrowsePage browsePage;

    @BeforeAll
    public void setUp() {
        browsePage = new BrowsePage();
        beforeEachSetup();
    }

    @AfterAll
    public void tearDown() {
//        logout(driver);
        close();

    }

    @Test
    public void browseProjects() {
        openUrl("secure/BrowseProjects.jspa");
        Assertions.assertEquals("Browse projects", browsePage.mainPageHeader.getText());
    }

    @Test
    public void openExistingProject(){
        openUrl("projects/MTP/summary");
        Assertions.assertEquals("MTP", browsePage.projectMetaValue.getText());
    }

    @Test
    public void openCOALAProject(){
        openUrl("projects/COALA/summary");
        Assertions.assertEquals("COALA", browsePage.projectMetaValue.getText());
    }

    @Test
    public void openJETIProject(){
        openUrl("projects/JETI/summary");
        Assertions.assertEquals("JETI", browsePage.projectMetaValue.getText());
    }

    @Test
    public void openTOUCANProject(){
        openUrl("projects/TOUCAN/summary");
        Assertions.assertEquals("TOUCAN", browsePage.projectMetaValue.getText());
    }

    @Test
    public void openNonExistingProject() {
        openUrl("projects/SOMETHING/summary");
        Assertions.assertEquals("You can't view this project", browsePage.pageError.getText());
    }
}