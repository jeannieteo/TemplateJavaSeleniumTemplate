package Tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import pageEvents.HomePageEvents;
import pageObjects.HomePageElements;
import utils.ExcelReader;
public class HomePageTests extends BaseTest{
	
	HomePageEvents homepageEvents = new HomePageEvents();
	HomePageElements homepageElements = new HomePageElements();
	ExcelReader reader =  new ExcelReader();
	
	@Test
	public void verifyPublicationOptions() {
		SoftAssert softAssert = new SoftAssert();
		List<WebElement> options = homepageEvents.getPublicationOptions();
		List<String> expectedOptions = reader.getColumnDatas("HomePage", "PublishDropdown");
		//for(WebElement option:options) {
		for(int i = 0; i < options.size(); i++)	{
			softAssert.assertEquals(options.get(i).getText(), expectedOptions.get(i+1));
			System.out.println(options.get(i).getText() + " VS " + expectedOptions.get(i+1));			
			}
		softAssert.assertAll();
	}
	
	@Test
	public void verifyCategoryOptions() {
		SoftAssert softAssert = new SoftAssert();
		List<WebElement> options = homepageEvents.getCategoryOptions();
		List<String> expectedOptions = reader.getColumnDatas("HomePage", "CategoryDropdown");
		
		for(int i = 0; i < options.size(); i++)	{
			softAssert.assertEquals(options.get(i).getText(), expectedOptions.get(i+1));
			System.out.println(options.get(i).getText() + " VS " + expectedOptions.get(i+1));			
			}
		softAssert.assertAll();
	}
	
	@Test
	public void verifySubCategoryOptions() {
		
		//homepageEvents.clickElement(homepageElements.Category);
		homepageEvents.selectDropdown(homepageElements.Category, "Houses for Sale");
		List<WebElement> options = homepageEvents.getSubCategoryOptions();
		
		for(int i = 0; i < options.size(); i++)	{
			System.out.println(options.get(i).getText() + " VS ");			
			}
		
	}
	

}
