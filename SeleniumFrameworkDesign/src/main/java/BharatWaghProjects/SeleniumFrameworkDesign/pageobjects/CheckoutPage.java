package BharatWaghProjects.SeleniumFrameworkDesign.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import BharatWaghProjects.SeleniumFrameworkDesign.pageobjects.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
	
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);//always give to your parent/serve first to your parent
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	

	@FindBy(css=".action__submit")
	WebElement submit;

	@FindBy(css="[placeholder*='Select Country']")
	WebElement country;
	
	@FindBy(xpath="//button[contains(@class,'ta-item')])[2]")
	WebElement selectCountry;
	
	By results= By.cssSelector(".ta-results");
	
	By buttonClick =By.cssSelector(".action__submit");
	
	
	public void selectCountry(String countryName)
	{
		
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();

		waitForwebElementToAppear(results);

		selectCountry.click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,100)");

//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".action__submit")));
		waitForwebElementToClickable(buttonClick);


	}
	
	public ConfirmationPage submitorder()
	{
		submit.click();
		return new ConfirmationPage(driver);
	}
	
	
	
}
