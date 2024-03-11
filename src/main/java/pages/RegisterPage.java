package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.CommonUtils;

public class RegisterPage {
	
	WebDriver driver;
	private CommonUtils commonUtils;
	
	public RegisterPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonUtils = new CommonUtils(driver);
	}
	
	//objects
	@FindBy(css = "#signInModalLabel")
	private WebElement SignUpModalLabel;
	
	@FindBy(css = "#sign-username")
	private WebElement UsernameField;
	
	@FindBy(css = "#sign-password")
	private WebElement PasswordField;
	
	@FindBy(css = "button[onclick='register()']")
	private WebElement SignUpButton;
	
	@FindBy(css = "div[id='signInModal'] div[class='modal-footer'] button:nth-child(1)")
	private WebElement SignUpCloseButton;
	
	
	
	//methods	
	public void enterUsername(String username) {
	   commonUtils.typeTextIntoElement(UsernameField, username, commonUtils.EXPLICIT_WAIT);	
	}
	
	public void enterPassword(String password) {
	   commonUtils.typeTextIntoElement(PasswordField, password, commonUtils.EXPLICIT_WAIT);	
	}
	
	public void clickSignUpButton() {
		commonUtils.clickOnElement(SignUpButton, commonUtils.EXPLICIT_WAIT);
	}
	
	public String getSignUpAlertMessage() {
		String alertMessage = commonUtils.getAlertMessage(commonUtils.EXPLICIT_WAIT);
		return alertMessage;
	}
	
	public void signUpAlert() {
	    commonUtils.waitForAlert(commonUtils.EXPLICIT_WAIT);
	}
	
	public void signUpAcceptAlert() {
		commonUtils.acceptAlert(commonUtils.EXPLICIT_WAIT);
	}
	
	public void signUpDismisstAlert() {
		commonUtils.dismissAlert(commonUtils.EXPLICIT_WAIT);
	}
	
	public String getModalLabel() {
		String modalLabel = commonUtils.getTextFromElement(SignUpModalLabel, commonUtils.EXPLICIT_WAIT);
		return modalLabel;
	}
	
	
	
			
}
