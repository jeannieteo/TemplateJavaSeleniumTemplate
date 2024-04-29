package pageEvents;

import java.util.List;
import base.BaseTest;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.HomePageElements;

public class HomePageEvents {
	

	public List<WebElement> getPublicationOptions()	{
		List<WebElement> options = base.BaseTest.driver.findElements(HomePageElements.publicationOptions);

		return options;
	
	}

}
