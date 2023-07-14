package org.rahulshettyacademy.AppiumFramework;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.rahulshettyacademy.AppiumFramework.TestUtilies.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import PageObjects.Android.NewFormPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;

public class HybridApp extends BaseTest {
	
	@Test
	public void addToCart_checkamount() throws InterruptedException
	{
		
		//NewFormPage newformpage = new NewFormPage(driver);		
		//newformpage.setNameField("Prathiba");
		//newformpage.setGender(("Female"));	
		
		
			driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("prathiba");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"))"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Air Jordan 4 Retro']/following-sibling::android.widget.LinearLayout//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Air Jordan 1 Mid SE']/following-sibling::android.widget.LinearLayout//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(2000);
		List<WebElement> prices= driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productPrice']"));
		double total_amount = 0;
		for (WebElement price :prices)
		{
			String value = (price.getText());
			String value_double=value.substring(1);
			double item_price = Double.parseDouble(value_double);
						total_amount = item_price+total_amount;
			System.out.println(total_amount);
			
		}
		String actual_value=driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/totalAmountLbl']")).getText();
		String remove_actual_total = actual_value.substring(1);
		double actual_total = Double.parseDouble(remove_actual_total);
		
		Assert.assertEquals(total_amount,actual_total);
		
		
		//LongPress
	WebElement condition=	driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
	longpressAction(condition);
	driver.findElement(By.id("android:id/button1")).click();
	
	driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
	driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
	
Thread.sleep(7000);
	
	// To switch to google web
	
	Set<String> All_context=  driver.getContextHandles();
	for(String context: All_context)
	{
		System.out.println(context);
	}
	
	driver.context("WEBVIEW_com.androidsample.generalstore");//switch to chromedriver
	driver.findElement(By.name("q")).sendKeys("Rahul shetty academey");
	driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	//driver.pressKey(new KeyEvent(AndroidKey.BACK));
	driver.context("NATIVE_APP");
	
		
	}
		
	
	
	
}
