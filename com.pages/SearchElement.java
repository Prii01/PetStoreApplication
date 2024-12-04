package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchElement extends BasePage{
	@FindBy(xpath = "//div[@class='site-nav__icons']/a[2]")
	private WebElement search;

	@FindBy(xpath = "//input[@class='site-header__search-input']")
	private WebElement searchTextField;

	@FindBy(xpath = "//div[@class='grid-product__price']")
	private WebElement item;

	public SearchElement(WebDriver driver) {
		super(driver);
	}
	 
}
