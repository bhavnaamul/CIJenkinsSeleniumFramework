package driverfactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public  static WebDriver driver;
	
	public static WebDriver initializeDriver() {
			
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		    System.out.println("DRIVER IN DRIVER FACTORY: " + driver);
			return driver;

	}
	
	public static WebDriver initializeDriver1(String browserName) {
		WebDriver driver;
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
            
        }else if (browserName.equalsIgnoreCase("firefox")) {
        	WebDriverManager.firefoxdriver().setup();
            driver= new FirefoxDriver();
            
        } else if(browserName.equalsIgnoreCase("edge")) {
        	WebDriverManager.edgedriver().setup();
        	 driver= new EdgeDriver();
        }else {
            throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			
			return driver;

	}	
	
	
	public static WebDriver getDriver() {
		//System.out.println("DRIVER IN DRIVER FACTORY: " + driver);
		driver.navigate().refresh();

		return driver;
		
	}
}
