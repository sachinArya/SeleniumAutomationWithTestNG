package com.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ObjectInteractions {

    public static void enterKeys(WebElement element, String keys) throws Exception{
            element.sendKeys(keys);
       /* System.out.println("element = " + element.getText());
            if (!(element.getText().equalsIgnoreCase(keys)))
                throw new Exception("Value not entered properly");

        */
    }

    public static void click(WebElement element) throws Exception{
        element.click();
    }

    public static void moveToElement(WebElement element) throws Exception
    {
        Actions builder = new Actions(DriverSetup.getDriver());
        builder.moveToElement(element);
    }

    public static void moveToElementAndClick(WebElement element) throws Exception
    {
        moveToElement(element);
        click(element);
    }
}
