package Selenium.maven.Selenium.maven.demo;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class test5 {

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
		
		String homePage = "http://www.zlti.com";
		
		driver.get(homePage);
		Thread.sleep(1000);
		
		
		 
	
		 
	        
		
		//System.out.println(driver.manage().window().getSize());
	     
	      Dimension dm = new Dimension(2000,1000);
	     
	      driver.manage().window().setSize(dm);
	      
	      Thread.sleep(2000);
	      
	    //getScreenshotAs method will take arguement for the output type of the file
			File screenshot1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				
		//Using the FileUtils class copy the generated screenshot file to any location
		Files.copy(screenshot1, new File("C:\\Users\\krishanmurti.gond\\Desktop\\size.png"));
	      
	      
	      
	      JavascriptExecutor JS = (JavascriptExecutor)driver;
	      
	      JS.executeScript("document.getElementById('searchform-1').value='without send keys';");
	      
	      Thread.sleep(2000);
	      
	    //getScreenshotAs method will take arguement for the output type of the file
			File screenshot2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				
		//Using the FileUtils class copy the generated screenshot file to any location
		Files.copy(screenshot2, new File("C:\\Users\\krishanmurti.gond\\Desktop\\withoutSend.png"));
	      
	      
	}
}
