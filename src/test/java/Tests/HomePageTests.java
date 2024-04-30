package Tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
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
		List<WebElement> options = homepageEvents.getPublicationOptions();
		List<String> expectedOptions = null;
		
		expectedOptions = reader.getColumnDatas("HomePage", "PublishDropdown");
		//for(WebElement option:options) {
		for(int i = 0; i < options.size(); i++)	{
			System.out.println(options.get(i).getText() + " VS " + expectedOptions.get(i+1));
			}
	}

}
