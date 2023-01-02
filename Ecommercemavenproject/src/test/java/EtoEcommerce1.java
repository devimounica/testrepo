

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Academy.pageobjects.Cartpage;
import Academy.pageobjects.ChechkoutPage;
import Academy.pageobjects.ConfirmationPage;
import Academy.pageobjects.Landingpage;
import Academy.pageobjects.Productcatalogue;

public class EtoEcommerce1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String productname="ZARA COAT 3";
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.manage().window().maximize();
	    Landingpage landingpage=new Landingpage(driver);
	    landingpage.goTo();
	    Productcatalogue Productcatalogue=landingpage.loginapplication("devimounica99@gmail.com", "Mounikaa@99");
		Productcatalogue.addproducttocart(productname);
		Cartpage Cartpage=Productcatalogue.goToCartpage();
		Stream<WebElement> Match=Cartpage.verifyproductDisplay(productname);
     //   Assert.assertTrue(Match);
		ChechkoutPage ChechkoutPage=Cartpage.goToCheckoutpage();
		ChechkoutPage.selectcountry("india");
		ConfirmationPage ConfirmationPage=ChechkoutPage.submitorder();
		String confirmmsg=ConfirmationPage.getConfirmationmsg();
		   Assert.assertEquals(confirmmsg, "THANKYOU FOR THE ORDER.");
	       driver.close();
	       
		
	       }
		}
		


