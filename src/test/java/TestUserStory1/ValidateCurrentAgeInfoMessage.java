package TestUserStory1;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.baseClass;
import retirementPlanCalculatorPageFactory.HomePage;
import retirementPlanCalculatorPageFactory.KiwiSaverCalculatorPage;
import retirementPlanCalculatorPageFactory.wksRetirementCalculatorPage;

public class ValidateCurrentAgeInfoMessage extends baseClass {

	public WebDriver driver;

	@BeforeTest

	public void Initiaze() throws IOException {
		// Initializing the Driver

		driver = BrowerInitialisation();

		// Open the Website under test

		driver.get(prop.getProperty("url"));

	}

	@Test(priority = 0)

	public void checkInfoButton() throws IOException, InterruptedException {
		// Creating a object for Landingpage
		HomePage lp = new HomePage(driver);

		// Using Mouseover actions to locate the Webelement and click
		Actions action = new Actions(driver);
		action.moveToElement(lp.selectKiwiSaver()).moveToElement(lp.getKiwiSaverCalc()).click().build().perform();

		// Creating a object for KiwiSaverCalculatorPage
		KiwiSaverCalculatorPage ks = new KiwiSaverCalculatorPage(driver);

		// Navigation to Westpac KiwiSaver Scheme Retirement Calculator
		WebDriverWait wait = new WebDriverWait(driver, 10);

		// Here we will wait until element is clickable
		// or else it will throw exception

		// Navigation to Westpac KiwiSaver Scheme Retirement Calculator
		wait.until(ExpectedConditions.elementToBeClickable(ks.getwksCalculator())).click();

		wksRetirementCalculatorPage rc = new wksRetirementCalculatorPage(driver);

		driver.switchTo().frame(rc.getMainFrame());

		String expectedmsg = "This calculator has an age limit of 64 years old as you need to be under the age of 65 to join KiwiSaver.";

		rc.getwksAgeInfoButton().click();
		System.out.println(rc.getwksAgeInfoText().getText());
		Assert.assertEquals(rc.getwksAgeInfoText().getText(), expectedmsg);

	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}
