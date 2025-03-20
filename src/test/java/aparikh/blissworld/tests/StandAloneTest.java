package aparikh.blissworld.tests;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.blissworld.com/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		By announcement = By.xpath("//section[@id='section-announcement']//div[@class='AnnouncementBar__Close']");
		By announcement2 = By.xpath("(//div[@class='layer-wiziwig'])[1]");
		By cookiesAccept = By.xpath("//button[@aria-label='Accept']");
		By starterKit = By.xpath("//a[@banner-id='Bliss Starter Kit PDP Tile']");
		By essentialsKit = By.xpath("//a[@banner-id='Essentials Kit PDP Tile']");
		By productPrice = By.xpath("//div[@class='desktop-only']//span[@class='ProductMeta__Price Price Price--highlight Text--subdued u-h4']");
		By addToCart = By.xpath("//div[@class='add_to_bag_btn add_to_bag_btn_atc custom-select']");
		By checkoutBtn = By.xpath("//button[@class='rebuy-button rebuy-cart__checkout-button block']");
		By checkoutPrice = By.xpath("//div[@role='row']//div[@role='cell']//strong");
		By cartIcon = By.xpath("//a[@id='cart-link']");
		By cartTotal = By.xpath("//p[@id='Cart__Total']");
		
		//Home page
		driver.findElement(announcement).click();
		driver.findElement(cookiesAccept).click();
		Assert.assertEquals(driver.getTitle(), "Skin Care & Beauty Products | 100% Cruelty-Free | Bliss – Bliss World Store");
		//Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		//driver.switchTo().alert();
		//alert.dismiss();
//		String parent = driver.getWindowHandle();
//		Set<String> popups = driver.getWindowHandles();
//		Iterator it = popups.iterator();
//		while(it.hasNext()) {
//			String popup = it.next().toString();
//			if(!popup.equals(parent)) {
//				driver.switchTo().window(popup);
//				driver.close();
//				driver.switchTo().window(parent);
//			}
//		}
		new Actions(driver).moveToElement(driver.findElement(essentialsKit)).perform();
		driver.findElement(essentialsKit).click();
		
		//Product page
		driver.findElement(announcement).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.blissworld.com/products/the-essentials-kit");
		Assert.assertEquals(driver.getTitle(), "The Essentials Kit – Bliss World Store");
		Assert.assertEquals(driver.findElement(productPrice).getText(), "$39.00");
		driver.findElement(addToCart).click();
		//Checkout slideout
		driver.findElement(checkoutBtn).click();
		
		//Checkout page
		Assert.assertEquals(driver.getTitle(),"Checkout - Bliss World Store");
		Assert.assertEquals(driver.findElement(checkoutPrice).getText(), "$39.00");
		driver.findElement(cartIcon).click();
		
		//Cart page
		driver.findElement(announcement).click();
		Assert.assertEquals(driver.getTitle(),"Your Shopping Cart – Bliss World Store");
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.blissworld.com/cart");
		Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "CART");
		new Actions(driver).moveToElement(driver.findElement(cartTotal)).perform();
		Assert.assertEquals(driver.findElement(cartTotal).getText(), "Total: $39.00");
	}
}
