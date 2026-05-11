package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;

public class BasePage {
	
		protected WebDriver driver;  //instance variable to hold WebDriver reference  ,  initialing null
		protected WebDriverWait wait;
		
		
		public BasePage(WebDriver d){
			this.driver=d;
			wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize WebDriverWait with a timeout of 10 secondsO
			PageFactory.initElements(driver, this); // Initialize WebElements using PageFactory
			System.out.println("BasePage constructor called to initialize WebDriver");
			
		}
		
		public void navigateTo(String url) {
	        driver.get(url);
	        driver.manage().window().maximize();
	        
	    }
		
		 public void click(By locator) {
		        driver.findElement(locator).click();
		    }
		 
		 public void enterText(By locator) {
		        driver.findElement(locator).click();
		    }
		

}
	