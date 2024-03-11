package steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;

public class CartSteps {
	WebDriver driver;
	HomePage homePage;
	LoginPage loginPage;
	CartPage cartPage;

	//step_cart_001
	@Given("User is logged-in to website using {string} and {string}")
	public void user_is_logged_in_to_website_using_and(String username, String password) {
		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);

		homePage.clickOnHomeLoginButton();
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickOnLoginButton();

	}

	//step_cart_002
	@Given("User navigate an {string} listed in home page")
	public void user_navigate_an_listed_in_home_page(String item) {
		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
		homePage.clickOnItem(item);

	}
	
	//step_cart_003
	@Given("Item details should be displayed")
	public void item_details_should_be_displayed() {
		cartPage = new CartPage(driver);
		cartPage.isItemImageDisplayed();
		cartPage.isItemModelDisplayed();
		cartPage.isItemPriceDisplayed();
		cartPage.isItemDescriptionDisplayed();
	}
	
	//step_cart_004
	@When("User clicks the add to cart button")
	public void user_clicks_the_add_to_cart_button() {
		cartPage = new CartPage(driver);
		cartPage.clickOnAddtoCartbutton();
	}

	//step_cart_005
	@Then("{string} should be added to cart")
	public void should_be_added_to_cart(String item) throws Exception {
		homePage.clickOnHomeCartButton();
		Thread.sleep(2000);
		cartPage.isCartItemDisplayed(item);

	}

	//step_cart_006
	@When("User clicks Delete Item")
	public void user_clicks_delete_item() {
		cartPage.deleteCartItem();

	}

	//step_cart_007
	@Then("{string} should be remove in the cart")
	public void should_be_remove_in_the_cart(String item) {
		Assert.assertFalse(cartPage.isCartItemNotDisplayed(item));
	}

	//step_cart_008
	@Then("^\"([^\"]*)\" should be updated$")
	public void should_be_updated(String totalPrice) throws Exception {

		Thread.sleep(1000);
		String actualtotalPrice = cartPage.getTotalPrice();
		Assert.assertEquals(actualtotalPrice, totalPrice, "Item price does not deduct from the Total price");

	}

	//step_cart_009
	@Then("Total Price should not display")
	public void total_price_should_not_display() {
		Assert.assertFalse(cartPage.isTotalPriceNotDisplayed());
	}

	//step_cart_010
	@Given("User navigate Cart page")
	public void user_navigate_cart_page() {
		homePage.clickOnHomeCartButton();
	}

	//step_cart_011
	@When("User clicks on Place order button")
	public void user_clicks_on_place_order_button() {
		cartPage = new CartPage(driver);
		cartPage.clickOnPlaceOrderButton();
	}

	//step_cart_012
	@When("Place Order details should appear with {string} total price")
	public void place_order_details_should_appear_with_total_price(String totalPrice) throws Exception {
		Thread.sleep(1000);
	
		cartPage.isTotalPriceModalDisplayed();
		String actualtotalPrice = cartPage.getTotalPriceModal().substring(7);
		Assert.assertEquals(actualtotalPrice, totalPrice, "Price display is incorrect");
	    
	}

	//step_cart_013
	@When("User supply fields {string} , {string} , {string} , {string} , {string} , {string}")
	public void user_supply_fields(String name, String country, String city, String creaditCard, String month, String year) throws Exception {
		Thread.sleep(1000);
		cartPage.enterUsersName(name);
		cartPage.enterCountry(country);
		cartPage.enterCity(city);
		cartPage.enterCreditCard(creaditCard);
		cartPage.enterMonth(month);
		cartPage.enterYear(year);
		
	}

	//step_cart_014
	@When("User clicks Purchase button")
	public void user_clicks_purchase_button() {
		cartPage.clickOnPurchaseButton();
	}

	//step_cart_015
	@Then("Thank you pop-up message should appear")
	public void thank_you_pop_up_message_should_appear() throws Exception {
		Thread.sleep(1000);
		cartPage.isThankYouMessageDisplayed();
	}

	//step_cart_016
	@Then("Popup message should display order details")
	public void popup_message_should_display_order_details() {
		
	}

	//step_cart_017
	@Then("Clicking OK should redirect the user in the home page")
	public void clicking_ok_should_redirect_the_user_in_the_home_page() {
		cartPage.clickThankYouMessageOkbutton();
		String PageTitle = homePage.getPageTitle();
		Assert.assertEquals(PageTitle, "STORE", "User does refirect to Home Page");
		
	}

	//step_cart_018
	@Then("with no {string} in cart")
	public void with_no_in_cart(String item) {
	    homePage.clickOnHomeCartButton();
		Assert.assertFalse(cartPage.isCartItemNotDisplayed(item));
	}

}
