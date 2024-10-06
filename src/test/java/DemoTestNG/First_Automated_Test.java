package DemoTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class First_Automated_Test {
    //The purpose of Webdriver is to control our browser, which is chrome
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @FindBy(css = "li>a[href='/tables']")
    WebElement sortableTable;

    @FindBy(xpath = "//table[@id='table1']//td//a")     //*[@id="table1"]/tbody/tr[1]/td[6]/a[1]
    WebElement sortableTableRow;

    @FindBy(css = "a[href='/inputs']")
    WebElement input;

    @FindBy(css = "input[type='number']")
    WebElement inputNumber;

    @Test
    public void testTableSort() {
//      driver.findElement(By.cssSelector("li>a[href='/checkboxes']")).click();
        sortableTable.click();
        sortableTableRow.click();
    }

    @Test
    public void bootstrap() {
        input.click();
        inputNumber.sendKeys("1");
    }
}
