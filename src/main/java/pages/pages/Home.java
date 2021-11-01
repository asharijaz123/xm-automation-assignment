package pages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.objects.OR_Home;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.concurrent.TimeUnit;

/**
 * @author MUHAMMAD ASHAR
 * Dated: 27/10/2021
 */
public class Home extends CommonMethods {

	public WebDriver driver;
	OR_Home or_home = null;

	public Home(WebDriver driver) {
		this.driver = driver;
		or_home = PageFactory.initElements(driver, OR_Home.class);
	}

	/**
	 * clickResearchEducation clicks on Research Education from the Nav bar
	 */
	public void clickResearchEducation() throws InterruptedException {
		clickBy(or_home.btnAcceptCookies);
		if (or_home.btnLeftNavMenu.isDisplayed() && or_home.btnLeftNavMenu.isEnabled()) {
			or_home.btnLeftNavMenu.click();
		}

		if (or_home.btnResearchEducationSmallView.isDisplayed() && or_home.btnResearchEducationSmallView.isEnabled()) {
			or_home.btnResearchEducationSmallView.click();
		}
		if (or_home.btnResearchEducation.isDisplayed() && or_home.btnResearchEducation.isEnabled()) {
			clickBy(or_home.btnResearchEducation);
		}
		TimeUnit.MILLISECONDS.sleep(10000);
	}

	/**
	 * clickResearchEducation clicks on Research Education from the Nav bar
	 */
	public void clickEconomicCalendar() {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("window.scrollBy(0,600)", "");
		if (or_home.btnEconomicCalenderSmallView.isDisplayed() && or_home.btnEconomicCalenderSmallView.isEnabled()) {
			clickBy(or_home.btnEconomicCalenderSmallView);
		}
		javascriptExecutor.executeScript("arguments[0].click();", or_home.btnEconomicCalender);
	}

}
