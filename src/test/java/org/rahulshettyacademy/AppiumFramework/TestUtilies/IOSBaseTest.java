package org.rahulshettyacademy.AppiumFramework.TestUtilies;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class IOSBaseTest extends AppiumBaseTest {
	public static IOSDriver driver;
	public static AppiumDriverLocalService service;
	@BeforeClass
	public void configureAppium() throws IOException
	{
		//IOS Code
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String ipaddress= prop.getProperty("ipAddress");
		int port = Integer.parseInt (prop.getProperty("port"));
		service =  startAppiumServer(ipaddress,port);
		
		XCUITestOptions options = new XCUITestOptions();
		
		options.setDeviceName("iPhone 13 Pro");
		options.setApp("Applocation(i.e:path where apk file is stored/ You can save in resources as well which is recommended");
		// **It is mandatory to set up ios version Ex: for 13 pro it is 15.5
		options.setPlatformVersion("15.5");
		
		//Appium -webdriver Agent ->IOS Apps.  IOS it can't talk directly to the Appium. so you have to write teh command.
		options.setWdaLaunchTimeout(Duration.ofSeconds(10));
		
		
		driver=new IOSDriver(new URL("http://127.0.0.1:4723"),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	
	@AfterClass
	public void teardown()
	{
		driver.quit();
		service.stop();
	}
}
