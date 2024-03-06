package SeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowseFile {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Ashok\\eclipse\\workspace\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://ufile.io/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='dz-message needsclick']")).sendKeys("C:\\Users\\navee\\OneDrive\\Desktop\\REST API Automation\\Week1Day1\\Create_incident_data_file");
}
}