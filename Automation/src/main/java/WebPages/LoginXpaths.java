package WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginXpaths {
	
	public LoginXpaths(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
		
	}	
		
	@FindBy(how= How.ID, using = "search")
	private WebElement searchOption;
	
	public WebElement getSearchOption() {
		
		return searchOption;
}
}
