package SeleniumConcepts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FacebookLogin {
	
		public static void main(String[] args) throws IOException {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\Ashok\\eclipse\\workspace\\msedgedriver.exe");
			WebDriver driver = new EdgeDriver();

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();

			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			driver.get("https://www.facebook.com/login.php/");
			System.out.println("driver.getTitle()");
			Properties prop = new Properties();
			FileInputStream fi = new FileInputStream("C:\\Users\\Ashok\\eclipse\\workspace\\MySeleniumLearnings\\src\\main\\java\\TestGmail\\config.properties");
			prop.load(fi);
			driver.findElement(By.name("email")).sendKeys(prop.getProperty("email"));
			

	}

}
