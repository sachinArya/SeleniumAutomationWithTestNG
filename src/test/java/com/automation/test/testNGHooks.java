package com.automation.test;

import com.automation.DriverSetup;
import org.testng.annotations.AfterSuite;

public class testNGHooks {

    @AfterSuite
    public void tearDown()
    {
        if(DriverSetup.getDriver()!=null)
        DriverSetup.getDriver().quit();
    }
}
