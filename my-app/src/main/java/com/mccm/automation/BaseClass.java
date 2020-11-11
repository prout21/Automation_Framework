package com.mccm.automation;




import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.ITestContext;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Parameters;

import com.mccm.automation.MyFrameWorkLibrary;
import com.mccm.automation.XLSXReadWrite;


//@SuppressWarnings("unused")
public class BaseClass extends MyFrameWorkLibrary  {
//	public static boolean USEGRID;
//	public static String GRIDURL;
//	Single Thread
//	static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>();
//	Parallel Execution
//	static ThreadLocal<RemoteWebDriver> threadDriver = new ThreadLocal<RemoteWebDriver>();
//	
//	static ThreadLocal<String> testResult = new ThreadLocal<String>();


	
	//@BeforeSuite
	public void configuration()
	{
		//Framework Variables
		PROJECT_FOLDER_PATH=general_ReadProperty("PROJECT_FOLDER_PATH");
		MAX_RETRY_COUNT=Integer.parseInt(general_ReadProperty("MAX_RETRY_COUNT"));
		MAX_TIME_OUT=Integer.parseInt(general_ReadProperty("MAX_TIME_OUT"));
		MIN_TIME_OUT=Integer.parseInt(general_ReadProperty("MIN_TIME_OUT"));
		
		//Project Variables
//		USEGRID=Boolean.parseBoolean(general_ReadProperty("USEGRID"));
//		GRIDURL=general_ReadProperty("GRIDURL");
		TEST_ENV=general_ReadProperty("TEST_ENV");
		ENV_WIKI=general_ReadProperty("ENV_WIKI");
		VF_DO_INPUT=general_ReadProperty("VF_DO_INPUT");
		VF_DO_ATTACHMENTS=general_ReadProperty("VF_DO_ATTACHMENTS");
		VF_DO_REFERENCE_FILES=general_ReadProperty("VF_DO_REFERENCE_FILES");
		VF_DO_RESULTS=general_ReadProperty("VF_DO_RESULTS");
		CHROME_DRIVER=general_ReadProperty("CHROME_DRIVER");
		IE_DRIVER=general_ReadProperty("IE_DRIVER");
		GECKO_DRIVER=general_ReadProperty("GECKO_DRIVER");
		
		performanceMonitoring=Boolean.parseBoolean(general_ReadProperty("PERFORMANCE_MONITORING"));
		
		XLSXReadWrite readFile = new XLSXReadWrite(PROJECT_FOLDER_PATH + ENV_WIKI );
		int URLRowIndex=readFile.findRowIndex("EnvDetails", TEST_ENV);
		int unixServerIndex=readFile.findColumnIndex("EnvDetails", "UNIX - SERVER");
		int unixUserIndex=readFile.findColumnIndex("EnvDetails", "UNIX - USER");
		int unixPasswordIndex=readFile.findColumnIndex("EnvDetails", "UNIX - PASSWORD");
		int dbHostIndex=readFile.findColumnIndex("EnvDetails", "DB - HOST");
		int dbPortIndex=readFile.findColumnIndex("EnvDetails", "DB - PORT");
		int dbSIDIndex=readFile.findColumnIndex("EnvDetails", "DB - SID");
		int dbSchemaIndex=readFile.findColumnIndex("EnvDetails", "DB - SCHEMA");
		int dbUserNameIndex=readFile.findColumnIndex("EnvDetails", "DB - USERNAME");
		int dbPasswordIndex=readFile.findColumnIndex("EnvDetails", "DB - PASSWORD");
		int xmlMOMIndex=readFile.findColumnIndex("EnvDetails", "MOM - XML PATH");
		int excelMOMIndex=readFile.findColumnIndex("EnvDetails", "MOM - EXCEL PATH");
		int xmlOMIndex=readFile.findColumnIndex("EnvDetails", "OM - XML PATH");
		
		
		serverHostName=readFile.getCellValue("EnvDetails", URLRowIndex, unixServerIndex);
		serverUserName=readFile.getCellValue("EnvDetails", URLRowIndex, unixUserIndex);
		serverPassword=readFile.getCellValue("EnvDetails", URLRowIndex, unixPasswordIndex);
		xmlOMFolder=readFile.getCellValue("EnvDetails", URLRowIndex, xmlOMIndex);
		xmlMOMFolder=readFile.getCellValue("EnvDetails", URLRowIndex, xmlMOMIndex);
		excelMOMFolder=readFile.getCellValue("EnvDetails", URLRowIndex, excelMOMIndex);

		userName=readFile.getCellValue("EnvDetails", URLRowIndex, dbUserNameIndex);
		password=readFile.getCellValue("EnvDetails", URLRowIndex, dbPasswordIndex);
		host=readFile.getCellValue("EnvDetails", URLRowIndex, dbHostIndex);
		port=readFile.getCellValue("EnvDetails", URLRowIndex, dbPortIndex);
		SID=readFile.getCellValue("EnvDetails", URLRowIndex, dbSIDIndex);
		schema=readFile.getCellValue("EnvDetails", URLRowIndex, dbSchemaIndex);
		
	}
	
//	@BeforeTest
//	@Parameters({"browser","testCaseID"}) 
	//ITestContext testContext
	public void setup(String browser, String testCaseID) throws MalformedURLException
	{
		//System.out.println("Test Case ID: "+ testContext.getName());
		XLSXReadWrite readFile = new XLSXReadWrite(PROJECT_FOLDER_PATH + ENV_WIKI );
		//Set Output Folder
		//testResult.set(PROJECT_FOLDER_PATH  + VF_DO_RESULTS + "/" + testCaseID +" "+general_TimeStamp());
		
		//If BROWSER_TYPE==GoogleChrome then create an instance of ChromeDriver()
		if (browser.equalsIgnoreCase("GoogleChrome"))
		{
			
			System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);
			DesiredCapabilities chromeProfile =  DesiredCapabilities.chrome();
			chromeProfile.setBrowserName("chrome");
			chromeProfile.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			//Driver = new ChromeDriver(chromeProfile);
			//threadDriver.set(new ChromeDriver(chromeProfile));
//			if (USEGRID)
//			{
//				threadDriver.set(new RemoteWebDriver(new URL(GRIDURL), chromeProfile));
//			}
//			else
//			{
//				threadDriver.set(new ChromeDriver(chromeProfile));
//			}

			
		}
		//If BROWSER_TYPE==InternetExplorer then create an instance of InternetExplorerDriver()
		//else if (browser.equalsIgnoreCase("InternetExplorer"))
		//{
			
