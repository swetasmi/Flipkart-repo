package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PricePage {
	
	@FindBy(xpath="//span[text()='Price details']")
	private WebElement pricetag;
	
	public PricePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getPricetag() {
		return pricetag;
	}

	public void setPricetag(WebElement pricetag) {
		this.pricetag = pricetag;
	}
	
	public String pricetext()
	{
		String pricetext = pricetag.getText();
		return pricetext;
	}
}


