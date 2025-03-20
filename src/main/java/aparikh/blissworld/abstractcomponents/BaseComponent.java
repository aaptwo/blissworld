package aparikh.blissworld.abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseComponent {
	WebDriver driver;
	
	public BaseComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	By announcement = By.xpath("//section[@id='section-announcement']//div[@class='AnnouncementBar__Close']");
	
	public void clickAnnouncement() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(announcement));
		driver.findElement(announcement).click();
	}
}
