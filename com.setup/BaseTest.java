package com.setup;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.utility.DataUtility;

public class BaseTest {

	public DataUtility data_Utility = new DataUtility();
	DriverSetup driver_Setup = new DriverSetup();
	public WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;

	@BeforeSuite
	public void setUpReport() {
		report = driver_Setup.configureReport();
	}

	@Parameters("browserName")
	@BeforeClass
	public void launchBrowser(@Optional("chrome") String browserName) throws IOException {
		driver = driver_Setup.invokeBrowser(browserName);
	}

	@AfterClass
	public void closeBrowser() {
		driver_Setup.quitBrowser();
	}

	@AfterSuite
	public void tearDownReport() {
		driver_Setup.finalizeReport();
	}
	
}
