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
	
	@FindBy(css = ".ng-animating")
	WebElement spinner;
	
	By productsBy = By.cssSelector(".mb-3");
	By addToCartBy = By.cssSelector(".card .card-body button:last-of-type");
	By toastmessage = By.cssSelector(".card .card-body button:last-of-type");
	
	public ProductCatalog(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public List<WebElement> getProducts() {
		waitforElementToAppear(this.productsBy);
		return products;
	}

	public WebElement getProductByName(String productName) {
		WebElement prod = getProducts().stream().filter(product->product.findElement(By.cssSelector(".card .card-body h5")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName) {
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCartBy).click();
		waitforElementToAppear(this.toastmessage);
		waitForElementToDissapear(this.spinner);
	}
	
}
