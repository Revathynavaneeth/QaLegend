package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClasses.GeneralUtilities;

public class ManageUsersPageClass 
{

WebDriver driver;
GeneralUtilities gl = new GeneralUtilities();

public ManageUsersPageClass(WebDriver driver) 
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	
	@FindBy(xpath="//a[@href='https://qalegend.com/billing/public/users/create']")
	WebElement addButton;
	
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="confirm_password")
	WebElement confirmPassword;
	
	@FindBy(id="submit_user_button")
	WebElement saveButton;
	
	@FindBy(xpath="//small[text()='Manage users']")
	WebElement manageUser;
	 
	@FindBy(xpath="//input[@type='search']")
	WebElement searchBar;
	
	@FindBy(xpath = "//table[@id='users_table']/tbody/tr/td[2]")
	WebElement searchName;
	
	
	
	public void clickOnAddButton()
	{
		gl.clickOnElement(addButton);
	}
	public void addNewUser(String fName,String mail,String pWord,String confirmPass)
	{
		 gl.clickOnElement(addButton);
		 gl.typeOnElement(firstName, fName);
		 gl.typeOnElement(email,mail);
		 gl.typeOnElement(password, pWord);
		 gl.typeOnElement(confirmPassword, confirmPass);
		 gl.clickOnElement(saveButton);
		
	}
	
	public String getTextOfManageUser()
	{
		return gl.getTextOfElement(manageUser);
	}
	public void searchAddedUserInTheSearchBar(String searchData)
	{
		gl.typeOnElement(searchBar, searchData);
	}
	public String getTextOfSearchName()
	{
		return gl.getTextOfElement(searchName);
	}
	public boolean isCreatedUserNameDisplayed() {

		return gl.isElementDisplayed(searchName);

	}

}
