package Assingment;
import java.net.MalformedURLException;

import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import JustDialObjectRepository.BookFlight;
import io.appium.java_client.TouchAction;

public class AssignmentBookFlightTest extends BaseClass {

	@Test
	public  void bookFlightAssignment() throws MalformedURLException, InterruptedException {
				
		BookFlight bookFlight=new BookFlight(driver);
		
		bookFlight.roundTripTravel(mobileExcelUtility, driver);
		

}
}
