package com.mccm.automation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


//import com.eoc.automation.utility.CustomExceptionElementDisabled;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class MyFrameWorkLibrary extends MyAutomationConstants{

	//public static String PROJECT_FOLDER_PATH;
	public static int MAX_RETRY_COUNT;
	public static int MAX_TIME_OUT;
	public static int MIN_TIME_OUT;
	public WebDriver driver;
	public FluentWait<WebDriver> minWait;
	public FluentWait<WebDriver> maxWait;
	public static boolean writeToLog=true;
	public static boolean takeScreenShot=true;
	public static boolean recoveryScenario=true;
	public static boolean performanceMonitoring=false;
	
	
	public JavascriptExecutor js;
	public String outputFolder;
	

	//*******************************************************************************************
	//*Function:	general_ReadProperty														*
	//*Arguments:	Property Key as String													 	*
	//*Return 		Poverty Value as String														*
	//*Descriptions: 																			*
	//*	This function will read the Properties file and return property value to based on key.	*
	//*Author: 														*
	//*******************************************************************************************
	public String general_ReadProperty(String propertyKey)
	{
		String propertyValue="";
		File cfgfile = new File("configurationFile.properties");
		
		if(cfgfile.exists())
		{
			  Properties propties = new Properties();
			  FileInputStream propFile;

			  try {
				  propFile = new FileInputStream(cfgfile);
				  propties.load(propFile);
				  propertyValue=propties.getProperty(propertyKey);
				  } catch (Exception e1) {
					  
					  e1.printStackTrace();
				  } 
		 }
		return propertyValue;
		
	}
	
	
	//*******************************************************************************************
	//*Function:	general_WaitTillElementIsDisabled											*
	//*Arguments:	WebElement as Object													 	*
	//*Return 		None																		*
	//*Descriptions: 																			*
	//*	This function will wait till a WebElement is disabled								 	*
	//*Author: 														*
	//*******************************************************************************************
	public boolean general_WaitTillElementIsDisabled(WebElement object)
	{
		boolean isDisabled=false;

		Predicate<WebDriver> waitFunction = new Predicate<WebDriver>() {
			public boolean apply(WebDriver driver) {
				return (!object.isEnabled());
			}
		};
		
		try
		{
			maxWait.until(waitFunction);
			isDisabled=true;
		}catch(TimeoutException e)
		{
			isDisabled=false;
			
		}
		return isDisabled;
	}
	
	//*******************************************************************************************
	//*Function:	general_WaitTillElementIsEnabled											*
	//*Arguments:	WebElement as Object													 	*
	//*Return 		None																		*
	//*Descriptions: 																			*
	//*	This function will wait till a WebElement is enabled								 	*
	//*Author: 														*
	//*******************************************************************************************
	public boolean general_WaitTillElementIsEnabled(WebElement object)
	{
		boolean isEnabled=false;

		Predicate<WebDriver> waitFunction = new Predicate<WebDriver>() {
			public boolean apply(WebDriver driver) {
				return (object.isEnabled());
			}
		};
		
		try
		{
			maxWait.until(waitFunction);
			isEnabled=true;
		}catch(TimeoutException e)
		{
			isEnabled=false;
			
		}
		return isEnabled;
	}
	
	//*******************************************************************************************
	//*Function:	performance_AddToLog														*
	//*Arguments:	entryID as String, activityID as String, activityTime as String				*
	//*Return 		None																		*
	//*Descriptions: 																			*
	//*	This function will write performance readings to log file.								*
	//*Author: 														*
	//*******************************************************************************************

	public void performance_AddToLog(String entryID, String activityID, String activityTime)
	{
		if (performanceMonitoring)
		{
			String logFileName="PERFORMANCE.log";
			String folderPath= outputFolder + "/Logs";
			String filePath= folderPath +"/" + logFileName;
			File logPath = new File(folderPath);;
			File logFile = new File(filePath);
			
			// if file does'nt exists, then create it
			logPath.mkdirs();
			if (!logFile.exists()) 
			{
				try {
					logFile.createNewFile();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
			
			FileWriter fileWriter;
			boolean notFileWritten=true;
			do
			{
				try {
					fileWriter = new FileWriter(logFile.getAbsoluteFile(),true);
					BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
					bufferedWriter.write(activityID +":"+ activityTime);
					bufferedWriter.newLine();
					bufferedWriter.close();
					fileWriter.close();
					notFileWritten=false;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}while(notFileWritten);
			
		}
	}
}
