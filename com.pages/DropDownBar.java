package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DropDownBar extends BasePage{
	@FindBy(xpath = "//select[@id='SortBy']")
	private WebElement dropDown;
	
	public DropDownBar(WebDriver driver) {
		super(driver);
	}
	
	public WebElement selectDropDown() throws InterruptedException {
		return dropDown;
	}
}
