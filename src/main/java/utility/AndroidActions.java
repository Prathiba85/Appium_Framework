package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class AndroidActions extends CommonActions {

	public static AndroidDriver driver;
	public AndroidActions(AndroidDriver driver)
	{
		this.driver = driver;
		//When init Element is called all the locators will be created behind the scenes.
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	public void longpressAction(WebElement element)
	{
		  ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
				    "elementId", ((RemoteWebElement) element).getId(),"duration",2000));
	}
	
	public void scrollToEndAction ()
	{
		// can scrollMore will return false if ther is no space for scrolling.
		boolean canScrollMore;	
		do
		{
		 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				));
		}while(canScrollMore);
	}
	public void swipeAction(WebElement element,String direction)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId",((RemoteWebElement)element).getId(),
		  "direction", direction,
		 "percent", 0.75
		));

	}
	
	public void scrollToText (String Text)
	{
driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+Text+"\"))"));
		
		
	}
	
	

}
