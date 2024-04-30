package pageObjects;

import org.openqa.selenium.By;

public class HomePageElements {
	
	public By navBarId = By.id("navbar-nav");
	public By publicationDropdown = By.id("publicationDDL");
	public static By publicationOptions = By.cssSelector("#publicationDDL option");
	
	public By Category = By.id("classCatDDL");
	public By subCategory = By.id("classCatDDL2");
	public static By categoryOptions = By.cssSelector("#classCatDDL option");
	public static By categoryOptions1 = By.cssSelector("#classCatDDL option[1]");
	public static By subCategoryOptions = By.cssSelector("#classCatDDL2 option");
	
	

}
