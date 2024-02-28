package BharatWaghProjects.SeleniumFrameworkDesign;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import BharatWaghProjects.SeleniumFrameworkDesign.pageobjects.CartPage;
import BharatWaghProjects.SeleniumFrameworkDesign.pageobjects.CheckoutPage;
import BharatWaghProjects.SeleniumFrameworkDesign.pageobjects.ConfirmationPage;
import BharatWaghProjects.SeleniumFrameworkDesign.pageobjects.LandingPage;
import BharatWaghProjects.SeleniumFrameworkDesign.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String productName = "zara coat 3";

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		LandingPage landingpage = new LandingPage(driver);
		landingpage.goTo();
		ProductCatalogue productCatalogue=landingpage.loginApplication("bharat@gmail.com", "Selenium@143");

//		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage =productCatalogue.goToCartPage();
		
//		CartPage cartPage = new CartPage(driver);
		Boolean match=cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkOutPage=cartPage.goToCheckOut();
		checkOutPage.selectCountry("India");
		ConfirmationPage confirmationpage =checkOutPage.submitorder();
		String confirmMessage=confirmationpage.getConfirmationMessage();
		
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();

		
		
		
		
		
		

//		WebElement prod = products.stream()
//				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
//				.orElse(null);

//		driver.findElement(By.cssSelector(".card-body button:last-of-type")).click();
//		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
//		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
//		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

//		List<WebElement> cartproduts = driver.findElements(By.cssSelector(".cartSection h3"));
//		boolean match = cartproduts.stream()
//				.anyMatch(cartproduct -> cartproduct.getText().equalsIgnoreCase(productName));

		

//		driver.findElement(By.cssSelector(".totalRow button")).click();

//		Actions a = new Actions(driver);
//		a.sendKeys(driver.findElement(By.cssSelector("[placeholder*='Select Country']")), "India").build().perform();
//
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
//
//		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//
//		js.executeScript("window.scrollBy(0,100)");
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".action__submit")));
//
//		driver.findElement(By.cssSelector(".action__submit")).click();

//		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
//
		
	}

}
