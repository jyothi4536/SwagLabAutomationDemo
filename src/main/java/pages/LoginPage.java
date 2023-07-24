package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
//1)
	WebDriver driver;

	private WebElement userNameElement;
	private WebElement passwordElement;
	private WebElement loginButtonElement;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.userNameElement = driver.findElement(By.xpath("//input[@id='user-name']"));
		this.passwordElement = driver.findElement(By.xpath("//input[@id='password']"));
		this.loginButtonElement = driver.findElement(By.xpath("//input[@id='login-button']"));

	}

	public WebElement getUserNameElement() {
		return userNameElement;
	}

	public WebElement getPasswordElement() {
		return passwordElement;
	}

	public WebElement getLoginButtonElement() {
		return loginButtonElement;
	}

	public void inputUsernamePassword(String userName, String password) {
		userNameElement.sendKeys(userName);
		passwordElement.sendKeys(password);
	}

	public void dologin() {
		loginButtonElement.click();
	}

}
