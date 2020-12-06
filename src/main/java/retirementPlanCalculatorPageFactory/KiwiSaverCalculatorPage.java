package retirementPlanCalculatorPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class KiwiSaverCalculatorPage {
	
	public WebDriver driver;


	//WebElement available for Westpac KiwiSaver Scheme Risk Profiler and Retirement Calculator Page
		
		@FindBy(xpath="//a[contains(text(),'Click here to get started.')]")
		WebElement ksCalc;
		
		public KiwiSaverCalculatorPage(WebDriver driver) {
			// TODO Auto-generated constructor stub
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}

		public WebElement getwksCalculator()
		{
			return ksCalc;
			
		}
		
}
