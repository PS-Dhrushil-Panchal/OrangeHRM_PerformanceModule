package pageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.SeleniumMethods;

public class HomePageObjects extends SeleniumMethods{

	public HomePageObjects(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By cmsTab = By.id("lnkCMS");
	private By cmsDropdownOptions = By.xpath("//li[@id = 'listCMS']/ul/li/a");
	private By sapOption = By.xpath("//ul[@id = 'ulCMSUI']/li[7]");
	private By sapOptions = By.xpath("//ul[@id = 'ulCMSUI']/li[7]/ul/li/a");
	private By sapListOption = By.xpath("//ul[@id = 'ulCMSUI']/li[7]/ul/li[1]/a");
	private By sapListHomePageText = By.id("lstActiveIcon");


	public void click_CMS_Tab() {
		
		clickOn(cmsTab);
	}

	public boolean verifyCmsDropdownOptions() {
		List<String> al = new ArrayList<String>(
				Arrays.asList("I4CGDB", "I4CPROD", "REGTRANS", "REGDB", "DF1", "REGTRANSPROD", "SAP"));
		boolean bool = verifyListOptions(cmsDropdownOptions, al);
		return bool;
	}

	public void hoverMouseOnSapOption() {
		waitForElementClickable(sapOption, 30);
		mouseHover(sapOption);
	}

	public boolean verifySapListOptions() {
		List<String> al = new ArrayList<String>(Arrays.asList("SAP List", "Library", "Property", "Characteristics",
				"Property Characteristics Mapping", "Identifiers Mapping", "Generate"));
		boolean bool = verifyListOptions(sapOptions, al);
		return bool;
	}

	public void selectSapListOption() {
		waitForElementClickable(sapListOption, 30);
		clickOn(sapListOption);
	}
	
	public boolean VerifySapListPage() {
		waitForElementVisible(sapListHomePageText, 30);
		return getText(sapListHomePageText).contains("CMS / SAP List");
	}
	
}
