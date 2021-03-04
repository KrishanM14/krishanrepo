package Selenium.maven.Selenium.maven.demo;

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

public class test4 {
	
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
		
		
		driver.get("http://openclinic.sourceforge.net/openclinic/home/index.php\r\n");
		Thread.sleep(3000);
				
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,5000)");
		
		Thread.sleep(2000);
		
		//getScreenshotAs method will take arguement for the output type of the file
		File screenshot1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
	//Using the FileUtils class copy the generated screenshot file to any location
	Files.copy(screenshot1, new File("C:\\Users\\krishanmurti.gond\\Desktop\\scroll.png"));
		
		
	}

}
