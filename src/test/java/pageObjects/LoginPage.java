package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.SeleniumMethods;

public class LoginPage extends SeleniumMethods {
	
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	private By usernameField=By.name("username");
	private By passwordField=By.name("password");
	private By LoginButton=By.xpath("//button[@type='submit']");
	private By ErrorMessage=By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']");
	
	
	public void portalLoginPage(String url) {
		navigateURL(url);
		verifyTitle("OrangeHRM");
	}
	
	public void inputCredentials(String username, String Password)
	{
		sendKeys(usernameField,username);
		sendKeys(passwordField,Password);
		
	}
	
	
	
	public void clickLogin() {
		clickOn(LoginButton);
	}
	
	public String getErrorMessageText() {
	    return getText(ErrorMessage);
	}
	

}
