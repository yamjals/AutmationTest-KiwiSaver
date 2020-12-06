package Resources;

/*
This is a base class and perform the following 
1. Browser Initialisation
2. Read data from Property file 
3. Screenshot Path		
*/


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class baseClass {

	public WebDriver driver;
	public Properties prop;

	public WebDriver BrowerInitialisation() throws IOException {
		// Web page under test
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\data.properties");
		prop.load(fis);
		String Browsername = prop.getProperty("browser");

		if (Browsername.equals("chrome")) {
			// Chrome is selected as browser for test
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (Browsername.equals("firefox")) {
			// Firefox is selected as browser for test
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\geckodriver.exe");
			driver = new FirefoxDriver();

		}

		else if (Browsername.equals("iexplore")) {
			// IE is selected as browser for test
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}

		// Maximizing the window size for better verification
		driver.manage().window().maximize();

		// implicitly defining the wait time
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

		return driver;

	}

	public void getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
	}

}