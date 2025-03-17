package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Signup_Login;
import setup.Setup;

public class LoginTest extends Setup{
    Signup_Login signupLogin;
        @Test
        public void TC1_CheckSuccessfulLogin(){
            signupLogin= homePage.clickSignupLoginBtn();
            Assert.assertTrue(signupLogin.getLoginLabel().isDisplayed());
            signupLogin.enterLoginEmail("hii@x.com");
            signupLogin.enterPasswordField("123456");
            signupLogin.clickLoginBtn();
            wait.until(ExpectedConditions.visibilityOf(signupLogin.logoutBtn()));
            Assert.assertTrue(signupLogin.getLoggedInUserLabel().isDisplayed());
            signupLogin.clickDeleteAccBtn();
            wait.until(ExpectedConditions.visibilityOf(signupLogin.getAccDeletedLabel()));
        }
        @Test
    public void TC2_CheckLoginFailure(){
            signupLogin= homePage.clickSignupLoginBtn();
            Assert.assertTrue(signupLogin.getLoginLabel().isDisplayed());
            signupLogin.enterLoginEmail("notFound@x.com");
            signupLogin.enterPasswordField("123456");
            signupLogin.clickLoginBtn();
            Assert.assertTrue(signupLogin.getErrorMsgLabel().isDisplayed());
        }
        @Test
        public void TC3_CheckSuccessfulLogout(){
            softAssert.assertTrue(homePage.IsUserInHomePage());
            signupLogin= homePage.clickSignupLoginBtn();
            softAssert.assertTrue(signupLogin.getLoginLabel().isDisplayed());
            signupLogin.enterLoginEmail("User2@x.com");
            signupLogin.enterPasswordField("123456");
            signupLogin.clickLoginBtn();
            wait.until(ExpectedConditions.visibilityOf(signupLogin.logoutBtn()));
            softAssert.assertTrue(signupLogin.getLoggedInUserLabel().isDisplayed());
            softAssert.assertTrue(homePage.getLogoutBtn().isDisplayed());
            homePage.getLogoutBtn().click();
            wait.until(ExpectedConditions.visibilityOf(signupLogin.getLoginLabel()));
            softAssert.assertTrue(signupLogin.getLoginLabel().isDisplayed());
            softAssert.assertAll();
        }
    }



