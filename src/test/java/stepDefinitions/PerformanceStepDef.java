package stepDefinitions;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.PerformancePage;
import utilities.BaseClass;

public class PerformanceStepDef {
	
	WebDriver driver;
	Properties prop;
	PerformancePage page;
	public PerformanceStepDef() {
		// TODO Auto-generated constructor stub
		this.driver = BaseClass.getDriver();
		this.prop = BaseClass.getProperties();
	}
	

    @Given("the user is on the report generation page")
    public void the_user_is_on_the_report_generation_page() {
        page = new PerformancePage(driver);
    }

    @When("the user enters a valid {string} and {string}")
    public void the_user_enters_a_valid_and(String employeeName, String department) {
    	page.SendValidInputs();
    }

    @When("clicks on the generate report button")
    public void clicks_on_the_generate_report_button() {
    	page.ClickSearch();
    }

    @Then("a report for the specified employee and department is displayed")
    public void a_report_for_the_specified_employee_and_department_is_displayed() {
    	page.AssertionforSc1(prop.getProperty("MsgForNoReocrd"));
    }
    
    
    //---------------------------------------------------------------------------//
   
    
    @When("the user enters an invalid {string} and a valid {string}")
    public void the_user_enters_an_invalid_and_a_valid(String employeeName, String department) {
    	page.InvalidNameInput();
    }

    
    @Then("reports of all the employee are displayed")
    public void reports_of_all_the_employee_are_displayed() {
    	page.AssertionforSc2(prop.getProperty("MsgForName"));
    }
    
  //---------------------------------------------------------------------------//

    @When("the user does not enter any data into the input fields")
    public void the_user_does_not_enter_any_data_into_the_input_fields() {
    	page.EmptyFields();
    }

    @Then("all the records available till now will be displayed")
    public void all_the_records_available_till_now_will_be_displayed() {
        page.AssertionforSc1(prop.getProperty("MsgForNoReocrd"));
    }
    
    //---------------------------------------------------------------------------//


    @When("User enters {string} and {string} invalid")
    public void user_enters_and_invalid(String fromDate, String toDate) {
        page.InvalidDates(fromDate, toDate);
    }

    @Then("error should be generated of invalid dates")
    public void error_should_be_generated_of_invalid_dates(DataTable dataTable) {
        // Convert the DataTable to a List of Maps to iterate over each row for assertions
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            page.InvalidDates(columns.get("FromDate"), columns.get("ToDate"));
            page.ClickSearch();
            page.AssertionforDate(columns.get("error"));
        }
    }
  
}
