package com.example.Selenium_Learning.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
    private WebDriver driver;
    private final String url = "https://www.saucedemo.com/";

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = "h3[data-test='error']")
    private WebElement errorMessage;

    // Constructor
    public LoginPageFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Navigate to login page
    public void navigateTo(){
        if (!driver.getCurrentUrl().equals(url)){
            driver.get(url);
        }
    }

    // Perform login action
    public void login(String username, String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    // Get error message
    public String getErrorMessage(){
        return errorMessage.getText();
    }
}
