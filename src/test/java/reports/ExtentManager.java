package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	private static ExtentReports extent;
	public static ExtentReports getExtent() {
		if(extent == null) {
			
			ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/ExtentReport.html");
			extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Browser", "Chrome");
			extent.setSystemInfo("OS", "Windows 10");
			extent.setSystemInfo("QA Engineer", "Bhavna Dargade");
			extent.setSystemInfo("Project Name", "Automation Framework");
		}
		return extent;
	}

}
