package aparikh.blissworld.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aparikh.blissworld.abstractcomponents.BaseComponent;

public class CartPage extends BaseComponent {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By cartTotal = By.xpath("//p[@id='Cart__Total']");
	
	@FindBy(xpath = "//p[@id='Cart__Total']")
	WebElement cartTotal2;
	
	public String getCartTotal() {
		new Actions(driver).moveToElement(driver.findElement(cartTotal)).perform();
		//String total = driver.findElement(cartTotal).getText();
		String total = cartTotal2.getText();
		return total;
	}
}
