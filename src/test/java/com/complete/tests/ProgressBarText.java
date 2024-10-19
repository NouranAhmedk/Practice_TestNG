package com.complete.tests;

import com.lambdatest.page.BootstrapProgressBarPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProgressBarText extends TestBase {
    SoftAssert softAssert = new SoftAssert();
    BootstrapProgressBarPage progressBarPage = new BootstrapProgressBarPage();

    @Test
    public void progressBarPercentage() {
        progressBarPage = homePage.clickBootStrapProgressBar();
        progressBarPage.clickStartDownloadBtn();
        progressBarPage.getCompletedMsg();
        String actualMsg = progressBarPage.getCompletedMsg();
        String actualPercentage = progressBarPage.getProgressBarPercentage();
        String expectedMsg = "Download completed!";
        String expectedPercentageMsg = "100%";
        softAssert.assertEquals(actualMsg, expectedMsg, "Message is not completed or Correct");
        softAssert.assertEquals(actualPercentage, expectedPercentageMsg, "Percentage is not correct");
        softAssert.assertAll();

    }
}
