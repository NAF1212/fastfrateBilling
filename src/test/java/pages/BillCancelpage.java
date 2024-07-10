package pages;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BillCancelpage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By billingsMenu = By.xpath("//span[normalize-space()='Billings']");
    private By viewBillings = By.xpath("//*[@id='viewBill']");
    private By clickProbilNoField = By.xpath("//*[@id='th2']/div");
    private By clickDot = By.xpath("//*[@id='dotsbillNo']/span[3]");
    private By searchProbil = By.id("seacrchField");
    private By mainLoader = By.id("mainLoader");
    private By enterProbillNo = By.xpath("//input[@id='seacrchField']");
    private By clickApply = By.xpath("//*[@id=\"th2\"]/div[2]/div/div[2]/ul/li[2]/button[2]");
    private By editButton = By.xpath("//a[@class='date-drop ng-star-inserted']");
    private By clickThreeDot = By.xpath("//body//app-root//span[2]");
    private By clickCancel = By.xpath("//button[normalize-space()='Cancel Bill']");
    private By cancelBillPopup = By.xpath("//span[normalize-space()='Yes']");
    

    public BillCancelpage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    private void waitForLoaderToDisappear() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(mainLoader));
    }

    public void navigateToBillings() throws InterruptedException {
        waitForLoaderToDisappear();
        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(billingsMenu));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", menu);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", menu);
    }

    public void selectViewBill() throws InterruptedException {
        waitForLoaderToDisappear();
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(viewBillings));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
        wait.until(ExpectedConditions.elementToBeClickable(option));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
    }

    public void clickProbilNoField() {
        waitForLoaderToDisappear();
        driver.findElement(clickProbilNoField).click();
    }

    public void clickThreeDot() throws InterruptedException {
        waitForLoaderToDisappear();
        Thread.sleep(3000); // Consider replacing with an explicit wait if there's a specific condition to wait for
        driver.findElement(clickDot).click();
    }

    public void searchProbil() {
        waitForLoaderToDisappear();
        driver.findElement(searchProbil).click();
    }
    
    public void enterProbillNo(String probilNo) {
        WebElement element = driver.findElement(enterProbillNo);
        element.sendKeys(probilNo);
        element.sendKeys(Keys.TAB);
    }
    
    public void clickApply() {
    	driver.findElement(clickApply).click();
    }
    
    public void editButtonClick() throws InterruptedException {
    	Thread.sleep(3000);
    	driver.findElement(editButton).click();
    }
    
    public void threeDotClick() {
    	
    	ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); // Assuming the new tab is the second tab
        waitForLoaderToDisappear();
        wait.until(ExpectedConditions.elementToBeClickable(clickThreeDot)).click();
        // Perform actions in the new tab
        // Example: Find an element and click it
        
    }
    
    public void clickCanceloption() {
    	driver.findElement(clickCancel).click();
    }
    
    public void clickYesButton() {
    	driver.findElement(cancelBillPopup).click();
    }
}
