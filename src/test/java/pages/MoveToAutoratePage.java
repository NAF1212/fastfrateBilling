package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MoveToAutoratePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By billingsMenu = By.xpath("//span[normalize-space()='Billings']");
    private By billingsOption = By.id("billings");
    private By tripDetailsInput = By.id("inputTripDetails");
    private By billNumberInput = By.id("inputBillNumber");
    private By termSelect = By.xpath("(//select[@id='term'])[2]");
    private By sequenceInput = By.id("inputSequence");
    private By shipperIdInput = By.id("inputShipperId");
    private By consigneeIdInput = By.id("inputConsigneeId");
    private By thirdPartyInput = By.id("inputThirdparty");
    private By termOverrideSelect = By.id("termOverRide");
    private By okButton = By.xpath("//button[normalize-space()='OK']");
    private By unitTypeSelect = By.id("dropdownunittype_0");
    private By piecesInput = By.xpath("(//input[@id='inputpiece_0'])[2]");
    private By unitSelect = By.id("dropdownunit_0");
    private By cuftInput = By.xpath("//input[@formcontrolname='cuFt']");
    private By descriptionInput = By.id("inputdescription_0");
    private By weightInput = By.id("inputWeight");
    private By scaledWeightInput = By.id("inputscaledweight");
    private By qstPortionInput = By.id("inputqstportion");
    private By declaredValueInput = By.id("labeldeclaredvalue");
    private By calcButton = By.id("calcButton");
    private By yesButton = By.xpath("//span[normalize-space()='Yes']");
    //private By saveToDraft=By.xpath("//button[@id='btnDraft']");
    private By clickThreeDot=By.xpath("//div[@class='proBillDots welcomeUser ng-star-inserted']//span[1]");
    private By loader = By.id("mainLoader");
    private By publishedButton = By.xpath("//button[@id='btnPublish']");
    //private By clickMoveToAutorate = By.xpath("//button[normalize-space()='Move to Autorate']");
    private By confirmButton = By.xpath("//span[normalize-space()='Yes']");
    private By undoFromAutorate = By.xpath("//button[normalize-space()='Undo from Autorate']");
    private By undoPopUp =By.xpath("//span[normalize-space()='Yes']");

    public MoveToAutoratePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    private void waitForLoaderToDisappear() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
    }

    public void navigateToBillings() throws InterruptedException {
        Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(billingsMenu));
        WebElement menu = driver.findElement(billingsMenu);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", menu);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", menu);
    }

    public void selectBillingOption() throws InterruptedException {
        Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(billingsOption));
        WebElement option = driver.findElement(billingsOption);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
    }

    public void enterTripDetails(String tripDetails) {
        WebElement element = driver.findElement(tripDetailsInput);
        element.sendKeys(tripDetails);
        element.sendKeys(Keys.TAB);
    }

    public void enterBillNumber(String billNumber) {
        WebElement element = driver.findElement(billNumberInput);
        element.sendKeys(billNumber);
        element.sendKeys(Keys.TAB);
    }

    public void selectTerm(String term) {
        Select sel = new Select(driver.findElement(termSelect));
        sel.selectByVisibleText(term);
    }

    public void enterShipmentDetails(String sequence, String shipperId) throws InterruptedException {
        driver.findElement(sequenceInput).sendKeys(sequence);
        WebElement eleShipper = driver.findElement(shipperIdInput);
        eleShipper.sendKeys(shipperId);
        eleShipper.sendKeys(Keys.ENTER);
        eleShipper.sendKeys(Keys.TAB);
        Thread.sleep(6000);
    }

    public void enterConsigneeDetails(String consigneeId) throws InterruptedException {
        WebElement eleConsig = driver.findElement(consigneeIdInput);
        eleConsig.sendKeys(consigneeId);
        eleConsig.sendKeys(Keys.ENTER);
        Thread.sleep(6000);
    }

    public void enterThirdPartyDetails() throws InterruptedException {
        WebElement thirdParty = driver.findElement(thirdPartyInput);
        thirdParty.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }

    public void selectTermOverride(String term) {
        Select sel = new Select(driver.findElement(termOverrideSelect));
        sel.selectByVisibleText(term);
        driver.findElement(okButton).click();
    }

    public void enterUnitDetails(String unitType, String pieces, String unit, String cuft) throws InterruptedException {
        Select select = new Select(driver.findElement(unitTypeSelect));
        select.selectByVisibleText(unitType);
        Thread.sleep(5000);
        driver.findElement(piecesInput).sendKeys(pieces);
        Thread.sleep(5000);
        select = new Select(driver.findElement(unitSelect));
        select.selectByVisibleText(unit);
        Thread.sleep(5000);
        WebElement cuf = driver.findElement(cuftInput);
        cuf.clear();
        cuf.sendKeys(cuft);
    }

    public void enterWeightDetails(String description, String weight) throws InterruptedException {
        driver.findElement(descriptionInput).sendKeys(description);
        Thread.sleep(2000);
        WebElement element = driver.findElement(weightInput);
        element.sendKeys(weight);
        element.sendKeys(Keys.TAB);
        Thread.sleep(2000);
        driver.findElement(scaledWeightInput).sendKeys(Keys.TAB);
        driver.findElement(qstPortionInput).sendKeys(Keys.TAB);
        driver.findElement(declaredValueInput).sendKeys(Keys.TAB);
    }

    public void calculateAndConfirm() throws InterruptedException {
        driver.findElement(calcButton).click();
        Thread.sleep(2000);
        driver.findElement(yesButton).click();
        Thread.sleep(2000);
  
	}
    public void clickPblished() {
    	wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
        WebElement publishedButtonElement = driver.findElement(publishedButton);
        wait.until(ExpectedConditions.elementToBeClickable(publishedButton));
        publishedButtonElement.click();
        waitForLoaderToDisappear();	
	}
    
    /*public void clickThreeDot() throws InterruptedException {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
        WebElement threeDotElement = driver.findElement(clickThreeDot);
        wait.until(ExpectedConditions.elementToBeClickable(threeDotElement));
        threeDotElement.click();
    }
    
    public void clickMoveToAutorate() throws InterruptedException { {
    	driver.findElement(clickMoveToAutorate).click();
    	Thread.sleep(2000);
		
	}
    
    }*/
    
    public void clickYesButton() {
		driver.findElement(confirmButton).click();
		waitForLoaderToDisappear();
	}
    
    public void clickThreeDot() throws InterruptedException {
    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
    WebElement threeDotElement = driver.findElement(clickThreeDot);
    wait.until(ExpectedConditions.elementToBeClickable(threeDotElement));
    threeDotElement.click();
}
    public void UndoFromAutorate() {
    	driver.findElement(undoFromAutorate).click();
    	waitForLoaderToDisappear();
		
	}
    
    public void undoPopupConfirm() {
    	driver.findElement(undoPopUp).click();
		
	}
}
