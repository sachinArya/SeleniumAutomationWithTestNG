package com.automation;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Connection;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.network.Network;

import java.util.concurrent.atomic.AtomicInteger;

public class AjaxHandler {

    public static void waitForAjax()
    {
        Connection connection = null;
        DevTools devTools = ((ChromeDriver)DriverSetup.getDriver()).getDevTools();

        AtomicInteger cntr = new AtomicInteger();

        devTools.createSession();

        devTools.addListener(Network.requestWillBeSent(), (requestWillBeSent -> {
            cntr.set(cntr.get() + 1);
        }));

        devTools.addListener(Network.responseReceived(), (responseReceived -> {
            cntr.set(cntr.get() - 1);
        }));
    }
}
