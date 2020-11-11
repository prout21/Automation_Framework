package Mccm.PegaTestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Mccm.PegaMain.HomePage;
import Mccm.PegaMain.PegaMarketPage;
import Mccm.QAUtil.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	
	public TestBase()
	{
		try {
			prop=new Properties();
			String projectPath = System.getProperty("user.dir");
	
					
	FileInputStream ip=new FileInputStream(projectPath+"/src/main/java/ConfigPega/Config.properties");
	      prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}      
	
	}

    public static void initialization() {
    	String browserName = prop.getProperty("browser");
    	String chromedriverPath = prop.getProperty("chromedriver.dir");
    	if(browserName.equals("chrome")) {
    	System.setProperty("webdriver.chrome.driver", chromedriverPath+"/chromedriver.exe");  
    	driver = new ChromeDriver();
    	
    	}
    	
      driver.manage().window().maximize();
      driver.manage().deleteAllCookies();
      driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
      driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
      driver.get(prop.getProperty("url"));
     
    }
    
 }
