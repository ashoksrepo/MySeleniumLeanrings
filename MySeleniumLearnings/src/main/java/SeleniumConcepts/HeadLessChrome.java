package SeleniumConcepts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;

public class HeadLessChrome {
static WebDriver driver;
	public static void main(String[] args) throws IOException {
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\Ashok\\eclipse\\workspace\\MySeleniumLearnings\\src\\main\\java\\SeleniumConcepts//config.properties");
		prop.load(ip);
		String browser = prop.getProperty("browser");
		if (browser.equals("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
		driver = WebDriverManager.chromedriver().capabilities(options).create();
		} else  if(browser.equals("FF")){
			driver = WebDriverManager.firefoxdriver().create();
		}
		driver.get("https://www.youtube.com/");
		System.out.println(driver.getTitle());

	}

}
