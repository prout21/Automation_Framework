package Mccm.PegaTest;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Mccm.PegaMain.HomePage;
import Mccm.PegaMain.LoginPage;
import Mccm.PegaMain.PegaMarketPage;
import Mccm.PegaMain.PageMrktEtoEFlow;
import Mccm.PegaSubClass.HomePageDetails;
import Mccm.PegaTestBase.TestBase;
import Mccm.QAUtil.TestUtil;

public class PegamarktingTest extends TestBase {
	private static final String priorty = null;
	LoginPage loginpage;
	HomePage  homepage;
	PegaMarketPage pegamarketpage;
	TestUtil testutil;
	

	public PegamarktingTest()
	{
		super();
	}
 @BeforeMethod
 
    public void setup() throws InterruptedException {
	    initialization();
	    loginpage = new LoginPage();
	     homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password")); 
	     testutil=new TestUtil();
	     pegamarketpage =new PegaMarketPage();
	     pegamarketpage=homepage.Pegamrklunch();
	    }
 
 @Test (priority=1)
 public void VerifyNBACampaignRunSuccessfully() throws InterruptedException, AWTException { 
	 homepage.Pegamrklunch();
	 pegamarketpage.pegamarkting();
	 testutil.WindowHandling();
	 pegamarketpage.ExpandPegMrkPage();
	 pegamarketpage.Campaigns();
	 testutil.SwitcToFrame(1);
	 testutil.RobertAction();
	 pegamarketpage.Create();
	 pegamarketpage.MultiChannelCampaign(); 
	 testutil.SwitcTodefaultContent();
	 testutil.SwitcToFrame(2);
	 pegamarketpage.Campaigncode();
	 pegamarketpage.Build();
	 pegamarketpage.MrktStrtgyConfig();
	 pegamarketpage.javaexictor();
	 pegamarketpage.Add();
	 pegamarketpage.Applay();
	 pegamarketpage.AudianceConfig();
	 pegamarketpage.javaexictor1();
	 pegamarketpage.Addadinceconfig();
	 pegamarketpage.ApplayAdience(); 
	 pegamarketpage.javaexictor2();
	 pegamarketpage.Engagementconfig();
	 pegamarketpage.Campaignschdul();
	 pegamarketpage.Recurring();
	 pegamarketpage.databasetemplate();
	 pegamarketpage.configtemplate();
	 pegamarketpage.javaexictor3();
	 pegamarketpage.MCCMLCOutbound();
	 pegamarketpage.Addmcclbound();
	 pegamarketpage.Javascriptserch();
	 pegamarketpage.ApplayEngagement();
	 pegamarketpage.SaveCampgn();
	 pegamarketpage.RunCampgn();
	 pegamarketpage.ConfirmCampgn();
	 pegamarketpage.RefreshCampgn();
	 pegamarketpage.Runstatus();
	 
	 
	 
 }
 

}
