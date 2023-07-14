package org.rahulshettyacademy.AppiumFramework.TestUtilies;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	public  AndroidDriver driver;
	public  AppiumDriverLocalService service;
	@BeforeClass
	public void configureAppium() throws MalformedURLException
	{
		//Appium Codecode
		
		//To start server Automatically (main .js file is responsible to invoke the server)
		service = new AppiumServiceBuilder().withAppiumJS(new File ("C://Users//sanpr//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
		.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("PrathibaEmulator");
		//options.setApp("C://Users//sanpr//exlipsefolder 2//Appium_practice//src//test//java//resources//ApiDemos-debug.apk");
		options.setApp("C://Users//sanpr//exlipsefolder 2//Appium_practice//src//test//java//resources//General-Store.apk");	
		options.setChromedriverExecutable("C://Appium_webDrivers//chromedriver.exe");
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void longpressAction(WebElement element)
	{
		  ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
				    "elementId", ((RemoteWebElement) element).getId(),"duration",2000));
	}
	
	public void scrollToEndAction ()
	{
		/* can scrollMore will return false if ther is no space for scrolling.
		boolean canScrollMore;	
		do
		{
		 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				    "left", 100, "top", 100, "width", 200, "height", 200,
				    "direction", "down",
				    "percent", 3.0
				));
		}while(canScrollMore);*/
	}
	public void swipeAction(WebElement element,String direction)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId",((RemoteWebElement)element).getId(),
		  "direction", direction,
		 "percent", 0.75
		));

	}
	@AfterClass
	public void teardown()
	{
		driver.quit();
		service.stop();
	}

}
