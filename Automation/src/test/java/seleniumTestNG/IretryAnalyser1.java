package seleniumTestNG;

import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class IretryAnalyser1 implements IRetryAnalyzer {
	
	private int retryCnt = 0;
	// You could mentioned maxRetryCnt (Maximiun Retry Count) as per your
	// requirement. Here I took 2, If any failed testcases then it runs two times
	private int maxRetryCnt = 2;

	// This method will be called everytime a test fails. It will return TRUE if a
	// test fails and need to be retried, else it returns FALSE
	

@AfterMethod
public boolean retry(ITestResult result) {
			if (retryCnt < maxRetryCnt) {
				
			System.out.println("Retrying " + result.getName() + " again and the count is " + (retryCnt + 1));
			retryCnt++;
			return true;
		}
		return false;
	}

	@Test(retryAnalyzer = seleniumTestNG.IretryAnalyser1.class)
	public void hardAssertion() {
		Assert.assertEquals("pass", "pass");
		System.out.println("This line is executed because assertEquals " + "passed as both the strings are same");
		Assert.assertNull("assertion");
		System.out.println("Since the object under assertion" + " is not null, the assertion will fail. "
				+ "This line will not be executed");
	}
}
