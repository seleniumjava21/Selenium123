package seleniumTestNG;

import org.testng.annotations.Test;

public class Dependecies {
	
	@Test()
	public void cart(){
		//click on cart icon
		//validated products added 
		System.out.println("cart executed after home");
	}
	@Test(enabled = false)
	public void home(){
		//search product
		//add to cart
		
		System.out.println("home executes 1st");
	}
	
	
	@Test(dependsOnMethods = "cart")
	public void submit(){
		//search product
		//add to cart
		
		System.out.println("submit order page");
	}
	
}
