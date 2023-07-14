package PageObjects.Android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utility.AndroidActions;

public class FormPage extends AndroidActions {
 AndroidDriver driver;
	
	public FormPage(AndroidDriver driver)
	{
		super(driver); //driver is coming from AndroidActions . Android Actions getting driver from BaseTest
		this.driver = driver;
		//When init Element is called all the locators will be created behind the scenes.
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	//Locators
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")private WebElement nameField;

	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")private WebElement femaleoption;
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")private WebElement maleoption;
	@AndroidFindBy(id="android:id/text1")private WebElement drp_country;
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")private WebElement btn_letsShop;
	
	//Action Classes
	
	public void setNameField(String name)
	{
		nameField.sendKeys(name);
	}
	
	public void setGender(String gender)
	{
		if(gender.contains("female"))
		{
			femaleoption.click();
		}
		else
		{
			maleoption.click();
		}
		
	}
	
	public void setCountry(String country)
	{

		drp_country.click();
		scrollToText(country);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+country+"']")).click();
		
	}
	
	public ProductCataloguePage  clickletsshop()
	{
		btn_letsShop.click();
		
		return new ProductCataloguePage(driver);
	}
	
}
