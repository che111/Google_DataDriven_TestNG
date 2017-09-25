package dd_testcases;

import java.util.List;

import org.apache.poi.hwpf.model.FootnoteReferenceDescriptor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dd_Core.testCore;
import dd_util.TestUtil;

public class TC_07Verify_Google_Search_Functionality extends testCore {
	@BeforeTest
	public void is_Skip()
	{
		if (!TestUtil.isExecutable("TC_07Verify_Google_Search_Functionality")) 
		{
			throw new SkipException("Skipping test because runmode is No");
		}
	}
	@Test
	public void searchFunctionality()
	{   
		try
		{   
			driver.findElement(By.cssSelector(object.getProperty("SearchboxFunctionality"))).sendKeys("amitabh bachchan ");
		
			driver.findElement(By.xpath(object.getProperty("SearchFunctionalityButton"))).click();
			
			
			List<WebElement> ele=driver.findElements(By.xpath(object.getProperty("nameconatinsinLinks")));
			
			app_log.debug("Google Search functionality showing the results of search keywords conatins --> amitabh bachchan ");
			
			System.out.print(Enabled(object.getProperty("nameconatinsinLinks")));
			System.out.print(Displayed(object.getProperty("nameconatinsinLinks")));
			System.out.print(isElementPresent(object.getProperty("nameconatinsinLinks")));

			String actualstr;
		    for (int i = 0; i < ele.size(); i++) 
			{
		    	
		    	actualstr=ele.get(i).getText();
		        
		    	
				Assert.assertEquals(actualstr, ele.get(i).getText());
				System.out.println(ele.get(i).getText());
				
	        }
			
		  
			
		}catch (Throwable t)
		{
			app_log.debug(t.getMessage());
			TestUtil.captureScreenshot();
			app_log.debug("Something is wrong we captured screenshot :"+t.getMessage());

		}

}
}
