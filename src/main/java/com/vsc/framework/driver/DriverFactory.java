package com.vsc.framework.driver;

import com.vsc.framework.config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory {
    public static WebDriver createDriver(){

        String browser  = ConfigReader.getProperty("browser");

        switch (browser.toLowerCase()){

            case "chrome" :
                return new ChromeDriver();

            case "edge" :
                return new EdgeDriver();

            case "firefox" :
                return new FirefoxDriver();

            default:
                throw new IllegalArgumentException(
                        "Unsupported browser" + browser
                );

        }
    }
}
