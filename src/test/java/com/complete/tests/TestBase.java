package com.complete.tests;

import com.lambdatest.page.HomePage;
import com.lambdatest.page.PageBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

public class TestBase {
    private WebDriver driver;
    protected PageBase pageBase;
    protected HomePage homePage;

    private final String AUT_URL = "https://www.lambdatest.com/selenium-playground/";

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @BeforeMethod
    public void loadApplication() {
        driver.get(AUT_URL);
        pageBase = new PageBase();
        pageBase.setDriver(driver);
        homePage = new HomePage();
        homePage.setDriver(driver);
    }

    @AfterMethod
    public void takeScreenShotForFailure(ITestResult result) throws IOException {
        TakesScreenshot screenShot = (TakesScreenshot) driver;
        File Source = screenShot.getScreenshotAs(OutputType.FILE);
        File destination;
        if (ITestResult.FAILURE == result.getStatus()) {
            destination = new File( "Screenshots/FailedScreenshots/" + result.getName() + ".png");
        } else {
            //destination = new File(System.getProperty("user.dir") + "/Screenshots/PassedScreenshots/" + result.getName() + ".png");
            destination = new File( "Screenshots/PassedScreenshots/" + result.getName() + ".png");
        }
        FileHandler.copy(Source, destination);
    }
}
