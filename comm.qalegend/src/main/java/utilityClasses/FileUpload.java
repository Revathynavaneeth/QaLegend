package utilityClasses;

import org.openqa.selenium.WebElement;

public class FileUpload 
{
public void uploadfile(WebElement element, String path)
{
	element.sendKeys(path);
}
}
