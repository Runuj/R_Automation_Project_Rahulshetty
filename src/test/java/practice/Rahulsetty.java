package practice;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Rahulsetty extends Base{

//------------------------------RadioButton----------------------------------------------------	
	
@Test(priority=1)
public void radio() throws InterruptedException 
{
	List<WebElement> radio = driver.findElements(By.name("radioButton"));
	for(int i=0;i<radio.size();i++) 
	{
		radio.get(i).click();
		Thread.sleep(3000);
	}
	
}

//------------------------------Sugession Class Example----------------------------------------------------	

@Test(priority=2)
public void text() throws InterruptedException 
{
	driver.findElement(By.id("autocomplete")).sendKeys("Ca");
	Thread.sleep(3000);
	List<WebElement> text=driver.findElements(By.xpath("//div[@tabindex='-1']"));
	Thread.sleep(3000);
	for(int i =0 ;i<text.size();i++) 
	{
		String list=text.get(i).getText();
		if(list.contains("Dominica")) 
		{
			Thread.sleep(3000);
			text.get(i).click();
			Thread.sleep(3000);
		}	
	}
	
}

//------------------------------Dropdown Class Example----------------------------------------------------	

@Test(priority=3)
public void dropdown()
{
	WebElement drp= driver.findElement(By.id("dropdown-class-example"));
	Select drp1= new Select(drp);
	drp1.selectByVisibleText("Option3");
}

//------------------------------Checkbox Class Example----------------------------------------------------	

@Test(priority=4)
public void checkbox() throws InterruptedException 
{
	List<WebElement> ckbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
	for(int i=0;i<ckbox.size();i++) 
	{
		ckbox.get(i).click();
		Thread.sleep(3000);
	}
	
}

//------------------------------Switch to new Window Example----------------------------------------------------	

@Test(priority=5)
public void switchwindow()
{
	driver.findElement(By.id("openwindow")).click();
	String originalWindowHandle = driver.getWindowHandle();
	Set<String> windowids= driver.getWindowHandles();
	
	for(String Windowid : windowids) 
	{
		driver.switchTo().window(Windowid);
		if(driver.getCurrentUrl().equals("https://www.qaclickacademy.com/"))
		{
			driver.findElement(By.linkText("Access all our Courses")).click();
			break;
		}
		
	}
	driver.switchTo().window(originalWindowHandle);
}


//------------------------------Switch to new Tab Example----------------------------------------------------
@Test(priority=6)
public void newtab() 
{
	 driver.findElement(By.id("opentab")).click();
	 String originalWindowHandle = driver.getWindowHandle(); // Store the original window handle
	 Set<String> tabs= driver.getWindowHandles();
	 for(String tab : tabs)
		{
			driver.switchTo().window(tab);
			if(driver.getCurrentUrl().equals("https://www.qaclickacademy.com/"))
			{
				driver.findElement(By.linkText("Blog")).click();
				break;
			}
		}
	 driver.switchTo().window(originalWindowHandle);  // Switch back to the original window
}

//------------------------------Switch to Alert Example----------------------------------------------------

@Test(priority=7)
public void alert() throws InterruptedException
{
	driver.findElement(By.id("alertbtn")).click();
	Thread.sleep(3000);
	driver.switchTo().alert().accept();
	//driver.switchTo().alert().dismiss();
	Thread.sleep(3000);
	
}

//------------------------------Switch to Alert Example----------------------------------------------------

@Test(priority=8)
public void alertconfirm() throws InterruptedException
{
	driver.findElement(By.id("confirmbtn")).click();
	Thread.sleep(3000);
	//driver.switchTo().alert().accept();
	driver.switchTo().alert().dismiss();
	Thread.sleep(3000);
	
}

//------------------------------Web table Example----------------------------------------------------

@Test(priority=9)
public void webtable() throws InterruptedException
{
	WebElement table = driver.findElement(By.id("product"));

    // Find all rows in the table
    List<WebElement> rows = table.findElements(By.tagName("tr"));

    // Iterate through each row
    for (WebElement row : rows) {
        // Find all columns in the row
        List<WebElement> columns = row.findElements(By.tagName("td"));
        // Iterate through each column
        for (WebElement column : columns) {
            // Print the text in each column
            System.out.print(column.getText() + "\t");
        }
        System.out.println(); // Move to the next line after printing all columns in the row
    }
}

//------------------------------Web table with Fixed Header Example----------------------------------------------------

@Test(priority=10)
public void webtableFixedheader() throws InterruptedException
{
	 WebElement table = driver.findElement(By.xpath("(//table[@id='product'])[2]"));

     // Find all rows in the table (including header row)
     List<WebElement> rows = table.findElements(By.tagName("tr"));

     // Iterate through each row
     for (WebElement row : rows) {
         // Find all columns in the row
         List<WebElement> columns = row.findElements(By.tagName("td"));
         // Iterate through each column
         for (WebElement column : columns) {
             // Print the text in each column
             System.out.print(column.getText() + "\t");
         }
         System.out.println(); // Move to the next line after printing all columns in the row
     }
}


//------------------------------show and hide Example----------------------------------------------------

@Test(priority=11)
public void showandhide() throws InterruptedException
{
	WebElement inputtext= driver.findElement(By.id("displayed-text"));
	inputtext.sendKeys("Runu");
	Thread.sleep(3000);
	WebElement hide= driver.findElement(By.id("hide-textbox"));
	hide.click();
	Thread.sleep(3000);
	WebElement show= driver.findElement(By.id("show-textbox"));
	show.click();
}

//------------------------------Scrolldown the page Example----------------------------------------------------

@Test(priority=12,groups = "smoke")
public void scrolldown() throws InterruptedException
{
	WebElement mhv = driver.findElement(By.id("mousehover"));
	//Scrolldown the page
	JavascriptExecutor js= (JavascriptExecutor)driver; //as the JavascriptExecutor is an interface so need to cast it by the webdriver 
	js.executeScript("arguments[0].scrollIntoView();",mhv);
	Thread.sleep(3000);
}

//------------------------------mousehover Example----------------------------------------------------

@Test(priority=12,groups = "smoke")
public void mousehover() throws InterruptedException
{
	WebElement mousehvr = driver.findElement(By.id("mousehover"));
	Thread.sleep(3000);
	Actions a = new Actions(driver);//For mouse hover we need to create an object for the Action class
	a.moveToElement(mousehvr).build().perform();
	Thread.sleep(3000);
	WebElement top = driver.findElement(By.linkText("Top"));
	top.click();
}

//------------------------------Switch to frame Example----------------------------------------------------

@Test(priority=12,groups = "smoke")
public void frame() throws InterruptedException
{
	Thread.sleep(3000);
	driver.switchTo().frame(0);
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//a[@href='lifetime-access'])[2]")).click();
}

//------------------------------Screenshot Example----------------------------------------------------

@Test(priority=12,groups = "smoke")
public void screenshot() throws InterruptedException, IOException
{
	TakesScreenshot ts = (TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	Thread.sleep(3000);
	File dest = new File("C:\\Users\\hp\\Desktop\\HYBRID AUTOMATION\\pic.png");
	FileUtils.copyFile(src, dest);
	Thread.sleep(3000);
}

}
