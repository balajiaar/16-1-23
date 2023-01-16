package Dataproviderinclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dataproinclass {
	WebDriver driver;
	String [][] data= {
			{"Admin","admin123"},
			{"admin1","Admin"},
			{"AdMiN","ADMIN#$%"},
			{"wtrwt","fjhfhjf"}				
			};
	@DataProvider(name="logindata")
	public String[][] Dataloginprovide() {
		return data;
				
	}
		
	
		@Test(dataProvider="logindata")
		
		public void correctpassword( String username,String password)
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.name("username")).sendKeys(username);
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		}
		
		

	}


	
	


