package testNGAssertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestDemo {
	
	String BaseUrl = "https://www.nopcommerce.com/en";
	WebDriver driver;
	@BeforeTest
	@Parameters("browserName")
	public void setUp (String browserName) {
		
		System.out.println("Browser name is.." + browserName);
		
		if (browserName.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\Launch Browsers\\Chrome Browser Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			
			System.setProperty("webdriver.edge.driver", "C:\\Users\\Admin\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
	}
	@Test
	public void BrowserTest() throws InterruptedException {
		driver.get(BaseUrl);
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}
	@AfterTest
	public void tearDown() {
		
		driver.quit();
	}

}
