package aparikh.blissworld.tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import aparikh.blissworld.pageobjects.CartPage;
import aparikh.blissworld.pageobjects.CheckoutPage;
import aparikh.blissworld.pageobjects.HomePage;
import aparikh.blissworld.pageobjects.ProductPage;
import aparikh.blissworld.testcomponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTest {
	//WebDriver driver;
	
	@BeforeTest
	public void setup() throws IOException {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().window().maximize();
		driver = initializeDriver();
		driver.get("https://www.blissworld.com/");
	}
	
	//@Test
	public void testEndToEnd() {
		HomePage hp = new HomePage(driver);
		hp.dismissCookieAccept();
		hp.clickAnnouncement();
		Assert.assertEquals(driver.getTitle(), "Skin Care & Beauty Products | 100% Cruelty-Free | Bliss – Bliss World Store");
		//hp.clickStarterKit();
		hp.clickEssentialsKit();
		
		ProductPage pp = new ProductPage(driver);
		pp.clickAnnouncement();
		//Assert.assertEquals(driver.getCurrentUrl(), "https://www.blissworld.com/products/skin-bliss-starter-kit");
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.blissworld.com/products/the-essentials-kit");
		Assert.assertEquals(driver.getTitle(), "The Essentials Kit – Bliss World Store");
		Assert.assertEquals(pp.getProductPrice(), "$39.00");
		pp.clickAddToCart();
		pp.clickCheckoutBtn();
		
		CheckoutPage cp = new CheckoutPage(driver);
		Assert.assertEquals(driver.getTitle(),"Checkout - Bliss World Store");
		String checkoutPrice = cp.getCheckoutPrice();
		Assert.assertEquals(checkoutPrice, "$39.00");
		cp.clickCartIcon();
		
		CartPage cart = new CartPage(driver);
		cart.clickAnnouncement();
		Assert.assertEquals(driver.getTitle(),"Your Shopping Cart – Bliss World Store");
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.blissworld.com/cart");
		Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "CART");
		String cartTotal = cart.getCartTotal();
		Assert.assertEquals(cartTotal, "Total: $39.00");
		
	}

	@Test
	public void homePageTest() {
		HomePage hp = new HomePage(driver);
		hp.dismissCookieAccept();
		hp.clickAnnouncement();
		Assert.assertEquals(driver.getTitle(), "Skin Care & Beauty Products | 100% Cruelty-Free | Bliss – Bliss World Store");
		//hp.clickStarterKit();
		hp.clickEssentialsKit();
	}
	
	@Test(dependsOnMethods = "homePageTest")
	public void productPageTest() {
		ProductPage pp = new ProductPage(driver);
		pp.clickAnnouncement();
		//Assert.assertEquals(driver.getCurrentUrl(), "https://www.blissworld.com/products/skin-bliss-starter-kit");
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.blissworld.com/products/the-essentials-kit");
		Assert.assertEquals(driver.getTitle(), "The Essentials Kit – Bliss World Store");
		Assert.assertEquals(pp.getProductPrice(), "$39.00");
		pp.clickAddToCart();
		pp.clickCheckoutBtn();
	}
	
	@Test(dependsOnMethods = "productPageTest")
	public void checkoutPageTest() {
		CheckoutPage cp = new CheckoutPage(driver);
		Assert.assertEquals(driver.getTitle(),"Checkout - Bliss World Store");
		String checkoutPrice = cp.getCheckoutPrice();
		Assert.assertEquals(checkoutPrice, "$39.00");
		cp.clickCartIcon();
	}
	
	@Test(dependsOnMethods = "checkoutPageTest")
	public void cartPageTest() {
		CartPage cart = new CartPage(driver);
		cart.clickAnnouncement();
		Assert.assertEquals(driver.getTitle(),"Your Shopping Cart – Bliss World Store");
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.blissworld.com/cart");
		//Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "CART");
		String cartTotal = cart.getCartTotal();
		Assert.assertEquals(cartTotal, "Total: $39.00");
	}
	
	
	//add comment
	//add comment 2
	//add comment 3
	//@AfterTest
	//public void teardown() {
		//driver.quit();
	//}
	
	
}
