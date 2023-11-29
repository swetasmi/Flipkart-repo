package GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;



public class WebDriverUtility {
  /**
   * maximize the browser
   * @param driver
   */
		public void maximize(WebDriver driver)
		{
			driver.manage().window().maximize();
		}
		/**
		 * minimize the browser
		 * @param driver
		 */
		public void manimize(WebDriver driver)
		{
			driver.manage().window().minimize();;
		}
		/**
		 * This method is use to wait until the WebElement is loaded in the page
		 * @param driver
		 * 
		 * @param duration
		 */
		public void implicityWait(WebDriver driver,int duration)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
		}
		
		/**
		 * This method will wait untill the url of the page gets load
		 * @param driver
		 * @param duration
		 * @param expectedurl
		 */
		
		public void waituntillurlload(WebDriver driver,int duration,String expectedurl)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
			wait.until(ExpectedConditions.urlContains(expectedurl));
		}
		
		/**
		 * This method will wait untill the title of the page gets load
		 * @param driver
		 * @param duration
		 * @param expectedtitle
		 */
		public void waituntillTitleload(WebDriver driver,int duration,String expectedtitle)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
			wait.until(ExpectedConditions.titleContains(expectedtitle));
		}
		
		/**
		 * This method will wait untill the element of the page gets load
		 * @param driver
		 * @param duration
		 * @param ele
		 */
		public void waituntillElementToBeClicklable(WebDriver driver,int duration,WebElement ele)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
			wait.until(ExpectedConditions.elementToBeClickable(ele));
		}
		
		/**
		 * This method will ignore NoSuchElementException and continue the execution
		 * @param driver
		 * @param duration
		 */
		public void ignoreNoSuchElementException(WebDriver driver,int duration)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
			wait.ignoring(NoSuchElementException.class);
		}
		
		
		
		/**
		 * This method will select the dropdown based on index number
		 * @param element
		 * @param index
		 */
		public void selectDropDown(WebElement element,int index)
		{
			Select s=new Select(element);
			s.selectByIndex(index);
		}
		
		/**
		 * This method will select the dropdown element based on visible text
		 * @param element
		 * @param visibleText
		 */
		public void selectDropDownByVisisbleText(WebElement element,String visibleText)
		{
			Select s=new Select(element);
			s.selectByVisibleText(visibleText);
		}
		
		/**
		 * This method will select the dropdown element based on value
		 * @param value
		 * @param element
		 */
		public void selectDropDown(String value,WebElement element )
		{
			Select s=new Select(element);
			s.selectByValue(value);
		}
		
		/**
		 * This methods is used to mouseover an element
		 * @param driver
		 * @param element
		 */
		public void mouseOverElement(WebDriver driver,WebElement element)
		{
			Actions a=new Actions(driver);
			a.moveToElement(element).perform();
		}
		
		/**
		 * This methods is used to rightclick on an element
		 * @param driver
		 * @param element
		 */
		public void rightclick(WebDriver driver,WebElement element)
		{
			Actions a=new Actions(driver);
			a.contextClick().perform();
		}
		
		/**
		 * This methods is used to click on enter button
		 * @param driver
		 */
		public void clickonEnterKey(WebDriver driver)
		{
			Actions a=new Actions(driver);
			a.sendKeys(Keys.ENTER).perform();
		}
		
		public void dragAnddrop(WebDriver driver,WebElement drag, WebElement drop)
		{
			Actions a=new Actions(driver);
			a.dragAndDrop(drag, drop);
			
			
		}
		
		
		/**
		 * This method is used to switch from one window to another widow based on title
		 * @param driver
		 * @param expectedtitle
		 */
		public void switchWindowBasedOnTitle(WebDriver driver,String expectedtitle)
		{
			Set<String> all = driver.getWindowHandles();
			for(String single:all)
			{
				driver.switchTo().window(single);
				String title = driver.getTitle();
				if(title.contains(expectedtitle))
				{
					break;
				}
				
			}
		}
		
		public void switchToWindow2(WebDriver driver)
		{
			String main = driver.getWindowHandle();
			Set<String> all = driver.getWindowHandles();
			for(String id:all)
			{
				if(!(main.equals(id)))
				{
					driver.switchTo().window(id);
					System.out.println("succesfully switch to window");
				}
			}
		}
		
		/**
		 * This method is used to press the enter key
		 * @param driver
		 * @throws Throwable
		 */
		public void entetkey(WebDriver driver) throws Throwable
		{
			Robot rb=new Robot();
			rb.keyPress(KeyEvent.VK_ENTER);
		}
		
		/**
		 * This method is used to release the enter key
		 * @param driver
		 * @throws Throwable
		 */
		public void enterRelease(WebDriver driver) throws Throwable
		{
			Robot rb=new Robot();
			rb.keyRelease(KeyEvent.VK_ENTER);
		}
		
		
			
	}


