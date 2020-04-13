package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindElement {

    public static WebElement findElement(By by) throws Exception
    {
        WebDriverWait o_wait = new WebDriverWait(DriverSetup.getDriver(),120);
        return o_wait.until(ExpectedConditions.elementToBeClickable(by));
    }
}
