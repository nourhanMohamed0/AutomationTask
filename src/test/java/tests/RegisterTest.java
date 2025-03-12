package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegisterPage;
import pages.Signup_Login;
import setup.Setup;

public class RegisterTest extends Setup {
    RegisterPage registerPage;
    Signup_Login signupLogin;

    String email="user2@x.com";
    String password="12345678";


    @Test(priority = 1)
    public void TC1_checkUserInHomePage() {
        Assert.assertTrue(homePage.IsUserInHomePage());
        signupLogin = homePage.clickSignupLoginBtn();
    }
    @Test(priority = 2)
    public void TC2_successfulInitialRegistration(){
        signupLogin.enterSignupName("Hello");
        signupLogin.enterSignupEmail("hii@x.com");
        registerPage=signupLogin.clickSignupBtn();
    }
    @Test (priority = 3)
    public void T3_successfulRegistration(){
        wait.until(ExpectedConditions.visibilityOf(registerPage.getRegisterForm()));
        registerPage.chooseGenderBtn("F");
        registerPage.enterPassword("123456");
        registerPage.enterDay("10");
        registerPage.enterMonth("9");
        registerPage.enterYear("2001");
        registerPage.subscribeNewsLetter();
        registerPage.receiveSpecialOffer();
        registerPage.enterFirstName().sendKeys("Hi");
        registerPage.enterLastName().sendKeys("test");
        registerPage.enterCompany().sendKeys("testCompany");
        registerPage.enterAddress1().sendKeys("address1");
        registerPage.enterAddress2().sendKeys("address2");
        registerPage.enterCountry("India");
        registerPage.enterZipcode().sendKeys("123456");
        registerPage.enterMobileNumber().sendKeys("0123456789");
        registerPage.enterState().sendKeys("state");
        registerPage.enterCity().sendKeys("city");
        registerPage.createAccountBtn().click();
        wait.until(ExpectedConditions.visibilityOf(registerPage.getAccCreatedLabel()));
        Assert.assertTrue(registerPage.getAccCreatedLabel().isDisplayed());
    }



}
