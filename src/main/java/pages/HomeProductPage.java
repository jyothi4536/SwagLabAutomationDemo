package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomeProductPage {
//2)
	WebDriver driver;

	private WebElement loginConformationElement;
	private WebElement cartButtonElement;

	public HomeProductPage(WebDriver driver) {
		this.driver = driver;
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		this.loginConformationElement = driver.findElement(By.xpath("//span[@class='title']"));
		this.cartButtonElement = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
	}

	public String getLoginConformationMessage() {
		String conformationMessageString = "";
		conformationMessageString = loginConformationElement.getText();
		return conformationMessageString;
	}

	public void selectItemAndAddtoCart(String Item) {

		List<WebElement> items = driver.findElements(By.xpath("//div[@class ='inventory_item']"));
		for (WebElement i : items) {
			String itemNameString = i.findElement(By.xpath("//div[@class ='inventory_item']")).getText();

			if (itemNameString.contains(Item)) {
				i.findElement(By.xpath("//button[@class ='btn btn_primary btn_small btn_inventory']")).click();

			}
		}

	}

	public void selectAnyOneItemAndAddtoCart() {

		driver.findElement(By.xpath("(//button[@class ='btn btn_primary btn_small btn_inventory'])[1]")).click();

	}

	public void clickOnCartButton() {
		cartButtonElement.click();
	}

}
