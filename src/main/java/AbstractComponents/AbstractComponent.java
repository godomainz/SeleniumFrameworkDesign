package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {

	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
	}

	public void waitforElementToAppear(By selector) {
		WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
	}
}
