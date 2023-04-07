package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class addcustomerPage {

public WebDriver ldriver;

	public addcustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	By lnkCustomers_menu = By.xpath("(//p[contains(.,'Customers')])[1]");
	By lnkCustomers_menuitem = By.xpath("(//p[contains(.,'Customers')])[2]");

	By btnAddNew = By.xpath("//a[@href='/Admin/Customer/Create']");

	By txtEmail = By.xpath("//input[@id='Email']");
	By txtPassword = By.xpath("//input[@id='Password']");

	By txtcustomerRoles = By.xpath("(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[2]");
	By lstitemAdministrators = By.xpath("//li[@tabindex='-1'][contains(.,'Administrators')]");
	By lstitemRegistered = By.xpath("//li[@tabindex='-1'][contains(.,'Registered')]");
	By lstitemGuests = By.xpath("//li[@tabindex='-1'][contains(.,'Guests')]");
	By lstitemVendors = By.xpath("//li[@tabindex='-1'][contains(.,'Vendors')]");

	By drpmgrOfVendor = By.xpath("//select[contains(@id,'VendorId')]");

	By rdmaleGender = By.id("Gender_Male");
	By rdFemaleGender = By.id("Gender_Female");

	By txtFirstName = By.xpath("//input[@id='FirstName']");
	By txtLastName = By.xpath("//input[@id='LastName']");

	By txtDob = By.xpath("//input[@id='DateOfBirth']");

	By txtCompanyName = By.xpath("//input[@id='Company']");

	By txtAdminContent = By.xpath("//textarea[@id='AdminComment']");

	By btnSave = By.xpath("//button[@name='save']");

//Action Methods	
	
	public String getPageTitle()
	{
		return ldriver.getTitle();
				
	}
	

	public void clickOnCustomersMenu() {
		ldriver.findElement(lnkCustomers_menu).click();
	}

	public void clickOnCustomersMenuItem() {
		ldriver.findElement(lnkCustomers_menuitem).click();
	}

	public void clickOnAddNew() {
		ldriver.findElement(btnAddNew).click();
	}

	public void setEmail(String email) {
		ldriver.findElement(txtEmail).sendKeys(email);
	}

	public void setPassword(String password) {
		ldriver.findElement(txtPassword).sendKeys(password);
	}

	public void setCustomerRoles(String role) throws InterruptedException {
	 	if (!role.equals("Vendors")) 
	 	{
 		ldriver.findElement(By.xpath("//span[@title='delete']"));
		
		ldriver.findElement(txtcustomerRoles).click();
		}

		WebElement listitem;

		Thread.sleep(3000);

		if (role.equals("Administrators"))
		{
			listitem = ldriver.findElement(lstitemAdministrators);
		} 
		else if (role.equals("Guests")) 
		{
			listitem = ldriver.findElement(lstitemGuests);
		} 
		else if (role.equals("Registered"))
		{
			listitem = ldriver.findElement(lstitemRegistered);
		}
		else if (role.equals("Vendors"))
		{
			listitem = ldriver.findElement(lstitemVendors);
		}
		else
		{ 
			listitem = ldriver.findElement(lstitemGuests);
		}
//		JavascriptExecutor js= (JavascriptExecutor)ldriver;
//		js.executeScript("argument[0].click();", listitem);
		}

	
	public void setManagerOfVendor(String value) 
		{
			Select drp=new Select(ldriver.findElement(drpmgrOfVendor));
			drp.selectByVisibleText(value);
		}
	public void setGender(String gender) {
        if(gender.equals("Male")) 
        {
            ldriver.findElement(rdmaleGender).click();
        } 
        else if(gender.equals("Female")) 
        {
            ldriver.findElement(rdFemaleGender).click();
        }
        else
        {
        	ldriver.findElement(rdmaleGender).click();
        }
	}

	public void setFirstName(String fname) {
		ldriver.findElement(txtFirstName).sendKeys(fname);
	}

	public void setLastName(String lname) {
		ldriver.findElement(txtLastName).sendKeys(lname);
	}

	public void setDob(String dob) {
		ldriver.findElement(txtDob).sendKeys(dob);
	}

	public void setCompanyName(String comname) {
		ldriver.findElement(txtCompanyName).sendKeys(comname);
	}

	public void setAdminContent(String content) {
		ldriver.findElement(txtAdminContent).sendKeys(content);
	}

	public void clickOnSave() {
		ldriver.findElement(btnSave).click();
	}

	
	
	
}
