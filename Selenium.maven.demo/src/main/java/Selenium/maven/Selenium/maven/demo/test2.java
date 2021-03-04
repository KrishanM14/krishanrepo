package Selenium.maven.Selenium.maven.demo;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.common.io.Files;

public class test2 {
	
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
	public void test1() throws InterruptedException, IOException {
		
		
		driver.get("https://jqueryui.com/droppable/\r\n");
		Thread.sleep(5000);
//		
//	driver.findElement(By.xpath("//input[@name=\"q\" and @type=\"text\"]")).click();
//		Thread.sleep(5000);
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		
		WebElement fromElement=driver.findElement(By.xpath("/html/body/div[1]"));
		Thread.sleep(4000);
		
		WebElement toElement=driver.findElement(By.xpath("/html/body/div[2]"));
		Thread.sleep(4000);
		
		Actions action=new Actions(driver);
		Thread.sleep(3000);
		
		action.dragAndDrop(fromElement, toElement).perform();
		Thread.sleep(3000);
		

		//getScreenshotAs method will take arguement for the output type of the file
			File dragAndDrop = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				
		//Using the FileUtils class copy the generated screenshot file to any location
		Files.copy(dragAndDrop, new File("C:\\Users\\krishanmurti.gond\\Desktop\\dragAndDrop.png"));
	}

}
