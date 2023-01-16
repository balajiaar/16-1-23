package Dataproviderinclass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Exceldata {
	public class Dataproinclass {
		WebDriver driver;
		String [][] data=null;	
				
		@DataProvider(name="logindata")
		public String[][] Dataloginprovide() {
			return data;
					
		}
			
		public void getexceldata() throws IOException {
			FileInputStream F=new FileInputStream ("C:\\Users\\Balaji.V\\Desktop\\New XLSX Worksheet.xlxs");
		    Workbook w=new XSSFWorkbook(F);
		    org.apache.poi.ss.usermodel.Sheet sheetAt= w.getSheet("0");
		    
		    
		
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


		
		

}
