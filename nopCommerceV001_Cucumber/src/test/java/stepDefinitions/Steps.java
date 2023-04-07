package stepDefinitions;
import java.io.*;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;
import pageObjects.addcustomerPage;

public class Steps extends BaseClass {

		@Before
	public void Setup( ) throws IOException 
		{

			logger=Logger.getLogger("nopCommere"); // Added logger
			PropertyConfigurator.configure("Log4j.properties"); // Added logger	
			
			//Reading properties
			configProp=new Properties();
			FileInputStream configPropfile=new FileInputStream("config.properties");
			configProp.load(configPropfile);
					
			String br=configProp.getProperty("browser");
			
			if(br.equals("chrome"))
						{
			System.setProperty("webdriver.chrome.driver",configProp.getProperty("chromepath"));
			driver = new ChromeDriver();
			}
			else if(br.equals("firefox"))
			{
			System.setProperty("webdriver.geckodriver.driver",configProp.getProperty("firefoxpath"));
			driver = new FirefoxDriver();
			}
			else if(br.equals("edge"))
			{
			System.setProperty("webdriver.msedgedriver.driver",configProp.getProperty("edgepath"));
			driver = new EdgeDriver();
			}
			
					
			logger.info("**************Lunching URL*********");
			}
		
		
		

	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		
			lp = new LoginPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		logger.info("**************Openning URL*********");
		driver.get(url);
		driver.manage().window().maximize();
	}

	@When("User  enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
		logger.info("**************Providing login details*********");
		lp.setUserName(email);
		lp.setPassword(password);
	}

	@When("Click on Login")
	public void click_on_login() {
		logger.info("**************Started Loging*********");
		lp.clickLogin();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) throws InterruptedException {
	    
		if (driver.getPageSource().contains("Login was unsuccessful.")) { 
			driver.close(); 
			logger.info("**************Logginf passed*********");
			Assert. assertTrue(false); 
		} else { 
			logger.info("**************Logging failed*********");
			Assert.assertEquals(title, driver.getTitle());
		} 
		Thread.sleep(3000);
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
		logger.info("**************Click on logout link*********");
		lp.clickLogout();
		Thread.sleep(3000);
	}

	@Then("close browser")
	public void close_browser() {
		logger.info("**************closing browser*********");
		driver.quit();
	   	}

	//Customer feature steps definitions 
	
 
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		addCust=new addcustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration",addCust.getPageTitle());					 
 	}
	
	@When("User click on customers Menu")
	public void user_click_on_customers_menu() throws InterruptedException {
		Thread.sleep(3000);
		addCust.clickOnCustomersMenu();
	}
		
 
//	@And("Click on customers Menu item")
//	public void click_on_customers_menu_item() throws InterruptedException {
//		Thread.sleep(3000);
//	addCust.clickOnCustomersMenuItem();
	
//}
	
	@And("Click on customers Menu item")
	public void click_on_customers_menu_item() throws InterruptedException {
		Thread.sleep(3000);
 	addCust.clickOnCustomersMenuItem();
	}
	
	
	
	//
	@When("click on Add new")
	public void click_on_add_new() throws InterruptedException {
		addCust.clickOnAddNew();
		Thread.sleep(3000);
 	}
	
	@Then("User can view Add new custumer")
	public void user_can_view_add_new_custumer() throws InterruptedException {
		
		
		Assert.assertEquals("Add a new customer / nopCommerce administration",addCust.getPageTitle());
		Thread.sleep(3000);
	  
	}
	@When("user enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		logger.info("**************Adding new customer *********");
		logger.info("**************Providing customer detail*********");
		String email=randomstring()+"@gmail.com";
		addCust.setEmail(email);
		addCust.setPassword("test123");
	  	
		// Registered - default 
		// The customer cannot be in both 'Guests' and 'Registered' customer roles 
		// Add the customer to 'Guests' or 'Registered' customer role 
		addCust.setCustomerRoles("Guest");
		Thread.sleep(3000); 
		
		addCust.setManagerOfVendor("Vendor 2");
		addCust.setGender("Male"); 
		addCust.setFirstName("Pavan"); 
		addCust.setLastName("Kumar"); 
		addCust.setDob("7/05/1985"); // Format: D/MM/YYY
		addCust.setCompanyName("busyQA");
		addCust.setAdminContent("This is for testing  ");

	
	}
	@When("click on Save button")
	public void click_on_save_button() throws InterruptedException {
		logger.info("**************Saving custuomer data*********");
	     addCust.clickOnSave();
	     Thread.sleep(2000);
	}
	@Then("user can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully"));
	}

	
	//steps for searching a customer using Email ID
	
	@When("Enter customer EMail")
	public void enter_customer_e_mail() {
		logger.info("**************Serching cutomer by ID*********");
		searchCust=new SearchCustomerPage(driver);
		searchCust.setEmail("kiyjcycyhjc676008@gmail.com");
	}
	
	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException {
		searchCust.clickSearch();
		Thread.sleep(3000);
	}
	
	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() {
		boolean status=searchCust.searchCustomerByEmail("kiyjcycyhjc676008@gmail.com");
		Assert.assertEquals(false, status);
	}
	
	//steps for searching a customer using first name and last name
	
	
	@When("Enter customer FirstName")
	public void enter_customer_first_name() {
		
		logger.info("**************Serching cutomer by name*********");
		searchCust=new SearchCustomerPage(driver);
		searchCust.setFirstName("Virat");
	 
	}
	@When("Enter customer LastName")
	public void enter_customer_last_name() {
		searchCust=new SearchCustomerPage(driver);
		searchCust.setLastName("Kohli");
	}
	
	@Then("User should found Name in the Search table")
	public void user_should_found_name_in_the_search_table() {
		boolean status=searchCust.searchCustomerByName("Virat Kohli");
	}
	
}
