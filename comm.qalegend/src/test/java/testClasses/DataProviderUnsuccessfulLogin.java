package testClasses;

import org.testng.annotations.Test;

import utilityClasses.ExcelReadClass;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderUnsuccessfulLogin {
  
  @DataProvider(name="dp1")
  public Object[][] dp() throws IOException {
	    return new Object[][] {
	      new Object[] {ExcelReadClass.getStringdata(1, 0),ExcelReadClass.getIntegerdata(1, 1)},
	      new Object[] { ExcelReadClass.getStringdata(2, 0),ExcelReadClass.getIntegerdata(2,1) },
	      new Object[] { ExcelReadClass.getStringdata(3, 0),ExcelReadClass.getIntegerdata(3, 1) },
	    };
}
}
