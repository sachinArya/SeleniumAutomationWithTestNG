package com.automation.test;

import com.automation.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends testNGHooks{

    @Test(groups = {"myTest"},description = "Test To Login to application",priority = 1, enabled = false)
    @Parameters("URL")
    public static void Login(String URL) throws Exception
    {
        WebDriver driver = DriverSetup.getDriver();
        System.out.println("Executing Login");
        driver.get(URL);
        com.automation.pom.LandingPage.clickSignIn(driver);
        com.automation.pom.Login.enterUserName(driver,"abc@gmail.com");
        com.automation.pom.Login.clickContinue(driver);
        com.automation.pom.Login.enterPassword(driver,"test");
        com.automation.pom.Login.clickLogin(driver);

    }

    @Test(description = "Search Product",enabled = true)
    public static void searchProduct() throws Exception
    {
        WebDriver driver = DriverSetup.getDriver();
        System.out.println("Executing search product");
        driver.get("http://www.amazon.co.uk");
        com.automation.pom.LandingPage.enterProductNameToSearch(driver,"thanos");
        com.automation.pom.LandingPage.clickSearchButton(driver);

    }


}
