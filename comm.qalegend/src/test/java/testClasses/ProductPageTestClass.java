package testClasses;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.ManageUsersPageClass;
import pageClasses.ProductPageClass;
import retryAnalyzer.RetryAnalyzerClass;
import utilityClasses.RandomDataUtility;

public class ProductPageTestClass extends BaseClass {
	LoginPageClass lp;
	HomePageClass hp;
	ManageUsersPageClass mp;
	ProductPageClass pp;

	@Test(retryAnalyzer = RetryAnalyzerClass.class,priority=1)
	public void verifyProductsPageIsOpenWhileClickingOnListProducts() {
		lp = new LoginPageClass(driver);
		hp = lp.login("admin", "123456");
		hp.clickOnEndTour();
		hp.clickOnProducts();
		pp = hp.clickOnListProducts();
		String actualResult = pp.getTextOfProductTextHeading();
		System.out.println(actualResult);
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(actualResult.contains("Products"));
		soft.assertAll();
	}

	@Test(retryAnalyzer = RetryAnalyzerClass.class,priority=2)
	public void verifyTocreateA_newProduct() 
	{
		lp = new LoginPageClass(driver);
		hp = lp.login("admin", "123456");
		hp.clickOnEndTour();
		hp.clickOnProducts();
		pp = hp.clickOnListProducts();
		pp.addNewProdutct("Orange", "120",System.getProperty("user.dir")+"\\src\\test\\resources\\lord-vishnu-sree-padmanabhaswamy-temple-trivandrum.jpg", "30","150", "150");
		pp.searchAddedProductOnSearchBarAfterAddition("orange");
		String actualResult = pp.getTextOfAddedProductAfterSearch();
		System.out.println(actualResult);
		Assert.assertTrue(actualResult.contains("Orange"));
	}
	@Test(groups = {"functional"},retryAnalyzer = RetryAnalyzerClass.class,priority=3)
	
	public void verifyToDeleteAddedProduct()
	{
		lp = new LoginPageClass(driver);
		hp = lp.login("admin", "123456");
		hp.clickOnEndTour();
		hp.clickOnProducts();
		pp = hp.clickOnListProducts();
		pp.searchAddedProductOnSearchBarAfterAddition("orange");
		pp.deleteAddedProduct();
		String actualResult=pp.getTextOfNoMatchingRecordsAfterDeletion();
		Assert.assertTrue(actualResult.contains("records"));
		
	}
	
	@Test(retryAnalyzer = RetryAnalyzerClass.class,priority=4)
	public void verifyToCreateAndDeleteA_NewProductUsingRandomDataUtility()
	{
		String pname=RandomDataUtility.getProductName();
		String alertQuantity=RandomDataUtility.getAlertQuantity();
		String expiry=RandomDataUtility.getExpiryPeriod();
		String exlusiveTax=RandomDataUtility.getExclusiveTax();
		String inclusiveTax=RandomDataUtility.getInclusiveTax();

		lp = new LoginPageClass(driver);
		hp = lp.login("admin", "123456");
		hp.clickOnEndTour();
		hp.clickOnProducts();
		pp = hp.clickOnListProducts();
		pp.addNewProdutct(pname, alertQuantity,System.getProperty("user.dir")+"\\src\\test\\resources\\lord-vishnu-sree-padmanabhaswamy-temple-trivandrum.jpg", expiry, exlusiveTax, inclusiveTax);
		pp.searchAddedProductOnSearchBarAfterAddition(pname);
		pp.deleteAddedProduct();
		String actualResult=pp.getTextOfNoMatchingRecordsAfterDeletion();
		Assert.assertTrue(actualResult.contains("records"));
		
		
	}
}

