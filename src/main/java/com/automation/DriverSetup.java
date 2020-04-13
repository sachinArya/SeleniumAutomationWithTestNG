package com.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class DriverSetup {

    private static WebDriver driver = null;

    public static WebDriver getDriver()
    {
        try
        {
            if(driver !=null)
            {
                return driver;
            }
            else
            {
                String dirPath = System.getProperty("user.dir");
                File file = new File(dirPath + "//conf//DriverSetup.properties");
                FileReader reader = new FileReader(file);

                Properties props = new Properties();
                props.load(reader);

                String browser = props.getProperty("Browser");

                switch(browser)
                {
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

                return driver;
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return driver;
    }
}
