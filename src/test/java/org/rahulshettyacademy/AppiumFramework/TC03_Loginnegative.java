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
import org.rahulshettyacademy.AppiumFramework.TestUtilies.AndroidBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import PageObjects.Android.CartPage;
import PageObjects.Android.FormPage;
import PageObjects.Android.ProductCataloguePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;

public class TC03_Loginnegative extends AndroidBaseTest {
	
	
		
	@Test 
	public void toastmessage()
	{
		
	
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String toastmessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(toastmessage,"Please enter your name");
	}
	
	

	
	
	
}
