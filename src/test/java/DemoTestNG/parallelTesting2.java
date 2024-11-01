package DemoTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class parallelTesting2 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test(threadPoolSize = 3, invocationCount = 4) // invocationCount can be used for load testing, but we will use it to demonstrate multithreading env //thread pool size depend on the environment create a thread pool to execute our test method by one thread
    public void test3_BootstrapAlerts() {
        driver.get("https://www.lambdatest.com/selenium-playground/bootstrap-alert-messages-demo");
        System.out.println(Thread.currentThread().getId() + ": Bootstrap Alerts Demo");
       // Thread.: allows our program to efficiently perform more than one thing at the same time
        // currentThread(): static method return ref to the current thread
        // getId() : return the identifier
    }

    @Test
    public void test4_DragAndDrop() {
        driver.get("https://www.lambdatest.com/selenium-playground/drag-and-drop-demo");
        System.out.println(Thread.currentThread().getId() + ": Drag and Drop slider Page");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
