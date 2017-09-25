package dd_testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dd_Core.testCore;
import dd_util.TestUtil;

public class TC_04Verify_User_is_able_to_Sign_In_Allapps extends testCore {
	@BeforeTest
	public void is_Skip()
	{
		if (!TestUtil.isExecutable("TC_04Verify_User_is_able_to_Sign_In_Allapps")) 
		{
		   throw new SkipException("Skipping test because runmode is No");
	    }
	}
	@Test(dataProvider="getdata")
	public void login(String username,String password )
	{  try{
		//WebDriverWait wait = new WebDriverWait(driver,70l);
		
		driver.findElement(By.xpath(object.getProperty("googleAppsicon"))).click();
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("gmailApp"))).click();
		driver.findElement(By.xpath(object.getProperty("gmailApp"))).click();
		driver.findElement(By.xpath(object.getProperty("singnInGmail"))).click();
		driver.findElement(By.xpath(object.getProperty("usernameGmail"))).sendKeys(username);
		driver.findElement(By.xpath(object.getProperty("nextButton"))).click();
		driver.findElement(By.xpath(object.getProperty("passwordGmail"))).sendKeys(password);
		driver.findElement(By.xpath(object.getProperty("loginButton"))).click();
		
		System.out.println("User Successfully logged in: "+username); 
		app_log.debug("User Successfully logged in: "+username); 
		driver.findElement(By.xpath(object.getProperty("myloginIcon"))).click();
		driver.findElement(By.xpath(object.getProperty("logoutButton"))).click();
		System.out.println("User Successfully loggedOut by clicked on logoutButton "+username);
		app_log.debug("User Successfully loggedOut by clicked on logoutButton "+username); 
		
	
		
	}catch (Throwable t)
	{	
		Assert.fail(t.getMessage());
		TestUtil.captureScreenshot();
		app_log.debug("Something is wrong we captured screenshot :"+t.getMessage());
	}
	
	}

	@DataProvider
	public Object[][] getdata()
	{
		return TestUtil.getData("SignInAllapps");
		
	}
}
