package steps;

import org.openqa.selenium.WebDriver;

import com.github.javafaker.Faker;

import driverFactory.DriverFactory;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterSteps {

	WebDriver driver;
	Faker faker = new Faker();
	
	private HomePage homePage;
	private RegisterPage registerPage;
	
	//steps_register_001
	@When("User navigates Sign up form")
	public void user_navigates_sign_up_form() {
		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
		homePage.clickOnHomeSignUpButton();
	}
    
	//steps_register_002
	@When("^User enters \"([^\"]*)\" to username field and \"([^\"]*)\" to password field$")
	public void user_enters_to_username_field_and_to_password_field(String username, String password) {
		registerPage = new RegisterPage(driver);
		
		if (username.equals("newuser")) {
			username = faker.name().username();
			}
			registerPage.enterUsername(username);
			registerPage.enterPassword(password);
				
	}
	
	//steps_register_003
	@When("User clicks the Sign up button")
	public void user_clicks_the_sign_up_button() {
		registerPage.clickSignUpButton();
	}
	


}
