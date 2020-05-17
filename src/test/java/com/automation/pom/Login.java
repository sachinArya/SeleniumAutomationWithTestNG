package com.automation.pom;

import com.automation.FindElement;
import com.automation.ObjectInteractions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Login {

    private static By userName = By.xpath("//*[@id='ap_email']");
    private static By btnContinue = By.xpath("//*[@id='continue']");
    private static By password = By.xpath("//*[@id='ap_password']");
    private static By loginBtn = By.xpath("//*[@id='signInSubmit']");

    public static void enterUserName(String name) throws Exception
    {
        WebElement elem = FindElement.findElement(userName);
        ObjectInteractions.enterKeys(elem,name);
    }

    public static void enterPassword(String pass) throws Exception
    {
        WebElement elem = FindElement.findElement(password);
        ObjectInteractions.enterKeys(elem,pass);
    }

    public static void clickContinue() throws Exception
    {
        WebElement elem = FindElement.findElement(btnContinue);
        ObjectInteractions.click(elem);
    }

    public static void clickLogin() throws Exception
    {
        WebElement elem = FindElement.findElement(loginBtn);
        ObjectInteractions.click(elem);
    }

    public static void loginApplication(String name, String password) throws Exception
    {
        enterUserName(name);
        clickContinue();
        enterPassword(password);
        clickLogin();
    }


}
