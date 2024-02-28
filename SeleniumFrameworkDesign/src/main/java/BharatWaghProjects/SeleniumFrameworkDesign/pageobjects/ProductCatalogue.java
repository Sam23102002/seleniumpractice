package BharatWaghProjects.SeleniumFrameworkDesign.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BharatWaghProjects.SeleniumFrameworkDesign.pageobjects.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {

	
		WebDriver driver;
//2	
		public ProductCatalogue(WebDriver driver)
		{
			super(driver);//always give to your parent/serve first to your parent
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}



		
//		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
//		Pagefactory
//1	
		@FindBy(id=".mb-3")
		List<WebElement> products;
		
		@FindBy(css=".ng-animating")
		WebElement spinner;
		
//		By.cssSelector(".mb-3")
		
		By productsBy=By.cssSelector(".mb-3");
		By addToCart=By.cssSelector(".card-body button:last-of-type");
		By toastMessage=By.cssSelector("#toast-container");
		
		public List<WebElement> getProductList()
		{
			waitForwebElementToAppear(productsBy);
			return products;
		}
		
		public WebElement getProductByName(String productName)
		{
			WebElement prod = getProductList().stream()
					.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
					.orElse(null);
			return prod;

		}
		
		public void addProductToCart(String productName)
		{
			WebElement prod= getProductByName(productName);
			
			prod.findElement(addToCart).click();
			//pagefactory can not be applied with in WebElement.findELement
			waitForwebElementToAppear(toastMessage);
//			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
			waitForwebElementToDisappear(spinner);
		}
		
		

	}

