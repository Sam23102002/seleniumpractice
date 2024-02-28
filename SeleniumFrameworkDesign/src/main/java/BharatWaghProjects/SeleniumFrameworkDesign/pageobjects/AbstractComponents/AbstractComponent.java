package BharatWaghProjects.SeleniumFrameworkDesign.pageobjects.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BharatWaghProjects.SeleniumFrameworkDesign.pageobjects.CartPage;


//utility to reuse the classes across the classes and avoid code duplication
//This will be parent class for all child object classes--methods will be available for child classes
//one way is creating object its overhead the memory------so using inheritance here 
//switching child windows, waiting for elements

public class AbstractComponent {
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;  //assigning the life from page object
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=("[routerlink*='cart']"))
	WebElement cartHeader;

	public void waitForwebElementToAppear(By findBy)
	{
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public CartPage goToCartPage()
	{
//		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		cartHeader.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
		
	}
	
	public void waitForwebElementToDisappear(WebElement ele)
	{
//		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public void waitForwebElementToClickable(By findBy)
	
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(findBy));
	}
	
	
	

}
