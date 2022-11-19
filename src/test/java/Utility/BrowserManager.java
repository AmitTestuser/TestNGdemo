package Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.InputStream;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class BrowserManager {
	
	
	public static WebDriver getDriver(String type) {
		WebDriver driver = null;
		if(type.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		return driver;
	}
	

}
