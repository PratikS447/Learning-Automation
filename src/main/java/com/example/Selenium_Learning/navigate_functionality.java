package com.example.Selenium_Learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class navigate_functionality {
    public static void main(String args[]){
        WebDriver chrome = new ChromeDriver();
        try {
            chrome.navigate().to("https://www.google.com/");
            chrome.navigate().to("https://leetcode.com/u/shindepratik447/");
            chrome.navigate().forward();
            System.out.println("forward");
            chrome.navigate().back();
            chrome.navigate().refresh();
            System.out.println("refresh");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            chrome.quit();
        }
    }
}
