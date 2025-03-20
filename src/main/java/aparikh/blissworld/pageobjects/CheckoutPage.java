package aparikh.blissworld.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aparikh.blissworld.abstractcomponents.BaseComponent;

public class CheckoutPage extends BaseComponent {
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By checkoutPrice = By.xpath("//div[@role='row']//div[@role='cell']//strong");
	By cartIcon = By.xpath("//a[@id='cart-link']");
	
	@FindBy(xpath = "//div[@role='row']//div[@role='cell']//strong")
	WebElement checkoutPrice2;
	
	@FindBy(xpath = "//a[@id='cart-link']")
	WebElement cartIcon2;
	
	public String getCheckoutPrice() {
		//String price = driver.findElement(checkoutPrice).getText();
		String price = checkoutPrice2.getText();
		return price;
	}
	
	public void clickCartIcon() {
		//driver.findElement(cartIcon).click();
		cartIcon2.click();
	}
	
}
