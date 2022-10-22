package testngsessions;

import org.testng.annotations.Test;

public class PriorityConcept {

	@Test(priority=1)
	public void A_Test()
	{
		System.out.println("A_Test");
	}
	@Test(priority=2)
	public void B_Test()
	{
		System.out.println("B_Test");
	}
	@Test(priority=3)
	public void C_Test()
	{
		System.out.println("C_Test");
	}
	@Test()
	public void D_Test()
	{
		System.out.println("D_Test");
	}
	@Test()
	public void E_Test()
	{
		System.out.println("E_Test");
	}
}
