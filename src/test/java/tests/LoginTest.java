package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Signup_Login;
import setup.Setup;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        @Test
    public void TC4_CheckInvalidEmailFormat(){
            String filePath = "InvalidMailFormatSignup.xlsx";
            try {
                List<String> InvalidMailFormat= new ArrayList<>();
                List<String> errorMsgList= new ArrayList<>();
                //Opens the file in read mode.
                FileInputStream file=new FileInputStream(filePath);
                //creates a workbook instance for .xlsx files
                Workbook workbook=new XSSFWorkbook(file);
                //accesses the first sheet in the Excel file
                Sheet sheet= workbook.getSheetAt(0);
                //loops through the rows (skipping the header)
                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    Row row=sheet.getRow(i);
                    InvalidMailFormat.add(row.getCell(0).getStringCellValue());
                    errorMsgList.add(row.getCell(1).getStringCellValue());
                }
                signupLogin=homePage.clickSignupLoginBtn();
                for (int i = 0; i < sheet.getLastRowNum(); i++) {
                    signupLogin.enterLoginEmail(InvalidMailFormat.get(i));
                    signupLogin.enterPasswordField("123456");
                    signupLogin.clickLoginBtn();
                    softAssert.assertEquals(signupLogin.getSignupEmail().getAttribute("validationMessage"),errorMsgList.get(i));
                    signupLogin.clearPasswordField();
                    signupLogin.clearLoginEmail();
                }
                }catch(IOException e){
                System.out.println(e.toString());
            }
        }
    }



