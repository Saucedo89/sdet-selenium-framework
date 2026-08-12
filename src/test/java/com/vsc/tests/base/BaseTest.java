package com.vsc.tests.base;

import com.vsc.framework.config.ConfigReader;
import com.vsc.framework.driver.DriverFactory;
import com.vsc.framework.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {



    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional String browser){

        WebDriver webDriver = DriverFactory.createDriver(browser);

        DriverManager.setDriver(webDriver);

        DriverManager.getDriver()
                .manage()
                .window()
                .maximize();

        int implicitWait =
                ConfigReader.getIntProperty("implicit.wait");

        DriverManager.getDriver()
                .manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(implicitWait));
    }
    @AfterMethod
    public void tearDown(){
        if (DriverManager.getDriver() != null) {

            DriverManager.getDriver().quit();

            DriverManager.removeDriver();
        }
    }
}
