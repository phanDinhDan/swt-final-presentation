package Logout;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.SecureAreaPage;

public class LogoutTests extends BaseTests {

    private WebDriver driver;

    @Test
    @DisplayName("TC01-Logout Successfully!")
    public void testLogoutSucessfull() {
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        loginPage.clickSelectField();
        SecureAreaPage secureAreaPageIn = loginPage.clickLoginButton();
        SecureAreaPage secureAreaPageOut = loginPage.clickLogoutButton();
//        driver.manage().deleteAllCookies();
    }

    @Test
    @DisplayName("TC03-Logout Successfully and login again!")
    public void testLogoutSucessfullAndLoginAgain() {
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");


        loginPage.clickSelectField();
        SecureAreaPage secureAreaPageIn = loginPage.clickLoginButton();
        SecureAreaPage secureAreaPageOut = loginPage.clickLogoutButton();
        Assertions.assertEquals("https://demo.openmrs.org/openmrs/login.htm", secureAreaPageOut.getCurrentUrl());
        Assertions.assertNotNull(loginPage.getElementById("loginButton"));
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
    }

    @Test
    @DisplayName("TC02-Verify that after logging out, the user is redirected to the correct page login page!")
    public void testLogoutRedirect() {
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        loginPage.clickSelectField();
        SecureAreaPage secureAreaPageIn = loginPage.clickLoginButton();
        SecureAreaPage secureAreaPageOut = loginPage.clickLogoutButton();
        Assertions.assertEquals("https://demo.openmrs.org/openmrs/login.htm", secureAreaPageOut.getCurrentUrl());
        Assertions.assertNotNull(loginPage.getElementById("loginButton"));
    }
}
