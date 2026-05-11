package pomPck;

import org.openqa.selenium.WebDriver;

import pages.BasePage;

public class AccountPage extends BasePage {
	
	public AccountPage(WebDriver driver) {
		super(driver);
		System.out.println("Account page constructor called");
		}
	public void enterDetails() { System.out.println("Account details entered"); }
    public void submit() { System.out.println("Account created"); }

}
