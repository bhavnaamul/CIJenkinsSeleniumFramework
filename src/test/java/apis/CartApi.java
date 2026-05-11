package apis;

import java.util.HashMap;

import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class CartApi {
	
	private Cookies cookies;
	
	public CartApi(Cookies cookies) {
		this.cookies = cookies;
	}
	
	public Cookies getCookies() {
		return cookies;
	}
	
	public Response addToCart(int productId, int quantity) {
		Header headers = new Header("content-type", "application/x-www-form-urlencoded");
		Headers headersList = new Headers(headers);
		
		HashMap<String, Object> formParams = new HashMap<>();
		//formParams.put("product-sku", "");
		formParams.put("productId", productId);
		formParams.put("quantity", quantity);
		
		Response response = APIRequest.post("?add_to_cart", headersList, formParams, cookies);
		
		if(response.getStatusCode()!= 200) {
		   // System.out.println("Failed to add to cart. Status code: " + response.getStatusCode());
			System.out.println("Response body: " + response.getBody().asString());
			throw new RuntimeException("Failed to add to cart. Status code: " + response.getStatusCode());
			
		}
		this.cookies = response.getDetailedCookies();
		System.out.println("Cookies updated successfully after adding to cart.");
		return response;
	}
}
