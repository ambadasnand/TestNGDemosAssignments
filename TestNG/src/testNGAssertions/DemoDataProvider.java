package testNGAssertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.Helper;

public class DemoDataProvider {
	
	WebDriver driver;
	
	@Test(dataProvider = "EasyCalculation")
	public void dataprovidertest(String UserName, String password) throws InterruptedException {
		
		driver = Helper.startBrowser("GC");
		driver.get("https://www.login.hiox.com/login?referrer=easycalculation.com");
		//driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		driver.findElement(By.id("log_email")).sendKeys(UserName);
		driver.findElement(By.id("log_password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='log_submit']")).click();
		Thread.sleep(4000);
		Assert.assertTrue(driver.getTitle().contains("Free Online Math  Calculator and Converter"),
				"User Not able to login Successfully - Invalid Credentials");
		System.out.println("User Able to login Successfully - Valid Credentials");
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@DataProvider(name= "EasyCalculation")
	public Object[][] passData() {
		
		Object[][] data = new Object[3][2];
		data[0][0] = "9740673180";
		data[0][1] = "raghubn";
		data[1][0] = "9740673180";
		data[1][1] = "raghubn@123";
		data[2][0] = "raghubn2";
		data[2][1] = "raghubn";
		return data;
	}

}
