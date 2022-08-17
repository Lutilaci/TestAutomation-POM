package com.codecool.testautomation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PermissionsPage {
    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"project-issuetypes-container\"]") public static List<WebElement> issueTypesContainer;
    @FindBy(xpath = "*[@id=\"glass-workflow-nav\"]/a/div") public static WebElement issueTypesDropDownButton;
    @FindBy(xpath = "//*[@id=\"dropdown-issuetypes\"]") public static WebElement issueTypesDropDownContainer;
    @FindBy(xpath = "//*[@id=\"glass-permissions-nav\"]") public static WebElement PermissionsMatrixButton;
    @FindBy(xpath = "//a[contains(text(),'View by Permissions')]") public static WebElement ViewByButton;

    //@FindAll(xpath = "//td//p[@class = \"title\"]") public static List<WebElement>WebElement p;



    public PermissionsPage(WebDriver driver) {
        this.driver = driver;
    }

    public  void  OpenPPProjectSettings()
    {
        driver.get("https://jira-auto.codecool.metastage.net/plugins/servlet/project-config/PP/summary");
    }

    public  void  OpenPPProjectGlassPage()
    {
        driver.get("https://jira-auto.codecool.metastage.net/projects/PP?selectedItem=com.codecanvas.glass:glass");
    }

    public List<String> GetAllIssueTypesFromSettings()
    {
        return new ArrayList<String>(Arrays.asList(driver.findElement(By.xpath("//*[@id=\"project-issuetypes-container\"]")).getText().split("\n")));
    }

    public void validateSettingIssues(List<String> requiredTypes) {

        assertTrue(GetAllIssueTypesFromSettings().containsAll(requiredTypes));
    }

    public void validateGlassIssues(List<String> issuesInSetting) {
        driver.findElement(By.xpath("//li[@id='glass-workflow-nav']/a/div")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"dropdown-issuetypes\"]"))));
        for(String s : issuesInSetting)
        {
            //Validate DropDown
            String dropDownPath = "//a[contains(.,' " + s + "')]";
            assertTrue(driver.findElement(By.xpath(dropDownPath)).isDisplayed());
            //ValidateIcons
            String spanPath = "//span[contains(@title, \"" + s + "\")]";
            assertTrue(driver.findElement(By.xpath(spanPath)).isDisplayed());
        }
    }


    public int findTrInPermissionMatrix(String trName) {
        List<WebElement> matrix = driver.findElements(By.xpath("//td//p[@class = \"title\"]"));
        int result = 0;
        for (WebElement e : matrix) {
            result++;
            if (e.getText().contains(trName))
                return result;
        }
        assertTrue(false);
        return 0;
    }


    public int findThInPermissionMatrix(String thName) {
        List<WebElement> matrix = driver.findElements(By.xpath("//th//b"));
        int result = 1;
        for (WebElement e : matrix)
        {
            result++;
            if (e.getText().contains(thName))
                return result;
        }
        assertTrue(false);
        return 0;
    }

    public int findTrInViewByPermissions(String thName) {
        List<WebElement> matrix = (driver.findElements(By.xpath("//tr//td//b")));
        int result = 0;
        for(WebElement e : matrix)
        {
            if(e.getText() != "") {
                result++;
                if (e.getText().contains(thName))
                    return result;
            }
        }
        assertTrue(false);
        return 0;
    }

    public int findThInViewByPermissions(String thName) {
        List<WebElement> matrix = driver.findElements(By.xpath("//th"));
        int result = 0;
        for(WebElement e : matrix)
        {
            if(e.getText() != "") {
                result++;
                if (e.getText().contains(thName)) {
                    return result;
                }
            }
        }
        assertTrue(false);
        return 0;
    }

    public void goToPermissionsMatrix() {
        driver.findElement(By.xpath("//*[@id=\"glass-permissions-nav\"]")).click();
    }

    public void validatePermissionsMatrix() {
        int tr = findTrInPermissionMatrix("Browse Projects");
        int th = findThInPermissionMatrix("Any logged in user");
        String selectedInMatrix = "//div[@id='glass-permissions-matrix-panel']/div/table/tbody/tr[" + tr + "]/td[" + th + "]/div";
        assertFalse(driver.findElements(By.xpath(selectedInMatrix)).isEmpty());
    }

    public void goToViewBy() {
        driver.findElement(By.xpath("//a[contains(text(),'View by Permissions')]")).click();
    }

    public void validateViewBy() {
        int tr = findTrInViewByPermissions("Browse Projects");
        int th = findThInViewByPermissions("Granted to");
        String selectedInMatrix = "//*[@id=\"glass-permissions-permissionview-panel\"]/div/table/tbody/tr[" + tr + "]/td[" + th + "]";
        assertTrue(driver.findElement(By.xpath(selectedInMatrix)).getText().contains("Application Access: Any logged in user"));
    }
}
