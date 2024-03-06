
package SpiceJetTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BookHotel {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Ashok\\eclipse\\workspace\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.spicejet.com/");
		System.out.println("driver.getTitle()");
//
//		Select currency = new Select(driver.findElement(By.xpath("//div[text()='Currency']")));
//		currency.selectByValue("AED");
			
			
			
			
			Actions selectcurrency = new Actions(driver);
		selectcurrency.moveToElement(driver.findElement(By.xpath("//div[text()='Currency']"))).click().build()
				.perform();
		driver.findElement(By.xpath("//div[text()='AED']")).click();
//		driver.findElement(By.xpath("//div[text()='Currency']")).click();
//		driver.findElement(By.xpath("//div[text()='AED']")).click();
		Thread.sleep(5000);
		Actions spiceclub = new Actions(driver);
		spiceclub.moveToElement(driver.findElement(By.xpath("//div[text()='SpiceClub']"))).build().perform();
		driver.findElement(By.xpath("//div[text()='Our Program']")).click();
		Set<String> windows = driver.getWindowHandles();
		String currentwindow = windows.iterator().next();
		System.out.println(currentwindow);
		windows.remove(windows.iterator().next());
		String nextwindow = windows.iterator().next();
		System.out.println(nextwindow);
		driver.switchTo().window(nextwindow);
		Thread.sleep(5000);
		driver.switchTo().window(currentwindow);

	}

}
