package context;

import domainObjects.Cookies;

public class TestContext {
	
	public Cookies cookies;
	
	public TestContext() {
		cookies = new Cookies();
		cookies.setCookie(new io.restassured.http.Cookies());
	}

}
