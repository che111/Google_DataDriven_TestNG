package dd_testcases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dd_Core.testCore;
import dd_util.TestUtil;

public class TC_06Verify_openandColse_the_Browser extends testCore {
	@BeforeTest
	public void is_Skip()
	{
		if (!TestUtil.isExecutable("TC_06Verify_openandColse_the_Browser")) 
		{
			throw new SkipException("Skipping test because runmode is No");
		}
	}
	@Test
	public void VerifOpenAndCloseBrowser()
	{   
		try
		{  app_log.debug("Appliaction open.");
			System.out.println("Browser Open ");
			driver.quit();
			System.out.println("Browser Closed. ");
			app_log.debug("Appliaction closed.");
			
		}catch (Throwable t)
		{
			app_log.debug(t.getMessage());
			TestUtil.captureScreenshot();
			app_log.debug("Something is wrong we captured screenshot :"+t.getMessage());

		}

}
}
