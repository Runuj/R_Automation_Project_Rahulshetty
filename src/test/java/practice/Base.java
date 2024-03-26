package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base {
	WebDriver driver;
@BeforeTest
public void driverInitialize() throws InterruptedException {
	driver = new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	driver.manage().window().maximize();
	Thread.sleep(3000);
}

@AfterTest
public void driverClose() throws InterruptedException {
	Thread.sleep(3000);
	driver.quit();
}
}
