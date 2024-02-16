package akila.SeleniumFrameworkDesign;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.CartPage;
import pageobjects.CheckoutPage;
import pageobjects.LandingPage;
import pageobjects.ProductCatalog;
import pageobjects.ConfirmationPage;

public class SubmitOrderTest {
	public static void main(String args[]) throws InterruptedException {
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
		
		ProductCatalog productCatalogPage = landingPage.loginApplication(username, password);
		productCatalogPage.addProductToCart(productName);
		CartPage cartPage = productCatalogPage.goToCartPage();
		
		Boolean match = cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		ConfirmationPage thankPage = checkoutPage.submit();
		
		String confirmMessage = thankPage.getConfirmMessage();
		String actualMessage = "THANKYOU FOR THE ORDER.";
		Assert.assertEquals(confirmMessage, actualMessage);
		
//		driver.wait(2000);
		driver.quit();
		
	}

}
