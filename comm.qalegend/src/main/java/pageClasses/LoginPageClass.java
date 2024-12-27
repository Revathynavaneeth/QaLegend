package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClasses.GeneralUtilities;

public class LoginPageClass {
	
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	
	public LoginPageClass(WebDriver driver) 
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="username") 
	WebElement username;
	
	@FindBy(id="password")
	WebElement  password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginbutton;
	
	@FindBy(xpath = "//strong[contains(text(),'credentials')]")//xpath=//*[@class='help=block']/child::strong
	WebElement invalidMsg;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/billing/public/password/reset']")
	WebElement forgetPassword;
	
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement checkBox;
	
	@FindBy(xpath="//div[@class='panel-heading']")
	WebElement emailResetMsg;
	
	@FindBy(xpath="//div[@class='panel-heading']")
	WebElement loginText;
	
	public HomePageClass login(String uname, String pword)
	{
		gl.typeOnElement(username, uname);
		gl.typeOnElement(password, pword);
		gl.clickOnElement(loginbutton);
		return new HomePageClass(driver);
	}
	
  public String getTextOfErrorMsg()
  {
	  return gl.getTextOfElement(invalidMsg);
  }
  public boolean checkBoxIsSelectedOrNot()
	{
		return gl.isSelectedMethod(checkBox);
	}
	public String getURLOfThePage()
	{
		return gl.getCurrentUrl(driver);
	}
	public void clickOnForgotPassword()
	{
		gl.clickOnElement(forgetPassword);
	}
	public String getTextOfResetEmail()
	{
		return gl.getTextOfElement(emailResetMsg);
	}
	public String getTextOfLoginAfterSuccessfullSignout()
	{
		return gl.getTextOfElement(loginText);
	}
  }
