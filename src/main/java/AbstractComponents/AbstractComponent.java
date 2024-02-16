package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {

	WebDriver driver;
	WebDriverWait wait;
	
	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver, Duration.ofSeconds(25));
	}

	public void waitforElementToAppear(By selector) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
	}
	
	public void waitForElementToDissapear(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
}
