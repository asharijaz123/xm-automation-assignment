package tests;

import base.SeleniumBase;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.pages.EconomicCalendar;
import pages.pages.Home;
import java.io.IOException;

/**
 * @author MUHAMMAD ASHAR
 * Dated: 27/10/2021
 */
public class TEST_ValidateUI extends SeleniumBase {


	@Test(dataProvider = "getData")
	public void EconomicCalendar(String browserType,int width,int height) throws IOException, InterruptedException {
		String childURL = "https://www.xm.com/assets/pdf/new/docs/XMGlobal-Risk-Disclosures-for-Financial-Instruments.pdf?v8";
		String riskHereURL = "https://www.xm.com/research/risk_warning";
		System.out.println ("The browser type is "+browserType);
		driver = initializeBrowser(browserType,width,height);
		driver.get(prop.getProperty("url"));
		Home home = new Home(driver);
		EconomicCalendar economicCalendar = new EconomicCalendar(driver);
		home.clickResearchEducation();
		home.clickEconomicCalendar();
		economicCalendar.clickYesterday();
		Assert.assertEquals(economicCalendar.getDateYesterday(), economicCalendar.getTextFromDateRange());
		economicCalendar.clickTomorrow();
		Assert.assertEquals(economicCalendar.getDateTomorrow(), economicCalendar.getTextFromDateRange());
		economicCalendar.clickThisWeek();
		Assert.assertEquals(economicCalendar.getWeekEndAndStartDates(), economicCalendar.getFullDateRange());
		economicCalendar.clickHere();
		Assert.assertEquals(economicCalendar.verifyRiskHerePage(), riskHereURL);
		economicCalendar.clickRiskHere();
		Assert.assertEquals(economicCalendar.validatePDF(), childURL);

	}

	@AfterMethod
	public void tearDown() {
	//	driver.quit ();
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[3][3];
		data[0][0] = "edge";
		data[0][1]=1024;
		data[0][2]=768;
		data[1][0] = "chrome";
		data[1][1]=800;
		data[1][2]=600;
		data[2][0] = "edge";
		data[2][1]=0;
		data[2][2]=0;

		return data;
	}
}
