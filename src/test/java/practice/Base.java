package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base {
	//WebDriver driver;
	WebDriver driver = null;
@BeforeTest
public void driverInitialize() throws InterruptedException, IOException {
	Properties prop = new Properties();
	File file = new File("config.properties");
	FileInputStream fis = new FileInputStream (file);
	prop.load(fis);
	String browserName = prop.getProperty("browser");
	
	if (browserName.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
		
	}else if (browserName.equalsIgnoreCase ("firefox")) {
		driver = new FirefoxDriver();
		
	}else if (browserName.equalsIgnoreCase ("edge")) {
		driver = new EdgeDriver();
	}
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
