package Maven.Maven;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutoIT {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\TiaaUser\\Downloads\\temp\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();			
	    driver.get("http://demo.guru99.com/test/autoit.html");	
	    
	    driver.manage().window().maximize();
	    
	    driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	    
	    //Thread.sleep(10000);
	    
	    //driver.findElement(By.id("postjob")).click();			

	    driver.findElement(By.id("input_3")).sendKeys("Nik");                                 					
	    driver.findElement(By.id("id_4")).sendKeys("test.test@gmail.com");					
	    driver.findElement(By.id("input_4")).click();			
	    // below line execute the AutoIT script .
	    
	    Runtime.getRuntime().exec("C:\\Users\\TiaaUser\\OneDrive\\Desktop\\Selenium\\Demo.exe");	
	    
	    
	    driver.findElement(By.id("input_6")).sendKeys("AutoIT in Selenium");					
	    driver.findElement(By.id("input_2")).click();
	    driver.close();
	    

	}

}
