package com.example.Selenium_Learning.Page_object_Model.PageFactory;

import com.example.Selenium_Learning.PageFactory.LoginPageFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginPageFactoryTest {
    private WebDriver driver;
    private LoginPageFactory loginPage;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPageFactory(driver);
    }

    @Test
    public void testValidPage(){
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

    @AfterMethod
    public void trearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
