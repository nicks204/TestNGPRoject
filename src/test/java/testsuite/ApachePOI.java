package testsuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ApachePOI {
	
	WebDriver driver;
	XSSFWorkbook wbook;
	XSSFSheet sheet;
	
	
	@BeforeMethod
	public void Setup() throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
		
		driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.simplilearn.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		FileInputStream fis = new FileInputStream("exceldata.xlsx");
		wbook = new XSSFWorkbook(fis);
		sheet = wbook.getSheet("data");
		
	}
	

	@Test
	public void Login() {
		
		WebElement loginLink = driver.findElement(By.partialLinkText("Log "));
		loginLink.click();
		
		String Username = sheet.getRow(0).getCell(1).getStringCellValue();
		String Password = sheet.getRow(0).getCell(2).getStringCellValue();
		
		WebElement tbEmail = driver.findElement(By.name("user_login"));
		tbEmail.sendKeys(Username);
		
		WebElement tbPwd = driver.findElement(By.name("user_pwd"));
		tbPwd.sendKeys(Password);
		
		WebElement chRemember = driver.findElement(By.className("rememberMe"));
		chRemember.click();
		
		WebElement btnLogin = driver.findElement(By.name("btn_login"));
		btnLogin.click();
		
		WebElement error = driver.findElement(By.id("msg_box"));
		
		String actMsg = error.getText();
		String expMsg = "The email or password you have entered is invalid.";
		
		Assert.assertEquals(expMsg, actMsg);
		
		
	}
	
	@AfterMethod
	public void teardown() {
		
		//driver.quit();
	}

}
