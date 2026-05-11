package apis;

import java.util.HashMap;
import static io.restassured.RestAssured.*;
import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class APIRequest extends SpecBuilder{
	
	public static Response post(String endpoint,Headers headers, HashMap<String, Object> formParams,Cookies cookies) {
		
		return given(getRequestSpec())
				.headers(headers)
				.baseUri("https://askomdch.com/store?add_to_cart")
				.formParams(formParams)
				.cookies(cookies)
				.when()
				.post(endpoint).
				then().spec(getResponseSpec())
				.extract().response();
	}
	
	
public static Response get(String endpoint,Cookies cookies) {
		
		return given(getRequestSpec())
				.cookies(cookies)
				.when()
				.get(endpoint).
				then().spec(getResponseSpec())
				.extract().response();
	}

}
