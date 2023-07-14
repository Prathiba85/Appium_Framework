package PageObjects.Android;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utility.AndroidActions;

public class CartPage extends AndroidActions {
 AndroidDriver driver;
	
	public CartPage(AndroidDriver driver)
	{
		super(driver); //driver is coming from AndroidActions . Android Actions getting driver from BaseTest
		this.driver = driver;
		//When init Element is called all the locators will be created behind the scenes.
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	//Locators
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")private WebElement nameField;
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productPrice']") private List<WebElement> allprices;
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/totalAmountLbl']") private WebElement totalamount;
	@AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")private WebElement terms;
	@AndroidFindBy(id="android:id/button1")private WebElement terms_close;
	@AndroidFindBy(className="android.widget.CheckBox")private WebElement chk_terms;
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")private WebElement btn_payment;
	//Action Classes
	
	public void setNameField(String name)
	{
		nameField.sendKeys(name);
	}
	
	public double getTotalamount()
	{
		double total_amount = 0;
		for (WebElement price :allprices)
		{
			String value = (price.getText());
			String value_double=value.substring(1);
			double item_price = Double.parseDouble(value_double);
			total_amount = item_price+total_amount;		
		}
		return total_amount;
	}
	
	public double totaldisplayed()
	{
		String amount = totalamount.getText();
		String remove_actual_total = amount.substring(1);
		double actual_total = Double.parseDouble(remove_actual_total);
		return actual_total;
	}
	
	public void clickterms()
	{
		
		longpressAction(terms);
		terms_close.click();
	}
	
	public void clickagreecheckbox()
	{
		chk_terms.click();
	}
	
	public void clickpayment()
	{
	
		
		btn_payment.click();
	}
	
}
