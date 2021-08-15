package week2.Day1Assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3SalesForce {
	
	public ChromeDriver ConfigureDriver() {
		
		// Below are standard steps to be included (except the URL)

		// Step 0-01: Download and set the path
		WebDriverManager.chromedriver().setup();
		// Step 0-02: Launch the Chrome browser
		ChromeDriver driver = new ChromeDriver();
		// Step 0-03: Load the URL
		driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=70130000000Enyk");
		// Step 0-04: Maximize the window
		driver.manage().window().maximize();
		// Step 0-05: waits for 10 secs if the element is not in the DOM
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public void EnterRegFields (ChromeDriver sfDriver) {
		
		// Step 1-01: Enter the First Name
		WebElement firstName = sfDriver.findElement(By.name("UserFirstName"));
		firstName.clear();
		firstName.sendKeys("Ramesh");

		// Step 1-02: Enter the Last Name
		WebElement lastName = sfDriver.findElement(By.name("UserLastName"));
		lastName.clear();
		lastName.sendKeys("Rao");

		// Step 1-03: Enter the Email ID
		WebElement emailID = sfDriver.findElement(By.name("UserEmail"));
		emailID.clear();
		emailID.sendKeys("ramesh.r@gmail.com");
		
		// Step 1-04: Select the Job Title
		WebElement userTitle = sfDriver.findElement(By.name("UserTitle"));
		Select dropdownUserTitle = new Select(userTitle);
		dropdownUserTitle.selectByVisibleText("IT Manager");
		
		// Step 1-05: Enter the Company Name
		WebElement companyName = sfDriver.findElement(By.name("CompanyName"));
		companyName.clear();
		companyName.sendKeys("Amazon");
		
		// Step 1-06: Select the # employees
		WebElement nbrCompanyEmployees = sfDriver.findElement(By.name("CompanyEmployees"));
		Select dropdownnbrCompanyEmployees = new Select(nbrCompanyEmployees);
		dropdownnbrCompanyEmployees.selectByIndex(dropdownnbrCompanyEmployees.getOptions().size()-1);

		// Step 1-07: Enter the User Phone
		WebElement userPhone = sfDriver.findElement(By.name("UserPhone"));
		userPhone.clear();
		userPhone.sendKeys("844-666-8111");
		
		// Step 1-08: Select the Country
		WebElement countryName = sfDriver.findElement(By.name("CompanyCountry"));
		Select dropdowncountryName = new Select(countryName);
		dropdowncountryName.selectByValue("US");
		
		// Step 1-09: Check the "Agreement" check box
		WebElement chkBoxAgree = sfDriver.findElement(By.className("checkbox-ui"));
		chkBoxAgree.click();

	}
	
	public void ClickSubmit (ChromeDriver sfDriver) {
		
		// Step 2-01: Click the "submit" button
		sfDriver.findElement(By.name("start my free trial")).click();
		
	}

	public static void main(String[] args) {
		
		
		Assignment3SalesForce myEntryObj = new Assignment3SalesForce();
		
		
		/*
		 *   Configure the Driver for the SalesForce registration page
		 */   
		ChromeDriver mainDriver = myEntryObj.ConfigureDriver();


		/*
		 *   Enter all the fields, and check the agreements checkbox
		 */   
		myEntryObj.EnterRegFields(mainDriver);

		
		/*
		 *   Click the submit button after all the fields are entered
		 */   
		myEntryObj.ClickSubmit(mainDriver);

	}

}
