package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.BillingPage;
import pages.LoginPage;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

import java.io.IOException;
import java.time.Duration;

public class TermChangePopUp {

    private WebDriver driver;
    private LoginPage loginPage;
    private BillingPage billingPage;
    
    private static final String URL = "https://dev-atm.fastfrate.com:20443/login";
    private static final String USERNAME = "Jitendra.kumar@atomicnorth.com";
    private static final String PASSWORD = "Jeetay@123";
    private static final String SCREENSHOT_PATH = "C:\\Users\\MdNafisAhmad\\eclipse-workspace\\CFFBilling\\target";

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-cache");
        options.addArguments("--delete-cookies");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(URL);
        loginPage = new LoginPage(driver);
        billingPage = new BillingPage(driver);
    }

    @Test
    public void termChangeTest() throws InterruptedException, IOException {
        loginPage.login(USERNAME, PASSWORD);
        billingPage.navigateToBillings();
        billingPage.selectBillingOption();
        billingPage.enterTripDetails("MLMTMT9997");
        billingPage.enterBillNumber("6078613");
        billingPage.selectTerm("3 Prepaid");
        billingPage.enterShipmentDetails("999", "422201");
        billingPage.enterConsigneeDetails("422228");
        billingPage.enterThirdPartyDetails();
        billingPage.selectTermOverride(" 3 Prepaid ");
        billingPage.enterUnitDetails("Pieces", "1", "IN", "29");
        billingPage.enterWeightDetails("1pcs", "452");
        billingPage.calculateAndConfirm();
        Thread.sleep(3000);
        Shutterbug.shootPage(driver, Capture.FULL, true).save(SCREENSHOT_PATH);
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.close();
        }
    }
}
