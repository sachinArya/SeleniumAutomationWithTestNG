package com.automation.test;

import com.automation.DriverSetup;
import com.automation.FindElement;
import com.automation.ObjectInteractions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Connection;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.network.Network;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class loadPage extends testNGHooks{

    @Test(groups = {"myTest"})
    public void testFunc()
    {
        DevTools devTools = ((ChromeDriver)DriverSetup.getDriver()).getDevTools();
        devTools.createSession();

        devTools.send(Network.enable(Optional.of(10000000),Optional.empty(),Optional.empty()));

        DriverSetup.getDriver().get("http://51.140.244.192:7802/insis_gen_v10/faces/login.jspx");



    }


    //@Test(groups = {"myTest"})
    public void testFunc1() throws Exception
    {
        String xp  = "//*[@id='pt1:pt_s2:pswd::content']";
        Thread.sleep(2000);
        By userName = By.xpath("//*[@id='pt1:pt_s2:usrname::content']");

        WebElement userNameElem = FindElement.findElement(userName);
        ObjectInteractions.EnterKeys(userNameElem,"insis_gen_v10");

        Thread.sleep(2000);
        List<WebElement> element = DriverSetup.getDriver().findElements(RelativeLocator.withTagName("input").toLeftOf(By.xpath(xp)));
        
        for(WebElement el:element)
        {
            System.out.println("el.getAttribute(\"id\") = " + el.getAttribute("id"));
        }
        System.out.println(element);
    }

}
