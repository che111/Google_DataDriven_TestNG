package dd_testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import dd_Core.testCore;
import dd_util.TestUtil;

public class TC_01GoogleWebpageLaunchTest extends testCore{

	public static boolean searchBox;
	@BeforeTest
	public void is_Skip()
	{
		if (!TestUtil.isExecutable("TC_01GoogleWebpageLaunchTest")) 
		{
			throw new SkipException("Skipping test because runmode is No");
		}
	}
	@Test(priority=1, dataProvider="getData")
	public void googleLaunchVerify(String ActualTitle)
	{   
		System.out.println("----------------------TC_0001------------------------");

		app_log.debug("googleLaunchVerify() method is executing");
		try
		{
			//verified the Page Title
			String actualPageTitle = ActualTitle;
		
			String expectedPageTitle= driver.getTitle();
			
			if(actualPageTitle.equals(expectedPageTitle)){
				
				System.out.println("Welcome to "+actualPageTitle);
				
			}else{
				
				System.out.println("Failed to Launched into Google Page !");
			}

			
			Assert.assertEquals(actualPageTitle, expectedPageTitle);
			
			// verify the Google Page Web Elements
			
			searchBox = isElementPresent(By.xpath(object.getProperty("searchBox")));
			
			
			if(searchBox){
				
				System.out.println("All web Elements are Present on the Webpage");
			}else{
				
				System.out.println("All web elements does not displayed on the web page");
			}
			
			/*Enabled(object.getProperty("searcshbox"));
			System.out.print(" searchbox");
			Displayed(object.getProperty("searchbox"));
			System.out.print(" searchbox");
			isElementPresent(object.getProperty("searchbox"));
			System.out.print(" searchbox");
			driver.findElement(By.xpath(object.getProperty("searchbox"))).click();
			System.out.println(" searchbox is Editiable ");
			System.out.println("");*/

			// verify the Google Search Button   imFeelingLuckyButton
			/*System.out.print(" googleSearchButton");
			Enabled(object.getProperty("googleSearchButton"));
			System.out.print(" googleSearchButton");
			Displayed(object.getProperty("googleSearchButton"));
			System.out.print(" googleSearchButton");
			isElementPresent(object.getProperty("googleSearchButton"));
			System.out.println("");

			// verify the I'm Feeling Lucky Button
			System.out.print(" imFeelingLuckyButton");
			Enabled(object.getProperty("imFeelingLuckyButton"));
			System.out.print(" imFeelingLuckyButton");
			Displayed(object.getProperty("imFeelingLuckyButton"));
			System.out.print(" imFeelingLuckyButton");
			isElementPresent(object.getProperty("imFeelingLuckyButton"));*/


			
		}
		catch(Throwable t)
		{
			
			System.out.println("Error!: "+t.getMessage());
			
			/*System.out.println("GoogleLaunchTest Failed. ");
			//app_log.debug("Google Website Launch Failed...");
			// TestUtil.captureScreenshot();
			app_log.debug("Something is wrong we captured screenshot :"+t.getMessage());
*/
		}


	}



	@DataProvider
	public Object[][] getData()
	{
		return TestUtil.getData("TC_01GoogleWebpageLaunchTest");
		
	}

}
