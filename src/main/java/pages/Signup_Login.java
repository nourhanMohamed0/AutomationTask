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
    private By nameField=By.name("name");
    private By emailNewUser=By.xpath("//input[@data-qa='signup-email']");
    private By signupBtn=By.xpath("//button[@data-qa='signup-button']");
    private By loginForm=By.cssSelector(".login-form");
    private By errorMsgLabel=By.xpath("//p[@style='color: red;']");

    public void enterLoginEmail(String email){
        driver.findElement(emailLoginField).sendKeys(email);
    }
    public void clearLoginEmail(){
        driver.findElement(emailLoginField).clear();
    }
    public WebElement getLoginEmail(){
       return driver.findElement(emailLoginField);
    }
    public void enterSignupEmail(String email){
       driver.findElement(emailNewUser).sendKeys(email);
    }
    public WebElement getSignupEmail(){
       return driver.findElement(emailNewUser);
    }
    public void enterSignupName(String name){
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterPasswordField(String pass){
        driver.findElement(passwordField).sendKeys(pass);
    }
    public void clearPasswordField(){
        driver.findElement(passwordField).clear();
    }
    public void clickLoginBtn(){
        driver.findElement(loginBtn).click();
    }
    public RegisterPage clickSignupBtn(){
        driver.findElement(signupBtn).click();
        return new RegisterPage(driver);
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
    public WebElement getLoginLabel(){
        return driver.findElement(loginForm);
    }
    public WebElement getErrorMsgLabel(){
        return driver.findElement(errorMsgLabel);
    }
}
