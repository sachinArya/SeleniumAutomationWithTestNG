package com.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.Connection;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.network.Network;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import sun.nio.ch.Net;

import java.io.File;
import java.io.FileReader;
import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class DriverSetup {

    public static HashSet<String> OpenRequests = new HashSet<>();
    public static int cntr = 0;
    private static WebDriver driver = null;

    public static WebDriver getDriver() {
        try {
            if (driver != null) {
                return driver;
            } else {
                String dirPath = System.getProperty("user.dir");
                File file = new File(dirPath + "//conf//DriverSetup.properties");
                FileReader reader = new FileReader(file);

                Properties props = new Properties();
                props.load(reader);

                String browser = props.getProperty("Browser");

                switch (browser) {
                    case "IE":
                        InternetExplorerOptions IEOptions = new InternetExplorerOptions();
                        IEOptions.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                        IEOptions.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
                        driver = new InternetExplorerDriver(IEOptions);
                        driver.manage().window().maximize();
                        break;
                    case "CHROME":
                        System.setProperty("webdriver.chrome.driver", dirPath + "\\webdrivers\\chromedriver.exe");
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.addArguments("--incognito");
                        chromeOptions.addArguments("--log-level=3");
                        driver = new ChromeDriver(chromeOptions);
                        driver.manage().window().maximize();
                        break;
                    case "FIREFOX":
                        driver = new FirefoxDriver();
                        driver.manage().window().maximize();
                        break;
                    default:
                        break;
                }

                /*Connection connection = null;
                DevTools devTools = ((ChromeDriver) driver).getDevTools();

                devTools.createSession();
                devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

                devTools.addListener(Network.requestWillBeSent(), (requestWillBeSent -> {
                    OpenRequests.add(requestWillBeSent.getRequestId().toString());
                    System.out.println("Request Sent : " + requestWillBeSent.getRequestId());
                }));

                devTools.addListener(Network.responseReceived(), (responseReceived -> {
                    if (OpenRequests.contains(responseReceived.getRequestId().toString())) {
                        OpenRequests.remove(responseReceived.getRequestId().toString());
                    }
                    System.out.println("Response received : " + responseReceived.getRequestId());
                })); */

                return driver;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return driver;
    }
}
