package GenericUtility;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class InstanceClass {
	public AppiumDriverLocalService service;
	public AndroidDriver driver;
	public MobilePropertyFile  mobilePropertyFile;
	public JavaUtility javaUtility;
	public String Url;
	public String platformName;
	public String platformVersion;
	public String udid;
	public String timeout;
	public DesiredCapabilities dc1;
	public MobileUtility mobileUtility;
	public String timeouts;
	public long time;
	public MobileExcelUtility mobileExcelUtility;

}
