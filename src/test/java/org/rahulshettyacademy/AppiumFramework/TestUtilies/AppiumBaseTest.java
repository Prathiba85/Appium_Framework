package org.rahulshettyacademy.AppiumFramework.TestUtilies;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import PageObjects.Android.FormPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import utility.CommonActions;

public class AppiumBaseTest extends CommonActions {
	public static AndroidDriver driver;
	public static AppiumDriverLocalService service;
	//public FormPage formpage;
	@BeforeMethod
	public void configureAppium() throws MalformedURLException, IOException
	{
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("PrathibaEmulator");
		//options.setApp("C://Users//sanpr//exlipsefolder 2//Appium_practice//src//test//java//resources//ApiDemos-debug.apk");
		options.setApp(("C://Users//sanpr//exlipsefolder 2//Appium_practice//src//test//java//resources//General-Store.apk"));	
		
		options.setChromedriverExecutable("C://Appium_webDrivers//chromedriver.exe");
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//formpage = new FormPage(driver);
	}
	
	public AppiumDriverLocalService startAppiumServer(String ipAddress,int port)
	{
		//Appium Codecode
		
		//To start server Automatically (main .js file is responsible to invoke the server)
		service = new AppiumServiceBuilder().withAppiumJS(new File ("C://Users//sanpr//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress(ipAddress).usingPort(port).build();
				service.start();
				return service;
	}
	
	public String getScreenshotPath(String Testcasename,AppiumDriver driver) throws IOException
	{
		File source = driver.getScreenshotAs(OutputType.FILE);
		String destinationfile = System.getProperty("user.dir")+"//reports"+Testcasename+".png";
		FileUtils.copyFile (source, new File (destinationfile));
		return destinationfile;
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
		service.stop();
	}

}
