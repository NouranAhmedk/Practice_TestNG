package DemoTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class parallelTesting1 {
    // ThreadLocal to ensure each thread has its own WebDriver instance
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    public void setUp() {
        // Each thread gets its own ChromeDriver instance
        driver.set(new ChromeDriver());
    }

    // Getter method to access the WebDriver for the current thread
    public WebDriver getDriver() {
        return driver.get();
    }

    @Test
    public void test1() {
        getDriver().get("https://www.youtube.com/");
        System.out.println("First thread: " + Thread.currentThread().getId());
    }

    @Test
    public void test2() {
        getDriver().get("https://www.facebook.com/");
        System.out.println("Second thread: " + Thread.currentThread().getId());
    }

    @AfterMethod
    public void tearDown() {
        // Quit the driver and remove it from ThreadLocal after each test method
        getDriver().quit();
        driver.remove();

//    WebDriver driver;
//
//    @BeforeMethod
//    public void setUp() {
//        driver = new ChromeDriver();
//    }
//
//    @Test
//    public void test1_Jquery_DataPicker() {
//        driver.get("https://www.lambdatest.com/selenium-playground/jquery-date-picker-demo");
//        System.out.println(Thread.currentThread().getId() + ": JQuery Data Picker Page");
//        // Thread.: allows our program to efficiently perform more than one thing at the same time
//        // currentThread(): static method return ref to the current thread
//        // getId() : return the identifier
//    }
//
//    @Test
//    public void test2_DataListFilter() {
//        driver.get("https://www.lambdatest.com/selenium-playground/data-list-filter-demo");
//        System.out.println(Thread.currentThread().getId() + ": Data List Filter Page");
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }
}}
