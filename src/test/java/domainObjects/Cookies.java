package domainObjects;
import java.util.List;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import utils.CookieUtils;

public class Cookies {
	
	
	private io.restassured.http.Cookies cookie;
	
	public io.restassured.http.Cookies getCookie() {
		return cookie;
	}
	
	public void setCookie(io.restassured.http.Cookies cookie) {
		this.cookie = cookie;
	}
	
	public void injectCookiesToBrowser(WebDriver driver) {
		
		List<Cookie> seleniumCookies= new CookieUtils().convertRestAssuredToSeleniumCookies(this.cookie);
		int i=0;
	    for(Cookie cookie : seleniumCookies) {
	      System.out.println("Injecting cookie: " + " with value: " +i +  cookie.toString());
		driver.manage().addCookie(cookie);
		i++;
		
	}
	    
	    driver.navigate().refresh();

	}
}
