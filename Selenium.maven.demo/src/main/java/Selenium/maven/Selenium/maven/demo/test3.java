package Selenium.maven.Selenium.maven.demo;


import java.io.File;
import java.io.IOException;
import java.util.List;
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

public class test3 {
	
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
		
		
		driver.get("https://www.google.com");
		
		
		
		driver.findElement(By.xpath("//input[@name=\"q\" and @type=\"text\"]")).sendKeys("India");;
		Thread.sleep(10000);
		

		//getScreenshotAs method will take arguement for the output type of the file
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				
		//Using the FileUtils class copy the generated screenshot file to any location
		Files.copy(screenshot, new File("C:\\Users\\krishanmurti.gond\\Desktop\\search.png"));
		
		List<WebElement> suggestion=driver.findElements(By.className("sbl1"));
		
		int count=0;
		
		for (WebElement suggest : suggestion) {
			
			
			count++;
			
			if(suggest.getText().equalsIgnoreCase("indian army"))
			{
				suggest.click();
				
				//getScreenshotAs method will take arguement for the output type of the file
				File screenshot1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					
			//Using the FileUtils class copy the generated screenshot file to any location
			Files.copy(screenshot1, new File("C:\\Users\\krishanmurti.gond\\Desktop\\result.png"));
				
				break;
			}
		}
		
		System.out.println(count);
	}


}
