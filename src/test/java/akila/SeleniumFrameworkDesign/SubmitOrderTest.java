package akila.SeleniumFrameworkDesign;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.LandingPage;
import pageobjects.ProductCatalog;

public class SubmitOrderTest {
	public static void main(String args[]) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		String username = "anshika@gmail.com";
		String password = "Iamking@000";
		String productName = "ZARA COAT 3";
		String countryName = "india";

		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();
		
		landingPage.loginApplication(username, password);
		
		ProductCatalog productCatalogPage = new ProductCatalog(driver);
		productCatalogPage.addProductToCart(productName);
		
		driver.quit();
		
	}

}
