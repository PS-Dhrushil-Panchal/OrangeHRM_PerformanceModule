
  package stepDefinitions;
  
  import org.openqa.selenium.WebDriver; import org.testng.Assert;
  
  import io.cucumber.java.en.Then; import io.cucumber.java.en.When; import
  pageObjects.HomePageObjects; import utilities.BaseClass;
  
  public class HomePageSteps { WebDriver driver;
  
  public HomePageSteps() { this.driver = BaseClass.getDriver(); }
  
  HomePageObjects homePageObjects;
  
  @When("User Clicks on CMS tab") public void click_CMS_Tab() { homePageObjects
  = new HomePageObjects(driver); homePageObjects.click_CMS_Tab(); }
  
  @Then("User should be able to see the CMS dropdown options") public void
  assertCmsDropdownOptions() { boolean actual =
  homePageObjects.verifyCmsDropdownOptions(); Assert.assertEquals(actual,
  true); }
  
  @When("User hover mouse on SAP option") public void
  hover_Mouse_On_Sap_Option() { homePageObjects.hoverMouseOnSapOption(); }
  
  @Then("User should be able to see the SAP list options") public void
  assert_User_Should_See_Sap_List_Options() { boolean actual =
  homePageObjects.verifySapListOptions(); Assert.assertEquals(actual, true); }
  
  @When("User clicks on SAPList option") public void select_SapList_Option() {
  homePageObjects.selectSapListOption(); }
  
  @Then("User should be able to see the SAP List page") public void
  assert_User_Should_See_SapList_Page() { boolean actual =
  homePageObjects.VerifySapListPage(); Assert.assertEquals(actual, true); }
  
  }
 