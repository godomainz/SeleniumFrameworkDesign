package akila.SeleniumFrameworkDesign;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import akila.TestComponents.BaseTest;
import pageobjects.CartPage;
import pageobjects.CheckoutPage;
import pageobjects.ConfirmationPage;
import pageobjects.LandingPage;
import pageobjects.ProductCatalog;

public class SubmitOrderNew extends BaseTest {
	
	String username = "anshika@gmail.com";
	String password = "Iamking@000";
	String productName = "ZARA COAT 3";
	String countryName = "india";
	
	@Test
	public void submitOrder() throws IOException, InterruptedException {
		
		ProductCatalog productCatalogPage = landingPage.loginApplication(username, password);
		productCatalogPage.addProductToCart(productName);
		CartPage cartPage = productCatalogPage.goToCartPage();
		
		Boolean match = cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry(countryName);
		ConfirmationPage thankPage = checkoutPage.submit();
		
		String confirmMessage = thankPage.getConfirmMessage();
		String actualMessage = "THANKYOU FOR THE ORDER.";
		Assert.assertEquals(confirmMessage, actualMessage);
	}

}
