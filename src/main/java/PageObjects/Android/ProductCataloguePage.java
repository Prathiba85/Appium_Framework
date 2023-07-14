package PageObjects.Android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utility.AndroidActions;

public class ProductCataloguePage extends AndroidActions {
 AndroidDriver driver;
	
	public ProductCataloguePage(AndroidDriver driver)
	{
		super(driver); //driver is coming from AndroidActions . Android Actions getting driver from BaseTest
		this.driver = driver;
		//When init Element is called all the locators will be created behind the scenes.
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	//Locators
	
	//@AndroidFindBy(xpath="//android.widget.TextView[@text='Air Jordan 4 Retro']/following-sibling::android.widget.LinearLayout//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']")private WebElement product1;
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")private WebElement btn_cart;
	//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"))"));
	
	/* Other method to get
	 * @AndroidFindBy(xpath="android.widget.TextView[@text="AddTo Cart']")private List<WebElement> addToCart;
	 */

	
	//Action Classes
	
	public void addCart(String product1,String product2)
	{
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+product1+"']/following-sibling::android.widget.LinearLayout//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+product2+"']/following-sibling::android.widget.LinearLayout//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']")).click();
		
	}
	
	public CartPage click_addcart() throws InterruptedException
	{
		btn_cart.click();
		Thread.sleep(2000);
		return new CartPage(driver);
	}
	
}
