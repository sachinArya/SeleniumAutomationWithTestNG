package com.automation.testNG;

import com.automation.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.lang.reflect.Method;


public class testNGHooks {

    public static String getParallelType = null;

    @BeforeMethod
    public void setupMethod(ITestContext context, Method m) throws Exception
    {
        String runType = context.getSuite().getParallel();
        if(runType.equals("methods"))
        {
            String cntx= m.getDeclaringClass().getName() + "::" + m.getName();
            WebDriver driver = DriverSetup.getDriver();
            context.setAttribute(cntx,driver);
        }
    }
    @AfterMethod
    public void tearDownMethod(ITestContext context, Method m)
    {
        String runType = context.getSuite().getParallel();
        if(runType.equals("methods"))
        {
            String cntx= m.getDeclaringClass().getName() + "::" + m.getName();
            WebDriver driver = (WebDriver)context.getAttribute(cntx);
            driver.quit();
        }
    }

    @BeforeClass
    public void setupClass(ITestContext context) throws Exception
    {
        String runType = context.getSuite().getParallel();
        if(runType.equals("classes"))
        {
            WebDriver driver = DriverSetup.getDriver();
            context.setAttribute(this.getClass().getName(),driver);
        }
    }
    @AfterClass
    public void tearDownClass(ITestContext context)
    {
        String runType = context.getSuite().getParallel();
        if(runType.equals("classes"))
        {
            WebDriver driver = (WebDriver)context.getAttribute(this.getClass().getName());
            driver.quit();
        }
    }

   @BeforeSuite
   public void beforeSuite(ITestContext context)
   {
       testNGHooks.getParallelType = context.getSuite().getParallel();
   }

   public static String getContextName() throws Exception
    {
        String cntx = null;

        String parallelType = testNGHooks.getParallelType;

        if(parallelType.equals("methods"))
        {
            String className = Thread.currentThread().getStackTrace()[2].getClassName();
            String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();

            cntx = className + "::"
                    + methodName;
        }
        else if(parallelType.equals("classes"))
        {
            String className = Thread.currentThread().getStackTrace()[2].getClassName();
            cntx = className;
        }

        return cntx;
    }

}
