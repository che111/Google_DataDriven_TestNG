package dd_testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dd_Core.testCore;
import dd_util.TestUtil;

public class TC_09Verify_User_able_login_to_Gmail extends testCore{
	@BeforeTest
	public void is_Skip()
	{
		if (!TestUtil.isExecutable("TC_09Verify_User_able_login_to_Gmail")) 
		{
			throw new SkipException("Skipping test because runmode is No");
		}
	}
	@Test(dataProvider="getdata")
	public void login(String username,String password )
	{  
		try
		{
			driver.get("https://mail.google.com");
			driver.findElement(By.xpath(object.getProperty("usernameGmail"))).sendKeys(username);
			driver.findElement(By.xpath(object.getProperty("nextButton"))).click();
			driver.findElement(By.xpath(object.getProperty("passwordGmail"))).sendKeys(password);
			driver.findElement(By.xpath(object.getProperty("loginButton"))).click();

			app_log.debug(" User LogIn on Gmail Account : "+username);
			System.out.println(" User LogIn on Gmail Account : "+username);


			Displayed(object.getProperty("compose"));
			Enabled(object.getProperty("compose"));
			isElementPresent(object.getProperty("compose"));
			System.out.println("");

			Displayed(object.getProperty("starred"));
			Enabled(object.getProperty("starred"));
			isElementPresent(object.getProperty("starred"));
			System.out.println("");

			Displayed(object.getProperty("Important"));
			Enabled(object.getProperty("Important"));
			isElementPresent(object.getProperty("Important"));
			System.out.println("");

			Displayed(object.getProperty("sentMail"));
			Enabled(object.getProperty("sentMail"));
			isElementPresent(object.getProperty("sentMail"));
			System.out.println("");

			Displayed(object.getProperty("dreafts"));
			Enabled(object.getProperty("dreafts"));
			isElementPresent(object.getProperty("dreafts"));
			System.out.println("");

			Displayed(object.getProperty("Personal"));
			Enabled(object.getProperty("Personal"));
			isElementPresent(object.getProperty("Personal"));
			System.out.println("");

			Displayed(object.getProperty("Travel"));
			Enabled(object.getProperty("Travel"));
			isElementPresent(object.getProperty("Travel"));
			System.out.println("");

			driver.findElement(By.xpath(object.getProperty("myloginIcon"))).click();
			driver.findElement(By.xpath(object.getProperty("logoutButton"))).click();

			System.out.println(" User LogOut on Gmail Account.."+username);
			app_log.debug("User Logout on Gmail Account..."+username);
		

		}catch (Throwable t)
		{    
			app_log.debug(t.getMessage());
			TestUtil.captureScreenshot();
			app_log.debug("Something is wrong we captured screenshot :"+t.getMessage());
		}

	}

	@DataProvider
	public Object[][] getdata()
	{
		return TestUtil.getData("SignInAllapps"); // in SignInAllapps execl sheet contains my gmail credentials.

	}
}
