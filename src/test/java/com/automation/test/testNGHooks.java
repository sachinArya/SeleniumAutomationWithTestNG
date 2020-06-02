package com.automation.test;

import com.automation.DriverSetup;
import com.automation.Utils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.Iterator;

public class testNGHooks {

    @BeforeSuite
    public void Setup() throws Exception
    {
        Utils.createTestReportFolder();
        DriverSetup.getDriver();
    }
    @AfterSuite
    public void tearDown()
    {
        if(DriverSetup.getDriver()!=null)
        DriverSetup.getDriver().quit();
        Iterator<String> ItrRequest = DriverSetup.OpenRequests.iterator();
        System.out.println("*********** Outstanding requests****************");
        while(ItrRequest.hasNext())
        {
            System.out.println(ItrRequest.next());
        }
    }
}
