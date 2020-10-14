package test;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Mccm.Pega.Outbound.PegaMain.HomePage;
import Mccm.Pega.Outbound.PegaTestBase.TestBase;

public class PageMrktEtoEFlowPreCheckNBACamp extends TestBase  {

 
@Test  
public void NBABatchCampaignSuccessfull() throws InterruptedException, AWTException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\prout21\\Downloads\\chromedriver_win32\\chromedriver.exe");  
	WebDriver driver = new ChromeDriver();
	driver.get("http://mccm-191102761.eu-central-1.elb.amazonaws.com:8573/prweb");
	driver.findElement(By.xpath("//input[@id='txtUserID']")).sendKeys("prafulla" );
	driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("rules" );
	driver.findElement(By.xpath("//span[@class='loginButtonText']")).click( );
	Thread.sleep(3000);

	String xpath = "(//i[@class='pi pi-caret-down'])[2]";
	WebElement element =  driver.findElement(By.xpath(xpath));
	Actions  action = new Actions(driver);
	action.moveToElement(element).click().build().perform();
	Thread.sleep(3000);
	String  s1 = "(//span[@class='menu-item-title'])[5]";
	driver.findElement(By.xpath(s1)).click( );
	Thread.sleep(3000);
	String mainWindow=driver.getWindowHandle();
	System.out.println(mainWindow);
	// It returns no. of windows opened by WebDriver and will return Set of Strings
	Set<String> set =driver.getWindowHandles();
	// Using Iterator to iterate with in windows
	Iterator<String> itr= set.iterator();
	while(itr.hasNext())
	{
		String childWindow=itr.next();
		// Compare whether the main windows is not equal to child window. If not equal, we will close.
		if(!mainWindow.equals(childWindow)){
			driver.switchTo().window(childWindow);

			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@id='appview-nav-toggle-one']")).click( );
			Thread.sleep(3000);
			driver.findElement(By.xpath("//span[text()='Campaigns']")).click( );
			Thread.sleep(3000);
			int size = driver.findElements(By.tagName("iframe")).size();
			System.out.println(size);

			driver.switchTo().frame(1);

			Actions actions = new Actions(driver);

			Robot robot = new Robot();

			robot.mouseMove(50,50);

			actions.click().build().perform();

			robot.mouseMove(200,70);

			actions.click().build().perform();



			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@name='PortalCardListingHeader_pyLanding_264']")).click( );
			Thread.sleep(3000);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@type='text'][@name='$PTempModalCardContainerPage$pFilterCriteriaDisplay$ppyValue']")).sendKeys("NBABatchCamp9");
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//button[text()='View'])[1]")).click( );
			Thread.sleep(8000);
			
			// display validation of the Flag id data

			WebElement w3;

			w3=driver.findElement(By.xpath("//div[text()='There are no results returned, please try a new search term.']"));

			String MSG = w3.getText();
			
			String MSG1 = "There are no results returned, please try a new search term.";

			System.out.println(w3.getText());

			Assert.assertEquals(MSG, MSG1); 
			
			
			
	 		driver.findElement(By.xpath("//div[@class='card-image no-image'][1]")).click( );
			Thread.sleep(8000);
			driver.switchTo().defaultContent();
			System.out.println("I am in outer frame.......................");
			int size1 = driver.findElements(By.tagName("iframe")).size();
			System.out.println(size1);
			driver.switchTo().frame(2);
			System.out.println("i am ineer frame no ");
			Thread.sleep(8000);



			// click on the search button
			System.out.println("i am in if----------------------");
			Thread.sleep(3000);
			WebElement element9 = driver.findElement(By.xpath("//text()[.='Actions']/ancestor::button[1]"));
			JavascriptExecutor executor3 = (JavascriptExecutor)driver;
			executor3.executeScript("arguments[0].click();", element9);
			Thread.sleep(3000);
			System.out.println("i am in if---search-------------------");

			Thread.sleep(8000);

			driver.findElement(By.xpath("//span[text()='Reschedule']")).click( );
			Thread.sleep(3000);

			//configure Engagemant
