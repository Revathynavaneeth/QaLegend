package utilityClasses;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities 
{
	
	public void clickOnElement(WebElement element)
	{
		element.click();
	}
	public void typeOnElement(WebElement element, String value)
	{
		element.sendKeys(value);
	}
	public String getTextOfElement(WebElement element)
	{
		return element.getText();
		
	}
	public static String getAttributeValueOfElement(WebElement element, String attributeName) 
	{
        return element.getAttribute(attributeName);
    }
	public String getTitileOfThePage(WebDriver driver)
	{
		return driver.getTitle();
		
	}
	public boolean isElementDisplayed(WebElement element)
	{
		return element.isDisplayed();
	}
	public void addThreadSleep() throws InterruptedException
	{
		Thread.sleep(3000);
	}
	public void scrollToFindAnElement(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	public String getTextOfAlertMsg(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	
	}
	public void selectByIndexDropDown(WebElement element,int index)
	{
		Select select =new Select(element);
		select.selectByIndex(index);
		}
	public void deSelectByIndexDropDown(WebElement element,int index)
	{
		Select select =new Select(element);
		select.deselectByIndex(index);
		}
	public void SelectByValueDropDown(WebElement element,String value)
	{
		Select select =new Select(element);
		 select.selectByValue(value);
		}
	public void deSelectByValueDropDown(WebElement element,String value)
	{
		Select select =new Select(element);
		 select.deselectByValue(value);
		}
	public void pressEnterKey(WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.keyDown(Keys.ENTER).build().perform();
	}
	public void deSelectAllOptions(WebElement element)
	{
		Select select=new Select(element);
		select.deselectAll();
	}
	
	public String getCssValue(WebElement element,String value)
	{
		return element.getCssValue(value);
		
	}
	public boolean isSelectedMethod(WebElement element)
	{
		return element.isSelected();
	}
	public boolean isEnabledMethod(WebElement element)
	{
		return element.isEnabled();
	}
	public String getCurrentUrl(WebDriver driver)
	{
		return driver.getCurrentUrl();
		
	}
	public void clearElement(WebElement element)
	{
		element.clear();
	}
	public void acceptAlertMessage(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void dismissAlertMessage(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public void SelectByVisibleText(WebElement element,String value)
	{
		Select select =new Select(element);
		 select.selectByVisibleText(value);
		}
	public void deSelectByVisibleText(WebElement element,String value)
	{
		Select select =new Select(element);
		 select.deselectByValue(value);
		}
	public boolean isMultipleMethod(WebElement element, String value)
	{
		Select select =new Select(element);
		return select.isMultiple();
	}
	public void SelectAllOptions(WebElement element)
	{
		Select select=new Select(element);
		select.getAllSelectedOptions();
	}
	public String getFirstSelectedOptionMethod(WebElement element,String value)
	{
		Select select=new Select(element);
	    ((Select) element).getFirstSelectedOption();
		return value;
	}
	public void moveToElement(WebDriver driver,WebElement element )
	{
        
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }
	 public  void sendKeysToAlert(WebDriver driver, String inputText) 
	 {
	        Alert alert = driver.switchTo().alert();
	        alert.sendKeys(inputText);
	        alert.accept();
	
	}
	 public  void hoverMouseOverElement(WebDriver driver, WebElement element) {
	        Actions actions = new Actions(driver);
	        actions.moveToElement(element).perform();
	    }
	
}
