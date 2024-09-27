package aparikh.blissworld.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import aparikh.blissworld.pageobjects.CartPage;
import aparikh.blissworld.pageobjects.CheckoutPage;
import aparikh.blissworld.pageobjects.HomePage;
import aparikh.blissworld.pageobjects.ProductPage;
import aparikh.blissworld.testcomponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest {
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.blissworld.com/");
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	@Test
	public void testEndToEnd() {
		HomePage hp = new HomePage(driver);
		hp.dismissCookieAccept();
		hp.clickAnnouncement();
		hp.clickStarterKit();
		
		ProductPage pp = new ProductPage(driver);
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.blissworld.com/products/skin-bliss-starter-kit");
		pp.clickAnnouncement();
		pp.clickAddToCart();
		pp.clickCheckoutBtn();
		
		CheckoutPage cp = new CheckoutPage(driver);
		Assert.assertEquals(driver.getTitle(),"Checkout - Bliss World Store");
		String checkoutPrice = cp.getCheckoutPrice();
		Assert.assertEquals(checkoutPrice, "$55.00");
		cp.clickCartIcon();
		
		CartPage cart = new CartPage(driver);
		cart.clickAnnouncement();
		Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "CART");
		String cartTotal = cart.getCartTotal();
		Assert.assertEquals(cartTotal, "Total: $55.00");
		
	}

	
	
}
