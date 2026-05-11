package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage{

	@FindBy(css ="#billing_first_name")
	private WebElement firstname;
	
	@FindBy(css ="#billing_last_name")
	private WebElement lastname;
	
	@FindBy(css ="td.product-name a")
	private WebElement countryDrpdown;
	
	@FindBy(css ="#billing_address_1")
	private WebElement streetAddress;
	
	@FindBy(css ="#billing_city")
	private WebElement town;
	
	@FindBy(css ="#billing_postcode")
	private WebElement zipcode;
	
	@FindBy(css ="#billing_email")
	private WebElement emailAddress;
	
	@FindBy(css ="#place_order")
	private WebElement checkoutBtn;
	
	@FindBy(css =".woocommerce-notice")
	private WebElement noticeMessage;
	
	
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		//PageFactory.initElements(driver, this);
		}
	
	public CheckoutPage addFirstName(String fname) {
		wait.until(ExpectedConditions.elementToBeClickable(firstname));
		firstname.sendKeys(fname);
		return this;
	}
	
	public CheckoutPage addLastName(String lname) {
		wait.until(ExpectedConditions.elementToBeClickable(lastname));
		lastname.sendKeys(lname);
		return this;
	}

	public CheckoutPage addStreetAddress(String address) {
		wait.until(ExpectedConditions.elementToBeClickable(streetAddress));
		streetAddress.sendKeys(address);
		return this;
	}
	
	public CheckoutPage addCity(String city) {
		wait.until(ExpectedConditions.elementToBeClickable(town));
		town.sendKeys(city);
		return this;
	}
	public CheckoutPage addZipCode(String code) {
		wait.until(ExpectedConditions.elementToBeClickable(zipcode));
		zipcode.sendKeys(code);
		return this;
	}
	
	public CheckoutPage addEmailAddress(String email) {
		wait.until(ExpectedConditions.elementToBeClickable(emailAddress));
		emailAddress.sendKeys(email);
		return this;
	}
	
	public void clickCheckoutBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn));
		checkoutBtn.click();
	}
	public String getNoticeMsg() {
		wait.until(ExpectedConditions.visibilityOf(noticeMessage));
		return noticeMessage.getText();
	}
	
}
