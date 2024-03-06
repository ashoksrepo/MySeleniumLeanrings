package SeleniumConcepts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

public class ConfigurePropertiesAndHtmlUnitDriver {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Ashok\\eclipse\\workspace\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
//		WebDriver driver = new HtmlUnitDriver();
		

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://www.facebook.com/");
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("Create new account")).click();
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("D:\\Ashok\\MySeleniumLearnings\\src\\main\\java\\TestGmail//config.properties");
		prop.load(ip);
		driver.findElement(By.xpath("//input[@name ='firstname']")).sendKeys(prop.getProperty("firstname"));
		driver.findElement(By.xpath("//input[@name ='lastname']")).sendKeys(prop.getProperty("lastname"));
		driver.findElement(By.xpath("//div[text()='Mobile number or email address']//following-sibling::input")).sendKeys(prop.getProperty("email"));
		driver.findElement(By.xpath("//div[text()='Re-enter email address']//following-sibling::input")).sendKeys(prop.getProperty("email"));
		driver.findElement(By.xpath("//div[text()='New password']//following-sibling::input")).sendKeys("Test@123");
		Select date = new Select(driver.findElement(By.xpath("//select[@id='day']")));
		date.selectByVisibleText("12");
		Select month = new Select(driver.findElement(By.xpath("//select[@id='month']")));
		month.selectByVisibleText("Feb");
		Select year = new Select(driver.findElement(By.xpath("//select[@id='year']")));
		year.selectByVisibleText("1905");
		driver.findElement(By.xpath("//label[text()='Female']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();
		System.out.println(driver.getCurrentUrl());
		
		
		
		

	}

}
