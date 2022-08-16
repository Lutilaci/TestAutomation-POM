package com.codecool.testautomation.test;

import com.codecool.testautomation.page.EditIssuePage;
import com.codecool.testautomation.page.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codecool.testautomation.utility.LogIn.logIn;

public class EditIssueTest {
    private WebDriver driver;
    private EditIssuePage ei;
    private LoginPage lp;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jira-auto.codecool.metastage.net/browse/MTP-2096");
        ei = new EditIssuePage(driver);
        lp = new LoginPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        logIn(driver);
    }

    @AfterEach
    public void tearDown(){
        driver.close();
        driver.quit();
    }

    @Test
    public void editExistingIssue(){
        ei.clickEditIssue();
        ei.renameSummary();
        ei.updateIssue();
        ei.validateSummaryChanges();
        ei.rollBackSummaryChange();
    }

    @Test
    public void editIssueCancel(){
        ei.clickEditIssue();
        ei.renameSummary();
        ei.cancelUpdate();
        ei.validateCancel();
        ei.rollBackSummaryChange();
    }

    @Test
    public void addField(){
        ei.clickEditIssue();
        ei.addDescription();
        ei.updateIssue();
        ei.validateNewDescriptionText();
        ei.rollBackDescriptionChange();
    }
}
