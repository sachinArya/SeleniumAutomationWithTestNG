package com.automation;

import org.openqa.selenium.WebElement;

public class ObjectInteractions {

    public static void EnterKeys(WebElement element, String keys) throws Exception{
            element.sendKeys(keys);
       /* System.out.println("element = " + element.getText());
            if (!(element.getText().equalsIgnoreCase(keys)))
                throw new Exception("Value not entered properly");

        */
    }

    public static void Click(WebElement element) throws Exception{
        element.click();
       /* System.out.println("element = " + element.getText());
            if (!(element.getText().equalsIgnoreCase(keys)))
                throw new Exception("Value not entered properly");

        */
    }
}
