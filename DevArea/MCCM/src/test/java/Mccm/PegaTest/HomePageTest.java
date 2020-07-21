package Mccm.PegaTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Mccm.PegaMain.HomePage;
import Mccm.PegaMain.LoginPage;
import Mccm.PegaSubClass.HomePageDetails;
import Mccm.PegaTestBase.TestBase;
import Mccm.QAUtil.TestUtil;

public class HomePageTest extends TestBase {

	private static final String priorty = null;
	LoginPage loginpage;
	HomePage  homepage;
	HomePageDetails HomePageDetails1;
	TestUtil testutil;
	
	public HomePageTest()
	{
		super();
	}
 @BeforeMethod
 
    public void setup() throws InterruptedException {
	    initialization();
	    loginpage = new LoginPage();
	    testutil = new TestUtil();
	    HomePageDetails1 =new HomePageDetails();
	    homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password")); 
	    HomePageDetails1=homepage.ClickHomepage();
 }
 @Test (priority=1)
 public void VerifyDynamicSystemSettingSuccessfully() throws InterruptedException { 
	 HomePageDetails1.Recordclk();
	 HomePageDetails1.SysAdmin();
	 HomePageDetails1.javaexictor4();
	 HomePageDetails1.DynamicSystemSettins();
	 testutil.SwitcToFrame(0);
	 HomePageDetails1.FilterNBAcamp();
	 HomePageDetails1.NBACampaignName();
	 HomePageDetails1.ApplayNBAfilter();
	 HomePageDetails1.ClikMCCM();
	 testutil.SwitcTodefaultContent();
	 testutil.SwitchToFrame("PegaGadget1Ifr");
	 HomePageDetails1.NBABatchCampaign();
	 HomePageDetails1.SaveNBABatchCamp();
	 HomePageDetails1.CloseNBABatchCamp();
	 testutil.SwitcTodefaultContent();
	 testutil.SwitchToFrame("PegaGadget0Ifr");
	 HomePageDetails1.FilterNotifyErrList();
	 HomePageDetails1.NotifyErrList();
	 HomePageDetails1.ApplayNotifyErr();
	 HomePageDetails1.ClikMCCMNotifyErr();
	 testutil.SwitcTodefaultContent();
	 testutil.SwitchToFrame("PegaGadget1Ifr");
	 HomePageDetails1.MailNotifyErr();
	 HomePageDetails1.SaveNotifyErrLst();
	 HomePageDetails1.CloseNotifyErrLst();
	 HomePageDetails1.D_mccmsettings();
	 HomePageDetails1.SerchClick();
	 HomePageDetails1.Clickdmccmsetting();
	 testutil.SwitcTodefaultContent();
	 testutil.SwitchToFrame("PegaGadget1Ifr");
	 HomePageDetails1.ActionClkDmccmsetting();
	 HomePageDetails1.RunActionClk();
	 HomePageDetails1.FulshRunClick();
	 HomePageDetails1.OverrideCampSrch();
	 HomePageDetails1.OverrideCampSrchClk();
	 HomePageDetails1.OverrideCampBlockrClk();
	 testutil.SwitcTodefaultContent();
	 testutil.SwitchToFrame("PegaGadget2Ifr");
	 HomePageDetails1.OverrideCampActClk();
	 HomePageDetails1.RunOverideBlkClk();
	 HomePageDetails1.OverridCampBlkRun();
	 
	
 }
 
 
 @AfterMethod
 
      public void teardown() {
	
      driver.quit();
	 
      
 	 System.out.println("Pega Markting Started");  
 }
    
}
