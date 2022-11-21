package pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ElementUtility;

public class HomePage {

	static WebDriver driver;
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://www.amazon.ca/");
		driver.manage().window().maximize();
		
		By idssss = By.xpath("//div[@id='glow-ingress-block']");
		By SearchDropDown =By.xpath("//select[@id='searchDropdownBox']");
		By MenuLinksList = By.xpath("//div[@id='nav-xshop']//following::a[contains(@data-csa-c-slot-id,'nav')]");
		
		By MEnuLinkList2 = By.xpath("");
		
		//MenuLinkList();
		linkScroll();
		multipleWindowHandling();
		ElementUtility ele= new ElementUtility(driver);
		//ele.doClick(idssss);
		//ele.doSelect(SearchDropDown, "Alexa Skills");
		//ele.doGetOption(SearchDropDown);;
	}
	
	public static void MenuLinkList() {
	    List<WebElement> MenuLinksLists=driver.findElements(By.xpath("//div[@id='nav-xshop']//following::a[contains(@data-csa-c-slot-id,'nav')]"));
	    System.out.println(MenuLinksLists.size());
	    for (int i = 0; i < MenuLinksLists.size(); i++) {
			String text = MenuLinksLists.get(i).getText();
			System.out.println(i +" " +text);
		}
	}
	
	public static void multipleWindowHandling() {
		String parent_window=driver.getWindowHandle();
		System.out.println("parent window ID is: "+parent_window);
		 
		WebDriverWait wait = new WebDriverWait(driver, 15);
	
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@id='navSwmHoliday']//following::a[@class='nav-imageHref']"))));
		element.click();
		
		Set<String> allWindowHandle = driver.getWindowHandles();
		System.out.println(allWindowHandle);
	}
	
	public static void linkScroll() {
		List<WebElement> list = driver.findElements(By.xpath("(//ul[@class='a-unordered-list a-nostyle a-horizontal feed-carousel-shelf'])[1]//child::li"));
		for (WebElement e : list) {
			System.out.println(e.getAttribute("aria-posinset"));
			if(e.getAttribute("aria-posinset") != null) {
				System.out.println(e);
			}
		}
	}
}
