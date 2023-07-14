package org.rahulshettyacademy.AppiumFramework.TestUtilies;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumDriver;

public class Listeners extends AppiumBaseTest implements ITestListener {
	ExtentReports extent = ExtentReport.config();
	//ITestListener is an interface.
	ExtentTest test;
	AppiumDriver driver;
	public void onTestStart(ITestResult result) {
	    // not implemented
	 test =  extent.createTest(result.getMethod().getMethodName());
	  }

	  public void onTestSuccess(ITestResult result) {
	  
			
			test.log(Status.PASS, "Test Passed");
	  }

	  public  void onTestFailure(ITestResult result) {
	   
		  test.log(Status.FAIL, "Test Failled");
		  
		  //driver
		 
		  
		  //screenshot
		  
		 try {
			 try {
				driver=(AppiumDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 test.addScreenCaptureFromPath(getScreenshotPath((result.getMethod().getMethodName()),driver), result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	  }

	  
	  public void onFinish(ITestContext context) {
	    extent.flush();
	  }

}
