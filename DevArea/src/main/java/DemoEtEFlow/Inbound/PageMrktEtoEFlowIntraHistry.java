package DemoEtEFlow.Inbound;

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

public class PageMrktEtoEFlowIntraHistry  {
 



@Test  
     public void NBABatchCampaignInboundSuccessfull() throws InterruptedException, AWTException {
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
	 String mainWindow5=driver.getWindowHandle();
	 System.out.println(mainWindow5);
	 // It returns no. of windows opened by WebDriver and will return Set of Strings
	 Set<String> set5 =driver.getWindowHandles();
	 // Using Iterator to iterate with in windows
	 Iterator<String> itr5= set5.iterator();
	 while(itr5.hasNext())
	 {
		 String childWindow3=itr5.next();
		 // Compare whether the main windows is not equal to child window. If not equal, we will close.
		 if(!mainWindow5.equals(childWindow3)){
			 driver.switchTo().window(childWindow3);

			 /////**laptop 
			 //	  Thread.sleep(8000);
			 //   String s5 = "(//span[@class='menu-item-icon-imageclass pi pi-megaphone'])[1]";
			 //     driver.findElement(By.xpath(s5)).click();
			 /////**laptop  
			 Thread.sleep(8000);
			 driver.findElement(By.xpath("//i[@class='icons pi pi-clipboard-check pi-white']")).click( );
			 Thread.sleep(8000);
			 //   driver.findElement(By.xpath("//*[@name='pyPortalHeader_pyDisplayHarness_8']")).click( );
			 driver.findElement(By.xpath("//span[text()='Interaction History']")).click( );
			 Thread.sleep(8000);

			 driver.switchTo().frame("PegaGadget1Ifr");	

			 Thread.sleep(8000);
			 driver.findElement(By.xpath("//span[text()='Recent interactions']")).click( );
  
}
}
}
}