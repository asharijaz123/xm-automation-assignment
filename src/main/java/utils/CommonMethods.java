package utils;

import base.SeleniumBase;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author MUHAMMAD ASHAR
 * Dated: 27/10/2021
 */
public class CommonMethods extends SeleniumBase
{


	/**
	 * type method to type a String value
	 *
	 * @param webElement the text box web element
	 * @param strValue   the value to enter
	 */
	public void type (WebElement webElement, String strValue)
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(
				ExpectedConditions.visibilityOfElementLocated((By) webElement));
		try
		{
			webElement.sendKeys (strValue);
		}
		catch (Exception e)
		{
			throw new TestException (String.format ("Error in sending [%s] to the following element: [%s]", strValue, webElement.toString ()));
		}
	}

	/**
	 * click method to click on a web element
	 */
	public void clickBy (WebElement webElement)
	{
//		WebDriverWait wait = new WebDriverWait(driver, 60);
//		WebElement element = wait.until(
//				ExpectedConditions.visibilityOfElementLocated((By) webElement));
		webElement.click ();
	}


	/**
	 * click - method to execute a JavaScript click event
	 *
	 * @param webElement
	 */
	public void clickJS (WebElement webElement)
	{
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript ("arguments[0].click();", webElement);
	}
	/**
	 * pause for a certain amount of time before , performing the next operation
	 *
	 * @param milliseconds
	 */
	public void wait(Integer milliseconds){
		try {
			TimeUnit.MILLISECONDS.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns the Date in Desired Format , which we are using
	 *
	 */
	public String getDateInDesiredFormat(String strDate){
		String strDateInActualFormat ="";
		String[] spllitedDate = strDate.split("T");
		String part1 = spllitedDate[0]; // 004
		String replaceString=part1.replace('-','/');
		String[] parts = replaceString.split("/");
		String strYear = parts[0];
		String strMonth = parts [1];
		String strDay= parts[2];
		strDateInActualFormat=strDay+"/"+strMonth+"/"+strYear;
		return strDateInActualFormat;
	}

	/**
	 * return the first day of the week in the desired format
	 *
	 */
	public String  getWeekStartDate() {
		Calendar calendar = Calendar.getInstance();
		while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
			calendar.add(Calendar.DATE, -1);
		}
		Date dt = calendar.getTime();
		DateFormat ndf = new SimpleDateFormat ("dd/MM/yyyy");
		String strWeekFirstDay = ndf.format(dt);
		return strWeekFirstDay;
	}

	/**
	 * Returns the last day of the week in desired format
	 *
	 */
	public String getWeekEndDate() {
		Calendar calendar = Calendar.getInstance();
		while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
			calendar.add(Calendar.DATE, 1);
		}
		calendar.add(Calendar.DATE, -1);
		Date dt = calendar.getTime();
		DateFormat ndf = new SimpleDateFormat("dd/MM/yyyy");
		String strWeekLastDay = ndf.format(dt);
		return strWeekLastDay;
	}

	/**
	 * Converts raw string response into JSON
	 *
	 */
	public static JsonPath rawToJSON(String response){
		JsonPath js = new JsonPath (response);
		return js;
	}

	/**
	 * Gets ID from a given URL
	 */
	public static String getID(String url){
		String[] strURLInParts = url.split("/");
		String strID= strURLInParts[5];
		return strID;
	}



}
