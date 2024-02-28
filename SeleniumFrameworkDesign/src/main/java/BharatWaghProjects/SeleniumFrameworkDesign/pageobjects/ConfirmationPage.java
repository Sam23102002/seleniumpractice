package BharatWaghProjects.SeleniumFrameworkDesign.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import BharatWaghProjects.SeleniumFrameworkDesign.pageobjects.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {
	
	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		
		// TODO Auto-generated constructor stub
		
		super(driver);//always give to your parent/serve first to your parent
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement confirmMessage;

//	String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
	
	public String getConfirmationMessage()
	{
		return confirmMessage.getText();
	}

//	Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	
}
