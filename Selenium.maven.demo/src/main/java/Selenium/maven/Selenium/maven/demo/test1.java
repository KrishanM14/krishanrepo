package Selenium.maven.Selenium.maven.demo;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.utils.FileUtil;
import com.google.common.io.Files;




public class test1 {

	WebDriver driver;
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver\\Chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
	}
	
	@After
	public void setDown()
	{
		driver.quit();
		
	}
	
	@Test
	public void test1() throws InterruptedException, IOException
	{
		driver.get("https://touch.facebook.com/");
		Thread.sleep(2000);
		
		driver.findElement(By.id("signup-button")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.name("firstname")).sendKeys("Harsh");
		Thread.sleep(2000);
		
		driver.findElement(By.name("lastname")).sendKeys("Sharma");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@id=\"mobile-reg-form\"]/div[9]/div[2]/button[1]")).click();
		Thread.sleep(1000);
		
		Select day=new Select(driver.findElement(By.id("day")));
		day.selectByValue("14");
		Thread.sleep(2000);
		
		Select month=new Select(driver.findElement(By.id("month")));
		month.selectByValue("7");
		Thread.sleep(2000);
		
		Select year=new Select(driver.findElement(By.id("year")));
		year.selectByValue("1997");
		Thread.sleep(2000);
		

		//getScreenshotAs method will take arguement for the output type of the file
				File dropdown = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				
		//Using the Files.copy class copy the generated screenshot file to any location
		Files.copy(dropdown, new File("C:\\Users\\krishanmurti.gond\\Desktop\\dropdown.png"));
		
		driver.findElement(By.xpath("//*[@id=\"mobile-reg-form\"]/div[9]/div[2]/button[1]")).click();
		Thread.sleep(2000);
		
		
		
	}
	
//	@Test
//	public void test2() throws InterruptedException {
//		
//		driver.get("https://jqueryui.com/droppable/");
//		Thread.sleep(2000);
//		
//		WebElement fromElement=driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
//		
//		WebElement toElement=driver.findElement(By.xpath("//*[@id=\"droppable\"]"));
//		
//		Actions action=new Actions(driver);
//		
//		action.dragAndDrop(fromElement, toElement).build().perform();
//	}
}
