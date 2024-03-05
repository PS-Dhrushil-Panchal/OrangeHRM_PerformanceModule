package pageObjects;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import utilities.SeleniumMethods;

public class PerformancePage extends SeleniumMethods{

	public PerformancePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}
	
	private By  Performance = By.xpath("//span[normalize-space()='Performance']");
	private By EmpName = By.xpath("//input[@placeholder='Type for hints...']");
	private By EmpNamValue = By.xpath("//div[@role='listbox']//div[2]");
	private By JobTitle = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[1]");
	private By JobTitleValue = By.xpath("//div[@class='oxd-select-wrapper']/div[2]/div[4]");
	private By SubUnit = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[2]");
	private By SubUnitValue = By.xpath("//div[@role='listbox']/div[normalize-space()='Administration']");
	private By Include = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[3]");
	private By IncludeValue = By.xpath("//div[@role='listbox']/div[normalize-space()='Current and Past Employees']");
	private By ReviewStatus = By.xpath("//div[@clear='false']");
	private By ReviewValue = By.xpath("//div[@role='listbox']/div[normalize-space()='Activated']");
	private By FromDate = By.xpath("(//div[@class='oxd-grid-item oxd-grid-item--gutters --offset-row-2'])[2]/div/div[2]/div/div/input");
	private By ToDate = By.xpath("(//div[@class='oxd-grid-item oxd-grid-item--gutters --offset-row-2'])[3]/div/div[2]/div/div/input");
	private By SubmitBtn = By.xpath("//button[@type='submit']");
	private By TextConfirm = By.xpath("//span[normalize-space()='No Records Found']");
	private By DateMsg = By.xpath("(//div[@class='oxd-input-group oxd-input-field-bottom-space'])[7]/span");
	private By NameMsg = By.xpath("(//div[@class='oxd-input-group oxd-input-field-bottom-space'])[1]/span");
	
	public void SendValidInputs() {	
		clickOn(Performance);
		sendKeys(EmpName, "O");
		clickOn(EmpNamValue);
		clickOn(JobTitle);
		clickOn(JobTitleValue);
		clickOn(SubUnit);
		clickOn(SubUnitValue);
		clickOn(Include);
		clickOn(IncludeValue);
		clickOn(ReviewStatus);
		clickOn(ReviewValue);
		ClearText(FromDate);
		sendKeys(FromDate, "2020-01-01");
		ClearText(ToDate);
		sendKeys(ToDate, "2024-01-01");
	}
	
	public void ClickSearch() {
		clickOn(SubmitBtn);
	}
	
	public void AssertionforSc1(String expectedText) {
		String actual = getText(TextConfirm);
		assertEquals(actual, expectedText);
	}
	
	public void InvalidNameInput(){
		clickOn(Performance);
		sendKeys(EmpName, "Odis Adalwin");
	}
	
	public void AssertionforSc2(String expectedText) {
		String actual = getText(NameMsg);
		System.out.println(actual);
		assertEquals(actual, expectedText);
	}
	
	
	public void EmptyFields() {
		clickOn(Performance);
		ClearText(FromDate);
		ClearText(ToDate);
	}
	
	public void InvalidDates(String fromDate, String toDate) {
	    clickOn(Performance); // Assuming this navigates to the correct section
	    sendKeys(EmpName, "O");
	    clickOn(EmpNamValue);
	    ClearText(FromDate);
	    sendKeys(FromDate, fromDate);
	    ClearText(ToDate);
	    sendKeys(ToDate, toDate);
	}


	public void AssertionforDate(String expectedText) {
	    waitForElementVisible(DateMsg, 10);
	    String actualText = getText(DateMsg);
	    assertEquals(actualText, expectedText, "The error message did not match the expected text.");
	}
	
}
