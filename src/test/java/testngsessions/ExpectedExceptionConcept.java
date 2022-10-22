package testngsessions;

import org.testng.annotations.Test;

public class ExpectedExceptionConcept {

	
	@Test(expectedExceptions = {ArithmeticException.class, NullPointerException.class})
	public void searchTest() {
		System.out.println("Test-----Search test");
		int i=9/0;
		System.out.println("bye");
	}
}
