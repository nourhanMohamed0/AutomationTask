package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Signup_Login;
import setup.Setup;

public class taskTest extends Setup {
    String email="user2@x.com";
    String password="12345678";
    Signup_Login signupLogin;

    @Test(priority = 1)
    public void checkUserInHomePage(){
        Assert.assertTrue(homePage.IsUserInHomePage());
        signupLogin=homePage.clickSignupLoginBtn();
    }
    @Test(dependsOnMethods = "checkUserInHomePage")
    public void test(){
        signupLogin.enterSignupEmail("hello@x.com");
        signupLogin.enterSignupName("hello");
        signupLogin.clickSignupBtn();
    }
    @Test(dependsOnMethods = "checkUserInHomePage",enabled = false)
    public void CheckSuccessfulLogin(){
        signupLogin.enterLoginEmail(email);
        signupLogin.enterPasswordField(password);
        signupLogin.clickLoginBtn();
        wait.until(ExpectedConditions.visibilityOf(signupLogin.logoutBtn()));
        Assert.assertTrue(signupLogin.getLoggedInUserLabel().isDisplayed());
        signupLogin.clickDeleteAccBtn();
        wait.until(ExpectedConditions.visibilityOf(signupLogin.getAccDeletedLabel()));
    }
}
