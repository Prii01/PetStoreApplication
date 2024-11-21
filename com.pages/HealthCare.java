package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HealthCare extends BasePage{
	
	@FindBy(xpath="//div[@class='grid-product__title grid-product__title--heading' and contains(text(),'Oxbow Animal Health® Poof! Chinchilla Dust Bath 2.5 Lbs')]")
	private WebElement healthProductItem;
	
	@FindBy(xpath="//button[@type='submit']//span[contains(text(),'Add to cart')]")
	private WebElement addToCartButton;
	
	public HealthCare(WebDriver driver) {
		super(driver);
	}
	
	public void selectAddToCartButton() throws InterruptedException {
		healthProductItem.click();
		addToCartButton.click(); 
	}
	
}
