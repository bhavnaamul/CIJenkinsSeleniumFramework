package stepsDefs;

import org.openqa.selenium.WebDriver;

import apis.CartApi;
import context.TestContext;
import driverfactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.StorePage;

public class CartStepDefs {
	 
	private WebDriver driver;
    private TestContext testContext;
    
    	public CartStepDefs(TestContext testContext) {
    		this.testContext = testContext;
    		System.out.println("Injected TestContext: " + testContext);
    	}
    	
//    	public CartStepDefs() {
//			// TODO Auto-generated constructor stub
//		}
    	
    
@Given("when I am on the cart page")
public void when_i_am_on_the_cart_page() {
//	driver = DriverFactory.getDriver();
//	driver.get("https://askomdch.com/store");
//	maybe because of this getting    java.lang.NullPointerException: Cannot read field "cookies" because "this.testContext" is null
//	driver = DriverFactory.getDriver();
//	  StorePage storePage = new StorePage(driver);
//	 driver.get("https://askomdch.com/store");;
}

@When("user verify products in the cart")
public void user_verify_products_in_the_cart() {
	StorePage storePage = new StorePage(driver);
  	storePage.addRandomProductsToCart(1); // Add 1 random product to the cart
	storePage.clickViewCartLink();
}

@Then("I should see the proceed to checkout button cart page")
public void i_should_see_the_proceed_to_checkout_button_cart_page() {
	CartPage cartpage=new CartPage(driver);	
	cartpage.getCartProductName();
	cartpage.clickCheckoutButton(); 
}


@When("user adds all the  products in the cart")
public void user_adds_all_the_products_in_the_cart() {
	StorePage storePage = new StorePage(driver);
	storePage.addRandomProductsToCart(5); // Add 3 random products to the cart
	storePage.clickViewCartLink();

}

@When("apiuser add products in the cart vias APIs")
public void apiuser_add_products_in_the_cart_vias_apis() throws InterruptedException {
	 driver = DriverFactory.getDriver();
	  StorePage storePage = new StorePage(driver);
	 driver.get("https://askomdch.com/store");;
	 Thread.sleep(3000);
	CartApi cartApi = new CartApi(testContext.cookies.getCookie());  //null
	cartApi.addToCart(1215, 1);
	testContext.cookies.setCookie(cartApi.getCookies());
	testContext.cookies.injectCookiesToBrowser(driver);
}

}