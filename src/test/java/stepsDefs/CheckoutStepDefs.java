package stepsDefs;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import context.TestContext;
import io.cucumber.java.en.Then;
import pages.CartPage;
import pages.CheckoutPage;

public class CheckoutStepDefs {
	private WebDriver driver;
	private TestContext testContext;
	
	public CheckoutStepDefs(TestContext testContext) {
		this.testContext = testContext;
	}
	@Then("User proceed to checkoutpage")
	public void user_proceed_to_checkoutpage() {
		CartPage cartpage = new CartPage(driver);
		CheckoutPage checkoutpage = cartpage.clickCheckoutBtn();
		checkoutpage.addFirstName("DemoUser").addLastName("Peculy").addStreetAddress("San Fransisco")
				.addCity("San Fransisco").addZipCode("94188").addEmailAddress("QWt548@gmail.com");
	}

	@Then("User fills the checkout details and place the order")
	public void user_fills_the_checkout_details_and_place_the_order() {
		new CheckoutPage(driver).clickCheckoutBtn();
	}

	@Then("User verify the order confirmation message")
	public void user_verify_the_order_confirmation_message() {
		assertEquals(new CheckoutPage(driver).getNoticeMsg(), "Thank you. Your order has been received.");

	}

}
