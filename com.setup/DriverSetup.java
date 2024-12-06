package com.setup;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utility.DataUtility;
import com.utility.FrameworkConstants;
import com.utility.JavaUtility;

public class DriverSetup {
	
	public DataUtility data_Utility = new DataUtility();
	WebDriver driver ;
	public static ExtentReports report;
	
	public ExtentReports configureReport() {
		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(FrameworkConstants.REPORTS_PATH+JavaUtility.getTimeStamp()+".html");
		report = new ExtentReports();
		report.attachReporter(sparkReporter);
		return report;
	}
	
	public WebDriver invokeBrowser(String browserName) throws IOException {
		
		if (browserName.equals("chrome")) {
			ChromeOptions opt = new ChromeOptions();
			opt.setBinary(FrameworkConstants.CHROME_EXE_PATH);
			driver = new ChromeDriver(opt);
		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(data_Utility.readDataFromProperties("url"));
		return driver;
	}

	public void quitBrowser() {
		driver.close();
	}
	
	public void finalizeReport() {
		report.flush();
	}
}
