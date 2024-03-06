package SeleniumConcepts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class LaunchBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * System.setProperty("webdriver.chrome.driver", "C:\Users\Ashok\eclipse\workspace\\chromedriver.exe");
		 * WebDriver driver = new ChromeDriver(); driver.get("https://www.google.com");
		 * System.out.println(driver.getTitle()); String title = driver.getTitle(); if
		 * (title.equals("Google")) { System.out.println("title is correct"); } else {
		 * System.out.println("title is in-correct"); } driver.quit();
		 */
		WebDriver driver = WebDriverManager.chromedriver().create();
		driver.get("https://www.facebook.com");
		System.out.println(driver.getTitle());
		
		
		
		

	}

}
