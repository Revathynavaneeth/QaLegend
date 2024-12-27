package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClasses.ExplicitWaitClass;
import utilityClasses.FileUpload;
import utilityClasses.GeneralUtilities;

public class ProductPageClass {
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	FileUpload fl = new FileUpload();
	ExplicitWaitClass ew= new ExplicitWaitClass();

	public ProductPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//section[@class='content-header']")
	WebElement productText;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/billing/public/products/create']")
	WebElement addButton;
	
	@FindBy(id="name")
	WebElement productName;
	
	@FindBy(id="alert_quantity")
	WebElement alertQuantity;
	
	@FindBy(xpath="//input[@id='expiry_period']")
	WebElement expiryPeriod;
	
	@FindBy(xpath="//input[@id='single_dpp']")
	WebElement exclusiveTax;
	
	@FindBy(xpath="//input[@id='single_dpp_inc_tax']")
	WebElement inclusiveTax;
	
	@FindBy(xpath="//button[@class='btn btn-primary submit_product_form']")
	WebElement saveButton;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement searchBar;
	
	@FindBy(xpath="//tbody/tr/td[@class='sorting_1']")
	WebElement searchInput;
	
	@FindBy(xpath="//input[@id='upload_image']")
	WebElement browseButton;
	
	@FindBy(xpath="//button[@class='btn btn-info dropdown-toggle btn-xs']")
	WebElement actions;
	
	@FindBy(xpath="//a[@class='delete-product']")
	WebElement delete;
	
	@FindBy(xpath="//button[text()='OK']")
	WebElement okButton;
	
	
	@FindBy(xpath="//tbody/tr/td[@class='dataTables_empty']")
	WebElement noMatchingRecords;
	
	
	
	
	public String getTextOfProductTextHeading()
	{
		return gl.getTextOfElement(productText);
	}
	public void addNewProdutct(String pname, String alertQ, String image,String expiry,String exltax,String incltax)
	{
		gl.clickOnElement(addButton);
		gl.typeOnElement(productName, pname);
		gl.typeOnElement(alertQuantity, alertQ);
		fl.uploadfile(browseButton,image);
		gl.typeOnElement(expiryPeriod, expiry);
		gl.scrollToFindAnElement(driver, exclusiveTax);
		gl.typeOnElement(exclusiveTax, exltax);
		gl.typeOnElement(inclusiveTax, incltax);
		gl.clickOnElement(saveButton);
		
		
	}
	public void searchAddedProductOnSearchBarAfterAddition(String searchData)
	{
		 gl.typeOnElement(searchBar, searchData);
		 
	}
	public String getTextOfAddedProductAfterSearch()
	{
		return gl.getTextOfElement(searchInput);
	}
	
	public void deleteAddedProduct()
	{
		gl.clickOnElement(actions);
		gl.clickOnElement(delete);
		gl.clickOnElement(okButton);
	}
	
	
	public String getTextOfNoMatchingRecordsAfterDeletion()
	{
		return gl.getTextOfElement(noMatchingRecords);
	}
	
}
