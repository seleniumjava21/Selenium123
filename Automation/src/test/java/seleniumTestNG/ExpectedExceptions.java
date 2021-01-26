package seleniumTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ExpectedExceptions {

	public WebDriver driver;

	@BeforeSuite
	public void beforeSuite() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\srilekha.shivadevuni\\chromedriver_win32\\chromedriver.exe");

		System.out.println("in Before Suite");
	}

	@BeforeClass
	public void beforeClass() {

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("in Before Class");
	}

	@BeforeMethod

	public void beforeMethod() {
		driver.get("https://www.google.co.in");

		driver.manage().window().maximize();// browser commands

	}

	
	@Test(enabled=false)
	public void google() throws NoSuchElementException {

		try {
			WebElement search = driver.findElement(By.xpath("//input[@class='harish']"));
			search.sendKeys("amazon", Keys.ENTER);// selenium
			Thread.sleep(5000);

		} catch (Exception e) {
			System.out.println("catch the exception");
			
			e.printStackTrace();
			e.getMessage();
		}

	}
	
	

	@Test(expectedExceptions= ArithmeticException.class)
	public void googleTest() {
		
		
		 int a = 2; int b= 0; int c= a/b; 
		 System.out.println("catch the exception");
		 
		/*
		 * WebElement search =
		 * driver.findElement(By.xpath("//input[@class='selenium']"));
		 * 
		 * search.sendKeys("amazon", Keys.ENTER);// selenium Thread.sleep(5000);
		 * 
		 * 
		 */
	}

	@AfterMethod

	public void afterMethod() {

		// Close the driver

		driver.quit();

	}

}
