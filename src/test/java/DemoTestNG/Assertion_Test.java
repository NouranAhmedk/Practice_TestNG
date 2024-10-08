package DemoTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class Assertion_Test {

    SoftAssert softAssert=new SoftAssert();
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testSingleCheckbox(){
        driver.findElement(By.linkText("Checkbox Demo")).click();
        driver.findElement(By.id("isAgeSelected")).click();
        String actualMsg = driver.findElement(By.id("txtAge")).getText();
        Assert.assertTrue(actualMsg.contains("Checked"), "It doesn't work");
//        AssertJUnit.assertTrue("It doesn't work", actualMsg.contains("Checked"));
    }

    @Test
    public void testRadioButton(){
        driver.findElement(By.linkText("Radio Buttons Demo")).click();
        driver.findElement(By.xpath("//input[@value='Other']")).click();
        driver.findElement(By.xpath("//input[@value='5 - 15']")).click();
        driver.findElement(By.xpath("//button[text()='Get values']")).click();
//        String actualGender = driver.findElement(By.xpath("//p//span[@class='genderbutton']")).getText();
        String actualGender = driver.findElement(By.cssSelector(".genderbutton")).getText();
        String actualAgeGroup = driver.findElement(By.cssSelector(".groupradiobutton")).getText();

        softAssert.assertEquals(actualGender, "Male","Actual Gender is not correct\n");
        softAssert.assertTrue(actualAgeGroup.contains("1 5"),"Actual AgeGroup is not correct\n");
        softAssert.assertAll("\n Test soft Assert");

//        driver.findElement(By.xpath("//div[@class=\"px-10 pt-20 pb-5\"]//input[@value=\"Female\"]")).click();
//        driver.findElement(By.xpath("//div[@class=\"px-10 pt-20 pb-5\"]//button")).click();
//        String actualGender = driver.findElement(By.linkText("Radio button 'Female' is checked")).getText();
//        Assert.assertTrue( actualGender.contains("Radio button 'Female' is checked"), "It doesn't work");
    }
}
