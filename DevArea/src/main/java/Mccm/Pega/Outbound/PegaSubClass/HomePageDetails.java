package Mccm.Pega.Outbound.PegaSubClass;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import Mccm.Pega.QAUtil.TestUtil;
import Mccm.Pega.excel.utility.Excel_Reader;

public class HomePageDetails extends TestBase {
	
	public static String ExcelFilePath;
	
	@FindBy(xpath="(//h3[@class='layout-group-item-title'])[5]")
	WebElement Recordclk;
	
	@FindBy(xpath="(//div[@id='iconExpandCollapse'])[15]")
	WebElement SysAdmin;
	
	@FindBy(xpath="//a[text()='Dynamic System Settings']")
	WebElement webelement4;
	
	@FindBy(xpath="(/html[1]/body[1]/div[2]/form[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[1]/th[2]/div[1]/span[1]/a[1])")
	WebElement FilterNBAcamp;
	
	@FindBy(xpath="//input[@type='text'][@name='$PpyFilterCriteria_pgRepPgSubSectionpzViewInstancesB_pxResults_pzViewInstances_1$ppyColumnFilterCriteria$gpyPurpose2$ppySearchText']")
	WebElement NBACampaignName;
	
	@FindBy(xpath="//text()[.='Apply']/ancestor::button[1]")
	WebElement ApplayNBAfilter;
	
	@FindBy(xpath="//div[contains(text(),'MCCM')]")
	WebElement ClikMCCM;
	
	@FindBy(xpath="//input[@type='text'][@name='$PRH_1$ppySetting']")
	WebElement NBABatchCampaign;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement Save;
	
	@FindBy(xpath="//*[@class='pi pi-close-circle']")
	WebElement Close;
	
	@FindBy(xpath="/html[1]/body[1]/div[3]/form[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[1]/th[2]/div[1]/span[1]/a[1]")
	WebElement FilterNotifyErrList;
	
	@FindBy(xpath="//input[@type='text'][@name='$PpyFilterCriteria_pgRepPgSubSectionpzViewInstancesB_pxResults_pzViewInstances_1$ppyColumnFilterCriteria$gpyPurpose2$ppySearchText']")
	WebElement NotifyErrList;
	
	@FindBy(xpath="//text()[.='Apply']/ancestor::button[1]")
	WebElement ApplayNotifyErr;
	
	@FindBy(xpath="//input[@type='text'][@name='$PRH_1$ppySetting']")
	WebElement MailNotifyErr;
	
	@FindBy(xpath="//input[@type='text'][@name='$PpyDisplayHarness$ppySearchText']")
	WebElement D_mccmsettings;
	
	@FindBy(xpath="//*[@class='pi pi-search-2']")
	WebElement SerchClick;
	
	@FindBy(xpath="//a[text()='D_MCCMSettings']")
	WebElement Clickdmccmsetting;


	@FindBy(xpath="//*[@class='pi pi-caret-down margin-l-1x']")
	WebElement ActionClkDmccmsetting;
	 
	@FindBy(xpath="(//text()[.='Run']/ancestor::a[1])[2]")
	WebElement RunActionClk;
	 
	@FindBy(xpath="//input[@type='checkbox'][@name='$PD_pzRunRecord$ppxRunWindow$gTABTHREAD1$ppxRunParameters$ppyFlushAll']")
	WebElement FlushClk;
	
	@FindBy(xpath="(//div[@class='pzbtn-mid'])[3]")
	WebElement RunFlushClk;
	
	@FindBy(xpath="//input[@type='text'][@name='$PpyDisplayHarness$ppySearchText']")
	WebElement OverrideCampSrch;
	
	@FindBy(xpath="//*[@class='pi pi-search-2']")
	WebElement OverrideCampSrchClk;

	@FindBy(xpath="//a[text()='OverrideCampaignBlockers']")
	WebElement OverrideCampBlockrClk;
	 
	@FindBy(xpath="//*[@class='pi pi-caret-down margin-l-1x']")
	WebElement OverrideCampActClk;
	
	 
	@FindBy(xpath="(//text()[.='Run']/ancestor::a[1])[2]")
	WebElement RunOverideBlkClk;
	
