package PO;


import javax.swing.tree.ExpandVetoException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentReportManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class PO_NopCommerce {
	WebDriver driver;
	

	public PO_NopCommerce(WebDriver driver){
		this.driver = driver;
		
	}
	
	public String VerifyTitle()
	{ // outside main function
		
		String Mtitle= driver.getTitle();
		System.out.println("The Title is ="+Mtitle);
		return Mtitle;
		
	}

	@FindBy(how = How.XPATH, using = "(//ul[@class='navigation-top-menu navigation-top-menu-user-actions'])/li[3]")
	WebElement userIcon;
	
	@FindBy(how=How.XPATH,using = "((//ul[@class='navigation-top-menu-sublist'])[6]/li)[2]/a")
	WebElement registerLink;
	
	@FindBy(how=How.XPATH,using ="//input[@id='FirstName']")
	WebElement first_name;
	
	@FindBy(how=How.XPATH,using ="//input[@id='LastName']")
	WebElement last_name;
	
	@FindBy(how=How.XPATH,using ="//input[@id='Email']")
	WebElement Uemail;
	
	
	@FindBy(how=How.XPATH,using ="//input[@Id='ConfirmEmail']")
	WebElement confirmEmail;
	
	@FindBy(how=How.XPATH,using ="//select[@id='TimeZoneId']")
	WebElement TimeZoneId;
	
	@FindBy(how=How.XPATH,using ="//input[@id='Username']")
	WebElement userName;
	
	@FindBy(how=How.XPATH,using ="(//select[@name='CountryId'])[1]")
	WebElement countryId;
	
	
	@FindBy(how=How.XPATH,using ="//input[@id='Password']")
	WebElement password;
	
	@FindBy(how=How.XPATH,using ="//input[@id='ConfirmPassword']")
	WebElement confrimPassword;
	
	@FindBy(how=How.XPATH,using ="//select[@id='Details_CompanyIndustryId']")
	WebElement companyIndustryId;
	
	
	@FindBy(how=How.XPATH,using ="//select[@id='Details_CompanyRoleId']")
	WebElement companyRoleId;
	
	@FindBy(how=How.XPATH,using ="//select[@id='Details_ExtensionsDevelopmentPeriodId']")
	WebElement WebsitesDevelopmentPeriodId;
	
	
	@FindBy(how=How.XPATH,using ="//select[@id='Details_CompanySizeId']")
	WebElement CompanySizeId;
	
	
	
	@FindBy(how=How.XPATH,using ="(//div[@class='gender has-nopCommerce-extension'])/div[2]/label")
	WebElement radioNoButton;
	
	
	@FindBy(how=How.XPATH,using ="(//div[@class='gender has-nopCommerce-extension'])/div[1]/input")
	WebElement radioYesButton;
	
	
	@FindBy(how=How.XPATH,using ="//input[@id='Details_CompanyWebsiteUrl']")
	WebElement companyUrl;
	
	@FindBy(how=How.XPATH,using ="//input[@id='register-button']")
	WebElement registerButton;
	
	
	@FindBy(how=How.XPATH,using ="//div[@class='sub-title']/h2")
	WebElement successMessage;
	
	
	@FindBy(how=How.XPATH,using ="//span[@id='Email-error']")
	WebElement emailError;
	
	
//	@FindBy(how=How.XPATH,using ="")
//	WebElement 
	
	//
	public void HoverAction() throws InterruptedException {
		Actions action = new Actions(driver);
		
		action.moveToElement(userIcon); // this is hovering operation
		Thread.sleep(3000);
		action.click(registerLink).build().perform(); // checking everything and performing action
		Thread.sleep(3000);
	}
	
	public void firstName(String fname) {
		first_name.sendKeys(fname);
		ExtentReportManager.extentTest.log(LogStatus.INFO, "Entering first name", "first name used:"+fname);

	}
	
	public void lastName(String lname) {
		last_name.sendKeys(lname);
		ExtentReportManager.extentTest.log(LogStatus.INFO, "Entering last name", "last name used:"+lname);

	}
	
	public void email(String email) {
		Uemail.sendKeys(email);
		Uemail.sendKeys(Keys.TAB); // keys has built in keys of keyboard
		ExtentReportManager.extentTest.log(LogStatus.INFO, "Entering email", " Email used:"+email);
		
	}
	
	
	
	public void cEmail(String strCEmail) {
		confirmEmail.sendKeys(strCEmail);
		ExtentReportManager.extentTest.log(LogStatus.INFO, "Entering email", "Email used:"+strCEmail);

	}
	
	public void selectTimeZone(String time) {
		Select select = new Select(TimeZoneId);
		select.selectByVisibleText(time);
		ExtentReportManager.extentTest.log(LogStatus.INFO, "Selecting Time zone", " Time zone used:"+time);

	}
	
	public void sendUserName(String user){
		userName.sendKeys(user);
		ExtentReportManager.extentTest.log(LogStatus.INFO, "Entering user name", " user name used:"+user);

	}
	
	public void selectCountryId(String strCid) {
		Select select = new Select(countryId);
		select.selectByVisibleText(strCid);
		ExtentReportManager.extentTest.log(LogStatus.INFO, "Selecting country name", " Country name used:"+strCid);

	}
	
	public void sendPassword(String pass) {
		password.sendKeys(pass);
		ExtentReportManager.extentTest.log(LogStatus.INFO, "Entering password", " Password used:"+pass);

	}
	
	public void sendCPassword(String cpass) {
		confrimPassword.sendKeys(cpass);
		ExtentReportManager.extentTest.log(LogStatus.INFO, "Entering password", " Password used:"+cpass);

	}
	
	
	public void selectCompanyIndustryId(String cName) throws InterruptedException {
		Select select = new Select(companyIndustryId);
		select.selectByVisibleText(cName);
		Thread.sleep(2000);
		ExtentReportManager.extentTest.log(LogStatus.INFO, "Selecting company id", "Id used:"+cName);

	}
	
	public void selectCompanyRoleId(String strRId) throws InterruptedException {
		Select select = new Select(companyRoleId);
		select.selectByVisibleText(strRId);
		Thread.sleep(2000);
		ExtentReportManager.extentTest.log(LogStatus.INFO, "Selecting role", "role used:"+strRId);

	}
	
	public void selectWebsitesDevelopmentPeriodId(String strWDid) throws InterruptedException {
		Select select = new Select(WebsitesDevelopmentPeriodId);
		select.selectByVisibleText(strWDid);
		System.out.println("Development:"+strWDid);
		Thread.sleep(2000);
		ExtentReportManager.extentTest.log(LogStatus.INFO, "Selecting Development Time period", "Time used:"+strWDid);

	}
	
	public void selectCompanySizeId(String strCsizeId) throws InterruptedException {
		Select select = new Select(CompanySizeId);
		select.selectByVisibleText(strCsizeId);
		System.out.println("Company size:"+strCsizeId);
	
		Thread.sleep(2000);
		ExtentReportManager.extentTest.log(LogStatus.INFO, "Selecting company size", "Size used:"+strCsizeId);

	}
	
	public void pressNRadioNoButton() {
		radioNoButton.click();
		ExtentReportManager.extentTest.log(LogStatus.INFO, "Selecting no button", "Chosing No radio button");

	}
	
	public void pressYRadioNoButton() {
		radioYesButton.click();
	}
	
	public void sendCompanyUrl(String url) {
		companyUrl.sendKeys(url);
		ExtentReportManager.extentTest.log(LogStatus.INFO, "Entering company URL", "URL used:"+url);

	}
	
	public void preassRegisterButton() {
		registerButton.click();
		ExtentReportManager.extentTest.log(LogStatus.INFO, "Pressed register button", "Pressed register button");

	}
	
	public void scrolling() {
		try {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("javascript:window.scrollBy(0,300)");
		Thread.sleep(2000);
		ExtentReportManager.extentTest.log(LogStatus.INFO, "Scrolling down", "By 300");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	 // 1: Valid Data
	public void valid_Data(String fname,String lname,String Email,String strCEmail,String user,String cName ,String time,String pass, String cpass, String StrComId,String strRId, String strWDid,String strCsizeId,String url,String expectedResult) throws InterruptedException
	{
		try {
		//HoverAction();
		firstName(fname);
		lastName(lname);

		email(Email);

		cEmail(strCEmail);
		

		sendUserName(user);

		selectCountryId(cName);
		

		//(UTC-10:00) Hawaii
		selectTimeZone(time);

		
		

		sendPassword(pass);
		

		sendCPassword(cpass);

		
		selectCompanyIndustryId(StrComId);
		

		scrolling();
		

		
		selectCompanyRoleId(strRId);
		

		
		selectWebsitesDevelopmentPeriodId(strWDid);
		

		
		scrolling();
		
		pressNRadioNoButton();
		

		
		selectCompanySizeId(strCsizeId);
		

		sendCompanyUrl(url);
		

		
		preassRegisterButton();

		ExtentReportManager.extentTest.log(LogStatus.INFO,"Expected Result:"+expectedResult,"Actual Result:"+successMessage.getText());
		//Assert.assertEquals(expectedResult,successMessage.getText());
		if(expectedResult.equals(successMessage.getText().toString().trim())) {
		ExtentReportManager.extentTest.log(LogStatus.PASS, "Test Status:","Test Passed");

		}else {
			ExtentReportManager.extentTest.log(LogStatus.FAIL, "Test Status:","Test Failed");

		}
		
		
		}catch(Exception e) {
			e.printStackTrace();
			ExtentReportManager.extentTest.log(LogStatus.FAIL, "Expection: ",e.getMessage());

		}
	
	}
	 // 2: InValid Data
	
	
	public void Invalid_email(String fname,String lname,String Email,String strCEmail,String expectedResult)
	{
		try {
			//HoverAction();
			firstName(fname);
			lastName(lname);

			email(Email);
			
			
			ExtentReportManager.extentTest.log(LogStatus.INFO,"Expected Result:"+expectedResult,"Actual Result:"+emailError.getText().toString().trim());

			//Assert.assertEquals(expectedResult,emailError.getText().toString().trim());
			// always use trim method
			if(expectedResult.equals(emailError.getText().toString().trim())) {
				ExtentReportManager.extentTest.log(LogStatus.PASS, "Test Status:","Test Passed");

				}else {
					ExtentReportManager.extentTest.log(LogStatus.FAIL, "Test Status:","Test Failed");

				}
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ExtentReportManager.extentTest.log(LogStatus.FAIL, "Expection: ",e.getMessage());
		}
		
		
		
	}
	
	// Blank data
		public void Invalid_BlankData(String fname,String lname,String Email,String strCEmail,String user,String cName ,String time,String pass, String cpass, String StrComId,String strRId, String strWDid,String strCsizeId,String url)
		{
			try {
				//HoverAction();
				firstName(fname);
				lastName(lname);
				email(Email);
				cEmail(strCEmail);
				sendUserName(user);
				selectCountryId(cName);
				//(UTC-10:00) Hawaii
				selectTimeZone(time);
				

				sendPassword(pass);
				sendCPassword(cpass);
				
				selectCompanyIndustryId(StrComId);
				
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("javascript:window.scrollBy(0,300)");
				Thread.sleep(2000);
				
				selectCompanyRoleId(strRId);
				
				selectWebsitesDevelopmentPeriodId(strWDid);
				
				js.executeScript("javascript:window.scrollBy(0,300)");
				
				Thread.sleep(2000);
				pressNRadioNoButton();
				
				selectCompanySizeId(strCsizeId);
				sendCompanyUrl(url);
				
				preassRegisterButton();
				Assert.assertEquals("Register - nopCommerce",VerifyTitle());
				
				} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		public void Invalid_DoubleSpace(String fname,String lname,String Email,String strCEmail,String user,String cName ,String time,String pass, String cpass, String StrComId,String strRId, String strWDid,String strCsizeId,String url)
		{
			try {
				//HoverAction();
				firstName(fname);
				lastName(lname);
				email(Email);
				cEmail(strCEmail);
				sendUserName(user);
				selectCountryId(cName);
				//(UTC-10:00) Hawaii
				selectTimeZone(time);
				

				sendPassword(pass);
				sendCPassword(cpass);
				
				selectCompanyIndustryId(StrComId);
				
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("javascript:window.scrollBy(0,300)");
				Thread.sleep(2000);
				
				selectCompanyRoleId(strRId);
				
				selectWebsitesDevelopmentPeriodId(strWDid);
				
				js.executeScript("javascript:window.scrollBy(0,300)");
				
				Thread.sleep(2000);
				pressNRadioNoButton();
				
				selectCompanySizeId(strCsizeId);
				sendCompanyUrl(url);
				
				preassRegisterButton();
				Assert.assertEquals("Register - nopCommerce",VerifyTitle());
				
				} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	

	
	//Invalid first name
	// below parameter are wrong
	public void AllValid_Invalid_fName(String fname,String lname,String Email,String strCEmail,String user,String cName ,String time,String pass, String cpass, String StrComId,String strRId, String strWDid,String strCsizeId,String url)
	{
		try {
			//HoverAction();
			firstName(fname);
			lastName(lname);
			email(Email);
			cEmail(strCEmail);
			sendUserName(user);
			selectCountryId(cName);
			//(UTC-10:00) Hawaii
			selectTimeZone(time);
			

			sendPassword(pass);
			sendCPassword(cpass);
			
			selectCompanyIndustryId(StrComId);
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("javascript:window.scrollBy(0,300)");
			Thread.sleep(2000);
			
			selectCompanyRoleId(strRId);
			
			selectWebsitesDevelopmentPeriodId(strWDid);
			
			js.executeScript("javascript:window.scrollBy(0,300)");
			
			Thread.sleep(2000);
			pressNRadioNoButton();
			
			selectCompanySizeId(strCsizeId);
			sendCompanyUrl(url);
			
			preassRegisterButton();
			Assert.assertEquals("Register - nopCommerce",VerifyTitle());
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//Invalid last name
	public void AllValid_Invalid_lName(String fname,String lname,String Email,String strCEmail,String user,String cName ,String time,String pass, String cpass, String StrComId,String strRId, String strWDid,String strCsizeId,String url)
	{
		try {
			//HoverAction();
			firstName(fname);
			lastName(lname);
			email(Email);
			cEmail(strCEmail);
			sendUserName(user);
			selectCountryId(cName);
			//(UTC-10:00) Hawaii
			selectTimeZone(time);
			

			sendPassword(pass);
			sendCPassword(cpass);
			
			selectCompanyIndustryId(StrComId);
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("javascript:window.scrollBy(0,300)");
			Thread.sleep(2000);
			
			selectCompanyRoleId(strRId);
			
			selectWebsitesDevelopmentPeriodId(strWDid);
			
			js.executeScript("javascript:window.scrollBy(0,300)");
			
			Thread.sleep(2000);
			pressNRadioNoButton();
			
			selectCompanySizeId(strCsizeId);
			sendCompanyUrl(url);
			
			preassRegisterButton();
			Assert.assertEquals("Register - nopCommerce",VerifyTitle());
			
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//Invalid email
	public void AllValid_Invalid_email(String fname,String lname,String Email,String strCEmail,String user,String cName ,String time,String pass, String cpass, String StrComId,String strRId, String strWDid,String strCsizeId,String url)
	{
		try {
			//HoverAction();
			firstName(fname);
			lastName(lname);
			email(Email);
			cEmail(strCEmail);
			sendUserName(user);
			selectCountryId(cName);
			//(UTC-10:00) Hawaii
			selectTimeZone(time);
			

			sendPassword(pass);
			sendCPassword(cpass);
			
			selectCompanyIndustryId(StrComId);
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("javascript:window.scrollBy(0,300)");
			Thread.sleep(2000);
			
			selectCompanyRoleId(strRId);
			
			selectWebsitesDevelopmentPeriodId(strWDid);
			
			js.executeScript("javascript:window.scrollBy(0,300)");
			
			Thread.sleep(2000);
			pressNRadioNoButton();
			
			selectCompanySizeId(strCsizeId);
			sendCompanyUrl(url);
			
			preassRegisterButton();
			Assert.assertEquals("Register - nopCommerce",VerifyTitle());
			
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//Invalid confirm email
	public void AllValid_Invalid_cEmail(String fname,String lname,String Email,String strCEmail,String user,String cName ,String time,String pass, String cpass, String StrComId,String strRId, String strWDid,String strCsizeId,String url)
	{
		try {
			//HoverAction();
			firstName(fname);
			lastName(lname);
			email(Email);
			cEmail(strCEmail);
			sendUserName(user);
			selectCountryId(cName);
			//(UTC-10:00) Hawaii
			selectTimeZone(time);
			

			sendPassword(pass);
			sendCPassword(cpass);
			
			selectCompanyIndustryId(StrComId);
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("javascript:window.scrollBy(0,300)");
			Thread.sleep(2000);
			
			selectCompanyRoleId(strRId);
			
			selectWebsitesDevelopmentPeriodId(strWDid);
			
			js.executeScript("javascript:window.scrollBy(0,300)");
			
			Thread.sleep(2000);
			pressNRadioNoButton();
			
			selectCompanySizeId(strCsizeId);
			sendCompanyUrl(url);
			
			preassRegisterButton();
			Assert.assertEquals("Register - nopCommerce",VerifyTitle());
			
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	//Invalid Password
	
	public void AllValid_Invalid_password(String fname,String lname,String Email,String strCEmail,String user,String cName ,String time,String pass, String cpass, String StrComId,String strRId, String strWDid,String strCsizeId,String url)
	{
		try {
			//HoverAction();
			firstName(fname);
			lastName(lname);
			email(Email);
			cEmail(strCEmail);
			sendUserName(user);
			selectCountryId(cName);
			//(UTC-10:00) Hawaii
			selectTimeZone(time);
			

			sendPassword(pass);
			sendCPassword(cpass);
			
			selectCompanyIndustryId(StrComId);
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("javascript:window.scrollBy(0,300)");
			Thread.sleep(2000);
			
			selectCompanyRoleId(strRId);
			
			selectWebsitesDevelopmentPeriodId(strWDid);
			
			js.executeScript("javascript:window.scrollBy(0,300)");
			
			Thread.sleep(2000);
			pressNRadioNoButton();
			
			selectCompanySizeId(strCsizeId);
			sendCompanyUrl(url);
			
			preassRegisterButton();
			Assert.assertEquals("Register - nopCommerce",VerifyTitle());
			
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//Invalid Cpassword
	public void AllValid_Invalid_cPassword(String fname,String lname,String Email,String strCEmail,String user,String cName ,String time,String pass, String cpass, String StrComId,String strRId, String strWDid,String strCsizeId,String url)
	{
		try {
			//HoverAction();
			firstName(fname);
			lastName(lname);
			email(Email);
			cEmail(strCEmail);
			sendUserName(user);
			selectCountryId(cName);
			//(UTC-10:00) Hawaii
			selectTimeZone(time);
			

			sendPassword(pass);
			sendCPassword(cpass);
			
			selectCompanyIndustryId(StrComId);
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("javascript:window.scrollBy(0,300)");
			Thread.sleep(2000);
			
			selectCompanyRoleId(strRId);
			
			selectWebsitesDevelopmentPeriodId(strWDid);
			
			js.executeScript("javascript:window.scrollBy(0,300)");
			
			Thread.sleep(2000);
			pressNRadioNoButton();
			
			selectCompanySizeId(strCsizeId);
			sendCompanyUrl(url);
			
			preassRegisterButton();
			Assert.assertEquals("Register - nopCommerce",VerifyTitle());
			
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//Invalid url
	public void AllValid_Invalid_URL(String fname,String lname,String Email,String strCEmail,String user,String cName ,String time,String pass, String cpass, String StrComId,String strRId, String strWDid,String strCsizeId,String url)
	{
		try {
			//HoverAction();
			firstName(fname);
			lastName(lname);
			email(Email);
			cEmail(strCEmail);
			sendUserName(user);
			selectCountryId(cName);
			//(UTC-10:00) Hawaii
			selectTimeZone(time);
			

			sendPassword(pass);
			sendCPassword(cpass);
			
			selectCompanyIndustryId(StrComId);
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("javascript:window.scrollBy(0,300)");
			Thread.sleep(2000);
			
			selectCompanyRoleId(strRId);
			
			selectWebsitesDevelopmentPeriodId(strWDid);
			
			js.executeScript("javascript:window.scrollBy(0,300)");
			
			Thread.sleep(2000);
			pressNRadioNoButton();
			
			selectCompanySizeId(strCsizeId);
			sendCompanyUrl(url);
			
			preassRegisterButton();
			Assert.assertEquals("Register - nopCommerce",VerifyTitle());
			
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	//Invalid user name
	
	public void AllValid_Invalid_userName(String fname,String lname,String Email,String strCEmail,String user,String cName ,String time,String pass, String cpass, String StrComId,String strRId, String strWDid,String strCsizeId,String url)
	{
		try {
			HoverAction();
			firstName(fname);
			lastName(lname);
		
			cEmail(strCEmail);
			sendUserName(user);
			selectCountryId(cName);
			//(UTC-10:00) Hawaii
			selectTimeZone(time);
			
		
			sendPassword(pass);
			sendCPassword(cpass);
			
			selectCompanyIndustryId(StrComId);
			selectCompanyRoleId(strRId);
			selectWebsitesDevelopmentPeriodId(strWDid);
			
			selectCompanySizeId(strCsizeId);
			sendCompanyUrl(url);
			
			preassRegisterButton();
			 Assert.assertEquals("True",successMessage.isDisplayed());
			
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	// Blank firstName
	
	public void Invalid_BlankfName(String fname,String lname,String Email,String strCEmail,String user,String cName ,String time,String pass, String cpass, String StrComId,String strRId, String strWDid,String strCsizeId,String url)
	{
		try {
			HoverAction();
			firstName(fname);
			lastName(lname);
		
			cEmail(strCEmail);
			sendUserName(user);
			selectCountryId(cName);
			//(UTC-10:00) Hawaii
			selectTimeZone(time);
			
		
			sendPassword(pass);
			sendCPassword(cpass);
			
			selectCompanyIndustryId(StrComId);
			selectCompanyRoleId(strRId);
			selectWebsitesDevelopmentPeriodId(strWDid);
			
			selectCompanySizeId(strCsizeId);
			sendCompanyUrl(url);
			
			preassRegisterButton();
			 Assert.assertEquals("True",successMessage.isDisplayed());
			
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// Blank lname
	
	public void Invalid_BlanklName(String fname,String lname,String Email,String strCEmail,String user,String cName ,String time,String pass, String cpass, String StrComId,String strRId, String strWDid,String strCsizeId,String url)
	{
		try {
			HoverAction();
			firstName(fname);
			lastName(lname);
		
			cEmail(strCEmail);
			sendUserName(user);
			selectCountryId(cName);
			//(UTC-10:00) Hawaii
			selectTimeZone(time);
			
		
			sendPassword(pass);
			sendCPassword(cpass);
			
			selectCompanyIndustryId(StrComId);
			selectCompanyRoleId(strRId);
			selectWebsitesDevelopmentPeriodId(strWDid);
			
			selectCompanySizeId(strCsizeId);
			sendCompanyUrl(url);
			
			preassRegisterButton();
			 Assert.assertEquals("True",successMessage.isDisplayed());
			
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	public void Invalid_NumberSpecialSymbol(String fname,String lname,String Email,String strCEmail,String user,String cName ,String time,String pass, String cpass, String StrComId,String strRId, String strWDid,String strCsizeId,String url)
	{
		try {
			HoverAction();
			firstName(fname);
			lastName(lname);
		
			cEmail(strCEmail);
			sendUserName(user);
			selectCountryId(cName);
			//(UTC-10:00) Hawaii
			selectTimeZone(time);
			
		
			sendPassword(pass);
			sendCPassword(cpass);
			
			selectCompanyIndustryId(StrComId);
			selectCompanyRoleId(strRId);
			selectWebsitesDevelopmentPeriodId(strWDid);
			
			selectCompanySizeId(strCsizeId);
			sendCompanyUrl(url);
			
			preassRegisterButton();
			 Assert.assertEquals("True",successMessage.isDisplayed());
			
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
