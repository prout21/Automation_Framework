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

public class PageAppEndToEndFlow {
   
   @Test  
    public void RunNBACampaignEndToEndFlow() throws InterruptedException, AWTException {
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\prout21\\Downloads\\chromedriver_win32\\chromedriver.exe");  
	 WebDriver driver = new ChromeDriver();
	 driver.get("http://mccm-191102761.eu-central-1.elb.amazonaws.com:8573/prweb");
	 driver.findElement(By.xpath("//input[@id='txtUserID']")).sendKeys("prafulla" );
	 driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("rules" );
	 driver.findElement(By.xpath("//span[@class='loginButtonText']")).click( );
	 Thread.sleep(8000);
	 driver.findElement(By.xpath("//a[@id='appview-nav-toggle-one']")).click( );
	 Thread.sleep(8000);
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
	 element10.sendKeys("NBABatchCampaign6");  	 
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
	 WebElement element12 = driver.findElement(By.xpath("//input[@type='text'][@name='$PpyFilterCriteria_pgRepPgSubSectionpzViewInstancesB_pxResults_pzViewInstances_1$ppyColumnFilterCriteria$gpyPurpose2$ppySearchText']"));
	 Thread.sleep(6000); 
	 element12.clear();
	 element12.sendKeys("NotifyNonErrorList");  
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
	    String mainWindow=driver.getWindowHandle();
		 Set<String> set =driver.getWindowHandles();
		 Iterator<String> itr= set.iterator();
		  while(itr.hasNext())
		  {
		 String childWindow=itr.next();
		 if(!mainWindow.equals(childWindow)){
		 driver.switchTo().window(childWindow);  
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
		     String winHandleBefore = driver.getWindowHandle();
		     for (String winHandle : driver.getWindowHandles()) {
		     driver.switchTo().window(winHandle);
		     }
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
			driver.close();
			Thread.sleep(6000);
			driver.switchTo().window(winHandleBefore);
					     
//******PEGA Marketing StarTed  Here  **************************************************************//
		
			String xpath5 = "(//i[@class='pi pi-caret-down'])[2]";
			WebElement element7 =  driver.findElement(By.xpath(xpath5));
			Actions  action3 = new Actions(driver);
			action3.moveToElement(element7).click().build().perform();
			Thread.sleep(6000);
			String  s1 = "(//span[@class='menu-item-title'])[5]";
			 driver.findElement(By.xpath(s1)).click( );
			 Thread.sleep(8000);
			 String mainWindow3=driver.getWindowHandle();
			 System.out.println(mainWindow3);
			 Set<String> set3 =driver.getWindowHandles();
			Iterator<String> itr3= set3.iterator();
			 while(itr3.hasNext())
			 {
			 String childWindow3=itr3.next();
			 if(!mainWindow.equals(childWindow3)){
			 driver.switchTo().window(childWindow3);
			  Thread.sleep(8000);
				 driver.findElement(By.xpath("//a[@id='appview-nav-toggle-one']")).click( );
				 Thread.sleep(8000);
				 driver.findElement(By.xpath("//span[text()='Campaigns']")).click( );
				 Thread.sleep(8000);
				int size1 = driver.findElements(By.tagName("iframe")).size();
			 System.out.println(size1);
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
			 int size2 = driver.findElements(By.tagName("iframe")).size();
			 System.out.println(size2);
			 driver.switchTo().frame(2);
			 System.out.println("i am ineer frame no ");
			 Thread.sleep(8000);
			  driver.findElement(By.xpath("//input[@type='text'][@name='$PpyWorkPage$ppyLabel']")).sendKeys("NBABatchCampaign6");
			 Thread.sleep(8000);
			 driver.findElement(By.xpath("//span[text()='Build']")).click( );
			 Thread.sleep(8000);
			 String xpath4 = "/html[1]/body[1]/div[2]/form[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/span[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/button[1]";
			 driver.findElement(By.xpath(xpath4)).click( );
			 Thread.sleep(8000);
			    JavascriptExecutor js1 = (JavascriptExecutor) driver;
				 WebElement element1 = driver.findElement(By.xpath("//span[text()='Test Channel']"));
				 js1.executeScript("arguments[0].scrollIntoView();", element1);
				 driver.findElement(By.xpath("/html[1]/body[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[20]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/span[1]/button[1]")).click( );
				 Thread.sleep(6000);
				 driver.findElement(By.xpath("//button[text()='Apply']")).click( );
				 Thread.sleep(6000);
				 driver.findElement(By.xpath("/html[1]/body[1]/div[3]/form[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/span[2]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/button[1]")).click( );
				 Thread.sleep(6000);						 
				 JavascriptExecutor js2 = (JavascriptExecutor) driver;
				 WebElement element8 = driver.findElement(By.xpath("//span[text()='NBATestSegment']"));
				 js2.executeScript("arguments[0].scrollIntoView();", element8);
				 driver.findElement(By.xpath("/html[1]/body[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/span[1]/button[1]")).click( );
				 Thread.sleep(6000);
				 driver.findElement(By.xpath("//button[text()='Apply']")).click( );
				 Thread.sleep(6000);			
				 JavascriptExecutor js3 = (JavascriptExecutor) driver;
				 WebElement element9 = driver.findElement(By.xpath("//div[text()='Engagement']"));
				 js3.executeScript("arguments[0].scrollIntoView();", element9);	
				 driver.findElement(By.xpath("/html[1]/body[1]/div[3]/form[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/span[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/button[1]")).click( );
				 Thread.sleep(6000);
				 WebElement checkbox =  driver.findElement(By.xpath("//input[@type='checkbox'][@name='$PpyWorkPage$pEnableScheduling']"));
				 checkbox.click( );
				 WebElement radio1 =  driver.findElement(By.xpath("//label[text()='Recurring']"));
				 radio1.click( );								 
			  	 Thread.sleep(6000);
				  WebElement checkbox1 =  driver.findElement(By.xpath("//input[@type='checkbox'][@name='$PpyWorkPage$pProgramConfiguration$pDirectDBTemplate']"));
				  checkbox1.click( );		
			      Thread.sleep(6000);
				   driver.findElement(By.xpath("//text()[.='Configure template']/ancestor::button[1]")).click( );
				  Thread.sleep(6000);
				  JavascriptExecutor js4 = (JavascriptExecutor) driver;
				  WebElement element5 = driver.findElement(By.xpath("//span[text()='MCCM LC Outbound']"));
				  js4.executeScript("arguments[0].scrollIntoView();", element5);	
				  Thread.sleep(6000);
				   int amount = driver.findElements(By.tagName("iframe")).size();
					 System.out.println(amount);
				  driver.findElement(By.xpath("//span[text()='MCCM LC Outbound']")).click( );
			       Thread.sleep(6000);	
			   		 driver.findElement(By.xpath("/html[1]/body[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/span[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/span[1]/button[1]")).click( );
			    Thread.sleep(6000);
			    boolean searchIconPresence = driver.findElement(By.xpath("//button[text()='Add template']")).isDisplayed();
			    boolean searchIconEnabled = driver.findElement(By.xpath("//button[text()='Add template']")).isEnabled();

			    if (searchIconPresence==true && searchIconEnabled==true)

			    {
			   	 System.out.println("i am in if----------------------");
			   	 Thread.sleep(6000);
			   	 WebElement element13 = driver.findElement(By.xpath("//button[text()='Add template']"));
			   	 JavascriptExecutor executor3 = (JavascriptExecutor)driver;
			   	 executor3.executeScript("arguments[0].click();", element13);
			    Thread.sleep(6000);
			    System.out.println("i am in if---search-------------------");
			      }
				  Thread.sleep(6000);
				  driver.findElement(By.xpath("//button[text()='Apply']")).click( );
				 Thread.sleep(6000);
				 driver.findElement(By.xpath("//button[text()='Save']")).click( );
				 Thread.sleep(6000);
				 driver.findElement(By.xpath("//button[text()='Run']")).click( );
				 Thread.sleep(6000);
				 driver.findElement(By.xpath("//button[text()='Confirm']")).click( );
				 Thread.sleep(6000);
				 driver.findElement(By.xpath("//*[@class='pi pi-refresh']")).click( );
				 Thread.sleep(6000);
				 for(int i=0;i<70;i++){
					 Thread.sleep(6000);
				}
			     driver.findElement(By.xpath("//*[@class='pi pi-refresh']")).click( );
				 JavascriptExecutor js5 = (JavascriptExecutor) driver;
				 WebElement element14 = driver.findElement(By.xpath("//h2[text()='Run schedule']"));
				 js5.executeScript("arguments[0].scrollIntoView();", element14);	
					    
		      }
		   
          }      
      }	  
		        
   }  
		      
		      
		      
