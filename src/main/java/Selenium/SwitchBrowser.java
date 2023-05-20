package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchBrowser {

	WebDriver driver; 
	
	public void init_driver(String browserName) {
		
		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		
		case "safari":
			
			driver = new SafariDriver();
			break;
		}
	
	
	}
	
	public static void main(String[] args) {
	
	}
}
