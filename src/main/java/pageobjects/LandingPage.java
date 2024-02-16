package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	
	WebDriver driver;
	
	@FindBy(id = "userEmail")
	WebElement userEmail;
	
	@FindBy(id = "userPassword")
	WebElement userPassword;
	
	@FindBy(id = "login")
	WebElement login;
	
	@FindBy(css = "div[aria-label='Incorrect email or password.']")
	WebElement errorMessage;
	
	public String getErrorMessage() {
		waitforElementToAppear(errorMessage);
		return errorMessage.getText();
	}

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(WebElement userEmail) {
		this.userEmail = userEmail;
	}
	public WebElement getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(WebElement userPassword) {
		this.userPassword = userPassword;
	}
	
	public ProductCatalog loginApplication(String username, String password) {
		this.userEmail.sendKeys(username);
		this.userPassword.sendKeys(password);
		this.login.click();
		return new ProductCatalog(driver);
	}
	
	public void goTo() {
		this.driver.get("https://rahulshettyacademy.com/client/");
	}
	
}
