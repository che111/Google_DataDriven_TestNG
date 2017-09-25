package dd_Core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import dd_util.ExcelReader;
import dd_util.TestUtil;

public class testCore {

	public static WebDriver driver = null;
	public static Logger app_log = Logger.getLogger("devpinoyLogger");
	public static Properties config = new Properties();
	public static Properties object = new Properties();
	public static ExcelReader excel = null;
	public static String captionName;

	@BeforeSuite
	public void init() throws IOException, InterruptedException {

		if (driver == null) {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "//src//dd_properties//config.properties");
			config.load(fis);
			fis = new FileInputStream(System.getProperty("user.dir") + "//src//dd_properties//object.properties");
			object.load(fis);

			// excel=new
			// ExcelReader(System.getProperty("user.dir")+"//src//testData.xlsx");
			excel = new ExcelReader(System.getProperty("user.dir") + "//src//Google_test_data.xlsx");

			// 1st step Create object of Web Driver
			if (config.getProperty("browser").equals("Firefox")) {
				System.setProperty("webdriver.firefox.bin", "D:\\my imp msg\\firefox.exe");
				System.setProperty("webdriver.gecko.driver",
						"G:\\java programs\\geckodriver-v0.17.0-win32\\geckodriver.exe");
				driver = new FirefoxDriver();
				ClearBrowserCache();
			} else if (config.getProperty("browser").equals("ie")) {

				System.setProperty("webdriver.ie.driver", "G:\\java programs\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				ClearBrowserCache();
			} else if (config.getProperty("browser").equals("Chrome")) {

				System.setProperty("webdriver.chrome.driver", "G:\\java programs\\chromedriver.exe");
				driver = new ChromeDriver();
				ClearBrowserCache();
			}

			driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
			LaunchSiteTest();
			// driver.get(config.getProperty("testsite"));//testsite=for Money
			// Control site used for LoginTest.java
			driver.manage().window().maximize();

		}
	}

	@AfterSuite
	public void finish() {
		// sending mail
		// System.out.println("Sending mail");
		// SendMailUsingAuthentication mail = new SendMailUsingAuthentication();
		// mail.postMail(SendMailUsingAuthentication.emailList,
		// SendMailUsingAuthentication.emailSubjectTxt,
		// SendMailUsingAuthentication.emailMsgTxt,
		// SendMailUsingAuthentication.emailFromAddress);

		System.out.println("Stopping Selenium server");
		driver.quit();
		// server.stop();
	}

	// for Google Test Case small function to open site in browser
	public void LaunchSiteTest() {
		try {
			driver.get(config.getProperty("testGooglesite"));

		} catch (Throwable t) {
			System.out.println("Web Site not reachable at this movement.... Try after some time...");
			TestUtil.captureScreenshot();
		}
	}

	public boolean isElementPresent(By by) {
		try {

			/*
			 * driver.findElement(By.xpath(locator));
			 * captionName=driver.findElement(By.xpath(locator)).getText();
			 * System.out.println(captionName+" Element is Present");
			 */
			boolean isEnabled = driver.findElement(by).isEnabled();

			boolean isDisplayed = driver.findElement(by).isDisplayed();

			if (isEnabled && isDisplayed) {
				return true;
			} else {
				return false;
			}
		} catch (Throwable t) {
			System.out.println(captionName + "Element not Present");
			TestUtil.captureScreenshot();
			return false;
		}
	}

	public boolean isElementPresent(String locator) {
		try {

			driver.findElement(By.xpath(locator));
			captionName = driver.findElement(By.xpath(locator)).getText();
			System.out.println(captionName + " Element is Present");
			return true;
		} catch (Throwable t) {
			System.out.println(captionName + "Element not Present");
			TestUtil.captureScreenshot();
			return false;
		}
	}

	public boolean Enabled(String locator) {
		try {
			driver.findElement(By.xpath(locator)).isEnabled();
			captionName = driver.findElement(By.xpath(locator)).getText();
			System.out.println(captionName + " is Enabled ");
			return true;
		} catch (Throwable t) {
			System.out.println(captionName + " is disabled ");
			TestUtil.captureScreenshot();
			return false;
		}

	}

	public boolean Displayed(String locator) {
		try {
			driver.findElement(By.xpath(locator)).isDisplayed();
			captionName = driver.findElement(By.xpath(locator)).getText();
			System.out.println(captionName + " is Displayed ");
			return true;
		} catch (Throwable t) {
			System.out.println(captionName + " is hidden mode ");
			TestUtil.captureScreenshot();
			return false;
		}
	}

	public void ClearBrowserCache() throws InterruptedException {
		driver.manage().deleteAllCookies(); // delete all cookies
		Thread.sleep(5000); // wait 5 seconds to clear cookies.
	}
}
