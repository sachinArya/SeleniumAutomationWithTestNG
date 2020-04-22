package com.automation.pom;

import com.automation.FindElement;
import com.automation.ObjectInteractions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Login {

    private static By userName = By.xpath("//*[@id='pt1:pt_s2:usrname::content']");
    private static By password = By.xpath("//*[@id='pt1:pt_s2:pswd::content']");
    private static By loginBtn = By.xpath("//*[@id='pt1:pt_s2:login']");

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

    public static void clickLogin() throws Exception
    {
        WebElement elem = FindElement.findElement(loginBtn);
        ObjectInteractions.click(elem);
    }


}
