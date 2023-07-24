package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YourCartPage {
//3)
	WebDriver driver;
	private WebElement checkOutButtonElement;
	private WebElement continueShopingButtonElement;

	public YourCartPage(WebDriver driver) {
		this.driver = driver;
		this.checkOutButtonElement = driver.findElement(By.xpath("//button[@id='checkout']"));
		this.continueShopingButtonElement = driver.findElement(By.xpath("//button[@id='continue-shopping']"));
	}

	public WebElement getcheckOutButtonElement() {
		return checkOutButtonElement;
	}

	public WebElement getContinueShoppingElement() {
		return continueShopingButtonElement;
	}

	public void clickOnProceedToCheckOut() {
		checkOutButtonElement.click();
	}
}
