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

public class ValidateRetirementPlanForNotEmployed extends baseClass {

	public WebDriver driver;

	@BeforeTest

	public void Initiaze() throws IOException {
		// Initializing the Driver

		driver = BrowerInitialisation();

		// Open the Website under test

		driver.get(prop.getProperty("url"));

	}

	@Test(dataProvider = "getDataNotEmployed")

	public void TestNotEmployed(String cAge, String empStatus, String kiwisaver, String vcontribution, String vfreq,
			String sgoals) throws IOException, Throwable {

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

		List<WebElement> empStatusList = driver.findElements(By.xpath("//ul[contains(@class,'option-list')]//li//div//span"));

		for (int i = 0; i < empStatusList.size(); i++)

		{

			if (empStatusList.get(i).getText().contains(empStatus)) {
				empStatusList.get(i).click();
				break;
			}

		}

		rc.getcurrentKiwiSaverBalanceValue().sendKeys(kiwisaver);
		rc.getvoluntaryContributionsAmount().sendKeys(vcontribution);

		rc.getfrequencySelect().click();

		List<WebElement> fList = driver.findElements(By.xpath("//label[contains(text(),'Voluntary contributions')]//following::ul[contains(@class,'option-list')]//li//div//span"));
		
		for (int j = 0; j < fList.size(); j++)

		{

			if (fList.get(j).getText().contains(vfreq)) {
				fList.get(j).click();
				break;
				
			}

		}

		rc.getriskProfileBalanced().click();

		rc.getsavingGoals().sendKeys(sgoals);

		rc.getprojectedBalances().click();

	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

	@DataProvider
	public Object[][] getDataNotEmployed() {
		// Passing test data for test case 1
		Object[][] data1 = new Object[1][6];
		data1[0][0] = "55";
		data1[0][1] = "Not employed";
		data1[0][2] = "140000";
		data1[0][3] = "10";
		data1[0][4] = "Annually";
		data1[0][5] = "200000";
		return data1;

	}

}
