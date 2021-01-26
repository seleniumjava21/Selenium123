package seleniumTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Paralleltests {

	public WebDriver driver;

	@Test

	public void google() throws Exception {

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\srilekha.shivadevuni\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.google.co.in");

		driver.manage().window().maximize();// browser commands

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

	@Test

	public void google1() throws Exception {

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\srilekha.shivadevuni\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.co.in");

		driver.manage().window().maximize();// browser commands
		WebElement search = driver.findElement(By.xpath("//input[@type='text']"));
		// driver.navigate()

		search.sendKeys("Selenium Testing", Keys.ENTER);// selenium
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

		// driver.quit();

	}

}
