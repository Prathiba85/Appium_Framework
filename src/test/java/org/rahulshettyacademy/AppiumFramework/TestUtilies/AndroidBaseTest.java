package org.rahulshettyacademy.AppiumFramework.TestUtilies;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
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
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import utility.CommonActions;

public class AndroidBaseTest extends AppiumBaseTest  {
	public static AndroidDriver driver;
	public static AppiumDriverLocalService service;
	public FormPage formpage;
	
	@BeforeMethod (alwaysRun = true)
	public void configureAppium() throws IOException
	{
		//Appium Codecode
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream ("C://Users//sanpr//exlipsefolder 2//AppiumFramework//src//main//java//resources//data.properties");
		prop.load(file);
		String ipAddress = prop.getProperty("ipAddress");
		int port = Integer.parseInt(prop.getProperty("port"));
		String AndroidDeviceName = prop.getProperty("AndroidDeviceName");
		service = startAppiumServer(ipAddress, port);
				UiAutomator2Options options = new UiAutomator2Options();
				options.setDeviceName(AndroidDeviceName);
				//options.setApp("C://Users//sanpr//exlipsefolder 2//Appium_practice//src//test//java//resources//ApiDemos-debug.apk");
				options.setApp("C://Users//sanpr//exlipsefolder 2//Appium_practice//src//test//java//resources//General-Store.apk");	
				options.setChromedriverExecutable("C://Appium_webDrivers//chromedriver.exe");
				driver=new AndroidDriver(service.getUrl(),options);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				formpage = new FormPage(driver);
	}
	
	@AfterMethod (alwaysRun = true)
	public void teardown()
	{
		driver.quit();
		service.stop();
	}

}
