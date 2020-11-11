package Mccm.PegaMain;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Mccm.PegaTestBase.TestBase;

public class LoginPage extends TestBase {
	//page factory - OR:
	
	@FindBy(xpath="//input[@id='txtUserID']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='txtPassword']")
	WebElement password;
	
	@FindBy(xpath="//span[@class='loginButtonText']")
	WebElement loginbtm;
	
	@FindBy(xpath="//img[@class='logo']")
	WebElement pegalogo;
	 
    public LoginPage()
    {
    	PageFactory.initElements(driver, this);
    }
    public String PageTitle()
    {
    	return driver.getTitle();
    }
    public boolean veryfyLogo()
    {
    	return pegalogo.isDisplayed();
    	
    			
    }
    public HomePage login(String uid,String pwd)
    {
    	username.sendKeys(uid);
    	password.sendKeys(pwd);
    	loginbtm.click();
    	return new HomePage();
    }
    
}
