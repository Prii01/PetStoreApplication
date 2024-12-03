package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage{
	@FindBy(xpath="//div[contains(text(),'Purina® Mazuri® Rodent Breeder 6f Diet Pellets Food 50 Lbs')]")
	private WebElement item;
	
	@FindBy(xpath="//button[@class='btn btn--full add-to-cart']")
	private WebElement addToCartButton;
	
	@FindBy(xpath = "//div[@class='js-qty__wrapper']/input")
	private WebElement cartQuantity;
	
	public void selectAddToCartButton() throws InterruptedException {
		Thread.sleep(3000);
		addToCartButton.click();
	}

	public ProductPage(WebDriver driver)
	{
		super(driver);
	}
	
	public void displayProduct() throws InterruptedException
	{
		item.click();
	}
	
	
}

