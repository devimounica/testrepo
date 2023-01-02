package Academy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Academy.AbstractComponenets.AbstractComponents;

public class ChechkoutPage extends AbstractComponents {
	
	
	WebDriver driver;
	ChechkoutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	By waitresults=By.cssSelector(".ta-results");
	
	@FindBy(css="*[placeholder='Select Country']")
			WebElement country;
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement selectcountry;
	@FindBy(xpath="//*[text()='Place Order ']")
	WebElement submit;
	
	public void selectcountry(String countryname )
	{
		 Actions a=new Actions(driver);
		 a.sendKeys(country, countryname).build().perform();
		 waiforelementtoappear(waitresults);
		 selectcountry.click();
		 
	}
	public ConfirmationPage submitorder()
	{
		submit.click();
		ConfirmationPage ConfirmationPage=new ConfirmationPage(driver);
		return ConfirmationPage;
	}
}






