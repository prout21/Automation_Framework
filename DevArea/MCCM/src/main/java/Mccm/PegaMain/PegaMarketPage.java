package Mccm.PegaMain;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Mccm.PegaTestBase.TestBase;
import Mccm.QAUtil.TestUtil;
import Mccm.excel.utility.Excel_Reader;

public class PegaMarketPage extends TestBase  {
	@FindBy(xpath="(//span[@class='menu-item-title'])[5]")
	WebElement pegamrkting1;
	@FindBy(xpath="//a[@id='appview-nav-toggle-one']")
	WebElement ExpandPegMrkPage;
	
	@FindBy(xpath="//span[text()='Campaigns']")
	WebElement Campaigns;
	
	@FindBy(xpath="//*[@class='pi pi-caret-down']")
	WebElement Create;
	
	@FindBy(xpath="//span[text()='Multi-Channel Campaign']")
	WebElement MultiChannelCampaign;
	
	@FindBy(xpath="//input[@type='text'][@name='$PpyWorkPage$ppyLabel']")
	WebElement Campaigncode;
	
	@FindBy(xpath="//span[text()='Build']")
	WebElement Build;
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/form[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/span[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/button[1]")
	WebElement MrktStrtgyConfig;
	
	@FindBy(xpath="//span[text()='Test Channel']")
	WebElement webelement;
	
	@FindBy(xpath="/html[1]/body[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[20]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/span[1]/button[1]")
	WebElement Add;
	
	
	@FindBy(xpath="//button[text()='Apply']")
	WebElement Applay;
	
	
	@FindBy(xpath="/html[1]/body[1]/div[3]/form[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/span[2]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/button[1]")
	WebElement AudianceConfig;
	
	
	
	@FindBy(xpath="//span[text()='NBATestSegment']")
	WebElement webelement1;
	
	@FindBy(xpath="/html[1]/body[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/span[1]/button[1]")
	WebElement Addadinceconfig;
	
	@FindBy(xpath="//button[text()='Apply']")
	WebElement ApplayAdience;
	
	@FindBy(xpath="//div[text()='Engagement']")
	WebElement webelement2;
	
	@FindBy(xpath="/html[1]/body[1]/div[3]/form[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/span[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/button[1]")
	WebElement Engagementconfig;
	
	
	@FindBy(xpath="//input[@type='checkbox'][@name='$PpyWorkPage$pEnableScheduling']")
	WebElement Campaignschdul;
	
	
	@FindBy(xpath="//label[text()='Recurring']")
	WebElement Recurring;
	

	@FindBy(xpath="//input[@type='checkbox'][@name='$PpyWorkPage$pProgramConfiguration$pDirectDBTemplate']")
	WebElement databasetemplate;
	
	@FindBy(xpath="//text()[.='Configure template']/ancestor::button[1]")
	WebElement configtemplate;
	
	@FindBy(xpath="//span[text()='MCCM LC Outbound']")
	WebElement MCCMLCOutbound;
	
	@FindBy(xpath="//span[text()='MCCM LC Outbound']")
	WebElement webelement3;
	
	@FindBy(xpath="/html[1]/body[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/span[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/span[1]/button[1]")
	WebElement Addmcclbound;
	
	@FindBy(xpath="//span[text()='MCCM LC Outbound']")
	WebElement webelement4;
	
	@FindBy(xpath="//button[text()='Add template']")
	WebElement Addtemplete;
	
	
	@FindBy(xpath="//button[text()='Apply']")
	WebElement ApplayEngagement;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement SaveCampgn;
	
	@FindBy(xpath="//button[text()='Run']")
	WebElement RunCampgn;
	
	@FindBy(xpath="//button[text()='Confirm']")
	WebElement ConfirmCampgn;
	
	@FindBy(xpath="//*[@class='pi pi-refresh']")
	WebElement RefreshCampgn;

	@FindBy(xpath="//h2[text()='Run schedule']")
	WebElement Runschedule;
	
		
	Excel_Reader obj= new Excel_Reader("C:\\Users\\prout21\\eclipse-workspace\\MCCM\\src\\main\\java\\Mccm\\TestData\\PegaTestData.xlsx");
	
	//Excel_Reader obj= new Excel_Reader(projectPath+"/src/main/java/Mccm/TestData/PegaTestData.xlsx");
	
	String Campaigncd = obj.getCellValue("PegaTestData", 1, 0);
	
	
	
	
	public PegaMarketPage( ) {
    	PageFactory.initElements(driver, this);
    }
	
	public void pegamarkting() throws InterruptedException
	{
		Thread.sleep(6000);
		pegamrkting1.click( );
        Thread.sleep(6000);
	}
	

	public void ExpandPegMrkPage() throws InterruptedException
	{
		Thread.sleep(6000);
		ExpandPegMrkPage.click( );
        Thread.sleep(6000);
	}
	
	public void Campaigns() throws InterruptedException
	{
		Thread.sleep(6000);
		Campaigns.click( );
        Thread.sleep(6000);
	}
	public void Create() throws InterruptedException
	{
		Thread.sleep(6000);
		Create.click( );
        Thread.sleep(6000);
	}
	public void MultiChannelCampaign() throws InterruptedException
	{
		Thread.sleep(6000);
		MultiChannelCampaign.click( );
        Thread.sleep(6000);
	}
	public void Campaigncode() throws InterruptedException
	{
		Thread.sleep(6000);
		Campaigncode.sendKeys(Campaigncd);
        Thread.sleep(6000);
	}
	public void Build() throws InterruptedException
	{
		Thread.sleep(6000);
		Build.click( );
        Thread.sleep(6000);
	}
	public void MrktStrtgyConfig() throws InterruptedException
	{
		Thread.sleep(6000);
		MrktStrtgyConfig.click( );
        Thread.sleep(6000);
	}
	public void javaexictor() throws InterruptedException
	{
		TestUtil obj=new TestUtil();
		obj.JavascriptExecutor(webelement);
	}
		
	public void Add() throws InterruptedException
	{
		Thread.sleep(6000);
		Add.click( );
        Thread.sleep(6000);
	
	}
	public void Applay() throws InterruptedException
	{
		Thread.sleep(6000);
		Applay.click( );
        Thread.sleep(6000);
        
	}    
	
	public void AudianceConfig() throws InterruptedException
	{
		Thread.sleep(6000);
		AudianceConfig.click( );
        Thread.sleep(6000);
	}
	public void javaexictor1() throws InterruptedException
	{
		TestUtil obj=new TestUtil();
		obj.JavascriptExecutor(webelement1);
	}
	public void Addadinceconfig() throws InterruptedException
	{
		Thread.sleep(6000);
		Addadinceconfig.click( );
        Thread.sleep(6000);
	}
	
	public void ApplayAdience() throws InterruptedException
	{
		Thread.sleep(6000);
		ApplayAdience.click( );
        Thread.sleep(6000);
	}
	
	public void javaexictor2() throws InterruptedException
	{
		TestUtil obj=new TestUtil();
		obj.JavascriptExecutor(webelement2);
	}
	
	public void Engagementconfig() throws InterruptedException
	{
		Thread.sleep(6000);
		Engagementconfig.click( );
        Thread.sleep(6000);
	}
	
	public void Campaignschdul() throws InterruptedException
	{
		Thread.sleep(6000);
		Campaignschdul.click( );
        Thread.sleep(6000);
	}
	
	public void Recurring() throws InterruptedException
	{
		Thread.sleep(6000);
		Recurring.click( );
        Thread.sleep(6000);
	}
	
	public void databasetemplate() throws InterruptedException
	{
		Thread.sleep(6000);
		databasetemplate.click( );
        Thread.sleep(6000);
	}
	
	public void configtemplate() throws InterruptedException
	{
		Thread.sleep(6000);
		configtemplate.click( );
        Thread.sleep(6000);
	}
	
	public void javaexictor3() throws InterruptedException
	{
		TestUtil obj=new TestUtil();
		obj.JavascriptExecutor(webelement3);
	}
	
	public void MCCMLCOutbound() throws InterruptedException
	{
		Thread.sleep(6000);
		MCCMLCOutbound.click( );
        Thread.sleep(6000);
	}
	public void Addmcclbound() throws InterruptedException
	{
		Thread.sleep(6000);
		Addmcclbound.click( );
        Thread.sleep(6000);
	}
	
	public void Javascriptserch() throws InterruptedException
	{
		 Thread.sleep(6000);
		 boolean searchIconPresence = Addtemplete.isDisplayed();
	     boolean searchIconEnabled =  Addtemplete.isEnabled();

	     if (searchIconPresence==true && searchIconEnabled==true)

	     {
	      	 WebElement element9 = Addtemplete;
	    	 JavascriptExecutor executor3 = (JavascriptExecutor)driver;
	    	 executor3.executeScript("arguments[0].click();", element9);
	    	 Thread.sleep(6000);
	     }
	}
	     
	public void ApplayEngagement() throws InterruptedException
	 	{
	 		Thread.sleep(6000);
	 		ApplayEngagement.click( );
	         Thread.sleep(6000);
	 	}
	
	public void SaveCampgn() throws InterruptedException
 	{
 		Thread.sleep(6000);
 		SaveCampgn.click( );
         Thread.sleep(6000);
 	}
	
	public void RunCampgn() throws InterruptedException
 	{
 		Thread.sleep(6000);
 		RunCampgn.click( );
         Thread.sleep(6000);
 	}
	
	public void ConfirmCampgn() throws InterruptedException
 	{
 		Thread.sleep(6000);
 		ConfirmCampgn.click( );
         Thread.sleep(6000);
 	}
	public void RefreshCampgn() throws InterruptedException
 	{
 		Thread.sleep(6000);
 		RefreshCampgn.click( );
         Thread.sleep(6000);
 	}
	
	public void Runstatus() throws InterruptedException
 	{
 	
		for(int i=0;i<70;i++){
			 Thread.sleep(6000);
		}
	 
		 RefreshCampgn.click( );
		 JavascriptExecutor js5 = (JavascriptExecutor) driver;
		 WebElement element6 = Runschedule;
		 js5.executeScript("arguments[0].scrollIntoView();", element6);	
	   }
      
     }
    
   
  

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 