package PanCardApplication;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class NewPanCardforIndians {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Ashok\\eclipse\\workspace\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://tin.tin.nsdl.com/pan2");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		String parentwindow = it.next();
		System.out.println(parentwindow);
		String childwindow = it.next();
		System.out.println(childwindow);
		driver.switchTo().window(childwindow);
		Thread.sleep(5000);
		Actions action = new Actions(driver.switchTo().window(childwindow));
		action.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Please Select')]"))).click().build()
				.perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//li[contains(text(),'New PAN - Indian Citizen ')]")).click();
driver.findElement(By.xpath("//input[@name='dateOfBirth']")).sendKeys("13/02/1985");

//		String date = "13/2/1985";
//		driver.findElement(By.xpath("//input[@name='dateOfBirth']")).click();
//		Select yearsel = new Select(driver.findElement(By.xpath("//select[contains(@class,'yearselect')]")));
//		yearsel.selectByValue("1985");
//		Select monthsel = new Select(driver.findElement(By.xpath("//select[contains(@class,'monthselect')]")));
//		monthsel.selectByValue("3");
//		String split[] = date.split("/");
//		String date1 = split[0];
//		System.out.println(date1);
//		String month = split[1];
//		String year = split[2];
//
//Thread.sleep(5000);
//		String first = "//div//table//tbody//tr[";
//		String second = "]//td[";
//		int weekdays = 7;
//		boolean flag = false;
//		for (int row = 1; row <= 6; row++) {
//			for (int col = 1; col <= weekdays; col++) {
//				if (driver.findElement(By.xpath(first+row+second+col+"]")).getText().equals("date1")) {
//					driver.findElement(By.xpath(first+row+second+col+"]")).click();
//					flag = true;
//					break;
//
//				}
//			}
//			if (flag) {
//				break;
//			}
//		}

	}

}
