package pages.pages;

import org.openqa.selenium.*;
import pages.objects.OR_EconomicCalendar;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author MUHAMMAD ASHAR
 * Dated: 27/10/2021
 */
public class EconomicCalendar extends CommonMethods {

	public WebDriver driver;
	OR_EconomicCalendar or_economicCalendar = null;

	public EconomicCalendar(WebDriver driver) {
		this.driver = driver;
		or_economicCalendar = PageFactory.initElements(driver, OR_EconomicCalendar.class);
	}

	/**
	 * clickYesterday clicks on Yesterday button
	 */
	public void clickYesterday() {
		driver.switchTo().frame(or_economicCalendar.iframe);
		if (or_economicCalendar.btnArrow.isDisplayed() && or_economicCalendar.btnArrow.isEnabled()) {
			or_economicCalendar.btnArrow.click();
		}
		clickBy(or_economicCalendar.btnYesterday);
	}

	/**
	 * clickYesterday clicks on Tomorrow
	 */
	public void clickTomorrow() {
		if (or_economicCalendar.btnArrow.isDisplayed() && or_economicCalendar.btnArrow.isEnabled()) {
			or_economicCalendar.btnArrow.click();
		}
		clickBy(or_economicCalendar.btnTomorrow);
	}

	/**
	 * clickThisWeek clicks on This Week
	 */
	public void clickThisWeek() {
		if (or_economicCalendar.btnArrow.isDisplayed() && or_economicCalendar.btnArrow.isEnabled()) {
			or_economicCalendar.btnArrow.click();
		}
		clickBy(or_economicCalendar.btnThisWeek);
	}

	/**
	 * clickThisWeek clicks on This Week
	 */
	public String getTextFromDateRange() throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(10000);
		String txtDateRangeText = or_economicCalendar.txtDateRange.getText();
		String[] parts = txtDateRangeText.split(" ");
		String actualDate = parts[0];
		return actualDate;

	}

	/**
	 * getFullDateRange gets the entire dates from date range
	 */
	public String getFullDateRange() throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(10000);
		String txtDateRangeText = or_economicCalendar.txtDateRange.getText();
		return txtDateRangeText;

	}
	/**
	 * clickThisWeek clicks on This Week
	 */
	public void getCurrentDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
	}

	/**
	 * getDateYesterday functions return the yesterday date in dd/mm/yyyy
	 */
	public String getDateYesterday() {
		Instant now = Instant.now();
		Instant yesterday = now.minus(1, ChronoUnit.DAYS);
		String strDateYesterday = getDateInDesiredFormat(yesterday.toString());
		return strDateYesterday;

	}

	/**
	 * getDateTomorrow functions return the tomorrow`s date in dd/mm/yyyy
	 */
	public String getDateTomorrow() {
		Instant now = Instant.now();
		Instant tomorrow = now.plus(1, ChronoUnit.DAYS);
		String strDateTomorrow = getDateInDesiredFormat(tomorrow.toString());
		System.out.println("I am tomorrow " + strDateTomorrow);
		return strDateTomorrow;
	}
	/**
	 * getDateTomorrow functions return the tomorrow`s date in dd/mm/yyyy
	 */
	public String getWeekEndAndStartDates() {
		String strStartDate = getWeekStartDate();
		String strLastDate = getWeekEndDate();
		String strWeekendRange = strStartDate + " - " + strLastDate;
		return strWeekendRange;
	}

	/**
	 * clickThisWeek clicks on This Week
	 */
	public void clickHere() {
		driver.switchTo().parentFrame();
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].click();", or_economicCalendar.lnkHere);
	}

	/**
	 * clickThisWeek clicks on This Week
	 */
	public void clickRiskHere() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1300)", "");
		js.executeScript("arguments[0].click();", or_economicCalendar.lnkRiskHere);
	}

	/**
	 * clickThisWeek clicks on This Week
	 */
	public String verifyRiskHerePage() {
		String url = driver.getCurrentUrl();
		return url;
	}

	/**
	 * validatePDF , validates the pdf open in new tab
	 */
	public String validatePDF() throws InterruptedException {
		String url = "";
		String parent = driver.getWindowHandle();
		Set < String > s1 = driver.getWindowHandles();
		Iterator < String > I1 = s1.iterator();
		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				url = driver.switchTo().window(child_window).getCurrentUrl();
				driver.close();
			}
		}
		return url;
	}

}
