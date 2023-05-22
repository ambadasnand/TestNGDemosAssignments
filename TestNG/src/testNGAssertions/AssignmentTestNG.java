package testNGAssertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.Helper;
import utility.Reusability;

public class AssignmentTestNG {
	
WebDriver driver;
	
	@Test(dataProvider = "LoginData")
	public void loginTest(String UserName, String password) throws InterruptedException {
		
		driver = Helper.startBrowser("GC");
		driver.get("https://www.hollandandbarrett.com");
		//driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"data-cs-mask-account\"]/button/div/img")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("username")).sendKeys(UserName);
		driver.findElement(By.id("password")).sendKeys(password);
		
		
		driver.findElement(By.xpath("/html/body/main/section/div/div/div/form/div[3]/button")).click();
		
		Thread.sleep(3000);
	}
	@AfterMethod
	public void teardown(ITestResult result) {
		
		if (ITestResult.FAILURE == result.getStatus()) {
			Reusability.capturedScreenshot(driver, result.getName());
		}
		driver.quit();
	}
	
	@DataProvider(name= "LoginData")
	public Object[][] passData() {
		
		Object[][] data = new Object[3][2];
		data[0][0] = "raghubn@gmail.com";
		data[0][1] = "raghubn";
		data[1][0] = "9880614548";
		data[1][1] = "raghubn@123";
		data[2][0] = "wiprotechnologies";
		data[2][1] = "123456789";
		return data;
	}

}
