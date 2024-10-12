package DemoTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class Parameterized_Test {
    WebDriver driver;
    WebDriverWait wait;

    @Parameters({"URL"})
    @BeforeTest
    public void setUp(String url) {
        //Step 1: Load AUT
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test
    @Parameters({"Task","TestResult"})
    public void test(String task, String testResult) {
        //Step 2: Click File download link
        driver.findElement(By.xpath("//a[text()=\"File Download\"]")).click();
        //Step 3: Enter data
        driver.findElement(By.id("textbox")).sendKeys(task + " Execution :" + testResult);
        // Step 4: Click generate btn
        driver.findElement(By.id("create")).click();
        // Step 5: Click download link
        driver.findElement(By.id("link-to-download")).click();
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
