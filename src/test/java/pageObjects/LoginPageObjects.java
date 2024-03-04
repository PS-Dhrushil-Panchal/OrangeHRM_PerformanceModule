package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.SeleniumMethods;

public class LoginPageObjects extends SeleniumMethods {

	public LoginPageObjects(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By usernameField = By.id("txtUserName");
	private By passwordField = By.id("txtPassword");
	private By loginButton = By.id("btnLogin");
	private By homePageText = By.id("lstActiveIcon");
	
	public boolean cms_Homepage() {
		return getText(homePageText).contains("Dashboard");
	}
	
	public void verify_LoginPage_Title(String url) {
		navigateURL(url);
		verifyTitle("3E Login");
	}

	public void inputUsername(String username) {
		sendKeys(usernameField, username);
	}

	public void inputPassword(String password) {
		sendKeys(passwordField, password);
	}

	public void clickLoginButton() {
		clickOn(loginButton);
	}

}
