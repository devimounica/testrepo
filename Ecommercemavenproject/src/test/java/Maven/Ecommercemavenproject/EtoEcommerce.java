package Maven.Ecommercemavenproject;

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

public class EtoEcommerce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
	String productname="ZARA COAT 3";
		
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://rahulshettyacademy.com/client");
			driver.findElement(By.id("userEmail")).sendKeys("devimounica99@gmail.com");
	        driver.findElement(By.id("userPassword")).sendKeys("Mounikaa@99");
	        driver.findElement(By.id("login")).click();
	        
	        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	        
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-lg-4")));		
	        List<WebElement> products=driver.findElements(By.cssSelector(".col-lg-4"));
	        
	        /*for(int i=0;i<products.size();i++)
	        {
	        	String prod=products.get(i).getText();
	        	if(prod.contains("ZARA COAT 3"))
	        	{
	        		driver.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	        	}
	        		
	        } oR*/
	        
	 WebElement prod= products.stream().filter(product->  product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
	        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	        	wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	        	driver.findElement(By.cssSelector("[routerlink*='cart']")).click();	
	        	List<WebElement> cartproducts=driver.findElements(By.cssSelector(".cart h3"));
	        	Stream<WebElement> Match=cartproducts.stream().filter(cartproduct-> cartproduct.getText().equalsIgnoreCase("ZARA COAT 3"));
	       //Assert.assertEquals(Match, "ZARA COAT 3");
	        	driver.findElement(By.xpath("//*[text()='Checkout']")).click();
	       Actions a=new Actions(driver);
	       a.sendKeys(driver.findElement(By.cssSelector("*[placeholder='Select Country']")), "india").build().perform();
	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	       driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
	       JavascriptExecutor js = (JavascriptExecutor) driver;
	       js.executeScript("window.scrollBy(0,1000)");
	       driver.findElement(By.xpath("//*[text()='Place Order ']")).click();
	       String confirmmsg=driver.findElement(By.cssSelector(".hero-primary")).getText();
	       confirmmsg.equalsIgnoreCase("THANKYOU FOR THE ORDER.");
	       Assert.assertEquals(confirmmsg, "THANKYOU FOR THE ORDER.");
	       }
		}
		


