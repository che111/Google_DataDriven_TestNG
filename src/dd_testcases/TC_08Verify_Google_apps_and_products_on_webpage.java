package dd_testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dd_Core.testCore;
import dd_util.TestUtil;

public class TC_08Verify_Google_apps_and_products_on_webpage extends testCore{
	@BeforeTest
	public void is_Skip()
	{
		if (!TestUtil.isExecutable("TC_08Verify_Google_apps_and_products_on_webpage")) 
		{
			throw new SkipException("Skipping test because runmode is No");
		}
	}
	@Test
	public void verify_Google_apps_products_on_webpage()
	{   
		try
		{
			driver.navigate().to("https://www.google.co.in/intl/en/about/products/");
			String startpath = object.getProperty("googleAppsProductspPath1");
			String endtpath=object.getProperty("googleAppsProductspPath2");
			int count =0;

			for (int i = 1; i<=71; i++)
			{
				String finalpath = driver.findElement(By.xpath(startpath+i+endtpath)).getText();
				String finalpath1 = startpath+i+endtpath;
				System.out.println("Google App/product name is "+finalpath);
				Displayed(finalpath1);
				Enabled(finalpath1);
				isElementPresent(finalpath1);
				System.out.println();
				
				count++;
			}

			System.out.println( "Total number of Google Apps/products on webpage is :"+count);
			app_log.debug( "Total number of Google Apps/products on webpage is :" +count);
			
		}catch(Throwable t)
		{
			Assert.fail(t.getMessage());
			app_log.debug(t.getMessage());
			TestUtil.captureScreenshot();
			app_log.debug("Something is wrong we captured screenshot :");

		}
	}


}
