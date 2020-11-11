package Mccm.PegaTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Mccm.PegaMain.HomePage;
import Mccm.PegaMain.LoginPage;
import Mccm.PegaTestBase.TestBase;

public class LoginPageTest extends TestBase{
	
	private static final String priorty = null;
	LoginPage loginpage;
	HomePage  Homepage;
	public LoginPageTest()
	{
		super();
	}
 @BeforeMethod
 
    public void setup() {
	    initialization();
	    loginpage = new LoginPage();
	    
 }
 
 
 @Test (priority=1)
 public void VerifyLoginPageTitleTest() { 
	 String title = loginpage.PageTitle();
	 Assert.assertEquals(title, "Pega Platform");
	
	 
 }

 @Test (priority=2)
 public void VerifyPegaLogoTest() { 
	 boolean flag = loginpage.veryfyLogo();
	 Assert.assertTrue(flag);
	 
 }
 @Test (priority=3)
 public void VerifyLoginSuccessfulTest() { 
	 loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	 	 
 }
 
 @AfterMethod
 
    public void teardown() {
	 driver.quit();
	    
 }
    
}
