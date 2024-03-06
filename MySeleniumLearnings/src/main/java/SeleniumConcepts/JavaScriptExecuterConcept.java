package SeleniumConcepts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class JavaScriptExecuterConcept {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Ashok\\eclipse\\workspace\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://www.spicejet.com/");
		System.out.println(driver.getTitle());
		WebElement searchFilght = driver.findElement(By.xpath("//div[contains(text(),'Search Flight')]"));
		flash(searchFilght,driver); //Highlight the element
		WebElement exploreMore = driver.findElement(By.xpath("//div[contains(text(),'Explore More')]"));
		scrollIntoView(exploreMore,driver);
		
	}
	
	public static void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for(int i =1; i<100; i++) {
			changeColor("rgb(0,200,0)",element,driver);
			changeColor(bgcolor,element,driver);
		}
	}
		public static void changeColor(String color, WebElement element, WebDriver driver) {
			JavascriptExecutor js = ((JavascriptExecutor)driver);
			js.executeScript("arguments[0].style.backgroundColor = '"+color+"'", element);
			try {
				Thread.sleep(20);
			}catch(InterruptedException e) {
			}
			
	}
		
		public static void scrollIntoView(WebElement element, WebDriver driver) {
			JavascriptExecutor js = ((JavascriptExecutor)driver);
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			
		}

}
