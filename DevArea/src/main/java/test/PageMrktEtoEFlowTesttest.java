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

public class PageMrktEtoEFlowTesttest extends TestBase  {
 



//private static final WebElement element10 = null;

@Test  
     public void NBABatchCampaignSuccessfull() throws InterruptedException, AWTException {
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\prout21\\Downloads\\chromedriver_win32\\chromedriver.exe");  
	 WebDriver driver = new ChromeDriver();
	 driver.get("http://mccm-191102761.eu-central-1.elb.amazonaws.com:8573/prweb");
	 driver.findElement(By.xpath("//input[@id='txtUserID']")).sendKeys("prafulla" );
	 driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("rules" );
	 driver.findElement(By.xpath("//span[@class='loginButtonText']")).click( );
	 Thread.sleep(8000);
	 
	 String xpath = "(//i[@class='pi pi-caret-down'])[2]";
	 WebElement element =  driver.findElement(By.xpath(xpath));
     Actions  action = new Actions(driver);
     action.moveToElement(element).click().build().perform();
     Thread.sleep(6000);
     String  s1 = "(//span[@class='menu-item-title'])[5]";
      driver.findElement(By.xpath(s1)).click( );
      Thread.sleep(8000);
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
     
      Thread.sleep(8000);
 	 driver.findElement(By.xpath("//a[@id='appview-nav-toggle-one']")).click( );
 	 Thread.sleep(8000);
 	 driver.findElement(By.xpath("//span[text()='Campaigns']")).click( );
 	 Thread.sleep(8000);
 	 int size = driver.findElements(By.tagName("iframe")).size();
	 System.out.println(size);
  
     driver.switchTo().frame(1);
     
     Actions actions = new Actions(driver);

     Robot robot = new Robot();

     robot.mouseMove(50,50);

     actions.click().build().perform();

     robot.mouseMove(200,70);

     actions.click().build().perform();

      Thread.sleep(8000);
 	  driver.findElement(By.xpath("//*[@class='pi pi-caret-down']")).click( );
 	  Thread.sleep(8000);
 	  driver.findElement(By.xpath("//span[text()='Multi-Channel Campaign']")).click( );
	  Thread.sleep(8000);
	  
	  driver.switchTo().defaultContent();
	  System.out.println("I am in outer frame.......................");
	  int size1 = driver.findElements(By.tagName("iframe")).size();
	  System.out.println(size1);
	  driver.switchTo().frame(2);
	  System.out.println("i am ineer frame no ");
	  Thread.sleep(8000);
	  
	  driver.findElement(By.xpath("//input[@type='text'][@name='$PpyWorkPage$ppyLabel']")).sendKeys("NBABatchCampaig2345");
	  Thread.sleep(8000);
      driver.findElement(By.xpath("//span[text()='Build']")).click( );
      Thread.sleep(8000);
      
       driver.findElement(By.cssSelector("button[name='ContainerWithHeader_pyWorkPage.ProgramConfiguration.StrategyContainer_7']")).click( );
      
      
     // String xpath1 = "/html[1]/body[1]/div[2]/form[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/span[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/button[1]";
    //  driver.findElement(By.xpath(xpath1)).click( );

        Thread.sleep(6000);
    	  driver.findElement(By.xpath("//input[contains(@name,'pFilterCriteriaDisplay$ppyValue')]")).sendKeys("Test Channel");  
    	  Thread.sleep(6000);       
    	  driver.findElement(By.xpath("//*[contains(@class,'pi-search')]")).click( );
          
    	  Thread.sleep(6000);
   	  driver.findElement(By.xpath("(//div[contains(@data-repeat-source,'MultiSelectCardSelector')]//button[text()='Add'])[1]")).click();  
   	  Thread.sleep(6000); 
    
//	     JavascriptExecutor js = (JavascriptExecutor) driver;
//		 WebElement element1 = driver.findElement(By.xpath("//span[text()='Test Channel']"));
//		 js.executeScript("arguments[0].scrollIntoView();", element1);
//		 Thread.sleep(8000);
//			// passed code	
			// driver.findElement(By.xpath("/html[1]/body[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/span[1]/button[1]")).click( );
			// Thread.sleep(6000);
		   // passed code	 	 
			// failed code
//		     driver.findElement(By.xpath("/html[1]/body[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[20]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/span[1]/button[1]")).click( );
//			 Thread.sleep(6000);
			// failed code
		 driver.findElement(By.xpath("//button[text()='Apply']")).click( );
		 Thread.sleep(6000);
		 driver.findElement(By.cssSelector("button[name='ContainerWithHeader_pyWorkPage.AudienceContainer_7']")).click( );
		 Thread.sleep(6000);
				 
		    Thread.sleep(6000);
		  	  driver.findElement(By.xpath("//input[contains(@name,'pFilterCriteriaDisplay$ppyValue')]")).sendKeys("OMBTA");  
		  	  Thread.sleep(6000);       
		  	  driver.findElement(By.xpath("//*[contains(@class,'pi-search')]")).click( );
		        
		  	  Thread.sleep(6000);
		 	  driver.findElement(By.xpath("(//div[contains(@data-repeat-source,'MultiSelectCardSelector')]//button[text()='Add'])[1]")).click();  
		 	  Thread.sleep(6000); 
		 driver.findElement(By.xpath("//button[text()='Apply']")).click( );
		 Thread.sleep(6000);
		 
		 //configure Engagemant
		 JavascriptExecutor js2 = (JavascriptExecutor) driver;
		 WebElement element3 = driver.findElement(By.xpath("//div[text()='Engagement']"));
		 js2.executeScript("arguments[0].scrollIntoView();", element3);	
		 
		 
		 driver.findElement(By.cssSelector("button[name='EngagementContainer_pyWorkPage_7']")).click( );
		 
		// driver.findElement(By.xpath("/html[1]/body[1]/div[3]/form[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/span[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/button[1]")).click( );
		 Thread.sleep(6000);
		 WebElement checkbox =  driver.findElement(By.xpath("//input[@type='checkbox'][@name='$PpyWorkPage$pEnableScheduling']"));
		 checkbox.click( );
		 WebElement radio1 =  driver.findElement(By.xpath("//label[text()='Recurring']"));
		 radio1.click( );
		 
		 //new added
		 
	   	 Thread.sleep(6000);
		  WebElement checkbox1 =  driver.findElement(By.xpath("//input[@type='checkbox'][@name='$PpyWorkPage$pProgramConfiguration$pDirectDBTemplate']"));
		  checkbox1.click( );		
	       Thread.sleep(6000);
		   driver.findElement(By.xpath("//text()[.='Configure template']/ancestor::button[1]")).click( );
		  Thread.sleep(6000);
//		  JavascriptExecutor js4 = (JavascriptExecutor) driver;
//		  WebElement element5 = driver.findElement(By.xpath("//span[text()='MCCM LC Outbound']"));
//		  js4.executeScript("arguments[0].scrollIntoView();", element5);	
//		  Thread.sleep(6000);
//		   int amount = driver.findElements(By.tagName("iframe")).size();
//	 		 System.out.println(amount);
//	 		 
//	 	  driver.findElement(By.xpath("//span[text()='MCCM LC Outbound']")).click( );
// 	       Thread.sleep(6000);	
// 	       
// 	      driver.findElement(By.cssSelector("button[name='SimpleSelectorCardContent_DBTemplateMultiPg.Cards(8)_16']")).click( );
// 	     	
		  driver.findElement(By.xpath("//input[@type='text'][@name='$PDBTemplateMultiPg$pFilterCriteriaDisplay$ppyValue']")).sendKeys("MCCM LC Outbound");  
		  	Thread.sleep(6000); 
		    driver.findElement(By.xpath("//*[@name='WideDetailsSelectorPanel_DBTemplateMultiPg_53']")).click( );
		    Thread.sleep(6000);
		 	  driver.findElement(By.xpath("(//div[contains(@data-repeat-source,'DBTemplateMultiPg')]//button[text()='Add'])[1]")).click();  
		 	 
	 	 // driver.findElement(By.xpath("/html[1]/body[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/span[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[7]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/span[1]/button[1]")).click( );
	      Thread.sleep(6000);
	     
	    
	     boolean searchIconPresence = driver.findElement(By.xpath("//button[text()='Add template']")).isDisplayed();
	     boolean searchIconEnabled = driver.findElement(By.xpath("//button[text()='Add template']")).isEnabled();

	     if (searchIconPresence==true && searchIconEnabled==true)

	     {
	     // click on the search button
	    	 System.out.println("i am in if----------------------");
	    	 Thread.sleep(6000);
	    	 WebElement element9 = driver.findElement(By.xpath("//button[text()='Add template']"));
	    	 JavascriptExecutor executor3 = (JavascriptExecutor)driver;
	    	 executor3.executeScript("arguments[0].click();", element9);
	     Thread.sleep(6000);
	     System.out.println("i am in if---search-------------------");
         
	     }
	      //zooming the page
	      // ((JavascriptExecutor)driver).executeScript("document.body.style.zoom='75%';");
	       //Thread.sleep(6000);
	       //System.out.println("jooming one");
	       //Thread.sleep(6000);
	       //Actions  joom = new Actions(driver);
	       //joom.sendKeys(Keys.CONTROL,Keys.SUBTRACT);
	      //joom.sendKeys(Keys.CONTROL,Keys.SUBTRACT);
	      //joom.sendKeys(Keys.CONTROL,Keys.SUBTRACT);
	      //Thread.sleep(6000);
	     
	       
	     // driver.findElement(By.xpath("//button[text()='Add template']")).click( );
		 // Thread.sleep(6000);	
		//  ((JavascriptExecutor)driver).executeScript("document.body.style.zoom='100%';");
		//added new 
	     
	     Thread.sleep(6000);
		 
         driver.findElement(By.xpath("//button[text()='Apply']")).click( );
		 Thread.sleep(6000);
		 driver.findElement(By.xpath("//button[text()='Save']")).click( );
		 Thread.sleep(6000);
		 //run the capmaingaine
		 driver.findElement(By.xpath("//button[text()='Run']")).click( );
		 Thread.sleep(6000);
		 driver.findElement(By.xpath("//button[text()='Confirm']")).click( );
		 Thread.sleep(6000);
		 driver.findElement(By.xpath("//*[@class='pi pi-refresh']")).click( );
		 Thread.sleep(6000);
		 
   ///* old code 
		 
//		// display run completed  successfully
		 
//			 for(int i=0;i<50;i++){
//			 Thread.sleep(6000);
//		}
//	     driver.findElement(By.xpath("//*[@class='pi pi-refresh']")).click( );
//		 JavascriptExecutor js5 = (JavascriptExecutor) driver;
//		 WebElement element6 = driver.findElement(By.xpath("//h2[text()='Run schedule']"));
//		 js5.executeScript("arguments[0].scrollIntoView();", element6);	
		 
  ///* old code 
		 
	////*	 new code fluent wait 
		 
		
		 
	
	     JavascriptExecutor js5 = (JavascriptExecutor) driver;
		 WebElement element6 = driver.findElement(By.xpath("//h2[text()='Run schedule']"));
	     js5.executeScript("arguments[0].scrollIntoView();", element6);	
	 
	
	///--------------------------------------------------------------------------------------------------------------//	 
		 
	 FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(15000, TimeUnit.SECONDS).pollingEvery(30, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
	 
	 WebElement ele = wait.until(new Function<WebDriver, WebElement>()
	 

	 {
	 

	 public WebElement apply(WebDriver driver)

	             {  
		 
		 try
		 {
		 Thread.sleep(6000);
		 driver.findElement(By.xpath("//*[@class='pi pi-refresh']")).click( );
		 Thread.sleep(6000);
		 JavascriptExecutor js6 = (JavascriptExecutor) driver;
		 WebElement element7 = driver.findElement(By.xpath("//h2[text()='Run schedule']"));
	     js6.executeScript("arguments[0].scrollIntoView();", element7);	
		 }catch(Exception e){
			 
		 }
         
		String getTextOnPage1 = "",getTextOnPage2 = "",getTextOnPage = "";
		
		try {
			
	     	 WebElement element10 = driver.findElement(By.xpath("//span[text()='Completed']"));
				
		        getTextOnPage = element10.getText();
		        
		       // if(getTextOnPage.equals("COMPLETED"))break;
		        			 
			}catch(Exception e2){
			e2.printStackTrace();
		
			}
		
		try {
			
		
		 WebElement element11 = driver.findElement(By.xpath("//span[text()='Failed']"));
         	 
	      getTextOnPage1 = element11.getText();
		 
		}catch(Exception e){
		e.printStackTrace();
		
		}
		
		try {
			 WebElement element12 = driver.findElement(By.xpath("//span[text()='Stopped']"));

			 getTextOnPage2 = element12.getText();
	 
		}catch(Exception e1){
			e1.printStackTrace();{
	                  	}
	             }
		
		
		
		{
			for (int i = 1; i <= 5; i++) {
				if (getTextOnPage1.equals("FAILED")) {
					 
					break;
				}
			}
	 if(getTextOnPage1.equals("FAILED")) 
	 {
		 
		 //break; 
	 //}
	          //   };
	 

 
	
 
	
	// if(getTextOnPage.equals("COMPLETED"))break;
	 
   //  System. exit(1);
	//  return HomePage11();
	  return null;
 
	 }
	 
  
 		 
     	 else if(getTextOnPage2.equals("STOPPED"))
				 
    	    {

		 System.out.println("Test Case Stopped");
	 
	     Assert.assertEquals(getTextOnPage2, "COMPLETED"); 

	    return null;
		    
		    } 
		 
	          else{
	            	 System.out.println("Test Case Running");
	            	 return null;
	            	
	            	 }
	            	 }
		
	 
	            	 }});
	 
	
	 
	 // main code bracket below
      }
      }
      }
}
 
 


