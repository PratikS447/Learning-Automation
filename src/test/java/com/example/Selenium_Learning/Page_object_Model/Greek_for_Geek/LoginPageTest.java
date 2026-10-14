package com.example.Selenium_Learning.Page_object_Model.Greek_for_Geek;

import com.example.Selenium_Learning.Page_object_Modal.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testValidLogin(){
        loginPage.navigateTo();
        loginPage.login("standard_user", "secret_sauce");
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Login failed: URL mismatch");
    }

    @Test
    public void testInvalidLogin(){
        loginPage.navigateTo();
        loginPage.login("invalid_user", "wrong_password");

        String expectedError = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(loginPage.getErrorMessage(), expectedError, "Error message mismatch");

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
