package pages.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
/**
 * @author MUHAMMAD ASHAR
 * Dated: 27/10/2021
 */
public class OR_Home {

	// This element is used to click on Research Button from Top Bar

	@CacheLookup
	@FindBy (how = How.CSS, using=("li.main_nav_research"))
	public WebElement btnResearchEducation;

	@CacheLookup
	@FindBy (how = How.CSS, using=("a[aria-controls='researchMenu']"))
	public WebElement btnResearchEducationSmallView;

	// This element is used to click on Economic Calendar

	@CacheLookup
	@FindBy (how = How.CSS, using=("li.menu-research:nth-child(6) a"))
	public WebElement btnEconomicCalender;

	@CacheLookup
	@FindBy (how = How.CSS, using=("a i.fa.fa-calendar"))
	public WebElement btnEconomicCalenderSmallView;


	// This element is used to Accept the Cookie

	@CacheLookup
	@FindBy (how = How.XPATH, using=("//button[text()='CONTINUE']"))
	public WebElement btnAcceptCookies;

	@CacheLookup
	@FindBy (how = How.CSS, using=("button.toggleLeftNav span"))
	public WebElement btnLeftNavMenu;


}
