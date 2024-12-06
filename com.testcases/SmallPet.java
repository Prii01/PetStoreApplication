package com.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.pages.BasePage;
import com.pages.CartPage;
import com.pages.DropDownBar;
import com.pages.HealthCare;
import com.pages.ProductPage;
import com.setup.BaseTest;

public class SmallPet extends BaseTest{
	BasePage base_page;
	DropDownBar dropdown;
	ProductPage product_page;
	CartPage cart_page;
	HealthCare health_care;
	
	/*+
	 * 
	 * Created By: Priyanka Pujar
	 * Reviewed By:
	 * Test Scenario: Verifying user is able to Navigating to HomePage
	 * 
	 *
	*/

	@Test(priority=1)
	public void navigateToHome() throws EncryptedDocumentException, IOException {
		test = report.createTest("Pets Test Case");
		base_page = new BasePage(driver);
		Assert.assertEquals(driver.getTitle(),data_Utility.readDataFromExcel("PageTitle", 1, 1));
		Reporter.log("Home page displayed",true);
		test.log(Status.PASS, "Home page displayed");
		test.addScreenCaptureFromBase64String(base_page.captureScreenshotFroReport(driver),"Home Page");
	}
	/*
	 * 
	 * Created By:Priyanka Pujar
	 * Reviewed By:
	 * Test Scenario: Verifying user is able to Navigating to Small Pet Page
	 * 
	 *
	*/

	
	@Test(priority=2)
	public void navigateToSmallPetPage() throws InterruptedException, EncryptedDocumentException, IOException {
		base_page.tryPopUp();
		base_page.navigateToSmallPet();
		Assert.assertEquals(driver.getTitle(), data_Utility.readDataFromExcel("PageTitle", 2, 1));
		Reporter.log("Small Pet page displayed",true);
		test.log(Status.PASS, "Small Pet page displayed");
		test.addScreenCaptureFromBase64String(base_page.captureScreenshotFroReport(driver),"Small Pet");
	}

	/*
	 * 
	 * Created By:Priyanka Pujar
	 * Reviewed By:
	 * Test Scenario:Verifying user is able to search product 
	 * 
	 *
	*/
		
	@Test(dataProvider = "SearchTestData1", priority=3)
	public void verify_User_Is_Able_To_SearchProduct(String productNumber, String productName, String price)
			throws EncryptedDocumentException, IOException, InterruptedException {
		
		String result = base_page.searchProduct(productName);
		base_page.navigateToHomePage();
		Assert.assertTrue(result.equalsIgnoreCase(productName));
		Reporter.log("Producted Displayed",true);
		test.log(Status.PASS,"Producted Displayed");
		test.addScreenCaptureFromBase64String(base_page.captureScreenshotFroReport(driver),"Product Displayed");
	}
	
	@DataProvider(name = "SearchTestData1")
	public Object[][] search_Test_Data() throws EncryptedDocumentException, IOException {
		return data_Utility.readMultipleDataFromExcel("SearchTestData1");
	}
	/*
	 * 
	 * Created By:Priyanka Pujar
	 * Reviewed By:
	 * Test Scenario:Verifying user is able to Navigating to Cage Accessories
	 * 
	 *
	*/

	
	@Test(priority = 4)
	public void verify_User_is_able_to_Navigate_to_Cage_AccessoriesPage() throws EncryptedDocumentException, IOException, InterruptedException {
				
		base_page.navigateTocageAccessories();
		Assert.assertTrue(driver.getTitle().contains(data_Utility.readDataFromExcel("PageTitle", 4, 1)));	
		Reporter.log("Cage Accessories page displayed",true);
		test.log(Status.PASS, "Cage Accessories page displayed");
		test.addScreenCaptureFromBase64String(base_page.captureScreenshotFroReport(driver),"Cage Accessories page");
		base_page.navigateToHomePage();
	}
	
	/*
	 * 
	 * Created By:Priyanka Pujar
	 * Reviewed By:
	 * Test Scenario:Verifying user is able to Navigating to Grooming
	 * 
	 *
	*/
	
