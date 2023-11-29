package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	@FindBy(xpath="//button[text()='Add to cart']")
	private WebElement cartBtn;
	
	@FindBy(id = "pincodeInputId")
	private WebElement pinCodeTbx;
	
	@FindBy(xpath = "//span[.='Check']")
	private WebElement checkBtn;

	public WebElement getCheckBtn() {
		return checkBtn;
	}

	public void setCheckBtn(WebElement checkBtn) {
		this.checkBtn = checkBtn;
	}

	public WebElement getPinCodeTbx() {
		return pinCodeTbx;
	}

	public void setPinCodeTbx(WebElement pinCodeTbx) {
		this.pinCodeTbx = pinCodeTbx;
	}

	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCartBtn() {
		return cartBtn;
	}

	public void setCartBtn(WebElement cartBtn) {
		this.cartBtn = cartBtn;
	}
	
	//business library
	public void clickOnCart()
	{
		cartBtn.click();
	}
	
	public void enterPinCode(int pinCode) 
	{
		pinCodeTbx.sendKeys(pinCode+"");
		checkBtn.click();
	}
	
	
	
	
	
	
	
	
}
