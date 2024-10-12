package DemoTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


public class Take_Failed_ScreenShots {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/");
        driver.manage().window().maximize();
    }

    @Test
    public void testSimpleFormDemo() {
        driver.findElement(By.linkText("Simple Form Demo")).click();
        driver.findElement(By.xpath("//p[text()='Enter Message']//following-sibling::input"))
                .sendKeys("LamdbaTest is Awesome!!!");
        driver.findElement(By.id("showInput")).click();
        String ActualMsg =
                driver.findElement(By.id("message")).getText();
        Assert.assertEquals(ActualMsg, "LamdbaTest is Awesome!!!", "Invalid Message");
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
