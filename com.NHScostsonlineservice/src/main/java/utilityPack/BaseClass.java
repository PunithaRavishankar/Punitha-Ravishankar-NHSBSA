package utilityPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseClass {
	public void navigateToUrl(WebDriver driver, String input) {
		driver.get(input);
	}

	public void scrollToElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void type(WebElement element, String input) {
		element.sendKeys(input);
	}

	public void clickElement(WebElement element) {
		element.click();
	}

	public String getTxt(WebElement element) {
		String text = element.getText();
		return text;
	}

	public void hardWait(long timeInMilliSec) {
		try {
			Thread.sleep(timeInMilliSec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void implicitWait(WebDriver driver, long timeInMilliSec) {
		driver.manage().timeouts().implicitlyWait(timeInMilliSec, TimeUnit.SECONDS);

	}

	public void close(WebDriver driver) {
		driver.quit();
	}
}