package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.ConfigReader;

public class Hooks {

	WebDriver driver;
	ConfigReader configReader;
	
	@Before
	public void setup() {
		Properties prop = new ConfigReader().init_props();
		
		driver = DriverFactory.init_browser(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
	
	}
	
	
	@After
	public void tearDown(Scenario scenario) {
		String scenarioName = scenario.getName().replaceAll("","_");
		
		if(scenario.isFailed()) {
			byte[]	srcScreensot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcScreensot,"image/png", scenarioName);
			}
		
		driver.quit();
	}
}
