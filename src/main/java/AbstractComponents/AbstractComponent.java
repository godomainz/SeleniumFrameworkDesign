package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageobjects.CartPage;

public class AbstractComponent {

	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;
	
	public AbstractComponent() {
		PageFactory.initElements(driver, this);
	}
	
	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver, Duration.ofSeconds(25));
	}

	public void waitforElementToAppear(By selector) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
	}
	
	public void waitForElementToDissapear(WebElement element) throws InterruptedException {
//		wait.until(ExpectedConditions.invisibilityOf(element));
		Thread.sleep(2000);
	}
	
	public CartPage goToCartPage() {
		cartHeader.click();
		return new CartPage(driver);
	}
}
