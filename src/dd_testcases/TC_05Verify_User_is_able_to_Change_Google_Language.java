package dd_testcases;

import org.apache.xerces.util.SynchronizedSymbolTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dd_Core.testCore;
import dd_util.TestUtil;

public class TC_05Verify_User_is_able_to_Change_Google_Language extends testCore{

	@BeforeTest
	public void is_Skip()
	{
		if (!TestUtil.isExecutable("TC_05Verify_User_is_able_to_Change_Google_Language")) 
		{
			throw new SkipException("Skipping test because runmode is No");
		}
	}
	@Test
	public void googleLanguage()
	{  try{
		
		driver.findElement(By.xpath(object.getProperty("googleHindiLanguageElement"))).click();

		System.out.print("Sign-In Button in Hindi");
		isElementPresent(object.getProperty("signinHindi"));
		System.out.print("Sign-In Button in Hindi");
		Displayed(object.getProperty("signinHindi"));
		System.out.print("Sign-In Button in Hindi");
		Enabled(object.getProperty("signinHindi"));
		System.out.println("");
		System.out.print("Search Button in Hindi");
		isElementPresent(object.getProperty("searchButtonHindi"));
		System.out.print("Search Button in Hindi");
		Displayed(object.getProperty("searchButtonHindi"));
		System.out.print("Search Button in Hindi");
		Enabled(object.getProperty("searchButtonHindi"));
        System.out.println("");
		System.out.print("filling Lucky Button in Hindi");
		isElementPresent(object.getProperty("fillingLuckyButtonHindi"));
		System.out.print("filling Lucky Button in Hindi");
		Displayed(object.getProperty("fillingLuckyButtonHindi"));
		System.out.print("filling Lucky Button in Hindi");
		Enabled(object.getProperty("fillingLuckyButtonHindi"));
		app_log.debug("Google Language is changed through the selenium script.");
		
		

	}catch (Throwable t)
	{	
		Assert.fail(t.getMessage());
	    TestUtil.captureScreenshot();
		app_log.debug("Something is wrong we captured screenshot :"+t.getMessage());
	}

	}
}
