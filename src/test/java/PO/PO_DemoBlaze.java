package PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PO_DemoBlaze {
	WebDriver driver;
	
	public PO_DemoBlaze(WebDriver driver){
		this.driver = driver;
		
	}
	
	
	@FindBy(how = How.XPATH,using ="//div[@class='navbar-collapse']/ul/li[8]/a")
	WebElement signUpLink;
	
	@FindBy(how = How.XPATH,using ="//input[@id='sign-username']")
	WebElement userName;
	
	@FindBy(how = How.XPATH,using = "//input[@id='sign-password']")
	WebElement password;
	
	@FindBy(how = How.XPATH, using = "(//div[@class='modal-footer']/button)[2]")
	WebElement signUpButtong;
	
	@FindBy(how = How.XPATH, using = "(//div[@class='modal-footer']/button)[1]")
	WebElement closeButton;
	
	@FindBy(how = How.XPATH, using = "(//ul[@class = 'navbar-nav ml-auto']/li)[5]/a")
	WebElement loginLink;
	
	// Sign up functionality
	
	public void pressSignUpLink() {
		signUpLink.click();
	}
	
	public void sendUserName(String uName) {
		userName.sendKeys(uName);
	}
	
	public void sendPassword(String pass) {
		password.sendKeys(pass);
	}
	
	
	public void pressSignUpButton() {
		signUpButtong.click();
		driver.switchTo().alert().accept(); // for default pop up
		
	}
	
	public void pressCloseButton() {
		closeButton.click();
	}
	
	// Login functionality
	
	public void pressLoginLink() {
		loginLink.click();
	}
	
	public void pressCloseButtonOflogin() {
		closeButton.click();
	}
	
	
	public void signUp(String uname, String pass) {
		sendUserName(uname);
		sendPassword(pass);
		pressSignUpButton();
		
	}
	

}
