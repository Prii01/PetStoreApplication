package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage{
	BasePage base_page = new BasePage(driver);
	
	@FindBy(xpath="//button[@type='submit']//span[contains(text(),'Add to cart')]")
	private WebElement addToCartButton;
	
	@FindBy(xpath = "//div[@class='js-qty__wrapper']/input")
	private WebElement cartQuantity;
	
	@FindBy(xpath="//p[text()='Your cart is currently empty.']")
	private WebElement cartEmptyMessage;
	
	@FindBy(xpath="//button[@class='js-qty__adjust js-qty__adjust--minus']")
	private WebElement removeItem;

	@FindBy(xpath="//button[@class='js-qty__adjust js-qty__adjust--plus']")
	private WebElement addItem;
	
	@FindBy(xpath="//button[@type='submit' and contains(text(),'Check out')]")
	private WebElement checkOutButton;
	
	@FindBy(xpath="//div[@id='CartDrawer']//div[@class='drawer__fixed-header']//button[@type='button']")
	private WebElement closeCart;
	
	@FindBy(xpath = "//h1[text()='Login']")
	private WebElement loginTitle;

	
	public CartPage(WebDriver driver) {
		super(driver);
	}
	public void selectAddToCartButton() {
		addToCartButton.click();
	}
	
	public void selectCheckOutButton() throws InterruptedException {
		checkOutButton.click();
		base_page.waitUntilVisibilityOfElement(driver, loginTitle);
		Thread.sleep(3000);
	}
	
	public void selectCloseCart() {
		closeCart.click();
	}
	
	public void selectAddItem() throws InterruptedException {
		base_page.waitUntilElementIsClickAble(driver, addItem);
		addItem.click();
	}

	public void selectRemoveItem() throws InterruptedException {
		base_page.waitUntilElementIsClickAble(driver, removeItem);
		removeItem.click();
	}
	
	public String cartQuantityValue() {
		return cartQuantity.getAttribute("value");
	}
	
	public String cartMsg() {
		base_page.waitUntilVisibilityOfElement(driver, cartEmptyMessage);
		return cartEmptyMessage.getText();
	}	
}
