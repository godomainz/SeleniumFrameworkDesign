package akila.SeleniumFrameworkDesign;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import akila.TestComponents.BaseTest;
import pageobjects.ProductCatalog;

public class ErrorValidation extends BaseTest {
	String username = "anshika@gmail.com";
	String password = "Iamking@0001";
	String productName = "ZARA COAT 3";
	String countryName = "india";
	
	@Test
	public void submitOrder() throws IOException, InterruptedException {
		
		ProductCatalog productCatalogPage = landingPage.loginApplication(username, password);
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());;
	}
}
