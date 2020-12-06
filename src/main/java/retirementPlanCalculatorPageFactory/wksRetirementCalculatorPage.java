package retirementPlanCalculatorPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class wksRetirementCalculatorPage {
	
	public WebDriver driver;
		
		// WebElements available on KiwiSaver Retirement Calculator Page
		
		@FindBy(xpath="//iframe[starts-with(@src,'/calculator-widgets/')]")
		WebElement mainFrame;
		
		@FindBy(xpath="//p[contains(text(),'This calculator has an age limit of 18 to 64 years')]")
		WebElement ageInfoText;
		
		@FindBy(xpath="//label[contains(text(),'Current age')]//following::button[@type='button'][1]")
		WebElement ageInfoButton;
				
		@FindBy(xpath="//label[contains(text(),'Current age')]//following::input[contains(@type,'text')][1]")
		WebElement currentAgeText;
		
		@FindBy(xpath="//span[contains(text(),'Select')][1]")
		WebElement employmentStatusDD;
		
		@FindBy(xpath="//label[contains(text(),'Current KiwiSaver balance')]//following::input[contains(@type,'text')][1]")
		WebElement currentKiwiSaverBalanceValue;
		
		@FindBy(xpath="//label[contains(text(),'Salary or wages per year (before tax)')]//following::input[contains(@type,'text')][1]")
		WebElement salaryPerYear;
		
		@FindBy(xpath="//span[contains(text(),'4%')]")
		WebElement kiwiSaverMemberContribution4;
		
		@FindBy(xpath="//label[contains(text(),'Voluntary contributions')]//following::input[contains(@type,'text')][1]")
		WebElement voluntaryContributionsAmt;
		
		@FindBy(xpath="//label[contains(text(),'Voluntary contributions')]//following::input[contains(@type,'text')][1]")
		WebElement voluntaryContributionsFrequency;
		
		@FindBy(xpath="//span[contains(text(),'Defensive')]")
		WebElement riskProfileDefensive;
		
		@FindBy(xpath="//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/button[1]")
		WebElement projectedBalances;
		
		@FindBy(xpath="//div[@class*='wpnib-field']")
		WebElement totalFields;
		
		@FindBy(xpath="//i[@class='icon']")
		WebElement totalIcons;
		
		@FindBy(xpath="//span[contains(text(),'Conservative')]")
		WebElement riskProfileConservative;

		@FindBy(xpath="//span[contains(text(),'Balanced')]")
		WebElement riskProfileBalanced;
		
		@FindBy(xpath="//label[contains(text(),'Savings goal at retirement')]//following::input[@class='ng-pristine ng-valid'][1]")
		WebElement savingGoals;
		
		@FindBy(xpath="//span[contains(text(),'Frequency')][1]")
		WebElement frequencySelect;
					
		
		public wksRetirementCalculatorPage(WebDriver driver) {
			// TODO Auto-generated constructor stub
			this.driver=driver;
			PageFactory.initElements(driver, this);

		}

		public WebElement getkiwiSaverMemberContribution4()
		{
			return kiwiSaverMemberContribution4;
			
		}

		public WebElement getriskProfileDefensive()
		{
			return riskProfileDefensive;
			
		}

		public WebElement getriskProfileConservative()
		{
			return riskProfileConservative;
			
		}

		public WebElement getriskProfileBalanced()
		{
			return riskProfileBalanced;
			
		}
		
		public WebElement getprojectedBalances()
		{
			return projectedBalances;
			
		}

		
		
		public WebElement getwksAgeInfoText()
		{
			return ageInfoText;
			
		}

		public WebElement getwksAgeInfoButton()
		{
			return ageInfoButton;
			
		}
		
		public WebElement getCurrentAgeText()
		{
			return currentAgeText;
			
		}

		public WebElement getMainFrame()
		{
			return mainFrame;
			
		}
		

		public WebElement getsalaryPerYear()
		{
			return salaryPerYear;
			
		}
		
		
		public WebElement getemploymentStatusDD()
		{
			return employmentStatusDD;
			
		}
		
		public WebElement getcurrentKiwiSaverBalanceValue()
		{
			return currentKiwiSaverBalanceValue;
			
		}
		
		public WebElement getvoluntaryContributionsAmount()
		{
			return voluntaryContributionsAmt;
			
		}
		
		public WebElement getvoluntaryContributionsFrequency()
		{
			return voluntaryContributionsFrequency;
			
		}
		
		
		public WebElement gettotalFields()
		{
			return totalFields;
			
		}
		
		public WebElement gettotalIcons()
		{
			return totalIcons;
			
		}

		public WebElement getsavingGoals()
		{
			return savingGoals;
			
		}
		
		
		public WebElement getfrequencySelect()
		{
			return frequencySelect;
			
		}

}
