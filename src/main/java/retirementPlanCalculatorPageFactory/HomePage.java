package retirementPlanCalculatorPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	

	//WebElement available on homepage (Westpac Main page)
		
		@FindBy(css="#ubermenu-section-link-kiwisaver-ps")
		WebElement sKiwiSaver;
		
		@FindBy(css="#ubermenu-item-cta-kiwisaver-calculators-ps")
		WebElement kSaverCalc;
		
		
		
		
		public WebElement selectKiwiSaver()
		{
			return sKiwiSaver;
						
		}
		
		public WebElement getKiwiSaverCalc()
		{
			return kSaverCalc;
						
		}
		
		
		public HomePage(WebDriver driver) {
			// TODO Auto-generated constructor stub
			this.driver=driver;
			PageFactory.initElements(driver, this);

		}
		

		
}
