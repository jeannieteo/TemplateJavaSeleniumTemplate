package base;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Date;

import org.apache.poi.ss.formula.functions.Replace;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.Constants;

public class BaseTest {
	
	public static WebDriver driver;
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest extentlog;
	
	
	@BeforeTest
	public void beforeTestMethod() {
		//Extent report
		Date date = new Date();
		String dateS = date.toString().replaceAll(":", "").replaceAll(" ", "");
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "reports" + File.separator + dateS + "_report.html");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		sparkReporter.config().setDocumentTitle("Doe Re Meee");
		sparkReporter.config().setReportName("Report alpha");
		
	}
	
	@AfterTest
	public void afterTest()	{
		extent.flush();
	}
	
	
	
	@Parameters("browser")
	@BeforeMethod
	public void beforeMethodMethod(String browserValue, Method testMethod) {
		//extent report method
		extentlog = extent.createTest(testMethod.getName());
		//setup
		if (browserValue.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if (browserValue.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			
		}
		else if (browserValue.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			
		}
		else {
			Assert.fail(browserValue + " : not valid browser");
		}
		driver.get(Constants.url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
	}
	
	
	@AfterMethod
	public void afterMethod(ITestResult testresult) {
		int result = testresult.getStatus();
		if( result == ITestResult.FAILURE) {
			extentlog.log(Status.FAIL, MarkupHelper.createLabel(testresult.getThrowable(), ExtentColor.RED));
			//extentlog.log(Status.FAIL, );
			String filename =  System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + testresult.getMethod().getMethodName();
			extentlog.addScreenCaptureFromPath("file:///" + filename + ".png");
		}
		else if( result == ITestResult.SKIP) {
			extentlog.log(Status.SKIP, MarkupHelper.createLabel(testresult.getName() + " : " +  Status.SKIP, ExtentColor.ORANGE));
		}
		else if( result == ITestResult.SUCCESS) {
			extentlog.log(Status.PASS, MarkupHelper.createLabel(testresult.getName() + " : " +  Status.PASS, ExtentColor.GREEN));
		}
		driver.quit();
		
		
		
	}
	

}
