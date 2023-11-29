import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import ObjectRepo.HomePage;
import ObjectRepo.PricePage;
import ObjectRepo.ProductPage;

public class AddAProductToCartTest extends BaseClass{
	@Test
	public void addAProductToCartTest() throws InterruptedException
	{
		
		//Inputs from user
		String expData = "PRICE DETAILS";
		String searchProduct="mobile";
		int pinCode=110092;
		
		
		//Maximise the browser and enter url of flipkart
		wLib.implicityWait(driver, 10);
		wLib.maximize(driver);
		driver.get("https://www.flipkart.com/");
		
		//handle the pop-up
       driver.findElement(By.xpath("//span[.='✕']")).click();

       //Search the product
		HomePage hp=new HomePage(driver);
		hp.search(searchProduct);
		
		//Dynamic xpath of first product
		String xpathOfFirstProd="//div[@class='W_R1IA']/../../../descendant::div[@class=\"_1AtVbE col-12-12\"][1]";
		driver.findElement(By.xpath(xpathOfFirstProd)).click();
		
		//Switching the window
		wLib.switchToWindow2(driver);
		Thread.sleep(3000);
		
		//Enter 6 digit pin code and click on the cart button
		ProductPage pp=new ProductPage(driver);
		pp.enterPinCode(pinCode);
		//Thread.sleep(2000);

		pp.clickOnCart();
		
		//Validating cart page.
		PricePage ppage=new PricePage(driver);
		String pricetext = ppage.pricetext();
		Assert.assertEquals(expData, pricetext);
		System.out.println("Product is suuccessfully added.");
//		
	}

}
