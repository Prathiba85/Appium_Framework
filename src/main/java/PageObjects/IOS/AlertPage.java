package PageObjects.IOS;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITBy;

public class AlertPage  {
IOSDriver driver;
	
	public AlertPage(IOSDriver driver)
	{
		//super(driver); //driver is coming from AndroidActions . Android Actions getting driver from BaseTest
		//this.driver = driver;
		//When init Element is called all the locators will be created behind the scenes.
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@iOSXCUITBy(iOSClassChain="**/XCUIElementTypeStaticText[`label=='Text Entry'`]\"") private WebElement txt_textEntry;
	@iOSXCUITBy(iOSNsPredicate= " ")
	
	
	public void selectAlertViews()
	{
		txt_textEntry.sendKeys("Prathiba");
	}
}
