package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * @author MUHAMMAD ASHAR
 * Dated: 26/10/2021
 */
public class SeleniumBase
{
	public static WebDriver driver;
	public Properties prop;
	public WebDriver initializeBrowser(String browserType,int width,int height) throws IOException
	{
		prop = new Properties ();
		FileInputStream fis = new FileInputStream ("src//main//java//data.properties");
		prop.load (fis);

		if (browserType.equals ("chrome")){
			WebDriverManager.chromedriver ().setup ();
			driver= new ChromeDriver ();

		}
		else if (browserType.equals ("edge")){
			WebDriverManager.edgedriver ().setup ();
			driver =new EdgeDriver ();
		}


		driver.manage ().window ().maximize ();
		Dimension dm = new Dimension(width,height);

		//Setting the current window to that dimension
		if (height!=0){
			driver.manage().window().setSize(dm);
		}
		driver.manage ().timeouts ().implicitlyWait (45, TimeUnit.SECONDS);
		return driver;
	}

}

