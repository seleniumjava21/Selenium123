package seleniumTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportsExample {

	public ExtentHtmlReporter htmlReporter = null;

	public ExtentTest logger = null;
	public ExtentReports extent = null;
	
	

	@BeforeSuite
	public void initReport() {

		// initialize the HtmlReporter
		
		
		 htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "//ExtentReport//extentReport.html");
		 
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "//ExtentReport//extent-config.xml");

		// initialize ExtentReports and attach the HtmlReporter
		extent = new ExtentReports();

		// attach only HtmlReporter
		extent.attachReporter(htmlReporter);
		
		WebDriver driver = new ChromeDriver();

	}
	
	@Test(priority= 1)
	public void testcase1() {
		
		
		logger= extent.createTest("my 1st test case");
		
		//code
		int a= 5, b=10;
		
		if(a<b) {
		logger.log(Status.PASS, "test case passed");
		
		}
	}
	
	@Test(priority= 2)
	public void testcase2() {
		
		logger= extent.createTest("my 2nd test case");
		logger.log(Status.PASS, "test case passed");
		
		
	}
	
	@AfterSuite
	public void endReports() {
		
		extent.flush();
		logger.log(Status.INFO, "end of testcase");
		
	}
}
