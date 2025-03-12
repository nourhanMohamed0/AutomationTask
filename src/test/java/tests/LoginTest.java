package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Signup_Login;
import setup.Setup;

public class LoginTest extends Setup{
    Signup_Login signupLogin;
        @Test
        public void CheckSuccessfulLogin(){
            signupLogin= homePage.clickSignupLoginBtn();
            signupLogin.enterLoginEmail("hii@x.com");
            signupLogin.enterPasswordField("123456");
            signupLogin.clickLoginBtn();
            wait.until(ExpectedConditions.visibilityOf(signupLogin.logoutBtn()));
            Assert.assertTrue(signupLogin.getLoggedInUserLabel().isDisplayed());
            signupLogin.clickDeleteAccBtn();
            wait.until(ExpectedConditions.visibilityOf(signupLogin.getAccDeletedLabel()));
        }
    }


