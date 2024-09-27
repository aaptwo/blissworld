package aparikh.blissworld.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aparikh.blissworld.abstractcomponents.AbstractComponent;

public class ProductPage extends AbstractComponent {
	WebDriver driver;

	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By addToCart = By.xpath("//div[@class='add_to_bag_btn add_to_bag_btn_atc custom-select']");
	By checkoutBtn = By.xpath("//button[@class='rebuy-button rebuy-cart__checkout-button block']");
	
	@FindBy(xpath = "//div[@class='add_to_bag_btn add_to_bag_btn_atc custom-select']") 
	WebElement addToCart2;
	
	@FindBy(xpath = "//button[@class='rebuy-button rebuy-cart__checkout-button block']")
	WebElement checkoutBtn2;
	
	public void clickAddToCart() {
		//driver.findElement(addToCart).click();
		addToCart2.click();
	}
	
	public void clickCheckoutBtn() {
		//driver.findElement(checkoutBtn).click();
		checkoutBtn2.click();
	}
}
