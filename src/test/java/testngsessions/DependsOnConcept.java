package testngsessions;

import org.testng.annotations.Test;

public class DependsOnConcept {
	
	//AAA in unit test
	// Arrange, Act and Assert
	public void a_CreateUser() {
		System.out.println("a_CreateUser");
	}

	@Test
	public void createUser() {
		System.out.println("createUser");
		//int i=9/0;//updateUser and deleteUser got skipped due to exception
		a_CreateUser();
	}
	
//	@Test(dependsOnMethods = "createUser")
//	public void updateUser() {
//		System.out.println("updateUser");
//	}
//	
//	@Test(dependsOnMethods = "createUser")
//	public void deleteUser() {
//		System.out.println("deleteUser");
//	}
	
	@Test
	public void updateUser() {
		a_CreateUser();
		System.out.println("updateUser");
	}
	
	@Test
	public void deleteUser() {
		a_CreateUser();
		System.out.println("deleteUser");
	}
}
