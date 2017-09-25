package dd_testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dd_Core.testCore;
import dd_util.TestUtil;

public class TC_03AllGoogleappsLaunchTest extends testCore{
	
	@BeforeTest
	public void is_Skip()
	{
		if (!TestUtil.isExecutable("TC_03AllGoogleappsLaunchTest")) 
		{
			throw new SkipException("Skipping test because runmode is No");
		}
	}
	@Test
	public void VerifygoogleappsLaunch()
	{   
		try
		{  
			//myaccountApp
			driver.findElement(By.xpath(object.getProperty("googleAppsicon"))).click();
			driver.findElement(By.xpath(object.getProperty("myaccountApp"))).click();
			driver.findElement(By.xpath(object.getProperty("myaccountPagelElementText"))).click();
			System.out.println(driver.getTitle());
			driver.navigate().back();
			
			//SearchApp
			driver.findElement(By.xpath(object.getProperty("googleAppsicon"))).click();
			driver.findElement(By.xpath(object.getProperty("SearchApp"))).click();
			driver.findElement(By.xpath(object.getProperty("searchPagelElementText"))).click();
			System.out.println(driver.getTitle());
			driver.navigate().back();
			
			//mapsApp
			driver.findElement(By.xpath(object.getProperty("googleAppsicon"))).click();
			driver.findElement(By.xpath(object.getProperty("mapsApp"))).click();
			driver.findElement(By.xpath(object.getProperty("searchdirectionPagelElementText"))).click();
			System.out.println(driver.getTitle());
			driver.navigate().back();
			
			//youTubeApp
			driver.findElement(By.xpath(object.getProperty("googleAppsicon"))).click();
			driver.findElement(By.xpath(object.getProperty("youTubeApp"))).click();
			driver.findElement(By.xpath(object.getProperty("youTubePagelElementText"))).click();
			System.out.println(driver.getTitle());
			driver.navigate().back();
			
			//playApp
			driver.findElement(By.xpath(object.getProperty("googleAppsicon"))).click();
			driver.findElement(By.xpath(object.getProperty("playApp"))).click();
			driver.findElement(By.xpath(object.getProperty("googlePlayPagelElementText"))).click();
			System.out.println(driver.getTitle());
			driver.navigate().back();
			
			//newsApp
			driver.findElement(By.xpath(object.getProperty("googleAppsicon"))).click();
			driver.findElement(By.xpath(object.getProperty("newsApp"))).click();
			driver.findElement(By.xpath(object.getProperty("googleNewsPagelElementText"))).click();
			System.out.println(driver.getTitle());
			driver.navigate().back();
			
			//gmailApp
			driver.findElement(By.xpath(object.getProperty("googleAppsicon"))).click();
			driver.findElement(By.xpath(object.getProperty("gmailApp"))).click();
			driver.findElement(By.xpath(object.getProperty("gmailPagelElementText"))).click();
			System.out.println(driver.getTitle());
			driver.navigate().back();
			
			//driveApp
			driver.findElement(By.xpath(object.getProperty("googleAppsicon"))).click();
			driver.findElement(By.xpath(object.getProperty("driveApp"))).click();
			driver.findElement(By.xpath(object.getProperty("drivePagelElementText"))).click();
			System.out.println(driver.getTitle());
			driver.navigate().back();
			
			//calenderApp
			driver.findElement(By.xpath(object.getProperty("googleAppsicon"))).click();
			driver.findElement(By.xpath(object.getProperty("calenderApp"))).click();
			driver.findElement(By.xpath(object.getProperty("calenderPagelElementText"))).click();
			System.out.println(driver.getTitle());
			driver.navigate().back();
			
			//googlePlusApp
			driver.findElement(By.xpath(object.getProperty("googleAppsicon"))).click();
			driver.findElement(By.xpath(object.getProperty("googlePlusApp"))).click();
			driver.findElement(By.xpath(object.getProperty("googlePlusPagelElementText"))).click();
			System.out.println(driver.getTitle());
			driver.navigate().back();
			
			
			//googleTranslateApp
			driver.findElement(By.xpath(object.getProperty("googleAppsicon"))).click();
			driver.findElement(By.xpath(object.getProperty("googleTranslateApp"))).click();
			driver.findElement(By.xpath(object.getProperty("googleTranslatePagelElementText"))).click();
			System.out.println(driver.getTitle());
			driver.navigate().back();
			
			//googlePhotosApp
			driver.findElement(By.xpath(object.getProperty("googleAppsicon"))).click();
			driver.findElement(By.xpath(object.getProperty("googlePhotosApp"))).click();
			driver.findElement(By.xpath(object.getProperty("googlePhotosPagelElementText"))).click();
			System.out.println(driver.getTitle());
			driver.navigate().back();
			
			
        
		}catch (Throwable t)
		{
        	Assert.fail(t.getMessage());
			TestUtil.captureScreenshot();
			app_log.debug("Something is wrong we captured screenshot :"+t.getMessage());

		}
	}



}
