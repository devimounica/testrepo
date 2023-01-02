package Crossbrowser;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class GoogleTest {
	
	@Test
	public void Homepagecheck() throws MalformedURLException
	
	{
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setBrowserName("chrome");
		//caps.setPlatform(Platform.WIN10);
		///caps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		//caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		
		WebDriver driver=new RemoteWebDriver(new URL("http://192.168.29.43:4444"),caps);  //1st time
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("devimounica");
		driver.close();
		
		
		
		
		
		
		
	}

}
