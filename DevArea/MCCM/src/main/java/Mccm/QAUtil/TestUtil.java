package Mccm.QAUtil;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Mccm.PegaTestBase.TestBase;

public class TestUtil extends TestBase {
	
	private static final By By = null;
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	
	public void WindowHandling()
	{
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
	      }
	   }
	}
	
	public void SwitcToFrame(int x)
	{
		driver.switchTo().frame(x);
	}
	
	public void SwitchToFrame(String x)
	{
		driver.switchTo().frame(x);
	}
	
	public void SwitcTodefaultContent()
	{
		driver.switchTo().defaultContent();
	}
	
public void RobertAction() throws AWTException
{
	Actions actions = new Actions(driver);

    Robot robot = new Robot();

    robot.mouseMove(50,50);

    actions.click().build().perform();

    robot.mouseMove(200,70);

    actions.click().build().perform();
}

public void JavascriptExecutor(WebElement webelement)
{
	    JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebElement element1 = webelement;
		 
		 js.executeScript("arguments[0].scrollIntoView();", element1);
	
}

public void ActionMouseMov(WebElement webelement)
{
	    WebElement element2 =  webelement;
        Actions  action = new Actions(driver);
        action.moveToElement(element2).click().build().perform();


}

}
	
