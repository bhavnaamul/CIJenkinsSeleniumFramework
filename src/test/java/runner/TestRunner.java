package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class TestRunner {
	
	@CucumberOptions(
	plugin = {"pretty",
			"html:target/cucumber-reports.html" ,
			"json:target/cucumber-reports/report.json",
	        "rerun:target/failed-scenarios.txt"},
	
	glue= {"stepsDefs","myHooks"},
	features = "src/test/java/features"
	 //tags ="@smoke" ,          //System.getProperty("cucumber.filter.tags", "@smoke"),mvn test -Dcucumber.filter.tags="@regression"
	
	    	
)
	public class CucumberTestRunner extends AbstractTestNGCucumberTests {
		// This class will be empty. It is used as a test runner for Cucumber tests.
		@Override
		@DataProvider(parallel = false)
		public Object[][] scenarios(){
			return super.scenarios();
		}
	}

}
