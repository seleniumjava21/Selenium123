package seleniumTestNG;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutoIt {

	WebDriver drv = new FirefoxDriver();

	@BeforeSuite
	public void beforeSuite1() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\srilekha.shivadevuni\\geckodriver-v0.24.0-win64\\geckodriver.exe");

		drv.get("https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	}

	@BeforeTest
	public void beforeTest() {
		drv.manage().window().maximize();

	}

	@BeforeClass
	public void beforeClass() {
		drv.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void beforeMethod1() throws Exception {
		WebElement username = drv.findElement(By.xpath("//input[@id='identifierId']"));

		username.clear();
		username.sendKeys("selenium.java21@gmail.com");

		WebElement next = drv.findElement(By.xpath("//span[contains(text(),'Next')]"));
		next.click();

		WebElement password = drv.findElement(By.xpath("//input[@name='password']"));

		password.clear();

		Thread.sleep(3000);

		password.sendKeys("P@$$word1");

		WebElement next1 = drv.findElement(By.xpath("//span[contains(text(),'Next')]"));

		next1.click();

		// explicit wait - to wait for the compose button to be click-able

		WebDriverWait wait = new WebDriverWait(drv, 30);
	}

	@Test
	public void testCase1() throws Exception {
		drv.findElement(By.xpath("//a[@href='https://www.google.co.in/intl/en/about/products?tab=kh']")).click();

		Thread.sleep(2000);

		String parent = drv.getWindowHandle();
		drv.findElement(By.xpath("//span[contains(text(),'Gmail')]")).click();

		Set<String> l1 = drv.getWindowHandles();
		Iterator<String> I1 = l1.iterator();

		while (I1.hasNext()) {

			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				drv.switchTo().window(child_window);
				Thread.sleep(2000);

				drv.findElement(By.xpath("//div[contains(text(),'Compose')]")).click();
				Thread.sleep(5000);
				drv.findElement(By.xpath("(//div[contains(text(),'Send')])[2]/following::td[3]/div/div[1]")).click();
				Thread.sleep(5000);
				Runtime.getRuntime().exec("C:\\AutoIt\\demo.exe");

				Thread.sleep(5000);
				System.out.print("file upload complete");

				drv.switchTo().window(child_window).close();
				drv.switchTo().defaultContent().close();
			}
			drv.quit();

		}
	}

	@AfterClass
	public void afterClass() {
		System.out.println("in After Class");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("in After Test");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("in After Suite");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("in After Method");
	}

}

// https://autoitscript.com/site/autoit/downloads/

//Runtime.getRuntime().exec("G:/Tutorial/AutoItScripts/upload.exe");

/*
 * @AfterMethod public void tearDown(ITestResult result) {
 * 
 * if(ITestResult.FAILURE==result.getStatus()) { try { TakesScreenshot
 * ts=(TakesScreenshot)driver; File source=ts.getScreenshotAs(OutputType.FILE);
 * FileUtils.copyFile(source, new
 * File("./Screenshots/"+result.getName()+".png"));
 * 
 * System.out.println("Screenshot taken"); } catch (Exception e) {
 * 
 * System.out.println("Exception while taking screenshot "+e.getMessage()); }
 */
