package seleniumTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNGExample {

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

	@Test

	public void google() throws Exception {
		WebElement search = driver.findElement(By.xpath("//input[@type='text']"));
		// driver.navigate()

		search.sendKeys("amazon", Keys.ENTER);// selenium
		Thread.sleep(5000);

		// search.sendKeys("sri", Keys.);

		String Title = driver.getTitle();// browser watch or bag

		// String Title = driver.getTitle();

		System.out.print(Title);
		String CurrentUrl = driver.getCurrentUrl();//
		System.out.print(CurrentUrl);

	}

	@AfterMethod

	public void afterMethod() {

		// Close the driver

		driver.quit();

	}

}
