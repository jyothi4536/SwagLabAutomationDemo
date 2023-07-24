package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutPage {
//4)
	WebDriver driver;

	private WebElement firstNameElement;
	private WebElement lastNameElement;
	private WebElement zipCodeElement;
	private WebElement continueButtonElement;
	private WebElement cancelButtonElement;

	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		this.firstNameElement = driver.findElement(By.xpath("//input[@id='first-name']"));
		this.lastNameElement = driver.findElement(By.xpath("//input[@id='last-name']"));
		this.zipCodeElement = driver.findElement(By.xpath("//input[@id='postal-code']"));
		this.continueButtonElement = driver.findElement(By.xpath("//input[@id='continue']"));
		this.cancelButtonElement = driver.findElement(By.xpath("//button[@id='cancel']"));

	}

	public WebElement getFirstNameElement() {
		return firstNameElement;
	}

	public WebElement getLastNameElement() {
		return lastNameElement;
	}

	public WebElement getZipCodeElement() {
		return zipCodeElement;
	}

	public WebElement getContinueButtonElement() {
		return continueButtonElement;
	}

	public WebElement getCancelButtonElement() {
		return cancelButtonElement;
	}

}
