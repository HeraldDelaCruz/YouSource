package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.CommonUtils;

public class LoginPage {
	
	WebDriver driver;
	private CommonUtils commonUtils;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonUtils = new CommonUtils(driver);
	}
	
	//objects
	@FindBy(css = "#logInModalLabel")
	private WebElement LoginModalLabel;
	
	@FindBy(css = "#loginusername")
	private WebElement UsernameField;
	
	@FindBy(css = "#loginpassword")
	private WebElement PasswordField;
	
	@FindBy(css = "button[onclick='logIn()']")
	private WebElement LoginButton;
	
	@FindBy(css = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > button:nth-child(1)")
	private WebElement LoginCloseButton;

	
	//methods
	public void enterUsername(String username) {
		commonUtils.typeTextIntoElement(UsernameField, username, commonUtils.EXPLICIT_WAIT);
	}
	
	public void enterPassword(String username) {
		commonUtils.typeTextIntoElement(PasswordField, username, commonUtils.EXPLICIT_WAIT);
			
	}
	
	public void clickOnLoginButton() {
		commonUtils.clickOnElement(LoginButton, commonUtils.EXPLICIT_WAIT);
	}
	
	


	
	
}