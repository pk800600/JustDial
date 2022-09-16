package GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Connection;

/**
 * This class contains mobile reusability methods for devices
 */
public class MobileUtility extends InstanceClass {
	
	//AndroidDriver driver;
	Connection connect;
	ScreenOrientation orientation;
	
	/**
	 * This method is used to switch the app between each other
	 * @param appPackage
	 * @param appActivity
	 */
	public void switchApp(String appPackage,String appActivity) {
		driver.startActivity(appPackage, appActivity);
	}
	
	/**
	 * This method is used to perform drag and drop function
	 * @param src
	 * @param trg
	 */
	public void dragAndDrop(WebElement src, WebElement trg) {
		TouchAction ta=new TouchAction(driver);
		ta.longPress(src).waitAction().moveTo(trg).release().perform();
	}
	
	/**
	 * This method is used to perform drag and drop function with some waiting time
	 * @param src
	 * @param ms
	 * @param trg
	 */
	public void dragAndDrop2(WebElement src, int ms,WebElement trg) {
		TouchAction ta=new TouchAction(driver);
		ta.longPress(src).waitAction(ms).moveTo(trg).release().perform();
	}
	
	/**
	 * This method is used for closing keyboard
	 */
	public void closeKeyBoard() {
		driver.hideKeyboard();
	}
	
	/**
	 * This method is used to perform click action using tap method
	 * @param fingers
	 * @param element
	 * @param duration
	 */
	public void clickAction(int fingers, WebElement element, int duration) {
		driver.tap(fingers, element, duration);
	}
	
	/**
	 * This method is used to turn on/off the DATA
	 */
	public void DATAConnection() {
		driver.getConnection();
		driver.setConnection(connect.DATA);
		
	}
	
	/**
	 * This method is used to turn on/off the WIFI
	 */
	public void WIFIConnection() {
		driver.getConnection();
		driver.setConnection(connect.WIFI);
		
	}
	/**
	 * This method is used to turn on/off the AIRPLANE
	 */
	public void AIRPLANEConnection() {
		driver.getConnection();
		driver.setConnection(connect.AIRPLANE);
		
	}
	
	/**
	 * This method is used run app in background
	 * @param seconds
	 */
	public void runAppInBackgroud(int seconds) {
		driver.runAppInBackground(seconds);
	}
	
	/**
	 * This method is used to change orientation to Landscape
	 */
	public void orientationLandscape() {
		 driver.getOrientation();
		 driver.rotate(orientation.LANDSCAPE);
	}
	
	/**
	 * This method is used to change orientation to portrait
	 */
	public void orientationPortrait() {
		 driver.getOrientation();
		 driver.rotate(orientation.PORTRAIT);
	}
	
	/**
	 * This method is used to perform swipe action
	 * @param startx
	 * @param starty
	 * @param endx
	 * @param endy
	 * @param duration
	 */
	public void swipeAction(int startx, int starty, int endx,int endy,int duration) {
		driver.swipe(startx, starty, endx, endy, duration);
	}
	
	/**
	 * This method is used to perform scroll action
	 * @param driver
	 * @param an
	 * @param av
	 */
	public void scrolltoElement(AndroidDriver driver, String an, String av) {
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+an+"(\""+av+"\"))");
		
	}
	
	/**
	 * This method is used to take screen shots of whole page
	 */

	public void takesScreenShotElement() {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg= new File("./screenshots/cancelled.png");
		try {
			FileUtils.copyFile(src, trg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	/**
	 * This method is used to use implicitwait
	 * @param longTimeout
	 */
	public void implicitwait(long timeout)
	{
		driver.manage().timeouts().implicitlyWait(timeout,TimeUnit.SECONDS );
	}
	
	public void explicitWait(By locator) {
		WebDriverWait wait= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	
	public void tapAction(int x, int y) throws InterruptedException {
		TouchAction tc=new TouchAction(driver);
		Thread.sleep(3000);
		tc.tap(x, y).perform();
	}
}
