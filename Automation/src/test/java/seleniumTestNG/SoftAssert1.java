package seleniumTestNG;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class SoftAssert1 {
	
	
		//SoftAssert softAssert = new SoftAssert();
	
	SoftAssert soft = new SoftAssert();
	
	    @Test
	    public void hardAssertion(){
	    	Assert.assertEquals("pass","pass");
	    	System.out.println("This line is executed because assertEquals "
	    			+ "passed as both the strings are same");
	    	
	    	Assert.assertNull("assertion");//false
	    	System.out.println("Since the object under assertion"
	    			+ " is not null, the assertion will fail. "
	    			+ "This line will not be executed");
	    }
	    @Test()
	    public void softAssertion(){
	    	
	    
	    	soft.assertNull("Assert");//false
	    	System.out.println("We are using Soft assertion in this method,"
	    			+ " so this line of code will also be executed even if "
	    			+ "the assetion fails.Wherever we want to execute full "
	    			+ "testcase/method, we should use SoftAssertion");
	   soft.assertAll();
	    }

	  @AfterMethod 
	    public void tearDown(ITestResult result) {
			 
			 if(ITestResult.FAILURE==result.getStatus()) {
				 System.out.println("failed test cases count");
		 
				 
			 
			 }
	    
	   }  

	    
}




