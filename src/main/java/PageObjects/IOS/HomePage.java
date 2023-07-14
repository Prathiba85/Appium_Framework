package PageObjects.IOS;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITBy;

public class HomePage  {
IOSDriver driver;
	
	public HomePage(IOSDriver driver)
	{
		//super(driver); //driver is coming from AndroidActions . Android Actions getting driver from BaseTest
		//this.driver = driver;
		//When init Element is called all the locators will be created behind the scenes.
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@iOSXCUITBy(accessibility="Alert Views") private WebElement alertViews;
	
	public void selectAlertViews()
	{
		alertViews.click();
	}
}
