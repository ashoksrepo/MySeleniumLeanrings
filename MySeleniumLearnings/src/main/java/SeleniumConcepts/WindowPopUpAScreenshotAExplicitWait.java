package SeleniumConcepts;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowPopUpAScreenshotAExplicitWait {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Ashok\\eclipse\\workspace\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://www.spicejet.com/");
//		clickOn(driver, driver.findElement(By.xpath("name")), 20);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'SpiceClub')]"))).build().perform();
		driver.findElement(By.xpath("//div[contains(text(),'Our Program')]")).click();
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it =handler.iterator();
		Thread.sleep(5000);
		String parentWindowId = it.next();
		System.out.println(parentWindowId);
		Thread.sleep(5000);
		String childWindowId = it.next();
		System.out.println(childWindowId);
		Thread.sleep(5000);
		driver.switchTo().window(childWindowId);
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:\\Ashok\\screenshots\\spicejet.png"));
		
		driver.close();
		
		

	}

//	public static void clickOn(WebDriver driver, WebElement locator,int timeout) {
//		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
//		locator.click();
//	}

}
