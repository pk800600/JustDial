package JustDialObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.dockerjava.api.model.Driver;

import GenericUtility.Dream11BaseClass;
import GenericUtility.InstanceClass;
import GenericUtility.MobileUtility;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class VerifyNavigationBar extends Dream11BaseClass{
	
	public VerifyNavigationBar(AndroidDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//android.widget.TextView[@text='Travel']") private WebElement travel;
	@FindBy(xpath = "//android.widget.TextView[@text='Flights']") private WebElement flights;
	@FindBy(xpath = "//android.widget.Button[@text='Round Trip']") private WebElement roundTrip;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.justdial.search:id/from_city']") private WebElement from;
	@FindBy(xpath = "//android.widget.MultiAutoCompleteTextView[@text='Search']") private WebElement search;
	@FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.justdial.search:id/cities_Lay']") private WebElement enterCity;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.justdial.search:id/to_city']") private WebElement to;
	@FindBy(xpath = "//android.widget.MultiAutoCompleteTextView[@text='Search']") private WebElement searchTo;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.justdial.search:id/city_airport']") private WebElement searcToClick;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.justdial.search:id/depature_date']") private WebElement departureDate;
	@FindBy(xpath = "//android.widget.TextView[@text='20']") private WebElement departureDateSelect;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.justdial.search:id/return_date']") private WebElement returnDate;
	@FindBy(xpath = "//android.widget.TextView[@text='October 2022']/parent::android.widget.LinearLayout/android.view.ViewGroup//android.widget.TextView[@text='12']") private WebElement returnDateSelect;
	@FindBy(xpath = "//android.widget.TextView[@text='Search']") private WebElement searchFlight;
	
	
	
	
	
	
	//business logic
	
	public void roundTripTravel(String fromDestination, String toDestination,AndroidDriver<WebElement> driver) throws InterruptedException {
		travel.click();
		flights.click();
		roundTrip.click();
		from.click();
		search.sendKeys(fromDestination);
		enterCity.click();
		to.click();
		searchTo.sendKeys(toDestination);
		searcToClick.click();
		departureDate.click();
		departureDateSelect.click();
		returnDateSelect.click();
		searchFlight.click();
		
		
		//driver.tap(1, 134, 755,	500);
		
		
		
	}
	

}
