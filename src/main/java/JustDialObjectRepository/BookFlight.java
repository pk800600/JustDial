package JustDialObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.BaseClass;
import GenericUtility.IpathConstant;
import GenericUtility.MobileExcelUtility;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class BookFlight {
	
	public BookFlight(AndroidDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//android.widget.TextView[@text='Travel']") private WebElement travel;
	@FindBy(xpath = "//android.widget.TextView[@text='Flights']") private WebElement flights;
	@FindBy(xpath = "//android.widget.Button[@text='Round Trip']") private WebElement roundTrip;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.justdial.search:id/from_city']") private WebElement from;
	@FindBy(xpath = "//android.widget.MultiAutoCompleteTextView[@text='Search']") private WebElement search;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.justdial.search:id/city_airport']") private WebElement enterCity;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.justdial.search:id/to_city']") private WebElement to;
	@FindBy(xpath = "//android.widget.MultiAutoCompleteTextView[@text='Search']") private WebElement searchTo;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.justdial.search:id/city_airport']") private WebElement searcToClick;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.justdial.search:id/depature_date']") private WebElement departureDate;
	@FindBy(xpath = "//android.widget.TextView[@text='20']") private WebElement departureDateSelect;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.justdial.search:id/return_date']") private WebElement returnDate;
	@FindBy(xpath = "//android.widget.TextView[@text='October 2022']/parent::android.widget.LinearLayout/android.view.ViewGroup//android.widget.TextView[@text='12']") private WebElement returnDateSelect;
	@FindBy(xpath = "//android.widget.TextView[@text='Search']") private WebElement searchFlight;
	
	
	
	
	
	
	//business logic
	
	public void roundTripTravel(MobileExcelUtility mobileExcelUtility,    AndroidDriver<WebElement> driver) throws InterruptedException {
		travel.click();
		Thread.sleep(3000);
		flights.click();
		roundTrip.click();
		from.click();
		mobileExcelUtility.initializeExcelFile(IpathConstant.MOBILEEXCELFILE);
		search.sendKeys(mobileExcelUtility.getDataFromExcel("Bookflight", 2, 1));
		enterCity.click();
		to.click();
		searchTo.sendKeys(mobileExcelUtility.getDataFromExcel("Bookflight", 2, 2));
		searcToClick.click();
		departureDate.click();
		departureDateSelect.click();
		returnDateSelect.click();
		searchFlight.click();
		
		Thread.sleep(10000);
		TouchAction tc= new TouchAction(driver);
		tc.tap(51, 495).perform();
		Thread.sleep(3000);
		tc.tap(619, 504).perform();
		Thread.sleep(3000);
		tc.tap(784, 2014).perform();
		
		
		//driver.tap(1, 134, 755,	500);
		
		
		
	}
	

}
