package TestUserStory2;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.baseClass;
import retirementPlanCalculatorPageFactory.HomePage;
import retirementPlanCalculatorPageFactory.KiwiSaverCalculatorPage;
import retirementPlanCalculatorPageFactory.wksRetirementCalculatorPage;

public class ValidateRetirementPlanForEmployed extends baseClass {

	public WebDriver driver;

	@BeforeTest

	public void Initiaze() throws IOException {
		// Initializing the Driver

		driver = BrowerInitialisation();

		// Open the Website under test

		driver.get(prop.getProperty("url"));

	}

	@Test(dataProvider = "getDataEmployed", groups= {"UserStory2"})

	public void TestEmployed(String cAge, String empStatus, String salary) throws IOException, InterruptedException {
		// Creating a object for Landingpage
		HomePage lp = new HomePage(driver);

		// Using Mouseover actions to locate the Webelement and click
		Actions action = new Actions(driver);
		action.moveToElement(lp.selectKiwiSaver()).moveToElement(lp.getKiwiSaverCalc()).click().build().perform();

		// Creating a object for KiwiSaverCalculatorPage
		KiwiSaverCalculatorPage ks = new KiwiSaverCalculatorPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		 
		// Here we will wait until element is clickable
		// or else it will throw exception
		
		// Navigation to Westpac KiwiSaver Scheme Retirement Calculator
		wait.until(ExpectedConditions.elementToBeClickable(ks.getwksCalculator())).click();

		wksRetirementCalculatorPage rc = new wksRetirementCalculatorPage(driver);

		driver.switchTo().frame(rc.getMainFrame());

		rc.getCurrentAgeText().sendKeys(cAge);

		rc.getemploymentStatusDD().click();

		List<WebElement> DropdownList = driver
				.findElements(By.xpath("//ul[contains(@class,'option-list')]//li//div//span"));
//		System.out.println(DropdownList.size());

		for (int i = 0; i < DropdownList.size(); i++)

		{
//			System.out.println(DropdownList.get(i).getText());

			if (DropdownList.get(i).getText().contains(empStatus)) {
				DropdownList.get(i).click();
				break;
			}

		}

		rc.getsalaryPerYear().sendKeys(salary);
		rc.getkiwiSaverMemberContribution4().click();
		rc.getriskProfileDefensive().click();

		rc.getprojectedBalances().click();

	}

	
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

	@DataProvider
	public Object[][] getDataEmployed() {
		// Passing test data for test case 1
		Object[][] data1 = new Object[1][3];
		data1[0][0] = "30";
		data1[0][1] = "Employed";
		data1[0][2] = "82000";

		return data1;

	}

}