			//System.setProperty("webdriver.ie.driver", IE_DRIVER);
			//DesiredCapabilities IEProfile =  DesiredCapabilities.internetExplorer();
			//IEProfile.setBrowserName("internet explorer");
			//IEProfile.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			//Driver = new InternetExplorerDriver(IEProfile);
			//threadDriver.set(new InternetExplorerDriver(IEProfile));
//			if (USEGRID)
//			{
//				threadDriver.set(new RemoteWebDriver(new URL(GRIDURL), IEProfile));
//			}
//			else
//			{
//				threadDriver.set(new InternetExplorerDriver(IEProfile));
//			}
//		}
		//If BROWSER_TYPE==MozillaFirefox then create an instance of FirefoxDriver()
	//	else if (browser.equalsIgnoreCase("MozillaFirefox"))
	//	{
			/*
			//Create a Firefox Profile
			FirefoxProfile FFProfile = new FirefoxProfile();
			//Set download folder as preference
			File downloadFolder = new File(getOutputDirectory()+"/Downloads");
			downloadFolder.mkdirs();
			FFProfile.setPreference("browser.download.folderList", 2);
			FFProfile.setPreference("browser.download.dir", downloadFolder.getAbsolutePath());
			//Set never ask to save to disk preference for PDF and excel file	
			FFProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream,application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			//set show when starting download preference
			FFProfile.setPreference("browser.download.manager.showWhenStarting", false);
			FFProfile.setPreference("pdfjs.disabled", true);
			
			//Set properties to accept untrusted sites.
			FFProfile.setAcceptUntrustedCertificates(true);
			FFProfile.setAssumeUntrustedCertificateIssuer(false);
			threadDriver.set(new FirefoxDriver(FFProfile));
			*/
			//System.setProperty("webdriver.gecko.driver", GECKO_DRIVER);
//			DesiredCapabilities FFProfile =  DesiredCapabilities.firefox();
//			FFProfile.setBrowserName("firefox");
//			FFProfile.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//			FFProfile.setCapability("marionette", false);
//			//Driver = new FirefoxDriver(FFProfile);
			
//			if (USEGRID)
//			{
//				threadDriver.set(new RemoteWebDriver(new URL(GRIDURL), FFProfile));
//			}
//			else
//			{
//				threadDriver.set(new FirefoxDriver(FFProfile));
//			}
//		}
//		
//		//Launch browser with the URL
//		int URLColIndex=readFile.findColumnIndex("EnvDetails", "SALESFORCE - URL");
//		int URLRowIndex=readFile.findRowIndex("EnvDetails", TEST_ENV);
//		getDriver().get(readFile.getCellValue("EnvDetails", URLRowIndex, URLColIndex));
		//Maximize the browser window
//		getDriver().manage().window().maximize();

	}
	
	//@AfterTest
	public void tearDown()
	{
		
//		getDriver().quit();
	//	threadDriver.remove();
		//testResult.remove();
		
	}
	
	//@AfterMethod
//	public void getStepResult(ITestResult result)
//	{
//		if (result.getStatus()==ITestResult.SUCCESS)
//		{
//			//System.out.println(Thread.currentThread().getId() + " :: "+ result.getAttribute("ID") + ": "+ result.getMethod() + ", Status: SUCCESS");
//		}
//		else if (result.getStatus()==ITestResult.FAILURE)
//		{
//			System.out.println(Thread.currentThread().getId() + " :: "+ result.getAttribute("ID") + ": "+ result.getMethod() + ", Status: FAILURE, Cause:" + result.getAttribute("ERROR"));
//		}
//		else if (result.getStatus()==ITestResult.SKIP)
//		{
//			//System.out.println(Thread.currentThread().getId() + " :: "+ result.getAttribute("ID") + ": "+ result.getMethod() + ", Status: SKIPPED");
//		}
//	}
	
	//Single Thread
	/*
	public WebDriver getDriver() 
	{
        return threadDriver.get();
    }*/
    
	//Parallel Execution
	
//	public static RemoteWebDriver getDriver() 
//	{
//        return threadDriver.get();
//    }
//	
	/*
	public static String getOutputDirectory() 
	{
        return testResult.get();
    }*/
}
