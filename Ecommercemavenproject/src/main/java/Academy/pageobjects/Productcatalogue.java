package Academy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Academy.AbstractComponenets.AbstractComponents;

public class Productcatalogue extends AbstractComponents{
	
	WebDriver driver;
	
	public Productcatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//List<WebElement> products=driver.findElements(By.cssSelector(".col-lg-4"));
	
	@FindBy(css=".col-lg-4")
	List<WebElement> products;
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productsBy=By.cssSelector(".col-lg-4");
	By addtocart=By.cssSelector(".card-body button:last-of-type");
	By toastmsg=By.cssSelector("#toast-container");
	public  List<WebElement> getProductList()
	{
		waiforelementtoappear(productsBy);
		return products;
	}
	public WebElement getProductByName(String productname)
	{
		WebElement prod= getProductList().stream().filter(product-> 
		product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
		return prod;
	}
	public void addproducttocart(String productname)
	{
		getProductByName(productname).findElement(addtocart).click();
		waiforelementtoappear(toastmsg);
		waitforElementDisappear(spinner);
		
	}
	
}
