package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NHSCostCheckerTool {

	public WebElement StartNow(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@type='submit']"));
	}

	public WebElement acceptOrRejectCookies(WebDriver driver, String buttonName) {
		WebElement element = null;
		element = driver.findElement(By.xpath("//button[contains(text(),'" + buttonName + "')]"));
		return element;
	}

	public WebElement Country(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@id='radio-scotland']//following-sibling::label"));
	}

	public WebElement Country1(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@id='radio-england']//following-sibling::label"));
	}

	public WebElement Country2(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@id='radio-nire']//following-sibling::label"));
	}

	public WebElement Country3(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@id='radio-wales']//following-sibling::label"));
	}

	public WebElement Next(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@value='Next']"));
	}

	public WebElement YesButton(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@id='radio-yes']//following-sibling::label"));
	}

	public WebElement NoButton(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@id='radio-no']//following-sibling::label"));
	}

	public WebElement BackButton(WebDriver driver) {
		return driver.findElement(By.xpath("//a[@id='back-button']"));
	}

	public WebElement dental(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@id='radio-not-registered']//following-sibling::label"));
	}

	public WebElement dental1(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@id='radio-scotland']//following-sibling::label"));
	}

	public WebElement dental2(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@id='radio-england']//following-sibling::label"));
	}

	public WebElement dental3(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@id='radio-wales']//following-sibling::label"));
	}

	public WebElement Day(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@id='dob-day']"));
	}

	public WebElement Month(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@id='dob-month']"));
	}

	public WebElement Year(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@id='dob-year']"));
	}

	public WebElement UniversalCredit(WebDriver driver) {
		return driver
				.findElement(By.xpath("//input[@value='YES_I_RECEIVED_UNIVERSAL_CREDIT']//following-sibling::label"));
	}

	public WebElement LinkDOB(WebDriver driver) {
		return driver.findElement(By.xpath("//span[@class='summary']"));
	}
}
