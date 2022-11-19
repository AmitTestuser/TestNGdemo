package TestCase;

import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PO.PO_Facebook;
import PO.PO_NopCommerce;
import Utility.BrowserManager;

import org.json.JSONObject;
import org.json.JSONTokener;

public class Facebook_TestCase {
	
	   WebDriver driver;
	    JSONObject facebooklogin;
	    
	    @BeforeClass
	    public void beforeClass()
	    {
	    InputStream details=null;    
	        
	        try {
	            String FileName="facebooklogin.json";
	            details=getClass().getClassLoader().getSystemResourceAsStream(FileName);
	            JSONTokener tokener=new JSONTokener(details);
	            facebooklogin=new JSONObject(tokener);
	            
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	            if(details!= null)
	            {
	                //driver.quit();
	            }
	            
	        }
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    @BeforeMethod
	    @Parameters({"browser","url"})
	    public void setup(String browser,String url) throws InterruptedException
	    {
	        driver=BrowserManager.getDriver(browser);
	        Thread.sleep(3000);
	        driver.get(url);
	        Thread.sleep(3000);
	        driver.manage().window().maximize();
	        Thread.sleep(3000);
	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	        Thread.sleep(3000);
	        }
	    
	    @Test(testName="Valid Data", description="Testing Nopcommerce with valid data")
	    public void ValidData()
	    {
	        String uname=facebooklogin.getJSONObject("Valid_data").getString("uname");
	        String pass=facebooklogin.getJSONObject("Valid_data").getString("pass");
	        



	       PO_Facebook obj=PageFactory.initElements(driver, PO_Facebook.class);
	        obj.valid(uname,pass);
	        



	   }
	    @Test(testName="InValid Data", description="Testing Nopcommerce with Invalid data")
	    public void InvalidValidData()
	    {
	        String uname=facebooklogin.getJSONObject("InValid_data").getString("uname");
	        String pass=facebooklogin.getJSONObject("InValid_data").getString("pass");
	        



	       PO_Facebook obj=PageFactory.initElements(driver, PO_Facebook.class);
	        obj.valid(uname,pass);
	    }
	    @Test(testName="InValid Data", description="Testing Nopcommerce with Invalid data")
	    public void Blank()
	    {
	        String uname=facebooklogin.getJSONObject("InValid_data").getString("uname");
	        String pass=facebooklogin.getJSONObject("InValid_data").getString("pass");
	        



	       PO_Facebook obj=PageFactory.initElements(driver, PO_Facebook.class);
	        obj.valid(uname,pass);
	    }
	    



}
