package stepDefinitions;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPageObjects;
import utilities.BaseClass;

public class LoginPageSteps {
	WebDriver driver;
	Properties prop;
	Logger logger;
	
	public LoginPageSteps() {
		this.driver = BaseClass.getDriver();
		this.prop = BaseClass.getProperties();
		this.logger = BaseClass.getLogger();
	}
	LoginPageObjects loginPageObjects;
	@Given("User is on login page of the application")
	public void verify_LoginPage_Title() {
		loginPageObjects = new LoginPageObjects(driver);
		logger.info("*****************opening url*****************");
		loginPageObjects.verify_LoginPage_Title(prop.getProperty("CMS_URL"));
	}

	@When("User enters valid username")
	public void inputUsername() {
		loginPageObjects.inputUsername(prop.getProperty("CMS_Username"));
	}

	@And("Enters valid password")
	public void inputPassword() {
		loginPageObjects.inputPassword(prop.getProperty("CMS_Password"));
	}

	@And("Click on Login button")
	public void clickLoginButton() {
		loginPageObjects.clickLoginButton();
	}

	@Then("User should redirects to CMS home page")
	public void assert_CMS_HomePage() {
		boolean actual = loginPageObjects.cms_Homepage();
		Assert.assertEquals(actual, true);
	}

	@Given("User is on CMS homepage")
	public void CMS_HomePage() {
		boolean actual = loginPageObjects.cms_Homepage();
		Assert.assertEquals(actual, true);
	}

}
