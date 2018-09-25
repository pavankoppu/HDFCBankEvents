//This is test program
package testpackage;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HDFC {
  @Test
  public void f() {
	  
	  
	  System.setProperty("webdriver.chrome.driver", "F:/subject/selenium/seleniumJars/chromedriver.exe");
		WebDriver driver = new ChromeDriver(); //Instantiate the browser
		//Navigate to URL
		driver.get("http://www.hdfcbank.com");
		//Maximize the window
		driver.manage().window().maximize();
		//wait statement
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//click on NetBanking
		driver.findElement(By.id("loginsubmit")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Set<String> HDFCWindows = driver.getWindowHandles();
		for(String Handle : HDFCWindows)
		{
			driver.switchTo().window(Handle);
			System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl());
			if("NetBanking".equals(driver.getTitle()))
			{
				driver.findElement(By.xpath("(//a[text()='Continue to NetBanking'])[2]")).click();
				driver.switchTo().defaultContent();
				driver.switchTo().frame("login_page");
				driver.findElement(By.name("fldLoginUserId")).sendKeys("3534535");
				driver.findElement(By.xpath("//img[@alt='continue']")).click();
			}
		}
			
  }
}
