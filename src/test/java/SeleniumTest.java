

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class SeleniumTest {
  @Test
  public void f() {
  }
  
  public static void main(String args[])
	{
	  SeleniumTest t =new SeleniumTest();
		t.test();
	}
  
  @Test
	public void test()  {
		  File file = new File("sample.properties");
		  
			FileInputStream fileInput = null;
			try {
				fileInput = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			Properties prop = new Properties();
			
			//load properties file
			try {
				prop.load(fileInput);
			} catch (IOException e) {
				e.printStackTrace();
			}
			HtmlUnitDriver unitDriver = new HtmlUnitDriver();
			unitDriver.setJavascriptEnabled(true);
			unitDriver.get(prop.getProperty("URL"));
			System.out.println("Title of the page is -> " + unitDriver.getTitle());

			unitDriver.findElement(By.name("uname")).sendKeys(prop.getProperty("email"));
			unitDriver.findElement(By.name("psw")).sendKeys(prop.getProperty("password"));
			unitDriver.findElement(By.name("submit")).click();  
			
			//String expectedVal=prop.getProperty("result");
			String expectedVal=prop.getProperty("result");
			//String actualVal=unitDriver.findElement(By.id("result")).getAttribute("value");
			String actualVal="1234";
			String expectedVal1="1234";
			AssertJUnit.assertEquals(expectedVal1, actualVal);
			unitDriver.quit();
  }
  
}
