package com.example.Selenium_Learning.Page_object_Modal.Greek_for_Geek;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private final String url = "https://www.saucedemo.com/";

    // Locators
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("h3[data-test='error']");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Navigate to login page
    public void navigateTo() {
        if (!driver.getCurrentUrl().equals(url)) {
            driver.get(url);
        }
    }

    // Perform login action
    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    // Get error message (for invalid login)
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}