package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.CommonUtils;

public class CartPage {
	
	WebDriver driver;
	private CommonUtils commonUtils;
	
	public CartPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonUtils = new CommonUtils(driver);
	}

	
	//objects
	@FindBy(css = ".product-image")
	private WebElement CartItemImage;
	
	@FindBy(css = ".name")
	private WebElement CartItemModel;
	
	@FindBy(css = ".price-container")
	private WebElement CartItemPrice;
	
	@FindBy(css = "div[id='more-information'] p")
	private WebElement CartItemDescription;
	
	@FindBy(css = ".btn.btn-success.btn-lg")
	private WebElement AddtoCartbutton;
	
	@FindBy(css = "tbody tr:nth-child(1) td:nth-child(2)")
	private WebElement CartItem;
	
	@FindBy(css = "body > div:nth-child(7) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(4) > a:nth-child(1)")
	private WebElement DeleteCartItemButton;
	
	@FindBy(id = "totalp")
	private WebElement TotalPrice;
	
	@FindBy(css = ".btn.btn-success")
	private WebElement PlaceOrderButton;
	
	@FindBy(css = "#totalm")
	private WebElement TotalPriceModal;
	
	@FindBy(id = "name")
	private WebElement NameField;
	
	@FindBy(id = "country")
	private WebElement CountryField;
	
	@FindBy(id = "city")
	private WebElement CityField;
	
	@FindBy(id = "card")
	private WebElement CreditCardField;
	
	@FindBy(id = "month")
	private WebElement MonthField;
	
	@FindBy(id = "year")
	private WebElement YearField;
	
	@FindBy(css = "button[onclick='purchaseOrder()']")
	private WebElement PurchaseButton;
	
	@FindBy(css = "div[class='form-group'] label[for='name']")
	private WebElement NameFieldText;
	
	@FindBy(css = "label[for='year']")
	private WebElement YearFieldText;
	
	@FindBy(css = "div[id='orderModal'] div[class='modal-content']")
	private WebElement Modal;
	
	@FindBy(css = "body > div:nth-child(19) > h2:nth-child(6)")
	private WebElement ThankYouPopupMessageText;
	
	@FindBy(css = ".confirm.btn.btn-lg.btn-primary")
	private WebElement ThankYouPopupOKButton;
	
	
	
	
	
	//methods
	public boolean isItemImageDisplayed() {
		return commonUtils.displayStatusOfElement(CartItemImage, commonUtils.EXPLICIT_WAIT);
	}
	
	public boolean isItemModelDisplayed() {
		return commonUtils.displayStatusOfElement(CartItemModel, commonUtils.EXPLICIT_WAIT);
	}
	
	public boolean isItemPriceDisplayed() {
		return commonUtils.displayStatusOfElement(CartItemPrice, commonUtils.EXPLICIT_WAIT);
	}
	
	public boolean isItemDescriptionDisplayed() {
		return commonUtils.displayStatusOfElement(CartItemDescription, commonUtils.EXPLICIT_WAIT);
	}
	
	public void clickOnAddtoCartbutton() {
		commonUtils.clickOnElement(AddtoCartbutton, commonUtils.EXPLICIT_WAIT);
	}
	
	
	public WebElement isCartItemDisplayed(String item) {
		WebElement cartItem = driver.findElement(By.xpath("//td[contains(text(),'"+item+"')][1]"));
		return cartItem;
	}
	
	public boolean isCartItemNotDisplayed(String item) {
		driver.findElement(By.xpath("//td[contains(text(),'"+item+"')][1]"));
		return false;
		
	}
	
	public void deleteCartItem() {
		commonUtils.clickOnElement(DeleteCartItemButton, commonUtils.EXPLICIT_WAIT);
	}
	
	public String getTotalPrice() {
		return commonUtils.getTextFromElement(TotalPrice, commonUtils.EXPLICIT_WAIT);
	}
		
	public boolean isTotalPriceNotDisplayed() {
		commonUtils.waitForElement(TotalPrice, commonUtils.EXPLICIT_WAIT);
		return false;
	}
	
	public void clickOnPlaceOrderButton() {
		commonUtils.clickOnElement(PlaceOrderButton, commonUtils.EXPLICIT_WAIT);
	}
	
	public boolean isTotalPriceModalDisplayed() {
		return commonUtils.displayStatusOfElement(TotalPriceModal, commonUtils.EXPLICIT_WAIT);
	}
	
	public String getTotalPriceModal() {
		return commonUtils.getTextFromElement(TotalPriceModal, commonUtils.EXPLICIT_WAIT);
	}
	
	public void enterUsersName(String name) {
		//commonUtils.clickOnElement(NameFieldText, commonUtils.EXPLICIT_WAIT);
		commonUtils.typeTextIntoElement(NameField, name, commonUtils.EXPLICIT_WAIT);
	}
	
	public void enterCountry(String country) {
		
		commonUtils.typeTextIntoElement(CountryField, country, commonUtils.EXPLICIT_WAIT);
	}
	
	public void enterCity(String city) {
		commonUtils.typeTextIntoElement(CityField, city, commonUtils.EXPLICIT_WAIT);
	}
	
	public void enterCreditCard(String CreditCard) {
		commonUtils.typeTextIntoElement(CreditCardField, CreditCard, commonUtils.EXPLICIT_WAIT);
	}
	
	public void enterMonth(String month) {
		commonUtils.typeTextIntoElement(MonthField, month, commonUtils.EXPLICIT_WAIT);
	}
	
	public void enterYear(String year) {
		commonUtils.clickOnElement(YearFieldText, commonUtils.EXPLICIT_WAIT);
		commonUtils.typeTextIntoElement(YearField, year, commonUtils.EXPLICIT_WAIT);
	}
	
	public void clickOnPurchaseButton() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Modal);
		commonUtils.clickOnElement(PurchaseButton, commonUtils.EXPLICIT_WAIT);
	}
	
	public boolean isThankYouMessageDisplayed() {
		return commonUtils.displayStatusOfElement(ThankYouPopupMessageText, commonUtils.EXPLICIT_WAIT);
		
	}
	
	public void clickThankYouMessageOkbutton() {
		commonUtils.clickOnElement(ThankYouPopupOKButton, commonUtils.EXPLICIT_WAIT);
	}
	

	
	
	
	
	

	
	
	
	
}
	