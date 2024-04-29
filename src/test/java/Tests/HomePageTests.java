package Tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import base.BaseTest;
import pageEvents.HomePageEvents;
import pageObjects.HomePageElements;
public class HomePageTests extends BaseTest{
	
	HomePageEvents homepageEvents = new HomePageEvents();
	HomePageElements homepageElements = new HomePageElements();
	
	@Test
	public void verifyPublicationOptions() {
		List<WebElement> options = homepageEvents.getPublicationOptions();
		
		for(WebElement option:options) {
			System.out.println(option.getText());
		
			}
	}

}
