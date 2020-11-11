package Mccm.ScreenShots;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.apache.commons.io.FileUtils;



import Mccm.PegaTestBase.TestBase;

public class ScreenCaptured extends TestBase{
   
	public void screen() {
	
	      try {
	            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	            //The below method will save the screen shot in destination directory with name "screenshot.png"
	             FileHandler.copy(scrFile, new File("C:/Users/prout21/eclipse-workspace/MCCM/Screenshots/screenshot.png"));
	         } catch (IOException e) {
	             e.printStackTrace();
	            }
} 

}
