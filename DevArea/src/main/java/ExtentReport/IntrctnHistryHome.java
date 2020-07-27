package ExtentReport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Mccm.Pega.Outbound.PegaSubClass.HomePageDetails;
import Mccm.Pega.Outbound.PegaTestBase.TestBase;

public class IntrctnHistryHome extends TestBase {
	//page factory - OR:
	
	@FindBy(xpath="//a[@id='appview-nav-toggle-one']")
	WebElement Homepage;
	@FindBy(xpath="(//i[@class='pi pi-caret-down'])[2]")
	WebElement Pegalunch;

	 public IntrctnHistryHome( ) {
    	PageFactory.initElements(driver, this);
    }
    
// 	
//   public PegaMarketIntrctnHistry Pegamrklunch()throws InterruptedException {
//	
//	     Actions  action = new Actions(driver);
//	     action.moveToElement(Pegalunch).click().build().perform();
//	     return new PegaMarketIntrctnHistry();
//   }


         
 
}
