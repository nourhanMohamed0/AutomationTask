package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import pages.HomePage;

import java.time.Duration;

public class Setup {
    protected WebDriver webdriver;
    protected WebDriverWait wait;
    protected static String baseURL="https://automationexercise.com/";
    protected static SoftAssert softAssert;
    protected HomePage homePage;

    @BeforeClass
    public void beforeClass(){
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--ignore-ssl-errors=yes");
        webdriver=new ChromeDriver(chromeOptions);
        wait=new WebDriverWait(webdriver, Duration.ofSeconds(15));
        softAssert=new SoftAssert();
        goHome();
    }

    public void goHome(){
        webdriver.get(baseURL);
        webdriver.manage().window().maximize();

        homePage = new HomePage(webdriver);
    }
    @AfterClass
    public void tearDown(){
        webdriver.quit();
    }

}
