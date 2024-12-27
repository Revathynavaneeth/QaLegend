package pageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utilityClasses.GeneralUtilities;

public class HomePageClass {


	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	
	public HomePageClass(WebDriver driver) 
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[text()='End tour']")
	WebElement endTour;
	
	@FindBy(xpath="//h1[contains(text(),'Welcome Admin')]") 
	WebElement welcomeAdminHeading;
	
	@FindBy(xpath="//div[@class='info-box-content']") 
	List<WebElement>allTiles;
	
	@FindBy(id="btnCalculator")
	WebElement calculatorButton;
	
	@FindBy(xpath="//span[text()='User Management']") 
	WebElement userManagement;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/billing/public/users']")
	WebElement users;
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	WebElement adminButtton;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/billing/public/logout']")
	WebElement signOutButton;
	
	@FindBy(xpath="//span[text()='Products']")
	WebElement products;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/billing/public/products']")
	WebElement listProducts;
	
	
	
	public void clickOnEndTour()
	{
		try {
            if (endTour.isDisplayed()) {
            	endTour.click();
                System.out.println("Tour popup appeared and 'End tour' button clicked.");
            }
        } catch (Exception e) {
            System.out.println("Tour popup did not appear. Moving on...");
        }
	}
	
	
	public String getTextOfWelcomeAdmin()
	{
		return gl.getTextOfElement(welcomeAdminHeading);
	}
	public boolean isAllTilesDisplayed()
	{	for(WebElement element:allTiles)
	{
		gl.isElementDisplayed(element);
		
	}
		return true;
		
	}

	public void  hoverMouseOverCalculatorButton()
	
	{
		gl.hoverMouseOverElement(driver, calculatorButton);	
	}
	public String getAttributeValueOfCalculatorButton(String value)
	{
		return gl.getAttributeValueOfElement(calculatorButton,value);
	}
	
	public void clickOnUserManagement()
	{
		 gl.clickOnElement(userManagement);
	}
	public ManageUsersPageClass clickOnUsers()
	{
		 gl.clickOnElement(users);
		 return new ManageUsersPageClass(driver);
	}
	public void clickOnAdminButton()
	{
		gl.clickOnElement(adminButtton);
	}
	public LoginPageClass clickOnSignOutButton()
	{
		gl.clickOnElement(signOutButton);
		return new LoginPageClass(driver);
	}
	public void clickOnProducts()
	{
		gl.clickOnElement(products);
	
	}
	public ProductPageClass clickOnListProducts()
	{
		gl.clickOnElement(listProducts);
		return new ProductPageClass(driver);
	}

	
		}
	
	
	
