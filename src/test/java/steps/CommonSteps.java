package steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.RegisterPage;

public class CommonSteps {

	WebDriver driver;
	RegisterPage registerPage;
	
	
	//step_commons_001
	@Given("User navigates the websites landing page")
	public void user_navigates_the_websites_landing_page() {
		driver = DriverFactory.getDriver();
	}
	
	//step_commons_002
	@Then("^\"([^\"]*)\" message should appear$")
	public void message_should_appear(String message) throws InterruptedException {
		driver = DriverFactory.getDriver();
		registerPage = new RegisterPage(driver);
		
		Thread.sleep(1000);
		registerPage.signUpAlert();
		String alertMessage = registerPage.getSignUpAlertMessage();
		System.out.println("Alert Message : " + alertMessage);
		
		Assert.assertEquals(alertMessage, message, "Alert message not match");
		registerPage.signUpAcceptAlert();
		
	}
	
	
	

	
	
	
}
