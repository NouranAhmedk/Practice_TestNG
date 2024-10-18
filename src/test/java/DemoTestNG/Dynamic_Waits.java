package DemoTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.function.Function;

public class Dynamic_Waits {
    SoftAssert softAssert = new SoftAssert();
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Note: We shouldn't mix between explicit and implicit wait statements because it can cause a time problem
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().timeouts().getPageLoadTimeout();
//        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));    // For javaScript
        driver.get("https://www.lambdatest.com/selenium-playground/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testExplicitWait() {
        driver.findElement(By.linkText("Dynamic Data Loading")).click();
        driver.findElement(By.id("save")).click();
        // By image = By.xpath("//div[@id='loading']//img");         // using xpath ->   //div[@id='loading']//img
        By image = By.cssSelector("#loading > img");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(image));

        boolean isImgDisplayed = driver.findElement(image).isDisplayed();
        Assert.assertTrue(isImgDisplayed, "Image is not displayed");  //ask why it is not displaying right

    }


    // User this url : https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/FluentWait.html
    @Test
    public void testFluentWait() {
        driver.findElement(By.linkText("JQuery Download Progress bars")).click();
        driver.findElement(By.id("downloadButton")).click();

        // Waiting 30 seconds for an element to be present on the page, checking
        // for its presence once every 100 milliseconds.
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30L)) //is a method that assesses how long to wait the evaluating condition to be true
                .pollingEvery(Duration.ofMillis(100)) // how often the condition should be evaluating
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement progress = driver.findElement(By.xpath("//div[@id='dialog']//div[@class='progress-label']"));
                String progressBarText = progress.getText();

                if (progressBarText.equals("Complete!")) {
                    System.out.println("Progress is complete!");
                    return progress;
                }else {
                    System.out.println(progress.getText());
                    return null;
                }
            }
        });
    }

    @Test
    public void testImplicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");
        driver.findElement(By.partialLinkText("Example 2")).click();
        driver.findElement(By.xpath("//div[@id='start']//button")).click(); // we can use one forward slash //div[@id='start']/button

        By HelloWorldTxt = By.xpath("//div[@id='finish']//h4[text()='Hello World!']");
        String actualMsg = driver.findElement(HelloWorldTxt).getText();
        Assert.assertEquals(actualMsg, "Hello World!", "Msg is not HelloWorld!");
    }


}
