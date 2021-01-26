package seleniumTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class JavaScriptExe {

	@Test
	public void Login() throws InterruptedException {
		
	
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\srilekha.shivadevuni\\chromedriver_win32\\chromedriver.exe");

		WebDriver drv = new ChromeDriver();
		drv.get("https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin");


		drv.manage().window().maximize();

		//CaptureScreenshot driver = new CaptureScreenshot();

		JavascriptExecutor js = (JavascriptExecutor)drv;
		
		

		drv.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	
		WebElement username = drv.findElement(By.xpath("//input[@id='identifierId']"));

		username.clear();
		username.sendKeys("selenium.java21@gmail.com");

		WebElement next = drv.findElement(By.xpath("//span[contains(text(),'Next')]"));
		next.click();

		WebElement password = drv.findElement(By.xpath("//input[@name='password']"));

		//password.clear();

		Thread.sleep(3000);

		password.sendKeys("P@$$word1");
		//js.executeScript("document.getElementByClass('whsOnd zHQkBf').value='P@$$word1';");
		//js.executeScript("document.getElementByName('password').value='P@$$word1';");
		//js.executeScript("document.getElementById('Email').value='SoftwareTestingMaterial.com';");

		WebElement next1 = drv.findElement(By.xpath("//span[contains(text(),'Next')]"));
		js.executeScript("alert('Hello')");
		//next1.click();
	//	js.executeScript(script, args)
	//	js.executeScript("arguments[0].click();", next1);
		/*String strJavaScript = "var element = arguments[0]; var mouseEventObj = "
				+ "document.createEvent('MouseEvents'); mouseEventObj.initEvent( 'mouseover', true, true );"
				+ " element.dispatchEvent(mouseEventObj);";
		((JavascriptExecutor) driver).executeScript(strJavaScript, element);
*/	//	js.executeScript("$(selector).mouseover(function)",next1);
		//js.executeScript(script, args)


		
		long start_time = System.currentTimeMillis();			
        
        //Call executeAsyncScript() method to wait for 5 seconds		
        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");			
        		
       //Get the difference (currentTime - startTime)  of times.		
       System.out.println("Passed time: " + (System.currentTimeMillis() - start_time));					
            

	}
}
