package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderCompletePage {
//6)
	WebDriver driver;
	private WebElement orderConformationElement;

	public OrderCompletePage(WebDriver driver) {
		this.driver = driver;
		this.orderConformationElement = driver.findElement(By.xpath("//h2[@class='complete-header']"));

	}

	public WebElement getOrderConformationElement() {
		return orderConformationElement;
	}

	public String getOrderConformationMessage() {
		String conformationMessage = "";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='complete-header']")));
		conformationMessage = orderConformationElement.getText();
		return conformationMessage;
	}

}
