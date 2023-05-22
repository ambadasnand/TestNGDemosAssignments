package testNGAssertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertDemo {
	
	SoftAssert softassert = new SoftAssert();
	
	@Test
	public void hardAssertion() {
		
		Assert.assertEquals("pass", "pass");
		
		System.out.println("This line is executed because assertEquals " + "Passed as both the strings are same");
		Assert.assertNull("assertion");
		
		
		System.out.println("since the object under assertion" + " is not null, the assertion will fail. "
		 + "This line will not be executed");
		
	}
	

	@Test
	public void softAssertion() {
		
		Assert.assertNull("assertion");
		
		System.out.println("we are using soft assertion in this method, " + "so this line of code will also be executed even if"
		+ "the assertion fails. wherever we want to execute full" + "testcase/method, we should use SoftAssertion");
		softassert.assertAll();
	}

}
