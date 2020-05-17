package com.automation.pom;

import com.automation.FindElement;
import com.automation.ObjectInteractions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LandingPage {

    private static By userName = By.xpath("//*[@id='nav-link-accountList']");

    public static void clickSignIn() throws Exception
    {
        WebElement elem = FindElement.findElement(userName);
        ObjectInteractions.click(elem);
    }


}
