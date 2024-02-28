package BharatWaghProjects.SeleniumFrameworkDesign.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BharatWaghProjects.SeleniumFrameworkDesign.pageobjects.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

	
		WebDriver driver;
//2	
		public LandingPage(WebDriver driver)
		{
			
//			initializing the driver
			super(driver); //sending to parent class for driver life using super keyword
			this.driver=driver;
			PageFactory.initElements(driver, this);  //for pagefactory elements initialization
		}

//page factory is for WebElements like driver.findElement
//not for locators By.CssSelector
		
//		WebElement userEmail = driver.findElement(By.id("userEmail"));
//		Pagefactory
		
//1
		@FindBy(id="userEmail")
		WebElement userEmail;
		
		@FindBy(id="userPassword")
		WebElement passwordEle;
		
		@FindBy(id="login")
		WebElement submit;
		
//3
		public ProductCatalogue loginApplication(String email, String password) //action method login
		{
			
			//page object should not hold any data. It should focus on elements and actions.
			userEmail.sendKeys(email);
			passwordEle.sendKeys(password);
			submit.click();
			
			ProductCatalogue productCatalogue = new ProductCatalogue(driver);
			return productCatalogue;
		}
		
//4		
		public void goTo()
		{
			driver.get("https://rahulshettyacademy.com/client");
		}
		
		

	}

