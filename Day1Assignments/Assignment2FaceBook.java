package week2.Day1Assignments;

import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2FaceBook {

	public ChromeDriver ConfigureDriver() {

		// Below are standard steps to be included (except the URL)

		// Step 0-01: Download and set the path
		WebDriverManager.chromedriver().setup();
		// Step 0-02: Launch the Chrome browser
		ChromeDriver driver = new ChromeDriver();
		// Step 0-03: Load the URL
		driver.get("https://en-gb.facebook.com/");
		// Step 0-04: Maximize the window
		driver.manage().window().maximize();
		// Step 0-05: waits for 10 secs if the element is not in the DOM
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

	public void CreateNewAccount(ChromeDriver fbDriver) {

		// Step 1-01: Click the "Create New Account Link"
		fbDriver.findElement(By.linkText("Create New Account")).click();

	}

	public void EnterSignUpDetails(ChromeDriver fbDriver) {

		// Step 2-01: Enter the First Name
		WebElement firstName = fbDriver.findElement(By.name("firstname"));
		firstName.clear();
		firstName.sendKeys("Ramesh");

		// Step 2-02: Enter the Last Name
		WebElement lastName = fbDriver.findElement(By.name("lastname"));
		lastName.clear();
		lastName.sendKeys("Rao");

		// Step 2-03: Enter the Email ID
		WebElement emailIDOrMobile = fbDriver.findElement(By.name("reg_email__"));
		emailIDOrMobile.clear();
		emailIDOrMobile.sendKeys("ramesh.r@gmail.com");

		// Step 2-04: Re-Enter the Email ID ==> when there is a new field dynamically,
		// requesting to re-enter the email ID
		Boolean isPresentEmailConf = fbDriver.findElements(By.name("reg_email_confirmation__")).size() > 0;
		if (isPresentEmailConf) {
			WebElement emailReEnter = fbDriver.findElement(By.name("reg_email_confirmation__"));
			emailReEnter.clear();
			emailReEnter.sendKeys("ramesh.r@gmail.com");
		}

		// Step 2-05: Enter the new Password
		WebElement newPassword = fbDriver.findElement(By.id("password_step_input"));
		newPassword.clear();
		newPassword.sendKeys("TestLeaf@123");

		// Step 2-06: Select the DOB date
		WebElement dobDate = fbDriver.findElement(By.id("day"));
		Select dropdowndobDate = new Select(dobDate);
		dropdowndobDate.selectByValue("4");

		// Step 2-07: Select the DOB month
		WebElement dobMonth = fbDriver.findElement(By.id("month"));
		Select dropdowndobMonth = new Select(dobMonth);
		dropdowndobMonth.selectByValue("9");

		// Step 2-08: Select the DOB year
		WebElement dobYear = fbDriver.findElement(By.id("year"));
		Select dropdowndobYear = new Select(dobYear);
		dropdowndobYear.selectByValue("1980");

		// Step 2-09: Select the Radio Button for gender
		java.util.List<WebElement> RadioButton = fbDriver.findElements(By.name("sex"));
		// selecting the Radio buttons by Name
		int nbrRadioButtons = RadioButton.size(); // finding the number of Radio buttons
		System.out.println(nbrRadioButtons);

		for (int i = 0; i < nbrRadioButtons; i++) // starts the loop from first Radio button to the last one
		{
			String val = RadioButton.get(i).getAttribute("value"); // Radio button name stored to the string variable,
																	// using 'Value' attribute

			if (val.equals("2")) // equalsIgnoreCase is ignore case(upper/lower)
			{ // selecting the Radio button if its value is same as that we are looking for
				RadioButton.get(i).click();
				break;
			}
		}

	}

	public void ClickSubmit(ChromeDriver fbDriver) {

		// Step 2-01: Click the "submit" button
		fbDriver.findElement(By.name("websubmit")).click();

	}

	public static void main(String[] args) {

		Assignment2FaceBook myEntryObj = new Assignment2FaceBook();

		/*
		 * Configure the Driver for the SalesForce registration page
		 */
		ChromeDriver mainDriver = myEntryObj.ConfigureDriver();

		/*
		 * Click on "Create New Account" button ---> Will Open the pop-up screen to
		 * enter the Sign Up details
		 */
		myEntryObj.CreateNewAccount(mainDriver);

		/*
		 * Enter the fields in the "Sign Up" pop up screen
		 */
		myEntryObj.EnterSignUpDetails(mainDriver);

		/*
		 * Click the submit button after all the fields are entered
		 */
		myEntryObj.ClickSubmit(mainDriver);

	}

}
