package aparikh.blissworld.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import aparikh.blissworld.abstractcomponents.BaseComponent;

public class HomePage extends BaseComponent {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By cookiesAccept = By.xpath("//button[@aria-label='Accept']");
	//By starterKit = By.xpath("//a[@banner-id='Bliss Starter Kit PDP Tile']");
	By essentialsKit = By.xpath("//a[@banner-id='Essentials Kit PDP Tile']");
	
	@FindBy(xpath = "//button[@aria-label='Accept']")
	WebElement cookiesAccept2;
	
	//@FindBy(xpath = "//a[@banner-id='Bliss Starter Kit PDP Tile']" )
	//WebElement starterKit2;
	
	@FindBy(xpath = "//a[@banner-id='Essentials Kit PDP Tile']")
	WebElement essentialsKit2;
	
	public void dismissBanner() {
		
	}
	
	public void dismissCookieAccept() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(cookiesAccept));
		//driver.findElement(cookiesAccept).click();
		cookiesAccept2.click();
	}
	
	public void clickStarterKit() {
		//new Actions(driver).moveToElement(driver.findElement(starterKit)).perform();
		//driver.findElement(starterKit).click();
		//starterKit2.click();
	}
	
	public void clickEssentialsKit() {
		new Actions(driver).moveToElement(driver.findElement(essentialsKit)).perform();
		//driver.findElement(essentialsKit).click();
		essentialsKit2.click();
	}
}
