package PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import junit.framework.Assert;

public class PO_ZenLogin {
	WebDriver driver;

	public PO_ZenLogin(WebDriver driver){
		this.driver = driver;
		
	}
	
	public String VerifyTitle()
	{ // outside main function
		
		String Mtitle= driver.getTitle();
		System.out.println("The Title is ="+Mtitle);
		return Mtitle;
		
	}
	
	
	@FindBy(how=How.XPATH,using ="//input[@id='username']")
	WebElement userName;
	
	@FindBy(how=How.XPATH,using ="//input[@id='password']")
	WebElement password;
	
	@FindBy(how=How.XPATH,using ="//div[@class='button-wrapper']/input")
	WebElement loginButton;
	
	
	
	@FindBy(how=How.XPATH,using ="//form[@id='fm1']/div")
	WebElement InvalidMessage;
	
	public void sendUserName(String user) {
		userName.sendKeys(user);
	}
	
	public void sendPassword(String pass) {
		password.sendKeys(pass);
	}
	
	
	public void pressdLoginButton() {
		loginButton.click();
	}
	
	
	public void valid_data(String user, String pass) {
		sendUserName(user);
		sendPassword(pass);
		Assert.assertEquals("Home - Zenlounge",VerifyTitle());
	}
	
	
	//invalid_data
	public void Invalid_data(String user, String pass) {
		sendUserName(user);
		sendPassword(pass);
		pressdLoginButton();
		Assert.assertEquals("The credentials you provided cannot be determined to be authentic.",InvalidMessage.getText());
		
	}
	//invalid user
	public void Invalid_user(String user, String pass) {
		sendUserName(user);
		sendPassword(pass);
		pressdLoginButton();
		Assert.assertEquals("The credentials you provided cannot be determined to be authentic.",InvalidMessage.getText());

	}
	//invalid password
	public void Invalid_password(String user, String pass) {
		sendUserName(user);
		sendPassword(pass);
		pressdLoginButton();
		Assert.assertEquals("The credentials you provided cannot be determined to be authentic.",InvalidMessage.getText());

	}
	
	//Blank
	public void Invalid_Blank(String user, String pass) {
		sendUserName(user);
		sendPassword(pass);
		pressdLoginButton();
		Assert.assertEquals("The credentials you provided cannot be determined to be authentic.",InvalidMessage.getText());

	}
	
	// user blank
	public void Invalid_BlankUser(String user, String pass) {
		sendUserName(user);
		sendPassword(pass);
		pressdLoginButton();
		Assert.assertEquals("The credentials you provided cannot be determined to be authentic.",InvalidMessage.getText());

	}
	
	//password blank
	public void Invalid_BlankPassword(String user, String pass) {
		sendUserName(user);
		sendPassword(pass);
		pressdLoginButton();
		Assert.assertEquals("The credentials you provided cannot be determined to be authentic.",InvalidMessage.getText());

	}
	
	// valid user blank password
	public void validUser_BlankPassword(String user, String pass) {
		sendUserName(user);
		sendPassword(pass);
		pressdLoginButton();
		Assert.assertEquals("The credentials you provided cannot be determined to be authentic.",InvalidMessage.getText());

	}
	
	// valid password blank user
		public void validPassword_BlankUser(String user, String pass) {
			sendUserName(user);
			sendPassword(pass);
			pressdLoginButton();
			Assert.assertEquals("The credentials you provided cannot be determined to be authentic.",InvalidMessage.getText());

		}
	
	
	
}