	@FindBy(xpath="//input[@type='text'][@name='$PD_pzRunRecord$ppxRunWindow$gTABTHREAD2$ppxRunParameters$ppxResults$l1$ppyValue']")
	WebElement OverridCampBlk;
	
	@FindBy(xpath="(//div[@class='pzbtn-mid'])[3]")
	WebElement RunOverideBlk;
	
	
   
	
	
	Excel_Reader obj= new Excel_Reader(ExcelFilePath+"/src/main/java/Mccm/Pega/TestData/PegaTestData.xlsx");
			
	String NBACampaignNmValue = obj.getCellValue("PegaTestData", 1, 1);
	
	String NBABthCmpignValue = obj.getCellValue("PegaTestData", 1, 2);
	
	String NotifyErrListValue = obj.getCellValue("PegaTestData", 1, 3);
	
	String MailNotifyErrValue = obj.getCellValue("PegaTestData", 1, 4);
	
	String D_mccmsettingsValue = obj.getCellValue("PegaTestData", 1, 5);
	
	String OverrideCampSrchValue = obj.getCellValue("PegaTestData", 1, 6);
	
	String OverridCampBlkvalue = obj.getCellValue("PegaTestData", 1, 7);
	
	
	
	
	public HomePageDetails( ) {
    	PageFactory.initElements(driver, this);
    }
	
	public void Recordclk() throws InterruptedException
	{
		Thread.sleep(6000);
		Recordclk.click( );
        Thread.sleep(6000);
	}
	public void SysAdmin() throws InterruptedException
	{
		 Thread.sleep(6000);
		 SysAdmin.click( );
		 Thread.sleep(6000);
	}
	public void javaexictor4() throws InterruptedException
	{
		TestUtil obj=new TestUtil();
		obj.JavascriptExecutor(webelement4);
	}	
	public void DynamicSystemSettins() throws InterruptedException
	{
		Thread.sleep(6000);
		webelement4.click( );
		Thread.sleep(6000);
	}
	public void FilterNBAcamp() throws InterruptedException
	{
		Thread.sleep(6000);
		FilterNBAcamp.click( );
		Thread.sleep(6000);
	}
	public void NBACampaignName() throws InterruptedException
	{
		Thread.sleep(6000);
		NBACampaignName.sendKeys(NBACampaignNmValue);
        Thread.sleep(6000);
	}
	public void ApplayNBAfilter() throws InterruptedException
	{
		Thread.sleep(6000);
		ApplayNBAfilter.click( );
        Thread.sleep(6000);
	}
	public void ClikMCCM() throws InterruptedException
	{
		Thread.sleep(6000);
		ClikMCCM.click( );
        Thread.sleep(6000);
	}
	public void NBABatchCampaign() throws InterruptedException
	{
		Thread.sleep(6000);
		NBABatchCampaign.clear();
		Thread.sleep(6000);
		NBABatchCampaign.sendKeys(NBABthCmpignValue);
        Thread.sleep(6000);
	}
	
	public void SaveNBABatchCamp() throws InterruptedException
	{
		Thread.sleep(6000);
		Save.click( );
        Thread.sleep(6000);
	}
	public void CloseNBABatchCamp() throws InterruptedException
	{
		Thread.sleep(6000);
		Close.click( );
        Thread.sleep(6000);
	}
	
	public void FilterNotifyErrList() throws InterruptedException
	{
		Thread.sleep(6000);
		FilterNotifyErrList.click( );
		Thread.sleep(6000);
	}
	
	public void NotifyErrList() throws InterruptedException
	{
		Thread.sleep(6000);
		NotifyErrList.clear();
		Thread.sleep(6000);
		NotifyErrList.sendKeys(NotifyErrListValue);
        Thread.sleep(6000);
	}
	public void ApplayNotifyErr() throws InterruptedException
	{
		Thread.sleep(6000);
		ApplayNotifyErr.click( );
		Thread.sleep(6000);
	}
	
	public void ClikMCCMNotifyErr() throws InterruptedException
	{
		Thread.sleep(6000);
		ClikMCCM.click( );
        Thread.sleep(6000);
	}
	
	public void MailNotifyErr() throws InterruptedException
	{
		Thread.sleep(6000);
		MailNotifyErr.clear();
		Thread.sleep(6000);
		MailNotifyErr.sendKeys(MailNotifyErrValue);
        Thread.sleep(6000);
	}
	
