package com.automation;

import org.openqa.selenium.WebDriver;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class Wait {

    public void setGlobalWait(WebDriver driver, int timeInSeconds) throws Exception
    {
        driver.manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);
    }


}
