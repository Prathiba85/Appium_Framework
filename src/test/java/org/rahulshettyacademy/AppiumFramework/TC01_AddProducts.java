package org.rahulshettyacademy.AppiumFramework;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;


import org.rahulshettyacademy.AppiumFramework.TestUtilies.AndroidBaseTest;
import org.rahulshettyacademy.AppiumFramework.TestUtilies.AppiumBaseTest;
import org.rahulshettyacademy.AppiumFramework.TestUtilies.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import PageObjects.Android.CartPage;
import PageObjects.Android.FormPage;
import PageObjects.Android.NewFormPage;
import PageObjects.Android.ProductCataloguePage;
import io.appium.java_client.android.AndroidDriver;


public class TC01_AddProducts extends AndroidBaseTest {
	
	
	@Test (dataProvider = "getData", groups = {"Smoke"})
	
	public void addToCart_checkamount(HashMap<String,String> input) throws InterruptedException
	{
		
	
	
		formpage.setGender(input.get("gender"));	
		formpage.setCountry(input.get("country"));
		formpage.setNameField(input.get("name"));
		ProductCataloguePage productpage = formpage.clickletsshop();	
		productpage.addCart("Air Jordan 4 Retro", "Air Jordan 1 Mid SE");
		CartPage cartpage = productpage.click_addcart();
		double expectedtotal= cartpage.getTotalamount();
		double actualtotal =cartpage.totaldisplayed();
		Assert.assertEquals(expectedtotal,actualtotal);
		cartpage.clickterms();
		cartpage.clickagreecheckbox();
		cartpage.clickpayment();		
	}

	
	/*@DataProvider 
	public  Object[][] getData()
	{
		//Object is the parent data type that accept all data types
		return new Object [] []  { {"rahul Shetty","male","Argentina"},{"Prathiba","female","Australia"} };
	}*/
	
	
	@DataProvider
	public  Object[][] getData() throws IOException
	{
		List<HashMap<String,String>>data = getJson("C:\\Users\\sanpr\\exlipsefolder 2\\AppiumFramework\\src\\test\\java\\org\\rahulshettyacademy\\AppiumFramework\\TestData\\ecommerce.json");
		//Object is the parent data type that accept all data types
		return new Object [] []  { {data.get(0)},{data.get(1)} };
	}
	

}
