package utility;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class CommonActions  {
	public  AppiumDriver driver;

		
	public Double getFormattedAmount(String amount)
	{
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}

	public void waitforElementToAppear(WebElement element,AppiumDriver driver )
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(element, "text", "Cart"));
		
	}
	
	public List<HashMap<String,String>> getJson(String jsonFilePath) throws IOException 
	{
		//File path = "C:\\Users\\sanpr\\exlipsefolder 2\\AppiumFramework\\src\\test\\java\\org\\rahulshettyacademy\\AppiumFramework\\TestData\\ecommerce.json
		String jsonContent =FileUtils.readFileToString(new File (jsonFilePath),StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap <String,String >> data = mapper.readValue(jsonContent, new TypeReference <List<HashMap<String,String>>>() {
		});
		return data;
		};
		
			
		
	
}
