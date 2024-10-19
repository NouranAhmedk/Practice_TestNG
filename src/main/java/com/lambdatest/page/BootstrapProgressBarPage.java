package com.lambdatest.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BootstrapProgressBarPage extends PageBase {
    private By startDownloadBtn = By.id("dwnBtn");
    private By progressBarPercentage = By.cssSelector(".counter");
    private By completedMsg = By.xpath("//p[contains(@class,'success')]");

    public void clickStartDownloadBtn() {
        click(startDownloadBtn);
    }

    public String getProgressBarPercentage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(progressBarPercentage));
        return getText(progressBarPercentage);
    }

    public String getCompletedMsg() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(completedMsg));
        return getText(completedMsg);
    }
}
