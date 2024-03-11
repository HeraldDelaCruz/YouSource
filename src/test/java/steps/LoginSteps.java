package steps;

import org.openqa.selenium.WebDriver;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;

public class LoginSteps {

	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	
	//step_login_001
	@Given("User navigates Login form")
	public void user_navigates_login_form() {
	   driver = DriverFactory.getDriver();
	   
	   homePage = new HomePage(driver);
	   
	   homePage.clickOnHomeLoginButton();
	}

	//step_login_002
	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String username, String password) {
		loginPage = new LoginPage(driver);
		
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);	
	}
	
	//step_login_003
	@When("User clicks the Log in button")
	public void user_clicks_the_log_in_button() {
	    loginPage.clickOnLoginButton();	
	}

	//step_login_004
	@Then("User should be logged-in")
	public void user_should_be_logged_in() throws Throwable {
		
		Thread.sleep(1000);
		homePage.isWelcomeUserDisplayed();
		String usersName = homePage.loggedinUsersName();
		System.out.println(usersName);
	}

	//step_login_005
	@Then("Log out button should appear in the header menu")
	public void log_out_button_should_appear_in_the_header_menu() {
		homePage.islogOutButtonDisplayed();

	}
}
