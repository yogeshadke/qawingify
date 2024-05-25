package Qa_wingnify_Util;

import java.io.File;


import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import rok.qa.Utilities.Read_Configration_From_config_Prop_Folder;

public class Qa_wingify_Base_class {

	// Get values from readConfig class in globally

	qa_wingify_Conf_Properties readconfig = new qa_wingify_Conf_Properties();
	protected String url = readconfig.getBaseURL();
	String browser = readconfig.getBrowsr();
	protected String username = readconfig.getusername();
	protected String password = readconfig.getpassword();

	public static WebDriver driver;
	public static ExtentTest test;
	public static ExtentReports extent = null;

	@Deprecated
	@BeforeClass
	public void setup() {
		// Browser switching
		switch (browser.toLowerCase())

		{
		case "chrome":
			WebDriverManager.chromedriver().clearDriverCache().setup();
			driver = new ChromeDriver();

			break;
		case "firefox":
			WebDriverManager.firefoxdriver().clearResolutionCache().setup();
			driver = new FirefoxDriver();
			break;
		default:
			driver = null;
			break;
		}

		//WebDriverListener listener = new webdriverEvents();
		//driver = new EventFiringDecorator<WebDriver>(listener).decorate(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(14, TimeUnit.SECONDS);
	}

	@BeforeSuite
	public static void setUp() {
		// Initialize ExtentReports
		extent = new ExtentReports();
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\Reports\\report.html");
		htmlReporter.config().setReportName("QA_WingifyProject Automation Result");
		htmlReporter.config().setDocumentTitle("QA_WingifyProject Automation");
		extent.setSystemInfo("QA Engineer", "Yogesh Adke");
		extent.setSystemInfo("Device", "Chrome");
		extent.attachReporter(htmlReporter);

	}

	public String takeScreenShots(String testCaseName, WebDriver driver) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		@SuppressWarnings("unused")
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File source = ts.getScreenshotAs(OutputType.FILE);
		// String base64Screenshot = convertImageToBase64(source);
		File file = new File(System.getProperty("user.dir") + "\\screenshots\\" + testCaseName + ".jpg");
		FileUtils.copyFile(source, file);
		// return base64Screenshot;
		return System.getProperty("user.dir") + "\\screenshots\\" + testCaseName + ".jpg";

	}

	@AfterMethod
	public void afterEachMethod(ITestResult result) throws IOException {

		String testName = result.getName();
		String screenshotpath = takeScreenShots(testName, driver);

		test = extent.createTest(testName);

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(testName + " Test Case Failed.", ExtentColor.RED));
			test.log(Status.FAIL, "Test Case Failed:- " + result.getThrowable());
			test.fail("Test Case Failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotpath).build());
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, MarkupHelper.createLabel(testName + " Test Case Skipped.", ExtentColor.ORANGE));
			test.skip("Test Case Skipped", MediaEntityBuilder.createScreenCaptureFromPath(screenshotpath).build());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(testName + " Test Case Passed.", ExtentColor.GREEN));
			//test.log(Status.PASS, "Test Case Passed:- " + result.getThrowable());
			test.pass("Test Case Passed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotpath).build());
		}

	}

	@AfterClass
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}


