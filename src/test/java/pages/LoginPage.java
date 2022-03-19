package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy (id = "login")
	WebElement weEmail;
	
	@FindBy (id = "password")
	WebElement wePassword;
	
	@FindBy (xpath = "//button[contains(text(),'Log in')]")
	WebElement btnLogin;
	

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public HomePage login(String email, String password) {
		weEmail.sendKeys(email);
		wePassword.sendKeys(password);
		btnLogin.click();
		// return home page
        return new HomePage(driver);
	}
}
