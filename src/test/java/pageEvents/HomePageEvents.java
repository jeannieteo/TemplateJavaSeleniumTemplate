package pageEvents;

import java.util.List;
import base.BaseTest;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pageObjects.HomePageElements;

public class HomePageEvents {
	

	public List<WebElement> getPublicationOptions()	{
		List<WebElement> options = base.BaseTest.driver.findElements(HomePageElements.publicationOptions);

		return options;
	
	}
	
	public List<WebElement> getCategoryOptions()	{
		List<WebElement> options = base.BaseTest.driver.findElements(HomePageElements.categoryOptions);

		return options;
	
	}
	
	public List<WebElement> getSubCategoryOptions()	{
		List<WebElement> options = base.BaseTest.driver.findElements(HomePageElements.subCategoryOptions);

		return options;
	
	}
	
	public void clickElement(By by)	{
		base.BaseTest.driver.findElement(by).click();
	}
	
	public void selectDropdown(By by, String value) {
		Select objSelect = new Select(base.BaseTest.driver.findElement(by));
		objSelect.selectByValue(value);
	}
	
}
