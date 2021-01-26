package seleniumTestNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Frames {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\srilekha.shivadevuni\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		Actions action = new Actions(driver);
		driver.manage().window().maximize();
		
		String baseUrl = "http://www.msn.com/en-in/weather/today/New-Delhi,Delhi,India/we-city-28.608,77.201?iso=IN";
		driver.get(baseUrl);
		
		// 2. Click on Header menu expandable link and select Travel instead of weather in the left top next to msn logo
		WebElement weatherExpandLink = driver.findElement(By.xpath("(//a[@href='/en-in/weather'])[1]"));
		weatherExpandLink.click();
		WebElement travelLink = driver.findElement(By.xpath("//a[@href='/en-in/lifestyle/travel']"));
		wait.until(ExpectedConditions.visibilityOf(travelLink));
		travelLink.click();
		
		// 3. Again Click on Header menu expandable link and in 'More on Lifestyle' click on 'Travel'
		WebElement lifestyleExpandLink = driver.findElement(By.xpath("(//a[@href='/en-in/lifestyle'])[1]"));
		lifestyleExpandLink.click();
		WebElement molTravel = driver.findElement(By.xpath("//a[@href='http://www.msn.com/en-in/travel']"));
		wait.until(ExpectedConditions.visibilityOf(molTravel));
		molTravel.click();
		// 4. Again Click on Header menu expandable link and in 'Tools' click on 'Flight
		// Search'
		WebElement flightSearch = driver
				.findElement(By.xpath("//a[@href='http://flights.msn.com/en-in/flight-search']"));
		lifestyleExpandLink.click();
		wait.until(ExpectedConditions.visibilityOf(flightSearch));
		action.moveToElement(flightSearch).click();
		
		// 5. Click on Flight search link from header menu
		WebElement headerFlight = driver.findElement(By.xpath("//a[@href='http://www.msn.com/en-in/travel/flights']"));
		headerFlight.click();
		
		//6. Select flight trip from Delhi to Chennai
		
		WebElement destinationCity = driver.findElement(By.xpath("(//input[@class='place-selector__input js-place-input'])[2]"));
		destinationCity.clear();
		destinationCity.sendKeys("Chennai");
		WebElement search = driver.findElement(By.xpath("//a[@class='field-box search-button js-search-button']"));
		search.click();
		WebElement serachResult = driver.findElement(By.xpath("//span[@class='num']/following-sibling::text()"));
		wait.until(ExpectedConditions.visibilityOf(serachResult));
		
	// 7. Select Depart date as 10 days ahead from current date.
		
		WebElement deptDateButton = driver.findElement(By.xpath("(//button[@class='search-date-cover'])[1]"));
		deptDateButton.click();
		WebElement pickDeptDate = driver.findElement(By.xpath("(//table[@id='date-depart_table'])[2]/tbody/tr[3]/td[2]"));
		pickDeptDate.click();		
		driver.quit();
  
   // 8. Add return and select date as 5 days ahead from Depart date
		
		WebElement returnDateButton = driver.findElement(By.xpath("(//button[@class='search-date-cover'])[2]"));
		returnDateButton.click();
		WebElement returnDeptDate = driver.findElement(By.xpath("(//table[@id='date-return_table'])[2]/tbody/tr[3]/td[7]"));
		returnDeptDate.click();		
		
//9. Select men 1, women 1 and child 1 and click on Search button
		
		List<WebElement> dropDownClick = driver.findElements(By.xpath("(//div[@class='dropdown'])"));
		for (int i = 0; i < dropDownClick.size(); i++) {
			driver.findElement(By.xpath("(//div[@class='dropdown'])["+i+"]")).click();
			WebElement noOfPeople = driver.findElement(By.xpath("(//a[@data-value='1'])["+i+"]"));
			noOfPeople.click();	
		}
		
		search.click();
		wait.until(ExpectedConditions.visibilityOf(serachResult));
		
// 10. Capture price from the first listed flight in to variable and print the price 
		
		List<WebElement> priceList = driver.findElements(By.xpath("//div[@class='price-text ']"));
		
		for (WebElement webElement : priceList) {
			String priceValue = webElement.getText();
			System.out.print("The value of 1st filght price from the list is -" +priceValue);
			break;
			
		}
		//11. Click on back to lifestyle link
		
		
		//12. Close browser
		 

	}
}
