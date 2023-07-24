package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OverViewPage {
//5)
	WebDriver driver;
	private WebElement finishButtonElement;
	private WebElement sideBarMenuElement;
	private WebElement logoutButtonElement;

	public OverViewPage(WebDriver driver) {
		this.driver = driver;
		this.finishButtonElement = driver.findElement(By.xpath("//button[@id='finish']"));
		this.sideBarMenuElement = driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));
		this.logoutButtonElement = driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));

	}

	public WebElement getFinishButtonElement() {
		return finishButtonElement;
	}

	public void clickOnFinishButton() {
		finishButtonElement.click();
	}

	public void clickOnSideBarAndLogout() {
		sideBarMenuElement.click();
		logoutButtonElement.click();
	}

}
