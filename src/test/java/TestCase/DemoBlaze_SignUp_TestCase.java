package TestCase;

import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PO.PO_DemoBlaze;
import Utility.BrowserManager;

public class DemoBlaze_SignUp_TestCase {
	WebDriver driver;
	JSONObject demoblaze;
	
	@BeforeClass
	public void beforeClass() {
		InputStream details = null;
		
		try {
			String fileName =  "data/demoblaze.json";
			details = getClass().getClassLoader().getResourceAsStream(fileName);
			
			JSONTokener tokner = new JSONTokener(details);
			
			demoblaze = new JSONObject(tokner);
			
			System.out.println("Data:"+demoblaze.toString());
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@BeforeMethod
	@Parameters({"browser","url"})
	public void setup(String browser, String url) throws InterruptedException {
		driver = BrowserManager.getDriver(browser);
		Thread.sleep(2000);
		
		driver.get(url);
		Thread.sleep(2000);
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		Thread.sleep(2000);

		
		
		
	}
	
	@Test(description="Testing signup for validData",priority=1)
	public void TestCase_validData() {
		
		String uname = demoblaze.getJSONObject("Valid").getString("user_name");
		String pass = demoblaze.getJSONObject("Valid").getString("Password");
		
		PO_DemoBlaze obj = PageFactory.initElements(driver, PO_DemoBlaze.class);
		obj.signUp(uname, pass);
		
	}

}
