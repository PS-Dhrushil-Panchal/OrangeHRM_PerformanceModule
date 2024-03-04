package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.SeleniumMethods;

public class AdminPage extends SeleniumMethods {
	
	public AdminPage(WebDriver driver) {
		super(driver);
	}
	
	private By AdminSectionButton=By.className("oxd-main-menu-item");

}
