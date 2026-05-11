package utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Cookie;
import io.restassured.http.Cookies;

public class CookieUtils {
	
	public List<Cookie> convertRestAssuredToSeleniumCookies(Cookies cookies){
		
		
		List<io.restassured.http.Cookie> restAssuredCookies;
		restAssuredCookies = cookies.asList();
		
		List<Cookie> seleniumCookies =  new ArrayList<>();
		
		
		for(io.restassured.http.Cookie cookie :restAssuredCookies) {
			System.out.println(cookie.getName());
			System.out.println(cookie.getValue());
			System.out.println(cookie.getDomain());
			System.out.println(cookie.getPath());
			System.out.println(cookie.getExpiryDate());
			System.out.println(cookie.isSecured());
			System.out.println(cookie.isHttpOnly());
			
			
			seleniumCookies.add(new Cookie(cookie.getName(), cookie.getValue(), cookie.getDomain(), cookie.getPath(), cookie.getExpiryDate(),
					cookie.isSecured(), cookie.isHttpOnly()));
			
		}
		
		
		return seleniumCookies;
		
		
	}

}
