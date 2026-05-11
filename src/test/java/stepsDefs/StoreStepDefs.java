package stepsDefs;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import context.TestContext;
import driverfactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myHooks.Hooks;
import pages.StorePage;

public class StoreStepDefs {
	
	private WebDriver driver;
	private TestContext testContext;
	protected static ExtentReports extent; // Declare an instance variable for ExtentTest
	protected ExtentTest test;
	
//	public StoreStepDefs(TestContext testContext) {
//		this.testContext = testContext;
//	}
	
@Given("when I am on the store page")
public void when_i_am_on_the_store_page() throws InterruptedException {
	Hooks.test.info("User launchs store page");
  driver = DriverFactory.getDriver();
  StorePage storePage = new StorePage(driver);
 driver.get("https://askomdch.com/store");;
 Thread.sleep(3000);
 //storePage.navigateTo("https://askomdch.com/store");

}


@Then("I should see the store page title")
public void i_should_see_the_store_page_title() {
	Hooks.test.info("User verifies store page title");

    String expectedTitle = "Store – AskOmDch";
	String actualTitle = driver.getTitle();
	if (actualTitle.equals(expectedTitle)) {
		System.out.println("Test Passed: Store page title is correct.");
	} else {
		System.out.println("Test Failed: Store page title is incorrect.");
		System.out.println("Expected: " + expectedTitle);
		System.out.println("Actual: " + actualTitle);
	}
}


@When("user adds products in the cart")
public void user_adds_products_in_the_cart() {
	StorePage storePage = new StorePage(driver);
	storePage.addRandomProductsToCart(1); // Add 3 random products to the cart
	storePage.clickViewCartLink();

}


@Then("I should see the products in add to cart link")
public void i_should_see_the_products_in_add_to_cart_link() {
	StorePage storePage = new StorePage(driver);
	Hooks.test.info("User clicks view cart toa dd products in the cart");

    storePage.clickViewCartLink();
    String expectedTitle = "Cart – AskOmDch";
    String actualTitle = driver.getTitle();
	if (actualTitle.equals(expectedTitle)) {
		Hooks.test.info("Store page title is correct.");
	//	System.out.println("Test Passed: Store page title is correct.");
	} else {
		Hooks.test.info("Store page title is incorrect.");
//		System.out.println("Test Failed: Store page title is incorrect.");
		System.out.println("Expected: " + expectedTitle);
		System.out.println("Actual: " + actualTitle);
	}
}

}
