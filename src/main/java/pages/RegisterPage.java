package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
private WebDriver driver;
public RegisterPage(WebDriver driver){
    this.driver=driver;
}
private By MrsRadioBtn= By.cssSelector("label[for='id_gender2']");
private By MrRadioBtn= By.cssSelector("label[for='id_gender1']");
private By passwordField=By.cssSelector("input[type='password']");
    private By dropDownDay = By.id("days");
    private By dropDownMonth = By.id("months");
    private By dropDownYears = By.id("years");
    private By FirstNameField = By.id("first_name");
    private By LastNameField = By.id("last_name");
    private By companyField = By.id("company");
    private By addressField = By.id("address1");
    private By addressOptionalField = By.id("address2");
    private By dropDownCountry = By.id("country");
    private By stateField = By.id("state");
    private By cityField = By.id("city");
    private By ZipcodeField = By.id("zipcode");
    private By mobileNumberField = By.id("mobile_number");
    private By newsLetterButton = By.id("newsletter");
    private By specialOfferButton = By.id("optin");
    private By signup = By.xpath("//button[contains(text(),'Create Account')]");
    private By accountCreated = By.cssSelector("h2[class='title text-center']");
    private By registerForm = By.cssSelector(".login-form");


    public void chooseGenderBtn(String gender){
        if(gender.equals("F"))
            driver.findElement(MrsRadioBtn).click();
        else
            driver.findElement(MrRadioBtn).click();
    }
    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    public void enterDay(String day) {
        Select selectDay = new Select(driver.findElement(dropDownDay));
        selectDay.selectByValue(day);
    }

    public void enterMonth(String monthNumber) {
        Select selectMonth = new Select(driver.findElement(dropDownMonth));
        selectMonth.selectByValue(monthNumber);
    }

    public void enterYear(String year) {
        Select selectYear = new Select(driver.findElement(dropDownYears));
        selectYear.selectByValue(year);
    }

    public void subscribeNewsLetter() {
        driver.findElement(newsLetterButton).click();
    }

    public void receiveSpecialOffer() {
        driver.findElement(specialOfferButton).click();
    }

    public WebElement enterFirstName() {
        return driver.findElement(FirstNameField);
    }
    public WebElement getAccCreatedLabel() {
        return driver.findElement(accountCreated);
    }

    public WebElement enterLastName() {
        return driver.findElement(LastNameField);
    }

    public WebElement enterCompany() {
        return driver.findElement(companyField);
    }

    public WebElement enterAddress1() {
        return driver.findElement(addressField);
    }

    public WebElement enterAddress2() {
        return driver.findElement(addressOptionalField);
    }

    public void enterCountry(String country) {
        Select selectCountry = new Select(driver.findElement(dropDownCountry));
        selectCountry.selectByValue(country);
    }

    public WebElement enterState() {
        return driver.findElement(stateField);
    }

    public WebElement enterCity() {
        return driver.findElement(cityField);
    }

    public WebElement enterZipcode() {
        return driver.findElement(ZipcodeField);
    }
    public WebElement getRegisterForm() {
        return driver.findElement(registerForm);
    }

    public WebElement enterMobileNumber() {
        return driver.findElement(mobileNumberField);
    }
    public WebElement createAccountBtn(){
        return driver.findElement(signup);
    }
}
