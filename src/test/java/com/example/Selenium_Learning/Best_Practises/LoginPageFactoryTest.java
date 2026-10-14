package com.example.Selenium_Learning.Best_Practises;

import com.example.Selenium_Learning.PageFactory.LoginPageFactory;
import org.testng.annotations.Test;

public class LoginPageFactoryTest extends BaseTest{
    @Test
    public void testLogin(){
        LoginPageFactory login = new LoginPageFactory(driver);
        login.login("standard_user", "secret_sauce");
    }
}
