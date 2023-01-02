package Academy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Academy.AbstractComponenets.AbstractComponents;

public class ConfirmationPage extends AbstractComponents {
	
	WebDriver driver;
	ConfirmationPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".hero-primary")
	WebElement Confirmationmsg;
	
	public String getConfirmationmsg()
	{
		return Confirmationmsg.getText();
	}
}
