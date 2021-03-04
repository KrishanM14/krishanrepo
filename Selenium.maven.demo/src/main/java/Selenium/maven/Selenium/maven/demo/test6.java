package Selenium.maven.Selenium.maven.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.junit.Test;


public class test6 {
	

	Properties property;
	FileInputStream fs;
	
	@Test
	public void test1() throws InterruptedException, IOException {
		
		fs=new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
		
		property = new Properties();
		
		property.load(fs);
		
		System.out.println(property.getProperty("name"));
		
		System.out.println(property.getProperty("url"));
		
		System.out.println(property.getProperty("browser"));
		
		System.out.println(property.getProperty("version"));
		
	}

}
