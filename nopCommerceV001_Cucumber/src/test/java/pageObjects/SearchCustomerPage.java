package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerPage {

	public WebDriver ldriver;
	
	WaitHelper waithelper;
	
	public SearchCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
		waithelper=new WaitHelper(ldriver);
	}
	
	@FindBy(how = How.ID, using = "SearchEmail") 
	@CacheLookup 
	WebElement txtEmail; 
	
	@FindBy(how = How.ID, using = "SearchFirstName") 
	@CacheLookup 
	WebElement txtFirstName; 
	
	@FindBy(how = How.ID, using = "SearchLastName") 
	@CacheLookup 
	WebElement txtLastName; 
	
	@FindBy(how = How.ID, using = "SearchMonthOfBirth") 
	@CacheLookup 
	WebElement drpdobMonth; 
	
	@FindBy(how = How.ID, using = "SearchCompany") 
	@CacheLookup 
	WebElement txtCompany; 
	
	@FindBy(how = How.XPATH, using = "//div[@class=1k-multiselect-wrap k-floatwrap']") 
	@CacheLookup 
	WebElement txtcustomerRoles; 
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Administrators')]") 
	@CacheLookup 
	WebElement lstitemAdministrators; 
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Registered')]") 
	@CacheLookup 
	WebElement lstitemRegistered; 
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Guests')]") 
	@CacheLookup 
	WebElement lstitemGuests; 
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Vendors')]") 
	@CacheLookup 
	WebElement lstitemVendors; 
	
	@FindBy(how = How.ID, using = "search-customers")  
	@CacheLookup 
	WebElement btnSearch; 
	
	@FindBy(how = How.XPATH, using = "//table[@role='grid']") 
	@CacheLookup 
	WebElement tblSearchResults; 
	
	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']") 
	WebElement table; 
	
	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//body/tr") 
	List<WebElement> tableRows; 
	
	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//body/tr/td") 
	List<WebElement> tableColumns; 
	
	public void setEmail(String email) {
		waithelper.WaitForElement(txtEmail, 30);
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	public void setFirstName(String lname) {
		waithelper.WaitForElement(txtFirstName, 30);
		txtFirstName.clear(); 
		txtFirstName.sendKeys(lname); 
	}
	public void setLastName(String lname) { 
		waithelper.WaitForElement(txtLastName, 30); 
		txtLastName.clear(); 
		txtLastName.sendKeys(lname); 
	}
	public void clickSearch() { 
		btnSearch.click(); 
		waithelper.WaitForElement(btnSearch, 30); 
	} 
	public int 
	getNo0fRows() { 
		return(tableRows.size()); 
	} 
	public int 
	getNoOfColumns() { 
		return(tableColumns.size()); 
	}  
	
	public boolean searchCustomerByEmail(String email) 
	{ 
	boolean flag=false; 
	
	for(int i=1;i<=getNo0fRows();i++) 
	{ 
		String emailid=table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
				System.out.println(emailid); 
		if(emailid.equals("email")) 
		{ 
			flag=true; } 
		} 
	return flag; 

	}
	public boolean searchCustomerByName(String Name) 
	{ 
	boolean flag=false; 
	
	for(int i=1;i<=getNo0fRows();i++) 
	{ 
		String name=table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
			
		String names[]=name.split(" ");
		
		if(names[0].equals("Virat") && names[1].equals("Kohli"))
		{
			flag=true; } 
		} 
	return flag; 
	}
}
