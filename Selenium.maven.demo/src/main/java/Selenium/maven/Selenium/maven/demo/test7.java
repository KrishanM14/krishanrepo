package Selenium.maven.Selenium.maven.demo;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
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

public class test7 {
	
	

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
	      List<WebElement> links = driver.findElements(By.tagName("a"));
	      
	      System.out.println("Total Links are"+links.size());
	      
	      for(int i=0;i<links.size();i++)
	      {
	    	  WebElement element = links.get(i);
	    	  
	    	  String url=element.getAttribute("href");
	    	  
	    	  URL link=new URL(url);
	    	  
	    	  HttpURLConnection httpConn=(HttpURLConnection)link.openConnection();
	    	  
	    	  Thread.sleep(2000);
	    	  
	    	  httpConn.connect();
	    	  
	    	  int rescode=httpConn.getResponseCode();
	    	  
	    	  if(rescode>400)
	    	  {
	    		  System.out.println(url+"-"+"is broken link");
	    	  }
	    	  
	    	  else
	    	  {
	    		  System.out.println(url+"-"+"is valid link");
	    	  }
	    	  
	    	  
	      }
	        
	}
       
}
