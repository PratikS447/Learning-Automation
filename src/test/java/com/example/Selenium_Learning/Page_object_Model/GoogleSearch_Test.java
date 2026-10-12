package com.example.Selenium_Learning.Page_object_Model;

import com.example.Selenium_Learning.Page_object_Modal.GoogleSearchpage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class GoogleSearch_Test {
    WebDriver driver;

    @BeforeTest
    public void beforetest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.google.com/");
    }

    @Test
    public void SearchOperation() throws InterruptedException{
        GoogleSearchpage page = new GoogleSearchpage(driver);
        page.searchgoogle("Facebook");
        Thread.sleep(5000);
    }

    @AfterTest
    public void aftertest(){
        driver.quit();
    }
}
