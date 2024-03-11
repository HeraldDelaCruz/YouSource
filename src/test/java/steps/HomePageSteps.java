package steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

public class HomePageSteps {

	WebDriver driver;
	private HomePage homePage;
	
	//step_home_001
	@When("^User checks the \"([^\"]*)\" in Carousel$")
	public void user_checks_the_in_carousel(String slide) throws Exception {
		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
				
		if (slide.equals("First slide")) {
			homePage.isCarouselFirstSlideDisplayed();
			
		}
		else if (slide.equals("Second slide")) {
			Thread.sleep(1000);
			homePage.clickCarouselNextImage();
			homePage.isCarouselSecondSlideDisplayed();
			
		}
		else if (slide.equals("Third slide")) {
			Thread.sleep(1000);
		    homePage.clickCarouselNextImage();
		    Thread.sleep(1000);
		    homePage.clickCarouselNextImage();
		    Thread.sleep(1000);
		    homePage.clickCarouselNextImage();
			homePage.isCarouselThirdSlideDisplayed();
		}
			
			
	}

	//step_home_002
	@Then("^\"([^\"]*)\" should be displayed$")
	public void should_be_displayed(String slide) throws Exception {
		
		if (slide.equals("Phone")) {
			String expectedItem = "https://www.demoblaze.com/Samsung1.jpg";
			String actualItem = homePage.getFirstSlideImageAttrib();
			Assert.assertEquals(actualItem, expectedItem, "Image display : "+actualItem+" , Display Image seems incorrect :");
			
		}
		else if (slide.equals("Laptop")) {
			String expectedItem = "https://www.demoblaze.com/Laptop.jpg";
			String actualItem = homePage.getSecondSlideImageAttrib();
			Assert.assertEquals(actualItem, expectedItem, "Image display : "+actualItem+" , Display Image seems incorrect :");
		}
		else if (slide.equals("Monitor")) {
			String expectedItem = "https://www.demoblaze.com/Monitor.jpg";
			String actualItem = homePage.getThirdSlideImageAttrib();
			Assert.assertEquals(actualItem, expectedItem, "Image display : "+actualItem+" , Display Image seems incorrect :");
		}
	}
	
	//step_home_003
	@When("User checks the category selection section")
	public void user_checks_the_category_selection_section() {
	    homePage.isCategoryHeaderDisplayed();
	}

	//step_home_004
	@Then("Categories should be displayed") 
	public void categories_should_be_displayed() {
		 homePage = new HomePage(driver);
		 homePage.isPhoneCategoryDisPlayed();
		 homePage.isLaptopDisPlayed();
		 homePage.isMonitorDisPlayed();
	}	
}
