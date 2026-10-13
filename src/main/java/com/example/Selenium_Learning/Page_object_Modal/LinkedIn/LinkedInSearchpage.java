package com.example.Selenium_Learning.Page_object_Modal.LinkedIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LinkedInSearchpage {
    WebDriver driver;

    public LinkedInSearchpage(WebDriver driver){
        this.driver = driver;
    }

    By search = By.xpath("//*[@id=\"_r_3_\"]");

    public void searchLinkedIn(String Searchinput) throws InterruptedException{
        driver.findElement(search).sendKeys(Searchinput);
        Thread.sleep(20000);
    }
}
