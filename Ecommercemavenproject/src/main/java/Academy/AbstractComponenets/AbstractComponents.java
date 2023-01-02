package Academy.AbstractComponenets;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Academy.pageobjects.Cartpage;

public class AbstractComponents {

	WebDriver driver;
	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="[routerlink*='cart']")
	WebElement cartheader;
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	
	public void waiforelementtoappear(By findBy)
	{
      wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));		
}
	public void waitforElementDisappear(WebElement ele) 
	{
		// Thread.sleep(4000); or
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public Cartpage goToCartpage()
	{
		cartheader.click();
		Cartpage Cartpage=new Cartpage(driver);
		return Cartpage;	
	}
}

