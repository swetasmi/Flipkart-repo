package ObjectRepo;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.BaseClass;

public class HomePage extends BaseClass {
	
	@FindBy(name="q")
	private WebElement searchTbx;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchTbx() {
		return searchTbx;
	}

	public void setSearchTbx(WebElement searchTbx) {
		this.searchTbx = searchTbx;
	}
	
	//bussiness
	public void search(String productNAme)
	{
		 searchTbx.sendKeys(productNAme,Keys.ENTER);
		 
		
	}
	

}
