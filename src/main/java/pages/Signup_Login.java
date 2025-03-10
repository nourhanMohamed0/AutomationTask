package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Signup_Login {
    private WebDriver driver;
    public Signup_Login(WebDriver driver){
        this.driver=driver;
    }
    private By emailLoginField= By.xpath("//input[@data-qa='login-email']");
    private By passwordField= By.cssSelector("input[data-qa='login-password']");
    private By loginBtn= By.cssSelector("button[data-qa='login-button']");
    private By logoutBtn= By.xpath("//i[@class='fa fa-lock']");
    private By deleteAcctBtn= By.xpath("//i[@class='fa fa-trash-o']");
    private By loggedInUserLabel= By.xpath("//i[@class='fa fa-user']");
    private By accDeltedLabel= By.xpath("//h2[@data-qa='account-deleted']");

    public void enterLoginEmail(String email){
        driver.findElement(emailLoginField).sendKeys(email);
    }
    public void enterPasswordField(String pass){
        driver.findElement(passwordField).sendKeys(pass);
    }
    public void clickLoginBtn(){
        driver.findElement(loginBtn).click();
    }
    public WebElement logoutBtn(){
        return driver.findElement(logoutBtn);
    }
    public void clickDeleteAccBtn(){
        driver.findElement(deleteAcctBtn).click();
    }
    public WebElement getLoggedInUserLabel(){
        return driver.findElement(loggedInUserLabel);
    }
    public WebElement getAccDeletedLabel(){
        return driver.findElement(accDeltedLabel);
    }
}
