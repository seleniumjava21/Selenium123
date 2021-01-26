package seleniumTestNG;
import org.testng.annotations.Test;

public class Priorities {
		
		@Test(priority = 4)
		public void cart(){
			//click on cart icon
			//validated products added 
			System.out.println("cart executed ");
		}
		@Test(priority = 0)
		public void home(){
			//search product
			//add to cart
			
			System.out.println("home executes ");
		}
		
		@Test(priority = 1)
		public void login(){
			//search product
			//add to cart
			
			System.out.println("login check");
		}

		@Test(priority = -1)
		public void logout(){
			//search product
			//add to cart
			
			System.out.println("logout check");
		}
	}



