package Assingment;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtility.Dream11BaseClass;
import JustDialObjectRepository.VerifyNavigationBar;

public class Assignment2 extends Dream11BaseClass {

	@Test
	public  void AppiumAssignment() throws MalformedURLException, InterruptedException {
				// TODO Auto-generated method stub
		VerifyNavigationBar verifyNavigationBar=new VerifyNavigationBar(driver);
		
		verifyNavigationBar.roundTripTravel("Bangalore", "Mumbai", driver);
		
		Thread.sleep(10000);
		driver.tap(1, 102, 1088,500);
		driver.tap(1, 601, 974, 500);
		
		
		
		
		

}
}
