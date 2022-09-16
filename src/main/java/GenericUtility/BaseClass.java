package GenericUtility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseClass extends InstanceClass {
		
	@BeforeClass
	public void laundServer() {
//		service= AppiumDriverLocalService.buildDefaultService();
//		service.start();
		mobilePropertyFile= new MobilePropertyFile();
		mobileUtility= new MobileUtility();
		javaUtility= new JavaUtility();
		mobileExcelUtility= new MobileExcelUtility();
		mobilePropertyFile.intializePropetiesFile(IpathConstant.MOBILEPROPERTIYFILE);
		mobileExcelUtility.initializeExcelFile(IpathConstant.MOBILEEXCELFILE);
		Url = mobilePropertyFile.getDataFromProperty("URL");
		platformName = mobilePropertyFile.getDataFromProperty("PLATFORM_NAME");
		platformVersion = mobilePropertyFile.getDataFromProperty("PLATFORM_VERSIONReal");
		udid = mobilePropertyFile.getDataFromProperty("UDIDDevice");
		timeout = mobilePropertyFile.getDataFromProperty("Timeouts");
		time = javaUtility.convertStringToLong(timeout);
	}
	
	@BeforeMethod
	public void LaunchApp() throws MalformedURLException {
					
		dc1= new DesiredCapabilities();
		dc1.setCapability(MobileCapabilityType.PLATFORM_NAME,platformName);
		dc1.setCapability(MobileCapabilityType.PLATFORM_VERSION,platformVersion);
		dc1.setCapability(MobileCapabilityType.UDID,udid);
		dc1.setCapability("appPackage","com.justdial.search");
		dc1.setCapability("appActivity",".SplashScreenNewActivity");
		dc1.setCapability(MobileCapabilityType.NO_RESET,true);
		URL url=new URL(Url);
		driver= new AndroidDriver(url, dc1);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		//mobileUtility.implicitwait(time);
//		timeouts=javaUtility.convertStringToLong(timeout);
//		mobileUtility.implicitwait(timeouts);
		
		
	}
	
	@AfterMethod
	public void closeApp() {
	//driver.closeApp();
		mobileExcelUtility.closeExcelSheet();
	}
	@AfterClass
	public void closeserver() {
		//service.stop();
	}
	
	

}
