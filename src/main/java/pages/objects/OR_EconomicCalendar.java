package pages.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
/**
 * @author MUHAMMAD ASHAR
 * Dated: 28/10/2021
 */
public class OR_EconomicCalendar {

	// This element is used to click on Yesterday Button from the Economic Calendar

	@CacheLookup
	@FindBy (how = How.ID, using=("timeFrame_yesterday"))
	public WebElement btnYesterday;


	// This element is used to click on Tomorrow Button from the Economic Calendar
	@CacheLookup
	@FindBy (how = How.ID, using=("timeFrame_tomorrow"))
	public WebElement btnTomorrow;

	@CacheLookup
	@FindBy (how = How.ID, using=("timeFrame_thisWeek"))
	public WebElement btnThisWeek;

	@CacheLookup
	@FindBy (how = How.CSS, using=("li.openArrow span"))
	public WebElement btnArrow;

	// This element is get the Date Range from

	@FindBy (how = How.CSS, using=("div#widgetFieldDateRange"))
	public WebElement txtDateRange;

	// Iframe

	@CacheLookup
	@FindBy (how = How.CSS, using=("iframe[title='economicCalendar']"))
	public WebElement iframe;

	// This element is get the Date Range from

	@CacheLookup
	@FindBy (how = How.XPATH, using=("//a[text()='here']"))
	public WebElement lnkHere;

	// This element is get the Date Range from

	@CacheLookup
	@FindBy (how = How.XPATH, using=("//strong[text()='Risk Disclosure']/following-sibling::a"))
	public WebElement lnkRiskHere;





}
