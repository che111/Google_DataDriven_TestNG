package dd_testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dd_Core.testCore;
import dd_util.TestUtil;

public class LoginTest extends testCore {
	
	@BeforeTest
	public void is_Skip()
	{
		if (!TestUtil.isExecutable("LoginTest")) 
		{
		   throw new SkipException("Skipping test because runmode is No");
	    }
	}
	
	@Test(dataProvider="getdata")
	public void login(String username,String password )
	{  try{
		driver.findElement(By.xpath(object.getProperty("signinoption"))).click();
		driver.findElement(By.xpath(object.getProperty("username"))).sendKeys(username);
		driver.findElement(By.xpath(object.getProperty("password"))).sendKeys(password);
		driver.findElement(By.xpath(object.getProperty("signin"))).click();
		
		
		//app_log.debug("User Successfully logged in: "+username);     
	}catch (Throwable t)
	{	
		Alert alert=driver.switchTo().alert();
	    alert.accept();
	    System.out.println(alert.getText());
		TestUtil.captureScreenshot();
		//app_log.debug("Something is wrong we captured screenshot :"+t.getMessage());
	}
	
	}

	@DataProvider
	public Object[][] getdata()
	{
		return TestUtil.getData("LoginTest");
		
	}
}
