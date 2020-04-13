package com.automation;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Connection;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.network.Network;

public class AjaxHandler {

    public static void waitForAjax()
    {
        Connection connection = null;
        DevTools devTools = ((ChromeDriver)DriverSetup.getDriver()).getDevTools();

        devTools.createSession();

        devTools.addListener(Network.responseReceived(), (responseReceived -> {
            System.out.println(responseReceived.getResponse());
            System.out.println(responseReceived.getResponse().getTiming());
        }));
    }
}
