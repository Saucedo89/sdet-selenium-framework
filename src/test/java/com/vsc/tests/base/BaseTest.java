package com.vsc.tests.base;

import com.vsc.framework.config.ConfigReader;
import com.vsc.framework.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = DriverFactory.createDriver();
        driver.manage().window().maximize();

        int implicitWait = ConfigReader.getIntProperty("implicit.wait");

                driver.manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(implicitWait));

    }
    @AfterMethod
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
