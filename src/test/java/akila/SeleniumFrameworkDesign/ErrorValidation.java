package akila.SeleniumFrameworkDesign;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import akila.TestComponents.BaseTest;
import pageobjects.CartPage;
import pageobjects.ProductCatalog;

public class ErrorValidation extends BaseTest {
	String username = "anshika@gmail.com";
	String password = "Iamking@000";
	String productName = "ZARA COAT 3";
	String countryName = "india";
	
	@Test
	public void loginErrorValidation() throws IOException, InterruptedException {
		
		landingPage.loginApplication(username, password+"1");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());;
	}
	
	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException {
		
		ProductCatalog productCatalogPage = landingPage.loginApplication(username, password);
		productCatalogPage.addProductToCart(productName);
		CartPage cartPage = productCatalogPage.goToCartPage();
		
		Boolean match = cartPage.verifyProductDisplay("ZARA COAT 33");
		Assert.assertTrue(match);
	}
}
