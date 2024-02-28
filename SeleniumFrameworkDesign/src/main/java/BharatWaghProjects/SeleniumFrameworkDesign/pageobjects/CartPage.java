package BharatWaghProjects.SeleniumFrameworkDesign.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BharatWaghProjects.SeleniumFrameworkDesign.pageobjects.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {

	
		WebDriver driver;
//2	
		public CartPage(WebDriver driver)
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
	
		
		@FindBy(css=".totalRow button")
		WebElement checkoutele;
		
		@FindBy(css=".cartSection h3")
		List<WebElement> cartproduts;
		
		
		
//		List<WebElement> cartproduts = driver.findElements(By.cssSelector(".cartSection h3"));
//		boolean match = cartproduts.stream()
//				.anyMatch(cartproduct -> cartproduct.getText().equalsIgnoreCase(productName));
		
		public Boolean verifyProductDisplay(String productName)
		{
			boolean match = cartproduts.stream().anyMatch(cartproduct -> cartproduct.getText().equalsIgnoreCase(productName));
			return match;
		}
		
		public CheckoutPage goToCheckOut()
		{
			checkoutele.click();
			
			return new CheckoutPage(driver);
		}
		

	}

