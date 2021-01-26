package seleniumTestNG;
import org.testng.SkipException;
import org.testng.annotations.Test;


public class SkipExample {
	
		@Test(enabled=false)
		public void testCaseEnabling(){
				System.out.println("dnt execute me");
			}
		@Test(priority= 1)
		public void testCaseSkipException(){
				System.out.println("Im in skip exception");
				throw new SkipException("Skipping this exception");
			}

		@Test(priority=2)
		public void testCaseConditionalSkipException(){
			System.out.println("Im in Conditional Skip");
					
			int a= 3; int b=5;
			if(a!=b) 
			throw new SkipException("Skipping this exception");
			System.out.println("Executed Successfully");
		
		}

	}



