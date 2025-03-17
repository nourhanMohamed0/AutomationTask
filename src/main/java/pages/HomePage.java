package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver=driver;
    }
    private By sign_LoginButton= By.xpath("//i[@class='fa fa-lock']");
    private By homeBtn=By.xpath("//i[@class='fa fa-home']");
    private By homeLabel=By.xpath("//div[@class='features_items']");
    private By logoutBtn=By.xpath("//a[@href='/logout']");

    public boolean IsUserInHomePage(){
        return driver.findElement(homeLabel).isDisplayed();
    }
    public WebElement getLogoutBtn(){
        return driver.findElement(logoutBtn);
    }
    public Signup_Login clickSignupLoginBtn(){
        driver.findElement(sign_LoginButton).click();
        return new Signup_Login(driver);
    }
}
