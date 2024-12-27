package testClasses;


import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import retryAnalyzer.RetryAnalyzerClass;
import utilityClasses.ExcelReadClass;


public class LoginPageTestClass extends BaseClass {
	LoginPageClass lp;
	HomePageClass hp;

	@Test(priority=1,retryAnalyzer = RetryAnalyzerClass.class,groups = {"functional"})
	public void verifySuccessfulLogin() throws IOException {
		lp = new LoginPageClass(driver);
		hp = lp.login(ExcelReadClass.getStringdata(0, 0),ExcelReadClass.getIntegerdata(0, 1));
//hp=lp.login(Constants.username,Constants.password);
		hp.clickOnEndTour();
		String actualResult = hp.getTextOfWelcomeAdmin();
		Assert.assertTrue(actualResult.contains(ExcelReadClass.getStringdata(5, 0)));
	}
	@Test(priority=2,groups = {"functional"},dataProviderClass=DataProviderUnsuccessfulLogin.class, dataProvider="dp1",retryAnalyzer = RetryAnalyzerClass.class)
	public void verifyUnsuccessfulLogin(String uname, String pword) throws IOException
	{
		lp= new LoginPageClass(driver);
		lp.login(uname, pword);
		String actualResult = lp.getTextOfErrorMsg();
		String expectedResult =ExcelReadClass.getStringdata(6, 0);
		Assert.assertEquals(actualResult, expectedResult);		
	}
	@Test(priority=3,retryAnalyzer = RetryAnalyzerClass.class)
	public void verifyCheckBoxIsSelectedByDefaultOrNot()
	{
		lp= new LoginPageClass(driver);
		boolean actualResult = lp.checkBoxIsSelectedOrNot();
		Assert.assertFalse(actualResult);
	}
	@Test(priority=4,retryAnalyzer = RetryAnalyzerClass.class)
	public void verifyTheExactURL_opensWhileHittingTheBaseURL()
	{
		lp=new LoginPageClass(driver);
		String actualResult =  lp.getURLOfThePage();
		String expectedResult="https://qalegend.com/billing/public/login";
		Assert.assertEquals(actualResult, expectedResult);
				
	}
	@Test(priority=5,retryAnalyzer = RetryAnalyzerClass.class)
	public void verifyResetPasswordPageComingWhileComingOnForgotYourPassword()
	{
		lp=new LoginPageClass(driver);
		lp.clickOnForgotPassword();
		String actualResult = lp.getTextOfResetEmail();
		System.out.println(actualResult);
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(actualResult.contains("Password"));
		soft.assertAll();
	}

}
