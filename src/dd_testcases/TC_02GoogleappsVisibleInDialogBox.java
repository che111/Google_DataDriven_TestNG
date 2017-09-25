package dd_testcases;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dd_Core.testCore;
import dd_util.TestUtil;

public class TC_02GoogleappsVisibleInDialogBox extends testCore {


	@BeforeTest
	public void is_Skip()
	{
		if (!TestUtil.isExecutable("TC_02GoogleappsVisibleInDialogBox")) 
		{
			throw new SkipException("Skipping test because runmode is No");
		}
	}
	@Test(priority=2)
	public void Verifygoogleappsvisible()
	{   
		System.out.println("----------------------TC_0002------------------------");
		try
		{
			driver.findElement(By.xpath(object.getProperty("googleAppsicon"))).click();
			System.out.println("***************** Display all Google Apps within DropDown List *********");
			String Xp_Start= object.getProperty("allGoogleAppsStartPath");
			String Xp_End=object.getProperty("allGoogleAppsEndPath");
			for (int row=1;row<=12;row++)
			{	
				String str=driver.findElement(By.xpath(Xp_Start+row+Xp_End)).getText();
				System.out.println(str);
			}
		
		}catch (Throwable t)
		{
			System.out.println(t.getMessage());
			TestUtil.captureScreenshot();
			app_log.debug("Something is wrong we captured screenshot :"+t.getMessage());

		}
	}
}
