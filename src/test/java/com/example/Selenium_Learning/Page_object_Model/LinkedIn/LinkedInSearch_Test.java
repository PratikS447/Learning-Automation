package com.example.Selenium_Learning.Page_object_Model.LinkedIn;

import com.example.Selenium_Learning.Page_object_Modal.LinkedIn.LinkedInSearchpage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class LinkedInSearch_Test {
    WebDriver driver;

    @BeforeTest
    public void beforetest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.linkedin.com/feed/");
    }

    @Test
    public void SearchOperation() throws InterruptedException{
        LinkedInSearchpage page = new LinkedInSearchpage(driver);
        page.searchLinkedIn("Java Developer");
        Thread.sleep(10000);
    }

    @AfterTest
    public void aftertest(){
        driver.quit();
    }
}
