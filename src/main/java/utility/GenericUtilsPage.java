package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GenericUtilsPage {

	WebDriver driver;

	public GenericUtilsPage(WebDriver driver) {
		this.driver = driver;
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
	}

	public String getProperty(String property) {
		Properties pro = new Properties();
		try {
			pro.load(new FileInputStream("TestData1.properties"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return pro.getProperty(property);
	}

	public void captureScreenshot() {
		TakesScreenshot screenShot = ((TakesScreenshot) driver);
		File SrcFile = screenShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File("./Screenshots/img1.png");
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
