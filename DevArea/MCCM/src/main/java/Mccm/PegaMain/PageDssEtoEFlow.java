package Mccm.PegaMain;

import java.awt.AWTException;
import java.awt.List;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class PageDssEtoEFlow {
   
   @Test  
    public void lunchChromBrowser() throws InterruptedException, AWTException {
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\prout21\\Downloads\\chromedriver_win32\\chromedriver.exe");  
	 WebDriver driver = new ChromeDriver();
	 driver.get("http://mccm-191102761.eu-central-1.elb.amazonaws.com:8573/prweb");
	 driver.findElement(By.xpath("//input[@id='txtUserID']")).sendKeys("prafulla" );
	 driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("rules" );
	 driver.findElement(By.xpath("//span[@class='loginButtonText']")).click( );
	 Thread.sleep(8000);
	 driver.findElement(By.xpath("//a[@id='appview-nav-toggle-one']")).click( );
	 Thread.sleep(8000);
	 //driver.findElement(By.xpath("//h3[@id='headerlabel2350']")).click( );
	 //Thread.sleep(8000);
	 String xpath="(//h3[@class='layout-group-item-title'])[5]";
	 driver.findElement(By.xpath(xpath)).click( );
	 Thread.sleep(6000);
	 String xpath1="(//div[@id='iconExpandCollapse'])[15]";
	 driver.findElement(By.xpath(xpath1)).click( );
	 Thread.sleep(6000);
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 WebElement element = driver.findElement(By.xpath("//a[text()='Dynamic System Settings']"));
	 js.executeScript("arguments[0].scrollIntoView();", element);
	 driver.findElement(By.xpath("//a[text()='Dynamic System Settings']")).click( );
	 Thread.sleep(6000);
	 driver.switchTo().frame(0);
	 int size = driver.findElements(By.tagName("iframe")).size();
	 System.out.println(size);
	 Thread.sleep(6000);
	 driver.findElement(By.xpath("(/html[1]/body[1]/div[2]/form[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[1]/th[2]/div[1]/span[1]/a[1])")).click( );
	 
	 Thread.sleep(6000);
	 driver.findElement(By.xpath("//input[@type='text'][@name='$PpyFilterCriteria_pgRepPgSubSectionpzViewInstancesB_pxResults_pzViewInstances_1$ppyColumnFilterCriteria$gpyPurpose2$ppySearchText']")).sendKeys("NBACampaignName");  
	 Thread.sleep(6000);
	 driver.findElement(By.xpath("//text()[.='Apply']/ancestor::button[1]")).click( );
	 Thread.sleep(6000);
	 driver.findElement(By.xpath("//div[contains(text(),'MCCM')]")).click( );
	 
	
	  driver.switchTo().defaultContent();
	  Thread.sleep(8000);
	  driver.switchTo().frame("PegaGadget1Ifr");
	    
	     Thread.sleep(6000); 
         WebElement element10 = driver.findElement(By.xpath("//input[@type='text'][@name='$PRH_1$ppySetting']"));
		 Thread.sleep(6000); 
		 element10.clear();
		 element10.sendKeys("NBABatchCampaign");  
	  
	  
	    
  	    Thread.sleep(6000);
	    driver.findElement(By.xpath("//button[text()='Save']")).click( );
		Thread.sleep(6000);
		 
		 driver.findElement(By.xpath("//*[@class='pi pi-close-circle']")).click( );
		 Thread.sleep(6000);
		 
		  driver.switchTo().defaultContent();
		  Thread.sleep(8000);
		  driver.switchTo().frame("PegaGadget0Ifr");
		
		 Thread.sleep(6000);
		 driver.findElement(By.xpath("/html[1]/body[1]/div[3]/form[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[1]/th[2]/div[1]/span[1]/a[1]")).click( );
		 Thread.sleep(6000);
	//	 driver.findElement(By.xpath("//a[text()='Clear Filter']")).click( );
	//	 Thread.sleep(6000);
	//	 driver.findElement(By.xpath("/html[1]/body[1]/div[3]/form[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[1]/th[2]/div[1]/span[1]/a[1]")).click( );
	//	 Thread.sleep(6000);
		// Thread.sleep(6000);
		  Thread.sleep(6000); 
	         WebElement element12 = driver.findElement(By.xpath("//input[@type='text'][@name='$PpyFilterCriteria_pgRepPgSubSectionpzViewInstancesB_pxResults_pzViewInstances_1$ppyColumnFilterCriteria$gpyPurpose2$ppySearchText']"));
			 Thread.sleep(6000); 
			 element12.clear();
			 element12.sendKeys("NotifyNonErrorList");  
		// driver.findElement(By.xpath("//input[@type='text'][@name='$PpyFilterCriteria_pgRepPgSubSectionpzViewInstancesB_pxResults_pzViewInstances_1$ppyColumnFilterCriteria$gpyPurpose2$ppySearchText']")).sendKeys("NotifyNonErrorList");  
	       Thread.sleep(6000);
		 driver.findElement(By.xpath("//text()[.='Apply']/ancestor::button[1]")).click( );
		 Thread.sleep(6000);
		 driver.findElement(By.xpath("//div[contains(text(),'MCCM')]")).click( );
		 
		 driver.switchTo().defaultContent();
		  Thread.sleep(8000);
		  driver.switchTo().frame("PegaGadget1Ifr");
		  
		    
		     Thread.sleep(6000); 
	         WebElement element11 = driver.findElement(By.xpath("//input[@type='text'][@name='$PRH_1$ppySetting']"));
			 Thread.sleep(6000); 
			 element11.clear();
			 element11.sendKeys("prafulla.rout@dxc.com");  
		  
		  
	  	    Thread.sleep(6000);
		    driver.findElement(By.xpath("//button[text()='Save']")).click( );
			Thread.sleep(6000);
			 
			 driver.findElement(By.xpath("//*[@class='pi pi-close-circle']")).click( );
			 Thread.sleep(6000);
			 
			 driver.findElement(By.xpath("//input[@type='text'][@name='$PpyDisplayHarness$ppySearchText']")).sendKeys("d_mccmsettings");  
			 Thread.sleep(6000); 
			 
			 driver.findElement(By.xpath("//*[@class='pi pi-search-2']")).click( );
			 Thread.sleep(6000);    
			 
			 driver.findElement(By.xpath("//a[text()='D_MCCMSettings']")).click( );
			 Thread.sleep(6000);
			 
			 driver.switchTo().defaultContent();
			  Thread.sleep(8000);
			  driver.switchTo().frame("PegaGadget1Ifr");
			 
			 
			 
			 driver.findElement(By.xpath("//*[@class='pi pi-caret-down margin-l-1x']")).click( );
			 Thread.sleep(6000);
			 
			
			 String xpath2 = "(//text()[.='Run']/ancestor::a[1])[2]";
			 WebElement element2 =  driver.findElement(By.xpath(xpath2));
		     Actions  action = new Actions(driver);
		     action.moveToElement(element2).click().build().perform();
		     Thread.sleep(6000);
		     
		
		     
		  	// driver.switchTo().defaultContent();
			//  Thread.sleep(8000);
			//  driver.switchTo().frame("EXPAND-OUTERFRAME");
		     String mainWindow=driver.getWindowHandle();
		     Set<String> set =driver.getWindowHandles();
		      // Using Iterator to iterate with in windows
		      Iterator<String> itr= set.iterator();
		      while(itr.hasNext())
		      {
		      String childWindow=itr.next();
		      // Compare whether the main windows is not equal to child window. If not equal, we will close.
		      if(!mainWindow.equals(childWindow)){
		      driver.switchTo().window(childWindow);

		     //Switching back to Parent Window  
		     //driver.switchTo().window(Parent_Window);  
			  
		     Thread.sleep(6000);
			 
			 driver.findElement(By.xpath("//input[@type='checkbox'][@name='$PD_pzRunRecord$ppxRunWindow$gTABTHREAD1$ppxRunParameters$ppyFlushAll']")).click( );
			 Thread.sleep(6000);
			 
			 Thread.sleep(6000);
			 driver.findElement(By.xpath("(//div[@class='pzbtn-mid'])[3]")).click( );
			 Thread.sleep(6000);
			 
             driver.close();
		     }
		      }
		     driver.switchTo().window(mainWindow);
		     
		     Thread.sleep(6000); 
             WebElement element3 = driver.findElement(By.xpath("//input[@type='text'][@name='$PpyDisplayHarness$ppySearchText']"));
			 Thread.sleep(6000); 
			 element3.clear();
			 element3.sendKeys("OverrideCampaign");  
			 
			 
			 Thread.sleep(6000); 
			 driver.findElement(By.xpath("//*[@class='pi pi-search-2']")).click( );
			 Thread.sleep(6000);  
			 
		
			 Thread.sleep(6000); 
			 driver.findElement(By.xpath("//a[text()='OverrideCampaignBlockers']")).click( );
			 Thread.sleep(6000); 

			 driver.switchTo().defaultContent();
			  Thread.sleep(8000);
			  driver.switchTo().frame("PegaGadget2Ifr");  
			 
			  Thread.sleep(8000);			 
			 driver.findElement(By.xpath("//*[@class='pi pi-caret-down margin-l-1x']")).click( );
			 Thread.sleep(6000);
			 
			
			 String xpath3 = "(//text()[.='Run']/ancestor::a[1])[2]";
			 WebElement element4 =  driver.findElement(By.xpath(xpath3));
		     Actions  action1 = new Actions(driver);
		     action1.moveToElement(element4).click().build().perform();
		     Thread.sleep(6000);
		    
			 //last part------------------------
		     
		 //    String mainWindow1=driver.getWindowHandle();
		//     Set<String> set1 =driver.getWindowHandles();
		//      // Using Iterator to iterate with in windows
		//      Iterator<String> itr1= set1.iterator();
		//      while(itr1.hasNext())
	//	      {
	//	      String childWindow1=itr1.next();
	//	      // Compare whether the main windows is not equal to child window. If not equal, we will close.
	//	      if(!mainWindow1.equals(childWindow1)){
		//      driver.switchTo().window(childWindow1);
//
	//	     //Switching back to Parent Window  
	//	     //driver.switchTo().window(Parent_Window);  
			  
		  
	//	     Thread.sleep(6000); 
     //        WebElement element5 = driver.findElement(By.xpath("//input[@type='text'][@name='$PD_pzRunRecord$ppxRunWindow$gTABTHREAD2$ppxRunParameters$ppxResults$l1$ppyValue']"));
	//		 Thread.sleep(6000); 
	//		 element5.clear();
	//		 element5.sendKeys("Yes"); 
			 
		
			 
	//		 Thread.sleep(6000);
	//		 driver.findElement(By.xpath("(//div[@class='pzbtn-mid'])[3]")).click( );
	//		 Thread.sleep(6000);
			 
	//		 //ready code -------------------------
			 
			//new code child close 
		     
		     // handling window in selenium-------------------------------------------------
		     //int sizee=driver.getWindowHandles().size();
		      //System.out.println(sizee);
		     //Set<String> windowHandles = driver.getWindowHandles();
		     //ArrayList<String> windowStrings = new ArrayList<>(windowHandles);
		     //String reqWindow = windowStrings.get(index);
		     //driver.switchTo().window(windowStrings.get(1));
			 
			// String mainWindow2=driver.getWindowHandle();
		     //Set<String> set2 =driver.getWindowHandles();
		     //int sizee=driver.getWindowHandles().size();
		      //System.out.println(sizee);
		      //Iterator<String> itr2= set2.iterator();
		     // while(itr2.hasNext())
		      //{
		     // String childWindow2=itr2.next();
		      // Compare whether the main windows is not equal to child window. If not equal, we will close.
		      //if(!mainWindow2.equals(childWindow2)){
		      //driver.switchTo().window(childWindow2);
		      //int sizee=driver.getWindowHandles().size();
		      //System.out.println(sizee);

		     //Switching back to Parent Window  
		     //driver.switchTo().window(Parent_Window);  
		     String winHandleBefore = driver.getWindowHandle();
		     for (String winHandle : driver.getWindowHandles()) {
		       // Switch to child window
		       driver.switchTo().window(winHandle);
		     }
			  
		     Thread.sleep(6000);
			 
		     Thread.sleep(6000); 
             WebElement element6 = driver.findElement(By.xpath("//input[@type='text'][@name='$PD_pzRunRecord$ppxRunWindow$gTABTHREAD2$ppxRunParameters$ppxResults$l1$ppyValue']"));
			 Thread.sleep(6000); 
			 element6.clear();
			 element6.sendKeys("Yes"); 
			 
			 Thread.sleep(6000);
			 driver.findElement(By.xpath("(//div[@class='pzbtn-mid'])[3]")).click( );
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
			 
			 
			 
			 
			 //int sizee1=driver.getWindowHandles().size();
		      //System.out.println(sizee1);
		    // Set<String> windowHandles1 = driver.getWindowHandles();
		     //ArrayList<String> windowStrings1 = new ArrayList<>(windowHandles1);
		     //String reqWindow = windowStrings.get(index);
		     //driver.switchTo().window(windowStrings1.get(1));
		     //driver.close();
			 //driver.switchTo().window(windowStrings.get(0));
			// driver.close();
			 //driver.switchTo().window(windowStrings.get(1));
			// driver.close();
			// driver.switchTo().window(windowStrings.get(0));
			 
			// String mainWindow3=driver.getWindowHandle();
		     //Set<String> set3 =driver.getWindowHandles();
		      // Using Iterator to iterate with in windows
		      //Iterator<String> itr3= set2.iterator();
		      //while(itr3.hasNext())
		      //{
		      //String childWindow3=itr3.next();
		      // Compare whether the main windows is not equal to child window. If not equal, we will close.
		      //if(!mainWindow3.equals(childWindow3)){
		     // driver.switchTo().window(childWindow3);
			 
            // driver.close();
		     // }
		      //}
		      //driver.switchTo().window(mainWindow3);
		      
		      //driver.close();
		     //}
		     // }
		     //driver.switchTo().window(mainWindow2);
			
		     
		     //////pega marketing stared ///
		     
		    
		      }
   
			      
		      
		        
		      
		      }
		      
		      
