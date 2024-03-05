package stepDefinitions;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ClaimObject;
import utilities.BaseClass;

public class ClaimStepDef {
	
	WebDriver driver;
	ClaimObject page;
	Properties prop;
	
	public ClaimStepDef() {
		// TODO Auto-generated constructor stub
		this.driver = BaseClass.getDriver();
		this.prop = BaseClass.getProperties();
	}

	@Given("User has click on submit claim buttom")
	public void user_has_click_on_submit_claim_buttom() {
		page = new ClaimObject(driver);
		page.ClickSubmit();
	}
	@When("user input require data into input fields")
	public void user_input_require_data_into_input_fields() {
		page.ValidInputs();
	}
	@When("click on create button")
	public void click_on_create_button() {
		page.ClickCreate();
	}
	@Then("Submit claim page should open")
	public void submit_claim_page_should_open() {
		page.AssertionOne();
	}
	
	//------------------------------------------------------------------//
	
	@Given("user has create claim without adding expense")
	public void user_has_create_claim_without_adding_expense() {
		page = new ClaimObject(driver);
		page.ClickSubmit();
		page.ValidInputs();
		page.ClickCreate();
	}
	@When("user click on add expense button")
	public void user_click_on_add_expense_button() {
		page.AddExpence();
	}
	@Then("a form for adding expense details should open")
	public void a_form_for_adding_expense_details_should_open() {
	}
	@When("user add require details inn form")
	public void user_add_require_details_inn_form() {
		page.AddData();
	}
	@When("click on save button")
	public void click_on_save_button() {
		page.clickSave();
	}
	@When("click on submit button")
	public void click_on_submit_button() {
	}
	@Then("claim amount should be updated.")
	public void claim_amount_should_be_updated() {
	}
	
	//------------------------------------------------------------------//
	

@Given("user has click on submit claim buton")
public void user_has_click_on_submit_claim_buton() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
@When("user does not input in require field")
public void user_does_not_input_in_require_field() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("{string} error message should be displayed.")
public void error_message_should_be_displayed(String string) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

}
