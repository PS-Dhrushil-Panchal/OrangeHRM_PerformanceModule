package stepDefinitions;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import utilities.BaseClass;

public class LoginStepDef {
	
	
	WebDriver driver;
	Properties prop;
	Logger logger;
	
	
	public LoginStepDef() {

	this.driver=BaseClass.getDriver();
	this.prop=BaseClass.getProperties();
	this.logger=BaseClass.getLogger();
	}
	
	LoginPage obj;
	
	@Given("User is on LoginPage")
	public void user_is_on_login_page() {
	   
		obj=new LoginPage(driver);
		logger.info("*****************opening url*****************");
		obj.portalLoginPage(prop.getProperty("URL"));

	}
	@When("User enter invalid credentials")
	public void user_enter_invalid_credentials() {
		obj.inputCredentials(prop.getProperty("Username"),prop.getProperty("Password"));
		
	}
	@When("click on Login button")
	public void click_on_login_button() {

		obj.clickLogin();
	}
	@Then("User gets {string} message and access to portal is denied")
	public void user_gets_message_and_access_to_portal_is_denied(String string) {

			SoftAssert sa=new SoftAssert();
			String a=obj.getErrorMessageText();
			sa.assertEquals("Invalid credentials", a);
	}
	
	@When("User enter valid username and password")
	public void user_enter_valid_username_and_password() {
		obj.inputCredentials(prop.getProperty("Uname"),prop.getProperty("Pwd"));
	}
	
    @When("User clicks on Login button")
    public void user_clicks_on_login_button() {
    	
    	obj.clickLogin();
    	

    }
    @Then("User is redirected to Homepage of OrangeHRM")
    public void user_is_redirected_to_homepage_of_orangehrm() {
    	


    }
	
	

}