	public void SaveNotifyErrLst() throws InterruptedException
	{
		Thread.sleep(6000);
		Save.click( );
        Thread.sleep(6000);
	}
	public void CloseNotifyErrLst() throws InterruptedException
	{
		Thread.sleep(6000);
		Close.click( );
        Thread.sleep(6000);
	}
	
	public void D_mccmsettings() throws InterruptedException
	{
		Thread.sleep(6000);
		D_mccmsettings.sendKeys(D_mccmsettingsValue);
        Thread.sleep(6000);
	}
	
	public void SerchClick() throws InterruptedException
	{
		Thread.sleep(6000);
		SerchClick.click( );
        Thread.sleep(6000);
	}
	public void Clickdmccmsetting() throws InterruptedException
	{
		Thread.sleep(6000);
		Clickdmccmsetting.click( );
        Thread.sleep(6000);
	}
	public void ActionClkDmccmsetting() throws InterruptedException
	{
		Thread.sleep(6000);
		ActionClkDmccmsetting.click( );
        Thread.sleep(6000);
	}
	
	public void RunActionClk() throws InterruptedException
	{
		TestUtil obj=new TestUtil();
		obj.ActionMouseMov(RunActionClk);
	}	
	
	public void FulshRunClick() throws InterruptedException
	{
	String mainWindow=driver.getWindowHandle();
    Set<String> set =driver.getWindowHandles();
    Iterator<String> itr= set.iterator();
     while(itr.hasNext())
     {
     String childWindow=itr.next();
      if(!mainWindow.equals(childWindow)){
     driver.switchTo().window(childWindow);

      Thread.sleep(6000);
      FlushClk.click();

	 Thread.sleep(6000);
	 RunFlushClk.click( );
	 Thread.sleep(6000);
	 
    driver.close();
    }
     }
    driver.switchTo().window(mainWindow);
	
	}
	public void OverrideCampSrch() throws InterruptedException
	{
		Thread.sleep(6000);
		OverrideCampSrch.clear();
		Thread.sleep(6000);
		OverrideCampSrch.sendKeys(OverrideCampSrchValue);
        Thread.sleep(6000);
	}
	
	public void OverrideCampSrchClk() throws InterruptedException
	{
		Thread.sleep(6000);
		OverrideCampSrchClk.click( );
        Thread.sleep(6000);
	}
	
	public void OverrideCampBlockrClk() throws InterruptedException
	{
		Thread.sleep(6000);
		OverrideCampBlockrClk.click( );
        Thread.sleep(6000);
	}
	public void OverrideCampActClk() throws InterruptedException
	{
		Thread.sleep(6000);
		OverrideCampActClk.click( );
        Thread.sleep(6000);
	}
	
	public void RunOverideBlkClk() throws InterruptedException
	{
		TestUtil obj=new TestUtil();
		obj.ActionMouseMov(RunOverideBlkClk);
	}

	public void OverridCampBlkRun() throws InterruptedException
	{
	
	String winHandleBefore = driver.getWindowHandle();
    for (String winHandle : driver.getWindowHandles()) {
      // Switch to child window
      driver.switchTo().window(winHandle);
    }
	 Thread.sleep(6000); 
     OverridCampBlk.clear();       
	 OverridCampBlk.sendKeys(OverridCampBlkvalue); 
	 
	 Thread.sleep(6000);
	 RunOverideBlk.click( );
	 Thread.sleep(6000);
	 
	 String winHandleAfter = driver.getWindowHandle();
	 for(String winChildHandle : driver.getWindowHandles()) {
		  // Switch to child window of the 1st child window.
		  if(!winChildHandle.equals(winHandleBefore) 
		  && !winChildHandle.equals(winHandleAfter)) {
		    driver.switchTo().window(winChildHandle);
		   }
		 }
	 Thread.sleep(6000);
	 driver.close();
	 Thread.sleep(6000);
	 driver.switchTo().window(winHandleAfter);
	 
	 Thread.sleep(6000);
	// to close the child window.
	driver.close();
	Thread.sleep(6000);
	// to switch to parent window.
	driver.switchTo().window(winHandleBefore);
	
}

}