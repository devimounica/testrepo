package Academy.pageobjects;

import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Academy.AbstractComponenets.AbstractComponents;

public class Cartpage extends AbstractComponents{
	
	WebDriver driver;
	public Cartpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		
	}
	@FindBy(css=".cart h3")
	private List<WebElement> cartproducts;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutele;

	
	public Stream<WebElement> verifyproductDisplay(String productname)
	{
   Stream<WebElement> Match=cartproducts.stream().filter(cartproduct-> cartproduct.getText().equalsIgnoreCase(productname));
    return Match;
	}

	public ChechkoutPage goToCheckoutpage()
	{
		checkoutele.click();
		ChechkoutPage ChechkoutPage=new ChechkoutPage(driver);
		return ChechkoutPage;
	}
}
