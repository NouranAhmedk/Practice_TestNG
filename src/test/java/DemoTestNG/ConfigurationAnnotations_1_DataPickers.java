package DemoTestNG;

import org.testng.annotations.*;

public class ConfigurationAnnotations_1_DataPickers {

    @Test(groups = "smoke")
    public void test1_BootstrapDataPicker(){
        System.out.println( "     (5) Test Method 1: BootStrap data picker");
    }

    @Test(groups = {"regression","e2e"})
    public void test2_JQueryDataPicker(){
        System.out.println( "     (5) Test Method 2: JQueryPicker data picker");
    }

   @BeforeMethod
    public void beforeMethod(){
       System.out.println("    (4) Executing before each test method");
   }

    @AfterMethod
    public void afterMethod(){
        System.out.println("    (4) Executing after each test method \n");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("   (3) Executing before class: Data Pickers");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("   (3) Executing after class: Data Pickers");
    }

    @BeforeTest
    public void  beforeTest(){
        System.out.println( "  (2)Before Executing test");
    }

    @AfterTest
    public void  afterTest(){
        System.out.println( "  (2)After Executing test");
    }

    @BeforeSuite
    public void  beforeSuit(){
        System.out.println( " (1)Before Executing suit");
    }

    @AfterSuite
    public void afterSuit(){
        System.out.println( " (1)after Executing suit");
    }


}
