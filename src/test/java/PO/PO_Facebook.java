package PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PO_Facebook {
	WebDriver driver;
	
	PO_Facebook(){
		driver = new ChromeDriver();
	} 
	
	public String verifyTitle() {
		String Title = driver.getTitle();
		
		
		return Title;
		
	}
	
	 @FindBy(how=How.XPATH,using="//input[@name='email']")
     WebElement username;
    
    @FindBy(how=How.XPATH,using="//input[@name='pass']")
     WebElement password;
    @FindBy(how=How.XPATH,using="//button[@name='login']")
    WebElement login;
    
    public void action()
    {
        Actions action=new Actions(driver);
        action.moveToElement(username);
        action.click(username).build().perform();
        
    }    
    
    public void EnterUsername(String uname)
    {
        username.sendKeys(uname);
    }
    public void EnterPassword(String Pass)
    {
        password.sendKeys(Pass);
    }
    public void Login()
    {
        login.click();
    }
    
    public void valid(String uname,String pass)
    {
        
        EnterUsername(uname);
        EnterPassword(pass);
        Login();
    }
        
        public void Blank(String uname,String pass) {
            
            EnterUsername(uname);
            EnterPassword(pass);
            Login();
    }

}
