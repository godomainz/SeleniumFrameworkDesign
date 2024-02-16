package akila.SeleniumFrameworkDesign;

import java.io.IOException;

import org.testng.annotations.Test;

import akila.TestComponents.BaseTest;
import pageobjects.LandingPage;

public class SubmitOrderNew extends BaseTest {
	
	String username = "anshika@gmail.com";
	String password = "Iamking@000";
	String productName = "ZARA COAT 3";
	String countryName = "india";
	
	@Test
	public void submitOrder() throws IOException {
		
		LandingPage landingPage = launchApplication();
		
	}

}
