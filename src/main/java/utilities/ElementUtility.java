package utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementUtility {

	WebDriver driver;
	
	public ElementUtility(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	public void doSelect(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);	
	}

	public void doGetOption(By locator) {
		List<WebElement> listOption = getElements(locator);
		
		System.out.println(listOption.size());
		
		for (WebElement e : listOption) {
			System.out.println(e.getText());
		}
	}
}
