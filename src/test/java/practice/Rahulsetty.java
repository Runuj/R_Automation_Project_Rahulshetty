package practice;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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



}
