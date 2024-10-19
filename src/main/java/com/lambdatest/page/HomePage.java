package com.lambdatest.page;

import org.openqa.selenium.By;

public class HomePage extends PageBase{

    private By bootStrapProgressBar = By.linkText("Bootstrap Progress bar");

    public BootstrapProgressBarPage clickBootStrapProgressBar(){
        click(bootStrapProgressBar);
        return new BootstrapProgressBarPage();
    }
}
