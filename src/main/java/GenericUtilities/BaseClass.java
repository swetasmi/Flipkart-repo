package GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	
	public WebDriverUtility wLib=new WebDriverUtility();
	public WebDriver driver;
	
	@BeforeMethod
	public void launchBrowser()
	{
		driver=new EdgeDriver();
		System.out.println("Edge browser launched successfully.");
		
	}
	
	@AfterMethod
	public void closeBrowser()
   {
		driver.quit();
	}

}
