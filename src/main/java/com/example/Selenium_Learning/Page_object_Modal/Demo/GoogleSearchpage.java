package com.example.Selenium_Learning.Page_object_Modal.Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchpage {
    WebDriver driver;
    By searchbox = By.xpath("//*[@id=\"ti6dpd\"]");
    public GoogleSearchpage(WebDriver driver){
        this.driver = driver;
    }

    public void searchgoogle(String Searchinput) throws InterruptedException{
        driver.findElement(searchbox).sendKeys(Searchinput);
        Thread.sleep(2000);
    }
}