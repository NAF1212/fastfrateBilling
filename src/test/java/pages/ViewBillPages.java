package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewBillPages {
    private WebDriver driver;
    private WebDriverWait wait;

    private By billingsMenu = By.xpath("//span[normalize-space()='Billings']");
    private By viewbillings = By.xpath("//*[@id='viewBill']");
    private By clickdot = By.xpath("//*[@id='th1']/div");
    
    public ViewBillPages(WebDriver driver) {
    	this.driver=driver;
    	 this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    
    public void navigateToBillings() throws InterruptedException {
        Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(billingsMenu));
        WebElement menu = driver.findElement(billingsMenu);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", menu);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", menu);
    }
    public void selectViewBill() throws InterruptedException {
    	Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(viewbillings));
        WebElement option = driver.findElement(viewbillings);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
        wait.until(ExpectedConditions.elementToBeClickable(option));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
    }

    public void clickThreeDot() {
    	driver.findElement(clickdot).click();
		
	}

}