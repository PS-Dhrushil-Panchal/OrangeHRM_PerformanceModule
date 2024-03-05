package pageObjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import utilities.SeleniumMethods;

public class ClaimObject extends SeleniumMethods{
	
	public ClaimObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}
	private By ClaimBtn = By.xpath("//ul[@class='oxd-main-menu']/li[11]/a");
	private By SubmitClaim = By.xpath("//a[normalize-space()='Submit Claim']");
	private By Event = By.xpath("((//div[@class='oxd-input-group oxd-input-field-bottom-space'])[1]/div[2]/div/div/div)[1]");
	private By EventValue= By.xpath("//div[@class='oxd-select-wrapper']/div[2]/div[3]/span");
	private By Currency= By.xpath("(//div[@class='oxd-input-group oxd-input-field-bottom-space'])[2]/div[2]/div/div/div");
	private By CurrencyVal= By.xpath("//div[@class='oxd-select-wrapper']/div[2]/div[9]/span");
	private By CreateBtn= By.xpath("//button[@type='submit']");
	private By MyClaim = By.xpath("//a[normalize-space()='My Claims']");
	private By EventName = By.xpath("//div[@class='oxd-table-body']/div/div/div[2]");
	private By AddBtn = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/button[1]");
	private By ExpType = By.xpath("//div[@class='oxd-select-text-input']");
	private By ExpVal = By.xpath("//div[@class='oxd-select-wrapper']/div[2]/div[5]/span");
	private By Date = By.xpath("(//div[@class='oxd-input-group oxd-input-field-bottom-space'])[7]/div[2]/div/div/input");
	private By Amount = By.xpath("(//div[@class='oxd-input-group oxd-input-field-bottom-space'])[8]/div[2]/input");
	private By SaveBtn = By.xpath("//button[@type='submit']");
	private String expected;
	private int sentAmount;
	private By AssertAmount = By.xpath("//div[@class='oxd-table-card']//div[@role='row']/div[5]");
	public void ClickSubmit() {
		clickOn(ClaimBtn);
		clickOn(SubmitClaim);
	}
	
	public void ValidInputs() {
		clickOn(Event);
		expected = getText(EventValue);
		clickOn(EventValue);
		clickOn(Currency);
		clickOn(CurrencyVal);
		
	}

	public void ClickCreate() {
		clickOn(CreateBtn);
	}
	
	public void AssertionOne() {
		clickOn(MyClaim);
		String actual = getText(EventName);
		assertEquals(actual,expected);
	}
	
	public void AddExpence() {
		waitForElementVisible(AddBtn, 10);
		clickOn(AddBtn);

	}
	
	public void AddData() {
		clickOn(ExpType);
		clickOn(ExpVal);
		clickOn(Date);
		//ClearText(Date);
		sendKeys(Date, "02-02-2002");
		int sendingAmt = 5000;
		sendKeysInt(Amount, sendingAmt);
	}
	
	public void clickSave() {
		clickOn(SaveBtn);
	}
	
	public void AssertTwo() {
		String actual = getText(AssertAmount);
		int a = Integer.parseInt(actual);
		assertEquals(a, sentAmount, "Sent amount and actual amount should match");
	}
}
