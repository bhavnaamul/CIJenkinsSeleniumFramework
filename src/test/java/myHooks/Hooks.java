package myHooks;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import driverfactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import reports.ExtentManager;

public class Hooks {
	
	private static WebDriver driver;
	protected static ExtentReports extent; // Declare an instance variable for ExtentManager
	public static ExtentTest test;
	
	@Before
	    public void beforeScenario(Scenario scenario) {
	        test = extent.createTest(scenario.getName());
	    }

	
	@Before
	public void setup() {
		extent= ExtentManager.getExtent(); // Initialize the ExtentReports instance using ExtentManager
		System.out.println("Setting up the test environment...");
        driver= DriverFactory.initializeDriver();

	}
	
	 @After
	    public void afterScenario(Scenario scenario) {
	        if (scenario.isFailed()) {
	            test.fail("Scenario Failed");
	        } else {
	            test.pass("Scenario Passed");
	        }
	    }

	
	@After
	public void tearDown() {
	System.out.println("Tearing down the test environment...");
	extent.flush();
	driver.quit();
		
	}

}