//			JavascriptExecutor js2 = (JavascriptExecutor) driver;
//			WebElement element3 = driver.findElement(By.xpath("//div[text()='Engagement']"));
//			js2.executeScript("arguments[0].scrollIntoView();", element3);	
			Thread.sleep(3000);

			driver.findElement(By.xpath("//text()[.='Configure']/ancestor::div[1]")).click( );

			Thread.sleep(3000);
			//			 WebElement checkbox =  driver.findElement(By.xpath("//input[@type='checkbox'][@name='$PpyWorkPage$pEnableScheduling']"));
			//			 checkbox.click( );
			WebElement radio1 =  driver.findElement(By.xpath("//label[text()='Recurring']"));
			radio1.click( );

			driver.findElement(By.xpath("//img[@name='CalendarImg-1d3ff703']")).click( );
			Thread.sleep(3000);

			driver.findElement(By.xpath("//a[text()='Today']")).click( );
			Thread.sleep(3000);

			driver.findElement(By.xpath("//button[text()='Apply']")).click( );
			Thread.sleep(3000);

			JavascriptExecutor js5 = (JavascriptExecutor) driver;
			WebElement element6 = driver.findElement(By.xpath("//button[text()='Confirm']"));
			js5.executeScript("arguments[0].scrollIntoView();", element6);	

			driver.findElement(By.xpath("//button[text()='Confirm']")).click( );
			Thread.sleep(3000);

			 Thread.sleep(6000);
		 	 driver.findElement(By.xpath("//button[@title='Refresh']")).click( );
	//		 driver.navigate().refresh();
			 Thread.sleep(6000);
			 JavascriptExecutor js7= (JavascriptExecutor) driver;
			 WebElement element8 = driver.findElement(By.xpath("//h2[text()='Run schedule']"));
		     js7.executeScript("arguments[0].scrollIntoView();", element8);	

			///--------------------------------------------------------------------------------------------------------------//	 

			for(int i=0;i<50;i++)
			{

				Thread.sleep(8000);

				try
				{
					Thread.sleep(8000);
				 	driver.findElement(By.xpath("//button[@title='Refresh']")).click( );
					Thread.sleep(8000);
					JavascriptExecutor js6 = (JavascriptExecutor) driver;
					WebElement element7 = driver.findElement(By.xpath("//h2[text()='Run schedule']"));
					js6.executeScript("arguments[0].scrollIntoView();", element7);	
				}catch(Exception e){

				}

				String getTextOnPage1 = "",getTextOnPage2 = "",getTextOnPage3 = "";


				try {


					WebElement element11 = driver.findElement(By.xpath("//h2[contains(text(),'Run schedule')]/following::span[contains(.,'Completed')][1]"));

					getTextOnPage1 = element11.getText();

				}catch(Exception e){
					e.printStackTrace();

				}
				try {


					WebElement element12 = driver.findElement(By.xpath("//span[text()='Failed']"));

					getTextOnPage2 = element12.getText();


				}catch(Exception e){
					e.printStackTrace();

				}

				try {
					WebElement element13 = driver.findElement(By.xpath("//span[text()='Stopped']"));

					getTextOnPage3 = element13.getText();

				}catch(Exception e1){
					e1.printStackTrace();{
					}
					if (getTextOnPage1.equals("COMPLETED")){


						System.out.println("Test Case Passed");


						break;
					}
					else if (getTextOnPage2.equals("FAILED")) {

						System.out.println("Test Case Failed");

						Assert.assertEquals(getTextOnPage2, "COMPLETED"); 

						break;
					}

					else if (getTextOnPage3.equals("STOPPED")) {

						System.out.println("Test Case Stopped");

						Assert.assertEquals(getTextOnPage3, "COMPLETED"); 

							break;
						}

						{
							continue;
						}

					}
				}
			
			Thread.sleep(8000);
		 	driver.findElement(By.xpath("//h2[contains(text(),'Run schedule')]/following::span[contains(.,'Completed')][1]")).click( );
			Thread.sleep(8000);
			
			JavascriptExecutor js9 = (JavascriptExecutor) driver;
			 WebElement element10 = driver.findElement(By.xpath("//h2[contains(text(),'Run schedule')]/following::span[contains(.,'Completed')][1]"));
		     js9.executeScript("arguments[0].scrollIntoView();", element10);	
			
			Thread.sleep(8000);
		 	driver.findElement(By.xpath("//*[@name='DataFlowRunDetails_pyWorkPage_3']")).click( );
			Thread.sleep(8000);
			
			JavascriptExecutor js8 = (JavascriptExecutor) driver;
			 WebElement element11 = driver.findElement(By.xpath("//span[text()='Campaign run ID']"));
		     js8.executeScript("arguments[0].scrollIntoView();", element11);	
			
		   //Search the element by using starts-with
		     WebElement w;
		     
		     w=driver.findElement(By.xpath("//span[.='Campaign run ID']/..//span[contains(.,'PR-')]"));
	     	
	     	 //Print the text of the searched element
		        String CampRunID = w.getText();
		        
	        	System.out.println(w.getText());
			 
			}
		}
	}

}
























