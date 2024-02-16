package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
	WebDriver driver;
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	By resultsBy = By.cssSelector(".ta-results");
	By countriesListBy = By.cssSelector(".ta-results button span");
	Actions a;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.a = new Actions(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void selectCountry(String countryName) {
		a.sendKeys(country, countryName).build().perform();
		
		waitforElementToAppear(resultsBy);
		
		List<WebElement> countries = driver.findElements(countriesListBy);
		WebElement selectedCountry = countries.stream().filter(country->country.getText().equalsIgnoreCase(countryName)).findFirst().orElse(null);
		a.moveToElement(selectedCountry).click().perform();
	}
	
	public ConfirmationPage submit() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		a.moveToElement(submit).click().perform();
		
		return new ConfirmationPage(driver);
	}

}
