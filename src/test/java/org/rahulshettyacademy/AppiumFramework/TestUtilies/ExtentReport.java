package org.rahulshettyacademy.AppiumFramework.TestUtilies;

import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReport {
	static ExtentReports extent;
	@BeforeTest
	public static ExtentReports config()
	{
		// ExtentReports - This will drive all reporting execution
		// ExtentSparReporter - Is responsible to create file and do configuration.
		String path = System.getProperty("user.dir")+"//reports/index.html";
		ExtentSparkReporter sreporter = new ExtentSparkReporter(path);
		sreporter.config().setReportName("Mobile Automation Results");
		sreporter.config().setDocumentTitle("Mobile Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(sreporter);
		extent.setSystemInfo("Tester","Prathiba");
		return extent;
	}
	
	
	
}
