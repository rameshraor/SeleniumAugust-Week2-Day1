package week2.Day1Assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1CreateLead {

	public ChromeDriver ConfigureDriver() {
		
		// Below are standard steps to be included (except the URL)

		// Step 0-01: Download and set the path
		WebDriverManager.chromedriver().setup();
		// Step 0-02: Launch the Chrome browser
		ChromeDriver driver = new ChromeDriver();
		// Step 0-03: Load the URL
		driver.get("http://leaftaps.com/opentaps/control/main");
		// Step 0-04: Maximize the window
		driver.manage().window().maximize();
		// Step 0-05: waits for 10 secs if the element is not in the DOM
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public void EnterFieldsInLoginScreen(ChromeDriver loginDriver) {					// LOGIN Screen
		
		// Step 1-01: Locate the Username and enter the username as demosalesmanager
		WebElement webUser = loginDriver.findElement(By.id("username"));
		webUser.sendKeys("demosalesmanager");
		
		// Step 1-02: Locate the password(webelement) and enter the password as crmsfa
		loginDriver.findElement(By.id("password")).sendKeys("crmsfa");

		// Step 1-03: Locate the Login button and click on it
		loginDriver.findElement(By.className("decorativeSubmit")).click();

	}
	
	public void EnterFieldsInCreateLeadScreen(ChromeDriver crLeadDriver) {					// CREATE LEAD Screen
		
		// Step 5-01: Enter Company name
		// id = createLeadForm_companyName
		crLeadDriver.findElement(By.id("createLeadForm_companyName")).sendKeys("Cognizant");
		
		// Step 5-02: Enter FirstName
		// id = createLeadForm_firstName
		crLeadDriver.findElement(By.id("createLeadForm_firstName")).sendKeys("Ramesh");

		// Step 5-03: Enter LastName
		// id= createLeadForm_lastName
		crLeadDriver.findElement(By.id("createLeadForm_lastName")).sendKeys("LNU");

		// Step 5-04: Enter the Data Source ID
		WebElement dataSourceID = crLeadDriver.findElement(By.id("createLeadForm_dataSourceId"));
		Select dropdownDataSourceID = new Select(dataSourceID);
		dropdownDataSourceID.selectByValue("LEAD_EMPLOYEE");
		
		// Step 5-05: Enter the Marketing Campaign ID
		WebElement mktgCampaignID = crLeadDriver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select dropdownmktgCampaignID = new Select(mktgCampaignID);
		dropdownmktgCampaignID.selectByIndex(3);
		
		// Step 5-06: Enter the First Name Local
		WebElement firstNameLocal = crLeadDriver.findElement(By.id("createLeadForm_firstNameLocal"));
		firstNameLocal.clear();
		firstNameLocal.sendKeys("John");

		// Step 5-07: Enter the Last Name Local
		WebElement lastNameLocal = crLeadDriver.findElement(By.id("createLeadForm_lastNameLocal"));
		lastNameLocal.clear();
		lastNameLocal.sendKeys("Doe");

		// Step 5-08: Enter the Salutation
		WebElement salutation = crLeadDriver.findElement(By.id("createLeadForm_personalTitle"));
		salutation.clear();
		salutation.sendKeys("Mr.");

		// Step 5-09: Enter the DOB
		WebElement birthDate = crLeadDriver.findElement(By.id("createLeadForm_birthDate"));
		birthDate.clear();
		birthDate.sendKeys("1/31/76");

		// Step 5-10: Enter the Prof Title
		WebElement profTitle = crLeadDriver.findElement(By.id("createLeadForm_generalProfTitle"));
		profTitle.clear();
		profTitle.sendKeys("Director");

		// Step 5-11: Enter the Department
		WebElement department = crLeadDriver.findElement(By.id("createLeadForm_departmentName"));
		department.clear();
		department.sendKeys("Quality Assurance");

		// Step 5-12: Enter the Annual Revenue
		WebElement annualRevenue = crLeadDriver.findElement(By.id("createLeadForm_annualRevenue"));
		annualRevenue.clear();
		annualRevenue.sendKeys("200001.08");

		// Step 5-13: Enter the Currency
		WebElement currencyID = crLeadDriver.findElement(By.id("createLeadForm_currencyUomId"));
		Select dropdowncurrencyID = new Select(currencyID);
		dropdowncurrencyID.selectByValue("USD");
		
		// Step 5-14: Enter the Industry
		WebElement industryID = crLeadDriver.findElement(By.id("createLeadForm_industryEnumId"));
		Select dropdownindustryID = new Select(industryID);
		dropdownindustryID.selectByVisibleText("Computer Software");
		
		// Step 5-15: Enter the # employees
		WebElement nbrEmployees = crLeadDriver.findElement(By.id("createLeadForm_numberEmployees"));
		nbrEmployees.clear();
		nbrEmployees.sendKeys("30,000");

		// Step 5-16: Enter the Ownership
		WebElement ownershipID = crLeadDriver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select dropdownownershipID = new Select(ownershipID);
		dropdownownershipID.selectByIndex(1);
		
		// Step 5-17: Enter the SIC Code
		WebElement sicCode = crLeadDriver.findElement(By.id("createLeadForm_sicCode"));
		sicCode.clear();
		sicCode.sendKeys("013546");

		// Step 5-18: Enter the Ticker Symbol
		WebElement tickerSymbol = crLeadDriver.findElement(By.id("createLeadForm_tickerSymbol"));
		tickerSymbol.clear();
		tickerSymbol.sendKeys("TSLF");

		// Step 5-19: Enter the Description
		WebElement descBox = crLeadDriver.findElement(By.id("createLeadForm_description"));
		descBox.clear();
		descBox.sendKeys("The Lead will be responsible for Driving all the activities related to the "
				+ "Quality Assurance activities across all the projects. He/She will also be responsible "
				+ "for designing Test Strtagey, Test Management, and Status reporting");

		// Step 5-20: Enter the Important Note
		WebElement importantNote = crLeadDriver.findElement(By.id("createLeadForm_importantNote"));
		importantNote.clear();
		importantNote.sendKeys("Please note that this position would require a person with extensive QA expertise and  "
				+ "Hands on experience with multiple Test management / Automation tools.");

		// Step 5-21: Enter the country code
		// First, clear the text- clear()
		// Then use sendKeys()
		WebElement countryCode = crLeadDriver.findElement(By.id("createLeadForm_primaryPhoneCountryCode"));
		countryCode.clear();
		countryCode.sendKeys("+1");

		// Step 5-22: Enter the Phone Number Area code
		WebElement phoneAreaCode = crLeadDriver.findElement(By.id("createLeadForm_primaryPhoneAreaCode"));
		phoneAreaCode.clear();
		phoneAreaCode.sendKeys("609");

		// Step 5-23: Enter the Phone Number
		WebElement primaryPhoneNumber = crLeadDriver.findElement(By.id("createLeadForm_primaryPhoneNumber"));
		primaryPhoneNumber.clear();
		primaryPhoneNumber.sendKeys("523-6213");

		// Step 5-24: Enter the Phone Number Extension
		WebElement primaryPhoneExtn = crLeadDriver.findElement(By.id("createLeadForm_primaryPhoneExtension"));
		primaryPhoneExtn.clear();
		primaryPhoneExtn.sendKeys("122");

		// Step 5-25: Enter the "Ask for"
		WebElement personToAskFor = crLeadDriver.findElement(By.id("createLeadForm_primaryPhoneAskForName"));
		personToAskFor.clear();
		personToAskFor.sendKeys("Mr. Q");

		// Step 5-26: Enter the Email ID
		WebElement primaryEmailID = crLeadDriver.findElement(By.id("createLeadForm_primaryEmail"));
		primaryEmailID.clear();
		primaryEmailID.sendKeys("ramesh.r@gmail.com");

		// Step 5-27: Enter the Web URL
		WebElement primaryWebUrl = crLeadDriver.findElement(By.id("createLeadForm_primaryWebUrl"));
		primaryWebUrl.clear();
		primaryWebUrl.sendKeys("https://linkedin.com/profile/rameshr");

		// Step 5-28: Enter the "To Name"
		WebElement addrToName = crLeadDriver.findElement(By.id("createLeadForm_generalToName"));
		addrToName.clear();
		addrToName.sendKeys("Ramesh R");

		// Step 5-297: Enter the "Attention Name"
		WebElement addrAttnName = crLeadDriver.findElement(By.id("createLeadForm_generalAttnName"));
		addrAttnName.clear();
		addrAttnName.sendKeys("Leasing Office Superintendent");

		// Step 5-30: Enter the Address line 1
		WebElement address1 = crLeadDriver.findElement(By.id("createLeadForm_generalAddress1"));
		address1.clear();
		address1.sendKeys("1008 Reading Rd");

		// Step 5-31: Enter the Address line 2
		WebElement address2 = crLeadDriver.findElement(By.id("createLeadForm_generalAddress2"));
		address2.clear();

		// Step 5-32: Enter the City name
		WebElement addressCity = crLeadDriver.findElement(By.id("createLeadForm_generalCity"));
		addressCity.clear();
		addressCity.sendKeys("Edison");

		// Step 5-33: Enter the State name
		WebElement addressState = crLeadDriver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select dropdownState = new Select(addressState);
		dropdownState.selectByVisibleText("New Jersey");
		
		// Step 5-34: Enter the Zip Code
		WebElement addressZip = crLeadDriver.findElement(By.id("createLeadForm_generalPostalCode"));
		addressZip.clear();
		addressZip.sendKeys("08817");

		// Step 5-35: Enter the Zip Code Extension
		WebElement addressZipExtn = crLeadDriver.findElement(By.id("createLeadForm_generalPostalCodeExt"));
		addressZipExtn.clear();
		addressZipExtn.sendKeys("2314");

	}
	
	public static void main(String[] args) {

		Assignment1CreateLead myEntryObj = new Assignment1CreateLead();
		
		
		/*
		 *   Configure the Driver for the SalesForce registration page
		 */   
		ChromeDriver mainDriver = myEntryObj.ConfigureDriver();



		/*
		 * Screen # 1 ---> Initial Login screen
		 */
		myEntryObj.EnterFieldsInLoginScreen(mainDriver);


		/*
		 * Screen # 2 ---> CRM/SFA screen  --> This will take to "myHome" screen
		 */
		// Step 2-01: Click on the crm/sfa link
		mainDriver.findElement(By.linkText("CRM/SFA")).click();


		/*
		 * Screen # 3 ---> "myHome" screen --> This will take to Leads screen
		 */
		// Step 3-01: Click Leads tab
		// link text = Leads
		mainDriver.findElement(By.linkText("Leads")).click();


		/*
		 * Screen # 4 ---> "Leads" screen --> This will take to Create Lead screen
		 */
		// Step 4-01: Click CreateLead
		// link Text = Create Lead
		mainDriver.findElement(By.linkText("Create Lead")).click();


		/*
		 * Screen # 5 ---> "Create Lead" screen
		 */
		myEntryObj.EnterFieldsInCreateLeadScreen(mainDriver);

		
		// Step 6-01: Click "CreateLead" button
		// class = smallSubmit, name = submitButton, id = ext-gen616 (auto generated)
		mainDriver.findElement(By.name("submitButton")).click();

	}

}
