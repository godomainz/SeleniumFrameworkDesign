package akila.SeleniumFrameworkDesign;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {
	public static void main(String args[]) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		String url = "https://rahulshettyacademy.com/client/";
		String username = "anshika@gmail.com";
		String password = "Iamking@000";
		String productName = "ZARA COAT 3";
		String countryName = "india";
		
		driver.get(url);
		
		driver.findElement(By.id("userEmail")).sendKeys(username);
		driver.findElement(By.id("userPassword")).sendKeys(password);
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod = products.stream().filter(product->product.findElement(By.cssSelector(".card .card-body h5")).getText().equals(productName)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card .card-body button:last-of-type")).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cart .cartSection h3:first-of-type"));
		Boolean match = cartProducts.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), countryName).build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		List<WebElement> countries = driver.findElements(By.cssSelector(".ta-results button span"));
		WebElement selectedCountry = countries.stream().filter(country->country.getText().equalsIgnoreCase(countryName)).findFirst().orElse(null);
		a.moveToElement(selectedCountry).click().perform();
		
		
		WebElement placeOrderBtn = driver.findElement(By.cssSelector(".action__submit"));
		a.moveToElement(placeOrderBtn).click().perform();
		
		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		String actualMessage = "THANKYOU FOR THE ORDER.";
		Assert.assertEquals(confirmMessage, actualMessage);
		driver.quit();
		
	}

}
