package com.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utility.DataUtility;

public class BasePage {

	DataUtility data_Utility = new DataUtility();
	WebDriver driver;
	Select select;
	Actions action;
	JavascriptExecutor javaScript;
	
	@FindBy(xpath = "//div[@class='site-nav']//button[@type='button']")
	private WebElement subButton ; 
	
	@FindBy(xpath="//a[@id='Label-collections-small-pet6' and contains(text(),'Small Pet')]")
	private WebElement smallPettextfield;
	
	@FindBy(xpath="//button[@type='button' and contains(text(),'Not today')]")
	private WebElement notTodayButton;
	
	@FindBy(id="Sublabel-collections-cages-habitats1")
	private WebElement cageHabitatTextField;
	
	@FindBy(id="Sublabel-collections-cage-accessories-small-pet2")
	private WebElement cageAccessoriesTextField;
	
	@FindBy(id="Sublabel-collections-food-53")
	private WebElement foodTextField; 
	
	@FindBy(id="Sublabel-collections-grooming-34")
	private WebElement groomingTextField;
	
	@FindBy(id="Sublabel-collections-health-care-45")
	private WebElement healthCareTextField;
	
	@FindBy(id="Sublabel-collections-litter-substrate6")
	private WebElement litterTextField;
	
	@FindBy(id="Sublabel-collections-toys-37")
	private WebElement toysTextField;
	
	@FindBy(xpath="//a[@id='Sublabel-collections-treats-38' and contains(text(),'Treats')]")
	private WebElement treatsTextField;
	
	@FindBy(id="Sublabel-collections-everything-else-39")
	private WebElement everythingElseTextField;
	
	@FindBy(xpath="//div[@class='site-nav__icons']/a[2]")
	private WebElement searchIcon;
	
	@FindBy(xpath="//input[@type='search']")
	private WebElement searchTextField;
	
	@FindBy(xpath = "//div[@class='grid-product__title grid-product__title--heading']")
	private WebElement item;
	
	@FindBy(xpath="//a[@class='site-header__logo-link']")
	private WebElement homePageLink;

	public void tryPopUp() {
		try {
			notTodayButton.click();
		} catch (Exception e) {
		}
	}


	
	public String searchProduct(String productName) throws InterruptedException
	{
		waitUntilElementIsClickAble(driver, searchIcon);
		searchIcon.click();
		searchTextField.sendKeys(productName + Keys.ENTER);
		return getItem().getText();
	}
	
	public void navigateToSmallPet() throws InterruptedException {
		navigateToSubmenu();
		Thread.sleep(3000);
		smallPettextfield.click();
	}
	
	public void navigateTocageHabitat() throws InterruptedException {
		navigateToSmallPet();
		navigateToSubmenu();
		cageHabitatTextField.click();
	}
	
	public void navigateTofood() throws InterruptedException {
		navigateToSmallPet();
		Thread.sleep(3000);
		navigateToSubmenu();
		foodTextField.click();
	}

	public void navigateTocageAccessories() throws InterruptedException {
		navigateToSmallPet();
		navigateToSubmenu();
		cageAccessoriesTextField.click();
	}
	
	public void navigateTogrooming() throws InterruptedException {
		navigateToSmallPet();
		Thread.sleep(3000);
		navigateToSubmenu();
		groomingTextField.click();
	}
	
	public void navigateTolitter() throws InterruptedException {
		
		navigateToSmallPet();
		Thread.sleep(3000);
		navigateToSubmenu();
		litterTextField.click();
	}
	
	public void navigateTotoys() throws InterruptedException {
		navigateToSmallPet();
		toysTextField.click();
	}
	public void navigateTotreats() throws InterruptedException {
		navigateToSmallPet();
		treatsTextField.click();
	}
	public void navigateTohealthCare() throws InterruptedException {
		navigateToSmallPet();
		Thread.sleep(3000);
		navigateToSubmenu();
		healthCareTextField.click();
	}
	
	public void navigateToeverythingElse() throws InterruptedException{
		navigateToSmallPet();
		everythingElseTextField.click();
	}
	
	public void navigateTosearch() throws InterruptedException{
		navigateToSmallPet();
		searchTextField.click();
	}
	
	public void navigateTosearchIcon() throws InterruptedException{
		navigateToSmallPet();
		searchIcon.click();
	}
	
	public WebElement getNotToday() {
		return notTodayButton;
	}
	public WebElement getItem() {
		return item;
	}
	
	public void navigateToSubmenu()
	{
		subButton.click();
	}
	                                                                                                                            
	public void navigateToHomePage()
	{
		homePageLink.click();
	}
	
	public void selectDropDownByValue(WebElement dropdown, String value) {
		select = new Select(dropdown);
		select.selectByValue(value);
	}

	public void selectDropDownByVisibleText(WebElement dropdown, String visibleText) {
		select = new Select(dropdown);
		select.selectByVisibleText(visibleText);
	}
	
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void switchToFrame(WebDriver driver, WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	
	public void waitUntilVisibilityOfElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitUntilPresenceOfElement(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public void waitUntilElementIsClickAble(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String captureScreenshotFroReport(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		return ts.getScreenshotAs(OutputType.BASE64);
	}
	
}
