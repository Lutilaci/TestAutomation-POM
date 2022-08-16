package com.codecool.testautomation.page;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EditIssuePage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "edit-issue")
    public WebElement editButton;

    @FindBy(id = "summary")
    public WebElement summaryField;

    @FindBy(id = "summary-val")
    public WebElement summaryValue;

    @FindBy(id = "description")
    public WebElement descriptionField;

    @FindBy(id = "description-val")
    public WebElement descriptionValue;

    @FindBy(id = "edit-issue-submit")
    public WebElement updateButton;

    @FindBy(xpath = "//*[@id=\"description-wiki-edit\"]/nav/div/div/ul/li[2]/button")
    public WebElement switchTextMode;

    @FindBy(xpath = "//*[@id=\"edit-issue-dialog\"]/footer/div/div/button")
    public WebElement cancelChangesButton;

    @FindBy(id = "fixVersions-textarea")
    public WebElement fixVersionsField;

    @FindBy(css = ".item-delete")
    public WebElement fixVersionDelete;

    @FindBy(id = "action_id_21")
    public WebElement inProgressButton;

    @FindBy(xpath = "//*[@id=\"aui-flag-container\"]/div/div")
    public WebElement updateSuccessMessage;

    public EditIssuePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickEditIssue(){
        wait.until(ExpectedConditions.elementToBeClickable(
                editButton)).click();
    }

    public void renameSummary(){
        wait.until(ExpectedConditions.elementToBeClickable(
                summaryField)).clear();
        summaryField.sendKeys("Happy Path Edit");
    }

    public void updateIssue(){
       updateButton.click();
    }

    public void cancelUpdate(){
        cancelChangesButton.click();
        driver.switchTo().alert().accept();
    }

    public void validateSummaryChanges(){
        wait.until(ExpectedConditions.elementToBeClickable(
                updateSuccessMessage));
        Assertions.assertEquals("MTP-2096 has been updated.",updateSuccessMessage.getText());
        Assertions.assertEquals("Happy Path Edit",summaryValue.getText());
    }

    public void validateCancel(){
        Assertions.assertEquals("Happy Path",summaryValue.getText());
    }

    public void validateNewDescriptionText(){
        wait.until(ExpectedConditions.elementToBeClickable(
                updateSuccessMessage));
        Assertions.assertEquals("MTP-2096 has been updated.",updateSuccessMessage.getText());
        Assertions.assertEquals("new description",descriptionValue.getText());
    }

    public void rollBackSummaryChange(){
        editButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(
                summaryField)).clear();
        summaryField.sendKeys("Happy Path");
        summaryField.submit();
    }

    public void rollBackDescriptionChange(){
        editButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(
                switchTextMode)).click();
        descriptionField.clear();
        updateButton.click();
    }

    public void addDescription(){
        wait.until(ExpectedConditions.elementToBeClickable(
                switchTextMode)).click();
        descriptionField.clear();
        wait.until(ExpectedConditions.elementToBeClickable(
                descriptionField)).sendKeys("new description");
    }
}
