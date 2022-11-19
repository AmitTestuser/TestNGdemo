package TestCase;

import java.io.InputStream;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import PO.PO_NopCommerce;
import Utility.BrowserManager;
import Utility.ExtentReportManager;

public class NopCommerce_TestCase {
	WebDriver driver;
	JSONObject nopcommerce;// make sure name is equal to Data/nopcommerce.json

	
	@BeforeClass
	public void beforeClass()throws Exception{
		InputStream details = null;
		try {
			String fileName = "data/nopcommerce.json";
			details = getClass().getClassLoader().getResourceAsStream(fileName);
			JSONTokener tokener = new JSONTokener(details);
			
			nopcommerce = new JSONObject(tokener);
			System.out.println("Data is "+nopcommerce.toString());
			
			ExtentReportManager.createReport("Registration_report");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	
	}
	
	@BeforeMethod // before each test case this method will execute
	@Parameters({"browser","url"})
	public void setup(String browser, String url) throws InterruptedException {
		driver = BrowserManager.getDriver(browser); // this class is present in Utility Package
		Thread.sleep(3000);
		driver.get(url);
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		Thread.sleep(3000);
		
		
		
		
	}
	
//	@Test(testName = "Valid Data",description = "Testing Nopcommerce with valid data")
//	public void test_registration_with_valid_data() { 
//		PO_NopCommerce obj = new PO_NopCommerce(driver);
//		PageFactory.initElements(driver, obj); // elements of PO_Nopcommerce are getting initialize here
//		//public void valid_Data(String fname,String lname,String Email,String strEmail,String strCEmail,String user,String cName ,String time,String pass, String cpass, String StrComId,String strRId, String strWDid,String strCsizeId,String url)
//		//public void valid_Data(String fname,String lname,String Email,String strEmail,String strCEmail,String user,String cName ,String time,String pass, String cpass, String StrComId,String strRId, String strWDid,String strCsizeId,String url)
//		// this is one method to send data
//		obj.valid_Data("Amit", "Nitnaware", "amit03@gmail.com", "amit03@gmail.com", "amit_20033", "India", "(UTC-10:00) Hawaii", "Pass@1234", "Pass@1234", "Develops nopCommerce extensions", "Technical developer", "1–3 years", "6–15", "www.google.com");
//	}
	
	
	
	
	@Test(description="Testing Nopcommerce using external data",priority=1)
	public void test_valid_data() {
		// variable name should be same as PO arguments names
		ExtentReportManager.startTest("Valid_data_registration");
		try {
		String fname = nopcommerce.getJSONObject("Valid").getString("Firstname");
		String lname = nopcommerce.getJSONObject("Valid").getString("Lastname");
		
		String Email = nopcommerce.getJSONObject("Valid").getString("email");
		String strCEmail = nopcommerce.getJSONObject("Valid").getString("ConfirmEmail");
		String user = nopcommerce.getJSONObject("Valid").getString("UserName");
		String cName = nopcommerce.getJSONObject("Valid").getString("CountryName");
		String time = nopcommerce.getJSONObject("Valid").getString("TimeZone");
		String pass = nopcommerce.getJSONObject("Valid").getString("password");
		String cpass = nopcommerce.getJSONObject("Valid").getString("confirmPassword");
		String StrComId = nopcommerce.getJSONObject("Valid").getString("companyPrimarily");
		String strRId = nopcommerce.getJSONObject("Valid").getString("mainActivity");
		String strWDid = nopcommerce.getJSONObject("Valid").getString("developmentTime");
		String strCsizeId = nopcommerce.getJSONObject("Valid").getString("workingYears");
		String url = nopcommerce.getJSONObject("Valid").getString("yourUrl");
		String expectedResult = nopcommerce.getJSONObject("Valid").getString("ExpectedResult");
 
		System.out.println(fname+lname);
		
		
		// here we are passing above variable to valid function of PO_NopCommerce
		PO_NopCommerce obj = PageFactory.initElements(driver, PO_NopCommerce.class);
		obj.valid_Data(fname, lname, Email, strCEmail, user, cName, time, pass, cpass, StrComId, strRId, strWDid, strCsizeId, url,expectedResult);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test(description ="Testing nopcommerce for invalid data",priority=1)
	public void test_Invalid_email() {
		
		ExtentReportManager.startTest("Invalid_data_registration");
		
		String fname = nopcommerce.getJSONObject("Invalid_email").getString("Firstname");
		String lname = nopcommerce.getJSONObject("Invalid_email").getString("Lastname");
		
		String Email = nopcommerce.getJSONObject("Invalid_email").getString("email");
		String strCEmail = nopcommerce.getJSONObject("Invalid_email").getString("ConfirmEmail");
		String expectedResult = nopcommerce.getJSONObject("Invalid_email").getString("ExpectedResult");
		PO_NopCommerce obj = PageFactory.initElements(driver, PO_NopCommerce.class);
		
		obj.Invalid_email(fname, lname, Email, strCEmail,expectedResult);
	
	}
	
	/*
	@Test(description="Testing nopcommerce for blank data")
	public void test_blank_data() {
		try {
		String fname = nopcommerce.getJSONObject("Blank").getString("Firstname");
		String lname = nopcommerce.getJSONObject("Blank").getString("Lastname");
		
		String Email = nopcommerce.getJSONObject("Blank").getString("email");
		String strCEmail = nopcommerce.getJSONObject("Blank").getString("ConfirmEmail");
		String user = nopcommerce.getJSONObject("Blank").getString("UserName");
		String cName = nopcommerce.getJSONObject("Blank").getString("CountryName");
		String time = nopcommerce.getJSONObject("Blank").getString("TimeZone");
		String pass = nopcommerce.getJSONObject("Blank").getString("password");
		String cpass = nopcommerce.getJSONObject("Blank").getString("confirmPassword");
		String StrComId = nopcommerce.getJSONObject("Blank").getString("companyPrimarily");
		String strRId = nopcommerce.getJSONObject("Blank").getString("mainActivity");
		String strWDid = nopcommerce.getJSONObject("Blank").getString("developmentTime");
		String strCsizeId = nopcommerce.getJSONObject("Blank").getString("workingYears");
		String url = nopcommerce.getJSONObject("Blank").getString("yourUrl");
		
		PO_NopCommerce obj = PageFactory.initElements(driver, PO_NopCommerce.class);
		obj.Invalid_BlankData(fname, lname, Email, strCEmail, user, cName, time, pass, cpass, StrComId, strRId, strWDid, strCsizeId, url);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	/*
	
	@Test(description="Testing nopcommerce for double data")
	public void test_doubleSpace_data() {
		String fname = nopcommerce.getJSONObject("DoubleSpace").getString("Firstname");
		String lname = nopcommerce.getJSONObject("DoubleSpace").getString("Lastname");
		
		String Email = nopcommerce.getJSONObject("DoubleSpace").getString("email");
		String strCEmail = nopcommerce.getJSONObject("DoubleSpace").getString("ConfirmEmail");
		String user = nopcommerce.getJSONObject("DoubleSpace").getString("UserName");
		String cName = nopcommerce.getJSONObject("Valid").getString("CountryName");
		String time = nopcommerce.getJSONObject("Valid").getString("TimeZone");
		String pass = nopcommerce.getJSONObject("Valid").getString("password");
		String cpass = nopcommerce.getJSONObject("Valid").getString("confirmPassword");
		String StrComId = nopcommerce.getJSONObject("Valid").getString("companyPrimarily");
		String strRId = nopcommerce.getJSONObject("Valid").getString("mainActivity");
		String strWDid = nopcommerce.getJSONObject("Valid").getString("developmentTime");
		String strCsizeId = nopcommerce.getJSONObject("Valid").getString("workingYears");
		String url = nopcommerce.getJSONObject("DoubleSpace").getString("yourUrl");
		
		PO_NopCommerce obj = PageFactory.initElements(driver, PO_NopCommerce.class);
		obj.Invalid_DoubleSpace(fname, lname, Email, strCEmail, user, cName, time, pass, cpass, StrComId, strRId, strWDid, strCsizeId, url);
	}
	
	/*
	@Test(description="Testing nopcommerce for Number special symbols")
	public void test_NumberSpecialSymbol() {
		String fname = nopcommerce.getJSONObject("NameNumberSpecialSymbol").getString("Firstname");
		String lname = nopcommerce.getJSONObject("NameNumberSpecialSymbol").getString("Lastname");
		
		String Email = nopcommerce.getJSONObject("NameNumberSpecialSymbol").getString("email");
		String strCEmail = nopcommerce.getJSONObject("NameNumberSpecialSymbol").getString("ConfirmEmail");
		String user = nopcommerce.getJSONObject("NameNumberSpecialSymbol").getString("UserName");
		String cName = nopcommerce.getJSONObject("NameNumberSpecialSymbol").getString("CountryName");
		String time = nopcommerce.getJSONObject("NameNumberSpecialSymbol").getString("TimeZone");
		String pass = nopcommerce.getJSONObject("NameNumberSpecialSymbol").getString("password");
		String cpass = nopcommerce.getJSONObject("NameNumberSpecialSymbol").getString("confirmPassword");
		String StrComId = nopcommerce.getJSONObject("NameNumberSpecialSymbol").getString("companyPrimarily");
		String strRId = nopcommerce.getJSONObject("NameNumberSpecialSymbol").getString("mainActivity");
		String strWDid = nopcommerce.getJSONObject("NameNumberSpecialSymbol").getString("developmentTime");
		String strCsizeId = nopcommerce.getJSONObject("NameNumberSpecialSymbol").getString("workingYears");
		String url = nopcommerce.getJSONObject("NameNumberSpecialSymbol").getString("yourUrl");
		
		PO_NopCommerce obj = PageFactory.initElements(driver, PO_NopCommerce.class);
		obj.Invalid_NumberSpecialSymbol(fname, lname, Email, strCEmail, user, cName, time, pass, cpass, StrComId, strRId, strWDid, strCsizeId, url);
	}
	*/
	
	
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}
// 
	@AfterMethod
	public void tearDown() {
		driver.close();
		ExtentReportManager.extentReport.endTest(ExtentReportManager.extentTest);
	}
	
	@AfterClass
	public void stopReport() {
		ExtentReportManager.extentReport.flush(); // this important 
		// if we dont flush we wont generate html report
	}
}