	@Test(priority=5)
	public void verify_User_is_able_to_Navigate_to_Grooming_page()
			throws EncryptedDocumentException, IOException, InterruptedException {
		base_page.navigateTogrooming();
		Assert.assertTrue(driver.getTitle().contains(data_Utility.readDataFromExcel("PageTitle", 6, 1)));
		
		Reporter.log("Grooming page displayed",true);
		test.log(Status.PASS, "Grooming page displayed");
		test.addScreenCaptureFromBase64String(base_page.captureScreenshotFroReport(driver),"Grooming page");
		base_page.navigateToHomePage();
		
	}
	
	/*
	 * 
	 * Created By:Priyanka Pujar
	 * Reviewed By:
	 * Test Scenario:Verifying user is able to Navigating to Litter and Substrate
	 * 
	 *
	*/
	
	@Test(priority=6)
	public void verify_User_is_able_to_Navigate_to_Litter_page() throws EncryptedDocumentException, IOException, InterruptedException {
		base_page.navigateTolitter();
		Assert.assertTrue(driver.getTitle().contains(data_Utility.readDataFromExcel("PageTitle", 8, 1)));
		Reporter.log("Litter and Substrate page displayed",true);
		test.log(Status.PASS, "Litter and Substrate page displayed");
		test.addScreenCaptureFromBase64String(base_page.captureScreenshotFroReport(driver),"Litter and Substrate page");	
		base_page.navigateToHomePage();		
	}
	/*
	 * 
	 * Created By:Priyanka Pujar
	 * Reviewed By:
	 * Test Scenario:Verifying user is able to Select dropdown options
	 * 
	 *
	*/
	
	@Test(priority=7)
	public void verify_User_is_Able_to_Click_on_Dropdown_and_Select_price_Alphabetically()
			throws EncryptedDocumentException, IOException, InterruptedException {	
		base_page.navigateTofood();
		Assert.assertTrue(driver.getTitle().contains(data_Utility.readDataFromExcel("PageTitle", 5, 1)));
		Reporter.log("Food Page displayed",true);
		test.log(Status.INFO, "Food Page displayed");
	    dropdown = new DropDownBar(driver);
	    Thread.sleep(3000);
		base_page.selectDropDownByValue(dropdown.selectDropDown(), data_Utility.readDataFromExcel("Dropdown", 1, 1));
		Assert.assertTrue(driver.getCurrentUrl().equals(data_Utility.readDataFromExcel("Dropdown", 1, 2)));
		Reporter.log("Drop Down Alphabetically displayed",true);
		test.log(Status.PASS, "Drop Down Alphabetically  displayed");
		test.addScreenCaptureFromBase64String(base_page.captureScreenshotFroReport(driver),"Drop Down Alphabetically");
		base_page.navigateToHomePage();		
	}
	
	/*
	 * 
	 * Created By:Priyanka Pujar
	 * Reviewed By:
	 * Test Scenario:Verifying user is able to Select dropdown options(low to high)
	 * 
	 *
	*/
	
	@Test(priority=8)
	public void verify_User_is_Able_to_Click_on_Dropdown_and_Select_price_LowToHigh()
			throws EncryptedDocumentException, IOException, InterruptedException {	
		base_page.navigateTofood();
		Assert.assertTrue(driver.getTitle().contains(data_Utility.readDataFromExcel("PageTitle", 5, 1)));
		Reporter.log("Food Page displayed",true);
		test.log(Status.INFO, "Food Page displayed");
	    dropdown = new DropDownBar(driver);
	    Thread.sleep(3000);
		base_page.selectDropDownByValue(dropdown.selectDropDown(), data_Utility.readDataFromExcel("Dropdown", 2, 1));
		Assert.assertTrue(driver.getCurrentUrl().equals(data_Utility.readDataFromExcel("Dropdown", 2, 2)));
		Reporter.log("Drop Down Low to High displayed",true);
		test.log(Status.PASS, "Drop Down page Low to High displayed");
		test.addScreenCaptureFromBase64String(base_page.captureScreenshotFroReport(driver),"Drop Down Low to High");
		base_page.navigateToHomePage();
	}

