package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.CommonUtils;

public class HomePage {
	WebDriver driver;
	private CommonUtils commonUtils;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonUtils = new CommonUtils(driver);
	}
	
	//objects
	@FindBy(css = "#signin2")
	private WebElement HomeSignUpButton;
	
	@FindBy(css = "#login2")
	private WebElement HomeLoginButton;
	
	@FindBy(css = "#nameofuser")
	private WebElement WelcomeUser;
	
	@FindBy(css = "#logout2")
	private WebElement LogOutButton;
	
	@FindBy(css = "img[alt='First slide']")
	private WebElement FirstSlide;
	
	@FindBy(css = "img[alt='Second slide']")
	private WebElement SecondSlide;
	
	@FindBy(css = "img[alt='Third slide']")
	private WebElement ThirdSlide;
	
	@FindBy(css = ".carousel-control-prev-icon")
	private WebElement CarouselLeftArrow;
	
	@FindBy(css = ".carousel-control-next-icon")
	private WebElement CarouselRightArrow;
	
	@FindBy(css = "#cat")
	private WebElement Categories;
	
	@FindBy(css = "body > div:nth-child(6) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(2)")
	private WebElement PhoneCategory;
	
	@FindBy(css = "body > div:nth-child(6) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(3)")
	private WebElement LaptopCategory;
	
	@FindBy(css = "body > div:nth-child(6) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(4)")
	private WebElement MonitorCategory;
	
	@FindBy(css = "#cartur")
	private WebElement CartPageButton;
	
	
	
	
	//methods
	public void clickOnHomeSignUpButton() {
		commonUtils.clickOnElement(HomeSignUpButton, commonUtils.EXPLICIT_WAIT);
	}
	
	public void clickOnHomeLoginButton() {
		commonUtils.clickOnElement(HomeLoginButton, commonUtils.EXPLICIT_WAIT);
	}
	
	public void clickOnHomeCartButton() {
		commonUtils.clickOnElement(CartPageButton, commonUtils.EXPLICIT_WAIT);
	}
	
	public String loggedinUsersName() {
		String usersName = commonUtils.getTextFromElement(WelcomeUser, commonUtils.EXPLICIT_WAIT);
		return usersName;
	}
	
	
	public boolean isWelcomeUserDisplayed() {
		return commonUtils.displayStatusOfElement(WelcomeUser,commonUtils.EXPLICIT_WAIT );
	}
	
	public boolean islogOutButtonDisplayed() {
		return commonUtils.displayStatusOfElement(LogOutButton,commonUtils.EXPLICIT_WAIT );
	}
	
	public boolean isCarouselFirstSlideDisplayed() {
		return commonUtils.displayStatusOfElement(FirstSlide,commonUtils.EXPLICIT_WAIT );
		
	}
	
	public boolean isCarouselSecondSlideDisplayed() {
		return commonUtils.displayStatusOfElement(SecondSlide,commonUtils.EXPLICIT_WAIT );
		
	}
	
	public boolean isCarouselThirdSlideDisplayed() {
		return commonUtils.displayStatusOfElement(ThirdSlide,commonUtils.EXPLICIT_WAIT );
		
	}
	
	public void clickCarouselPreviousImage() {
		commonUtils.clickOnElement(CarouselLeftArrow, commonUtils.EXPLICIT_WAIT);
	}
	
	public void clickCarouselNextImage() {
		commonUtils.clickOnElement(CarouselRightArrow, commonUtils.EXPLICIT_WAIT);
	}
	
	public String getFirstSlideImageAttrib() {
		WebElement element = commonUtils.waitForElement(FirstSlide, commonUtils.EXPLICIT_WAIT);
		return element.getAttribute("src");
	}
	
	public String getSecondSlideImageAttrib() {
		WebElement element = commonUtils.waitForElement(SecondSlide, commonUtils.EXPLICIT_WAIT);
		return element.getAttribute("src");
	}
	
	public String getThirdSlideImageAttrib() {
		WebElement element = commonUtils.waitForElement(ThirdSlide, commonUtils.EXPLICIT_WAIT);
		return element.getAttribute("src");
	}
	
	
	public boolean isCategoryHeaderDisplayed() {
		return commonUtils.displayStatusOfElement(Categories, commonUtils.EXPLICIT_WAIT);
		
	}
	
	public boolean isPhoneCategoryDisPlayed() {
		return commonUtils.displayStatusOfElement(PhoneCategory, commonUtils.EXPLICIT_WAIT);

	}
	
	public boolean isLaptopDisPlayed() {
		return commonUtils.displayStatusOfElement(LaptopCategory, commonUtils.EXPLICIT_WAIT);

	}
	
	public boolean isMonitorDisPlayed() {
		return commonUtils.displayStatusOfElement(MonitorCategory, commonUtils.EXPLICIT_WAIT);

	}
	
	
	public void clickOnItem(String item) {
		commonUtils.clickOnElementByLinkText(item, commonUtils.EXPLICIT_WAIT);
	}

	public String getPageTitle() {
		return commonUtils.getPageTitle();
	}

			
}
