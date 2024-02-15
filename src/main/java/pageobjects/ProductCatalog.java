package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AbstractComponents.AbstractComponent;

public class ProductCatalog extends AbstractComponent {
	
	WebDriver driver;
	
	@FindBy(css = ".mb-3")
	List<WebElement> products;
	By productsLocator = By.cssSelector(".mb-3");
	
	public ProductCatalog(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public List<WebElement> getProducts() {
		waitforElementToAppear(this.productsLocator);
		return products;
	}

	
	
	
}
