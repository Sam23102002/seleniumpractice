package rahulshettyacademy.tests;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class SearchProductTest extends BaseTest  {
	
	@Test
	public void searchProduct() throws InterruptedException
	{
		ProductCatalogue productCatalogue = landingPage.loginApplication("shetty@gmail.com", "Iamking@000");
		 Thread.sleep(5000); 
		 List<String> productList = Arrays.asList("ZARA COAT 3", "ADIDAS ORIGINAL", "IPHONE 13 PRO");
	     for (String product : productList) {
	    	 System.out.println("Searching for product: " + product);
	            landingPage.searchProduct(product);
	            // Add a delay to visually confirm the results are loaded (optional)
	            landingPage.HomeLink();
	     }
		
	    
	     
	}

}
