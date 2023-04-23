package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testcases.BaseClass;

public class LoginPage {

	// ============================ Objects ======================================

	@FindBy(id = "user-name")
	WebElement userName;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "login-button")
	WebElement loginBtn;

	// ============================ Methods ======================================

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void LoginFunction(String UserNameVal, String PasswordVal) {
		
//		loginLink.click();
//		Thread.sleep(10000);
		userName.sendKeys(UserNameVal);
		password.sendKeys(PasswordVal);
		loginBtn.click();

	}

}
