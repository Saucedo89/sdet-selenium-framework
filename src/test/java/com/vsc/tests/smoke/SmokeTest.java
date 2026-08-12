package com.vsc.tests.smoke;

import com.vsc.framework.config.ConfigReader;
import com.vsc.framework.driver.DriverManager;
import com.vsc.tests.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class SmokeTest extends BaseTest {

    @Test
    public void openGoogle(){

        String url = ConfigReader.getProperty("base.url");

        System.out.println("URL obtenida: " + url);



        DriverManager.getDriver().get(url);



    }
}
