package SeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EbayRegistration {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Ashok\\eclipse\\workspace\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://signup.ebay.com/pa/crte?ru=https%3A%2F%2Fwww.ebay.com%2F");
		driver.manage().window().maximize();
	driver.manage().wait(10000);
	WebElement checkbox = driver.findElement(By.id("personalaccount-radio"));
	 try {
         checkbox.wait(5000);
     } catch (InterruptedException e) {
         e.printStackTrace();
     }
		driver.findElement(By.id("personalaccount-radio")).click();
		driver.findElement(By.id("firstname")).sendKeys("Ashok");
		driver.findElement(By.name("lastname")).sendKeys("K");
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("abc123@gmail.com");
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("Ashok@123");
		driver.findElement(By.xpath("//input[@id='showpassword']")).click();
		driver.findElement(By.xpath("//button[@id='EMAIL_REG_FORM_SUBMIT']")).click();
		
		
		
		
		
		
			

	}

}
