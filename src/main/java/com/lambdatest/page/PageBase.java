package com.lambdatest.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageBase {
    public static WebDriver driver;

    public void setDriver(WebDriver driver) {
        PageBase.driver = driver;
    }
//    public PageBase (WebDriver driver) {
//        this.driver = driver;
//    }

    protected WebElement find(By locator) {
       return driver.findElement(locator);
    }

    protected void click(By locator) {
        find(locator).click();
    }

    protected String getText(By locator) {
        String Text = find(locator).getText();
        System.out.println("getText: " + Text);
        return Text;
    }
}
