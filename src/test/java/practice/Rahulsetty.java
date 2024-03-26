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

@Test(priority=8)
public void switchwindow()
{
	driver.findElement(By.id("openwindow")).click();
	Set<String> windowids= driver.getWindowHandles();
	
	for(String Windowid : windowids) 
	{
		driver.switchTo().window(Windowid);
		if(driver.getCurrentUrl().equals("https://www.qaclickacademy.com/"))
		{
			driver.findElement(By.linkText("Access all our Courses")).click();
		}
	}
}


//------------------------------Switch to new Tab Example----------------------------------------------------
@Test(priority=7)
public void newtab() 
{
	 driver.findElement(By.id("opentab")).click();
	 Set<String> tabs= driver.getWindowHandles();
	 for(String tab : tabs)
		{
			driver.switchTo().window(tab);
			if(driver.getCurrentUrl().equals("https://www.qaclickacademy.com/"))
			{
				driver.findElement(By.linkText("Blog")).click();
			}
		}
	 
}

//------------------------------Switch to Alert Example----------------------------------------------------

@Test(priority=5)
public void alert() throws InterruptedException
{
	driver.findElement(By.id("alertbtn")).click();
	Thread.sleep(3000);
	driver.switchTo().alert().accept();
	//driver.switchTo().alert().dismiss();
	Thread.sleep(3000);
	
}

//------------------------------Switch to Alert Example----------------------------------------------------

@Test(priority=6)
public void alertconfirm() throws InterruptedException
{
	driver.findElement(By.id("confirmbtn")).click();
	Thread.sleep(3000);
	//driver.switchTo().alert().accept();
	driver.switchTo().alert().dismiss();
	Thread.sleep(3000);
	
}

}
