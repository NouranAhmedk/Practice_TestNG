package DemoTestNG;

import org.testng.annotations.*;

@Test(groups = "smoke")
public class ConfigurationAnnotations_2_ListBox {
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


    public void test3_BootstrapListBox(){
        System.out.println( "     (5) Test Method 3: BootStrap List Box");
    }


    public void test4_JQueryListBox(){
        System.out.println( "     (5) Test Method 4: JQuery List Box");
    }


    public void test5_DataListBox(){
        System.out.println( "     (5) Test Method 5: Data List Box");
    }

    @BeforeGroups(groups = {"regression","smoke"})
    public void beforeGroups(){
        System.out.println("Execute before group");
    }

    @AfterGroups(groups = {"regression","smoke"})
    public void afterGroups(){
        System.out.println("Execute after group");

    }
}
