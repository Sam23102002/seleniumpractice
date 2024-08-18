package rahulshettyacademy.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {
	
	static WebDriver driver;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Register link clicking 
		driver.findElement(By.linkText("Register here")).click();
		//
		driver.findElement(By.id("firstName")).sendKeys("ramesh");
		driver.findElement(By.id("lastName")).sendKeys("korla");
		driver.findElement(By.id("userEmail")).sendKeys("ramesh.korla@aol.com");
		driver.findElement(By.id("userMobile")).sendKeys("9392976665");
		
		driver.findElement(By.id("userPassword")).sendKeys("Test#123");
		driver.findElement(By.id("confirmPassword")).sendKeys("Test#123");
		/***ScrollInto Element for Clicking **/
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id("login")));
		driver.findElement(By.id("login")).click();
	}

}
