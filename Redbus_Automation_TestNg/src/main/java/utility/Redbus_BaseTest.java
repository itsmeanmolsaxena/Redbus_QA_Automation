package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import ScreenshotJar.Screenshots;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Redbus_BaseTest {

	public static WebDriver driver;
	// Remote web driver to run parallel cases on docker
	public static RemoteWebDriver remotedriver;

	public static ExtentReports extent;
	public static ExtentTest extentTest;

	public static ExcelDataReaderFile reader = null;

	public static Properties prop = new Properties();
	public static File file = new File("./Global_information/config.properties");
	public static FileInputStream fis = null;

	// Excel File Test Data Reader
	// public static File reader = new File(".//Exit Test//TestData.xlsx");

	// Log4j logger
	public final static Logger logger = Logger.getLogger(Redbus_BaseTest.class);

	// Creating and using properties file
	static {

		// Exception Handling for FIS
		try {

			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {

			logger.error(e.getMessage());
		}

		// Exception Handling for Prop
		try {

			prop.load(fis);
		} catch (IOException e) {

			logger.error(e.getMessage());
		}

		try {

			reader = new utility.ExcelDataReaderFile(".\\TestData.xlsx");
		} catch (Exception e) {

			logger.error(e.getMessage());
		}

	}

	@BeforeTest
	public void setExtent() {
		extent = new ExtentReports(".\\Report\\Redbus_ExtentReport.html");
		extent.addSystemInfo("Total Test Case", "currently 20");
	}

	public static void Browser_Initiliaze(String Browser) {

		if (Browser.toLowerCase().equals("chrome")) {
			if (prop.getProperty("Headless").equals("true")) {
				System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");

				ChromeOptions options = new ChromeOptions();
				options.addArguments("headless");
				options.addArguments("window-size=1920,1080");
				options.addArguments("--no-sandbox");
				options.addArguments("user-agent=whatever you want");

				driver = new ChromeDriver(options);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			} else {
				System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");

				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}

		} else if (Browser.toLowerCase().equals("firefox")) {
			if (prop.getProperty("Headless").equals("true")) {

				// set the path of the Gecko driver as per the location on local machine
				System.setProperty("webdriver.gecko.driver", ".//Drivers//geckodriver.exe");

				// Set Firefox Headless mode as TRUE
				FirefoxOptions options = new FirefoxOptions();
				options.setHeadless(true);

				// pass the options parameter in the Firefox driver declaration
				driver = new FirefoxDriver(options);

				// driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			} else {
				// set the path of the Gecko driver as per the location on local machine
				System.setProperty("webdriver.gecko.driver", ".//Drivers//geckodriver.exe");

				// pass the options parameter in the Firefox driver declaration
				driver = new FirefoxDriver();

				// driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			}
		}
	}

	@BeforeMethod
	public void OPEN_URL() throws MalformedURLException {
		Browser_Initiliaze(prop.getProperty("Browser_1"));
		driver.get(prop.getProperty("BaseUrl"));

	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		extentTest = extent.startTest(result.getName());
		// for fail test cases
		if (result.getStatus() == ITestResult.FAILURE) {

			extentTest.log(LogStatus.FAIL, "TEST FAILED " + result.getName());
			extentTest.log(LogStatus.FAIL, "TEST FAILED THROWABLE EXC " + result.getThrowable());

			// adding screenshot
			String screenshotPath = Screenshots.takeScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
		}

		else if (result.getStatus() == ITestResult.SKIP) {

			extentTest.log(LogStatus.SKIP, "TEST SKIPPED " + result.getName());
		}

		else if (result.getStatus() == ITestResult.SUCCESS) {

			extentTest.log(LogStatus.PASS, "TEST PASSED " + result.getName());
			String screenshotPath = Screenshots.takeScreenshot(driver, result.getName());
			extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(screenshotPath));

		}

		// end the testcase in the extent report
		extent.endTest(extentTest);
		driver.close();

	}

	@AfterTest
	public void closeBrowser() {
		logger.info("Browser closed...");
	}

	@AfterSuite
	public void report() {
		extent.flush();
		// extent.close();
	}

}
