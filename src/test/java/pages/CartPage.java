package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {
	public CartPage(WebDriver driver) {
		super(driver);
		//PageFactory.initElements(driver, this);
	}
	@FindBy(css = "td.product-name a")
	private WebElement addedToCartproductName;

	@FindBy(css = "a.checkout-button")
	private WebElement checkoutBtn;

	

	public String getCartProductName() {
		return addedToCartproductName.getText();
	}
	public CheckoutPage clickCheckoutButton() {
		wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn));
		checkoutBtn.click();
		return new CheckoutPage(driver);
	}
	
	public CheckoutPage clickCheckoutBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(addedToCartproductName));
		checkoutBtn.click();
		return new CheckoutPage(driver);
	}

	public List<Double> getPricesFromCart() {
		List<WebElement> priceElements = driver.findElements(By.cssSelector(
				"tr.woocommerce-cart-form__cart-item.cart_item td[data-title=\"Price\"] span.woocommerce-Price-amount.amount bdi:nth-child(1)"));
		List<Double> prices = new ArrayList<Double>();
		for (int i = 0; i < priceElements.size(); i++) {
			String priceText = priceElements.get(i).getText().replace("$", "").trim();
			prices.add(Double.parseDouble(priceText));
		}
		return prices;
	}

	public void validateOfferImpact(List<Double> pricesBefore, List<Double> pricesAfter, int windowSize) {
		int left = 0; // start of window
		int right = windowSize - 1; // end of window

		while (right < pricesBefore.size()) {
			System.out.println("Checking window: [" + left + " - " + right + "]");

			for (int i = left; i <= right; i++) {
				double before = pricesBefore.get(i);
				double after = pricesAfter.get(i);

				if (after < before) {
					System.out.println(
							"Discount applied on product index: " + i + " | Before: " + before + " | After: " + after);
				} else if (after > before) {
					System.out.println(
							"Price increased for product index: " + i + " | Before: " + before + " | After: " + after);
				} else {
					System.out.println("No price change for index: " + i);
				}
			}

			// slide the window forward
			left++;
			right++;
		}
	}

	public List<Double> getCartPrices() {
		List<WebElement> priceElements = driver.findElements(By.cssSelector(
				"tr.woocommerce-cart-form__cart-item.cart_item td[data-title=\"Price\"] span.woocommerce-Price-amount.amount bdi:nth-child(1)"));
		List<Double> prices = new ArrayList<Double>();

		for (int i = 0; i < priceElements.size(); i++) {
			String priceText = priceElements.get(i).getText().replace("$", "").trim();
			prices.add(Double.parseDouble(priceText));
		}
		return prices;
	}

	public void verifySlidingWindowSums(int windowSize) {
		List<Double> prices = getCartPrices();
		double windowSum = 0;

		if (prices == null || prices.isEmpty()) {
			System.out.println("No items in cart.");
			return;
		}

		if (windowSize > prices.size()) {
			System.out.println("Window size larger than number of items.");
			return;
		}
		// Calculate first window
		for (int i = 0; i < windowSize; i++) {
			windowSum += prices.get(i);
		}

		System.out.println("Window 0–" + (windowSize - 1) + " sum: " + windowSum);

		for (int i = windowSize; i < prices.size(); i++) {
			windowSum = windowSum - prices.get(i - windowSize) + prices.get(i);
			System.out.println("Window " + (i - windowSize + 1) + "–" + i + " sum: " + windowSum);
		}
	}

}
