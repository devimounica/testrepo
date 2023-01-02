package Academy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Academy.AbstractComponenets.AbstractComponents;



public class Landingpage extends AbstractComponents{
	
	 WebDriver driver;
	
	 public Landingpage(WebDriver driver)  //this driver scope is inside this method only id comeoutof this methos scope willbe lost coz declared methos inside nly
	{
		 super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	 
	//WebElement useremail=driver.findElement(By.id("userEmail"));

	 @FindBy(id="userEmail")
	 WebElement userEmail;
	 
	 @FindBy(id="userPassword")
	 WebElement password;
	 
	 @FindBy(id="login")
	 WebElement submit;
	 

	public Productcatalogue loginapplication(String email, String passwordele) {
		// TODO Auto-generated method stub
		 userEmail.sendKeys(email);
		 password.sendKeys(passwordele);
		 submit.click();
		 Productcatalogue Productcatalogue=new Productcatalogue(driver);//after click on login imme it'll go to productcatalge page instead of creating object in test class we created itinside method
		 return Productcatalogue;
		
	}
	 
	 public void goTo()
	 {
		 driver.get("https://rahulshettyacademy.com/client");
	 }
	 
	 
	 
}
