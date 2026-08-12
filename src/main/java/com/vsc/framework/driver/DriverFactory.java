package com.vsc.framework.driver;

import com.vsc.framework.config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.net.MalformedURLException;
import java.net.URL;




public class DriverFactory {
    public static WebDriver createDriver(String browser){

        String execution = ConfigReader.getProperty("execution");

        if (browser == null || browser.isBlank()){

            browser = ConfigReader.getProperty("browser");
        }

        switch (execution.toLowerCase()){

            case "local":
                return createLocalDriver(browser);

            case "remote":
                return createRemoteDriver(browser);

            default:
                throw new IllegalArgumentException(
                        "Unsupported execution type " + execution

                );

        }
    }

    public static WebDriver createLocalDriver(String browser){


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

    public static WebDriver createRemoteDriver(String browser){


        String gridUrl = ConfigReader.getProperty("grid.url");

        try {
            switch (browser.toLowerCase()){
                case "chrome":
                    return new RemoteWebDriver(
                            new URL(gridUrl),
                            new ChromeOptions()
                    );

                case "edge":
                    return new RemoteWebDriver(
                            new URL(gridUrl),
                            new EdgeOptions()
                    );

                case "firefox":
                    return new RemoteWebDriver(
                            new URL(gridUrl),
                            new FirefoxOptions()
                    );

                default:
                    throw new IllegalArgumentException(
                            "Unsupported browser: " + browser
                    );


            }
        }catch (MalformedURLException exception){
            throw new RuntimeException(
                    "Invalid Selenium Grid Url: " + gridUrl,
                    exception
            );
        }


    }
}



