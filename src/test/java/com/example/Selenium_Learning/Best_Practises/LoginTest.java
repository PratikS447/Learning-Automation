package com.example.Selenium_Learning.Best_Practises;

import com.example.Selenium_Learning.Page_object_Modal.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    @Test
    public void testLogin(){
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");
    }
}
