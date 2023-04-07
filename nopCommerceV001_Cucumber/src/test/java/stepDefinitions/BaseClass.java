package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;
import pageObjects.addcustomerPage;

public class BaseClass {

	public WebDriver driver;
	public LoginPage lp;
	public addcustomerPage addCust;
	public SearchCustomerPage searchCust;
	public static Logger logger;
	public Properties configProp;
	
//	Created for generting random string for unique email
	public static String randomstring(){
		
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}
	
	
	
	
}
