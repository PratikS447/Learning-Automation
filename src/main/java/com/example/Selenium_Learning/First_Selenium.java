package com.example.Selenium_Learning;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class First_Selenium {
    public static void main(String args[]){
//        THIS IS A TRADIONAL  METHOD
//        System.setProperty("webdriver.chrome.driver",
//                "/Users/apple/Desktop/springboot-learning/springSecurity/chromedriver-mac-arm64/chromedriver");
//
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.amazon.in/ref=nav_logo");

//        System.setProperty("webdriver.gecko.driver", "/Users/apple/Desktop/springboot-learning/springSecurity/geckodriver");
//        WebDriver driver1 = new FirefoxDriver();
//        driver1.get("https://www.amazon.in/ref=nav_logo");

//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://getbootstrap.com/docs/5.3/forms/checks-radios/");
//        System.out.println("Title of the url :"+ driver.getTitle());
//        System.out.println("To get the current url :" + driver.getCurrentUrl());
//        System.out.println("To get the page source :"+driver.getPageSource());

        // isDisplayed
//        WebElement small = driver.findElement(By.xpath("//*[@id=\"radioDefault1\"]"));
//
//        System.out.println(small.isSelected());
//        small.click();
//
//        System.out.println(small.isSelected());
//        System.out.println(search_stone.isDisplayed()); // true
//        System.out.println(search_stone.isEnabled()); // true

//        WebDriverManager.firefoxdriver().setup();
//        WebDriver driver1 = new FirefoxDriver();
//        driver1.get("https://www.amazon.in/ref=nav_logo");

        System.out.println("------------------------------------------------------");

        WebDriver driver = new ChromeDriver();

        try {
            // 1. Open your target webpage
            driver.get("https://getbootstrap.com/docs/5.3/forms/checks-radios/");
            driver.manage().window().maximize();

            // 2. Set up explicit wait (wait up to 10 seconds)
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // 3. Locate the element safely with a wait
            By elementLocator = By.xpath("/html/body/div[2]/main/div[3]/div[9]/div[1]/div[1]/label");
            WebElement targetElement = wait.until(
                    ExpectedConditions.presenceOfElementLocated(elementLocator)
            );

            // 4. Scroll the element into view (fixes ElementClickInterceptedException)
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", targetElement);

            // 5. Wait until the element is fully clickable
            wait.until(ExpectedConditions.elementToBeClickable(targetElement));

            // 6. Click using JavaScript to bypass any sticky headers, footers, or overlays
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", targetElement);

            System.out.println("Successfully clicked the element!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Optional: Close the browser when done
             driver.quit();
        }
    }
}
