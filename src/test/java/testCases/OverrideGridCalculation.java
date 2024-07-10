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
import pages.OverrideGridValuePage;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

import java.io.IOException;
import java.time.Duration;

public class OverrideGridCalculation {

    private WebDriver driver;
    private LoginPage loginPage;
    private OverrideGridValuePage gridValuePage;
    
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
        gridValuePage = new OverrideGridValuePage(driver);
    }
 
    @Test
    public void termChangeTest() throws InterruptedException, IOException {
        loginPage.login(USERNAME, PASSWORD);
        gridValuePage.navigateToBillings();
        gridValuePage.selectBillingOption();
        gridValuePage.enterTripDetails("MLMTMT9997");
        gridValuePage.enterBillNumber("217811");
        gridValuePage.selectTerm("3 Prepaid");
        gridValuePage.enterShipmentDetails("999", "422201");
        gridValuePage.enterConsigneeDetails("422228");
        gridValuePage.enterThirdPartyDetails();
        gridValuePage.selectTermOverride(" 3 Prepaid ");
        gridValuePage.enterUnitDetails("Pieces", "1", "IN", "29");
        gridValuePage.enterWeightDetails("1pcs", "452");
        gridValuePage.calculateAndConfirm();
        gridValuePage.saveToDraft();
        gridValuePage.clickThreeDot();
        gridValuePage.editGrid();
        gridValuePage.calculateAndConfirmAgain();
        
        
        Thread.sleep(3000);
        Shutterbug.shootPage(driver, Capture.FULL, true).save(SCREENSHOT_PATH);
    }

    @AfterTest(enabled = false)
    public void tearDown() {
        if (driver != null) {
            driver.close();
        }
    }
}
