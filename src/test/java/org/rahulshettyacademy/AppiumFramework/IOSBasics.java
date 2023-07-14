package org.rahulshettyacademy.AppiumFramework;

import org.openqa.selenium.By;
import org.rahulshettyacademy.AppiumFramework.TestUtilies.IOSBaseTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSBasics extends IOSBaseTest {
	
	@Test
	public void IOSBasictest()
	{
		//XPath,class,IOS,Tow more additional locators -- >iosClassChain, IOSPredicateString,accessibility id ,id 
		
		driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
		
		//New locator -- ios class chain becaus xpath will be slow xpath --> xml language--App .source
		
		driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Text Entry']")).click();
		
		//Difference between xpath and ioschain locator -- > Instead of // it is **/ and you have to use backslash`, there is no @
		//you will get iosclasschain details in the Appium locator
		
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label=='Text Entry'`]")).click();
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell")).click();
		
		//IOSPredicateString -- > matching string -->Attribute =value--> label ="confirm/Cancel" .This is verysimple
		//predicate string you can use conjunction of multiple 
		driver.findElement(AppiumBy.iOSNsPredicateString("type = 'XCUIElementTypeStaticText' AND value = 'confirm/cancel'"));
		
		//BegisWith and Ends with ---> [c] -->ignore case
		driver.findElement(AppiumBy.iOSNsPredicateString("type = 'XCUIElementTypeStaticText' AND value BEGISWITH[c] 'confirm'")).click();
	}

}