	/*
	 * 
	 * Created By:Priyanka Pujar
	 * Reviewed By:
	 * Test Scenario:Verifying user is able to navigate to product page
	 * 
	 *
	*/
	
	@Test(priority=9)
	public void verify_user_is_able_to_navigate_to_product_page() throws InterruptedException, EncryptedDocumentException, IOException {
		base_page.navigateTofood();
		Assert.assertTrue(driver.getTitle().contains(data_Utility.readDataFromExcel("PageTitle", 5, 1)));
		Reporter.log("Food Page displayed",true);
		test.log(Status.INFO, "Food Page displayed");
		product_page = new ProductPage(driver);
		product_page.displayProduct();
	    Assert.assertTrue(driver.getCurrentUrl().contains(data_Utility.readDataFromExcel("CartPageData", 3, 2)));
	    Reporter.log("Product Page displayed",true);
		test.log(Status.PASS, "Product Page displayed");
		test.addScreenCaptureFromBase64String(base_page.captureScreenshotFroReport(driver),"Product Page");
		base_page.navigateToHomePage();
	}
	
	/*
	 * 
	 * Created By:Priyanka Pujar
	 * Reviewed By:
	 * Test Scenario:Verifying user is able to add product to cart
	 * 
	 *
	*/
	
	@Test(priority=10)
	public void verify_user_is_able_to_add_product_to_cart() throws EncryptedDocumentException, IOException, InterruptedException {
		base_page.navigateTofood();
		Assert.assertTrue(driver.getTitle().contains(data_Utility.readDataFromExcel("PageTitle", 5, 1)));
		Reporter.log("Food Page displayed",true);
		test.log(Status.INFO, "Food Page displayed");
		product_page = new ProductPage(driver);
		product_page.displayProduct();
		product_page.selectAddToCartButton();
		cart_page = new CartPage(driver);
		cart_page.selectAddItem();
		Assert.assertTrue(cart_page.cartQuantityValue().equals(data_Utility.readDataFromExcel("CartPageData", 1, 1)));
		Reporter.log("Add to cart  displayed",true);
		test.addScreenCaptureFromBase64String(base_page.captureScreenshotFroReport(driver),"Add to cart ");
		test.log(Status.PASS, "Add to cart  displayed");
	}
	/*
	 * 
	 * Created By:Priyanka Pujar
	 * Reviewed By:
	 * Test Scenario:Verifying user is able to remove product from cart
	 * 
	 *
	*/
	
	@Test(priority=11)
	public void verify_user_is_able_to_remove_product_from_cart() throws InterruptedException, EncryptedDocumentException, IOException  {		
		cart_page.selectRemoveItem();
		Assert.assertTrue(cart_page.cartQuantityValue().equals(data_Utility.readDataFromExcel("CartPageData", 2, 1)));
		Reporter.log("Remove from cart  displayed",true);
		test.log(Status.PASS, "Remove from cart  displayed");
		test.addScreenCaptureFromBase64String(base_page.captureScreenshotFroReport(driver),"Remove from cart ");
	}
	
	/*
	 * 
	 * Created By:Priyanka Pujar
	 * Reviewed By:
	 * Test Scenario:Verifying user is able to navigate to login page after Checkout
	 * 
	 *
	*/
	
	@Test(priority = 12)
	public void verify_User_is_Able_to_Navigate_to_Loginpage_after_Checkout()
			throws EncryptedDocumentException, IOException, InterruptedException {
		cart_page.selectCheckOutButton();
		Assert.assertEquals(driver.getTitle(), data_Utility.readDataFromExcel("PageTitle", 12, 1));
		Reporter.log("Checkout successful",true);
		test.log(Status.PASS,"Checkout successful");
		Reporter.log("Login Page Checkout displayed",true);
		test.log(Status.PASS, "Login Page Checkout  displayed");
		test.addScreenCaptureFromBase64String(base_page.captureScreenshotFroReport(driver),"Login Page Checkout");
		base_page.navigateToHomePage();
	}
}
