package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest; 
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import pages.ViewBillPages;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

import java.io.IOException;
import java.time.Duration;

public class ViewBill {

    private WebDriver driver;
    private LoginPage loginPage;
    private ViewBillPages viewBillPages;
    private static final String URL = "https://dev-atm.fastfrate.com:20443/";
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
        viewBillPages = new ViewBillPages(driver);
    }
 
    @Test
    public void termChangeTest() throws InterruptedException, IOException {
        loginPage.login(USERNAME, PASSWORD);
        viewBillPages.navigateToBillings();
        viewBillPages.selectViewBill();
        
        
 
        
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
