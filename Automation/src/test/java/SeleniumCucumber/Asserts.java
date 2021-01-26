package SeleniumCucumber;



import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Asserts {

	@Test
	

	public void AutoIT() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\srilekha.shivadevuni\\chromedriver_win32\\chromedriver.exe");

		WebDriver drv = new ChromeDriver();
		drv.get("https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin");

		drv.manage().window().maximize();

		drv.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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
		
		String title= "Sign in – Google accounts";
		
		String title1 = "hfjdgh";
		
		
		Assert.assertEquals(drv.getTitle(), title);
		//Assert.assertEquals(drv.getTitle(), title1 ,"expected title is not same as actual");
		
		
		int a=5 ,b=10;
		
		Assert.assertTrue(b>a);
		System.out.println("This line is executed because assertTrue");
		
		Assert.assertNull(null);
		
		System.out.println("check");
    
		
    	System.out.println("Since we we set null in the condition, the assertion "
    			+ "assertNull will pass");
    

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
				drv.quit();

			}
		}

	}
}

/*
 * Assertion tool class is a part of org.testng and extends java.lang.Object
 * class.
 */ 

/*
 * Till now, we have learnt about the hard assertions in WebDriver using testNg
 * framework. In a hard assertion, when the assertion fails it terminates/aborts
 * the test(method). But, what if we want to run the entire program? What if, we
 * want to report fail test in testNg report but do not want to terminate the
 * script at any case? It is not really possible if we use hard assertions. So,
 * to overcome this drawback of hard assertion we can use soft assertions in
 * testNg. To use a soft assertion in testNg, we have to include it’s
 * corresponding class (as SoftAssert()) in the script. This class prevents the
 * execution to throw any exception (of assertion). Also, the most important
 * context is, now the failed assertions will be reported in the testNg report
 * and not making the test to abort anywhere. Let’s see an example of soft
 * assertion in testNg. Also, try to look at the difference between the two
 * assertion and which assert should be used when.
 */
