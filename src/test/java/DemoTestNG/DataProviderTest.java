package DemoTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @DataProvider(name= "AJAX data")
    public Object[][] provideAJAXData() {
      Object[][] data = {
                {"Nouran", "hi"},
                {"Nourhan", "bye"},
        };
      return data;
    }

    @Test(dataProvider = "AJAX data")
    public void test(String name , String comment) {
        driver.get("https://www.lambdatest.com/selenium-playground/ajax-form-submit-demo");
        driver.findElement(By.id("title")).sendKeys(name);
        driver.findElement(By.id("description")).sendKeys(comment);
        driver.findElement(By.id("btn-submit")).click();

        System.out.println("Name :" + name);
        System.out.println("Comment :" + comment);
    }

    @Test(dataProviderClass = DataProviderOnly.class,dataProvider = "Input_Provider")
    public void test2(String name , String email, int number) {
        driver.get("https://www.lambdatest.com/selenium-playground/input-form-demo");
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("inputEmail4")).sendKeys(email);


        System.out.println("#input :" + number);
        System.out.println("#Name :" + name);
        System.out.println("#Email :" + email);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
