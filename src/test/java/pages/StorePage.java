package pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StorePage extends BasePage {
	public StorePage(WebDriver d) {
		super(d);
	}
	@FindBy(css="input#woocommerce-product-search-field-0")
	private WebElement searchField	;
	
	@FindBy(css="button[value='Search']")
	private WebElement searchbtn;
	
	@FindBy(css="#main > div > header > h1")
	private WebElement searchresultDisplay;
	
	@FindBy(xpath="//a[@class=\"button product_type_simple add_to_cart_button ajax_add_to_cart\"]")
	private List<WebElement> addToCartBtnList;
	
	@FindBy(css="h1.woocommerce-products-header__title")
	private WebElement searchProductTitle;
	
	@FindBy(css="a[aria-label='Add “Blue Shoes” to your cart']")
	private WebElement addToCartBtn;
	
	@FindBy(css="a[title='View cart']")
	private WebElement viewCartLink;
	
	@FindBy(css="div.ast-site-header-cart a.cart-container:nth-child(1)")
	private WebElement viewCartIconLink;
	
	@FindBy(css="#menu-item-1227 > a")
	private WebElement storeLink;
	
	@FindBy(css="button[name=\"add-to-cart\"]")
	private WebElement addToCartButton;
	
	@FindBy(css="div.woocommerce-message a")
	private WebElement viewCartBtn;
	
	@FindBy(css="ul.products.columns-4 li")
	private List<WebElement> productsCard;
	
	@FindBy(css="div.astra-shop-summary-wrap a h2")
	private List<WebElement> productsDescription;
	
	@FindBy(css="div.astra-shop-summary-wrap bdi")
	private List<WebElement>  productsPrice;
	
	@FindBy(css="select.orderby")
	private WebElement sortDropdown;
	
	@FindBy(css="ul.products.columns-4")// li a[class=\"button product_type_simple add_to_cart_button ajax_add_to_cart\"]")
	private List<WebElement> productsList;
	
	
	public StorePage AddToCartButton() {
		addToCartButton.click();
		return this;
		}
	
	public void goToStorePage() {
		wait.until(ExpectedConditions.visibilityOf(storeLink));
		storeLink.click();		
		}
	
	public StorePage searchProduct(String text) {
		wait.until(ExpectedConditions.elementToBeClickable(searchField));
		searchField.sendKeys(text);
		wait.until(ExpectedConditions.elementToBeClickable(searchbtn));
		return this;
	}
	
	public StorePage clickSearchBtn() {
		searchbtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(searchresultDisplay));
		return this;
	}
	
	public String getTitleOfSearchProduct() {
		return searchProductTitle.getText();
		}
	
	//static element or single element only
	public StorePage clickAddToCartBtn() {
		addToCartBtn.click();
		return this;
	}
	
	public StorePage clickAddToCartButton() {
		addToCartButton.click();
		return this;
	}
	public StorePage clickViewCartLink() {
		wait.until(ExpectedConditions.visibilityOf(viewCartLink));
		viewCartLink.click();
		return this;
	}
	 public StorePage addRandomProductsToCart(int count) {
	        Random random = new Random();
	        int totalProducts = productsList.size();
	        System.out.println("Total products found: " + totalProducts);

	        if (totalProducts == 0) {
	            throw new RuntimeException("No products found on the page!");
	        }

	        for (int i = 0; i < count; i++) {
	            int randomIndex = random.nextInt(totalProducts);
	            WebElement product = productsList.get(randomIndex);

	            try {
	                WebElement name = product.findElement(By.cssSelector("a.ast-loop-product__link"));
	                WebElement addButton = product.findElement(By.cssSelector("a[class=\"button product_type_simple add_to_cart_button ajax_add_to_cart\"]"));
	                String productName = name.getText();

	                addButton.click();
	                System.out.println("✅ Added product: " + productName);

	                // small wait to allow DOM/cart to update
	                Thread.sleep(5000);

	            } catch (Exception e) {
	                System.out.println("⚠️ Error adding product: " + e.getMessage());
	            }
	        }
	        return this;
	    }

}
