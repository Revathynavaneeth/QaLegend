package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.ManageUsersPageClass;
import retryAnalyzer.RetryAnalyzerClass;
import utilityClasses.RandomDataUtility;

public class ManageUsersTestClass extends BaseClass
{
  
	LoginPageClass lp;
	HomePageClass hp;
	ManageUsersPageClass mp;
	
	 @Test(retryAnalyzer = RetryAnalyzerClass.class,priority=1)
	  
	  public void verifyTheManagerUsersPageIsOpenWhileClickingOnUsers()
	  {
		  lp=new LoginPageClass(driver);
		  hp = lp.login("admin", "123456");
		  hp.clickOnEndTour(); 
		  hp.clickOnUserManagement();
		  mp= hp.clickOnUsers();
		  String actualResult = mp.getTextOfManageUser();
		  Assert.assertTrue(actualResult.contains("Manage"));
	  }
	 @Test(groups = {"functional"},retryAnalyzer = RetryAnalyzerClass.class,priority=2)
	 
	public void verifyToAddNewUser()
	 {
		  String uName=RandomDataUtility.getUserFullName();
		  String pword = RandomDataUtility.getPassword();
		  String email = RandomDataUtility.getRandomEmail();
		  
		  lp=new LoginPageClass(driver);
		  hp = lp.login("admin", "123456");
		  hp.clickOnEndTour();  
		  hp.clickOnUserManagement();
		  mp=hp.clickOnUsers();
		  mp.addNewUser(uName,email,pword,pword);
		  mp.searchAddedUserInTheSearchBar(uName);
		  boolean actualResult = mp.isCreatedUserNameDisplayed();
		  SoftAssert soft = new SoftAssert();
		  soft.assertTrue(actualResult);
		  soft.assertAll();
		  System.out.println("New User Added Successfully");
	 }
}
					
 

	

