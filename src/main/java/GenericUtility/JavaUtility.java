package GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class contains java reusable methods
 * @author DELL
 *
 */
public class JavaUtility {
	
	/**
	 * This method is used to generate Random Number
	 * @return
	 */

	public int RandomNumber()
	{
		Random random= new Random();
		return random.nextInt(1000);
	}
	
	/**
	 * This method is used to convert the String to Long data type
	 * @param stringData
	 * @return
	 */
	public long convertStringToLong(String stringData)
	{
		return Long.parseLong(stringData);
	}
	
	/**
	 * This method is used to print the value in Console 
	 * @param statement
	 */
	
	public void printStatement(String data)
	{
		System.out.println(data);
	}
	/**
	 * This method is used to get current date in specified strategy
	 * @param strategy
	 * @return
	 */
	public String getCurrentDate(String strategy)
	{
		return new SimpleDateFormat(strategy).format(new Date());
	}

}
