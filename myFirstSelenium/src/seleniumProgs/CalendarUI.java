package seleniumProgs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarUI {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\USHA\\Desktop\\MyWork\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
		
		// to select month
		driver.findElement(By.id("travel_date")).click();
		while (!driver.findElement(By.xpath("//div[@class='datepicker-days'] //th[@class='datepicker-switch']")).getText().contains("July"))
		{
			driver.findElement(By.xpath("//div[@class='datepicker-days'] //th[@class='next']")).click();
		}
		
		// to select date as august 23 
		// taking all dates into one list
		
		//List<WebElement> dates= driver.findElements(By.className("day"));
		
		int count = driver.findElements(By.className("day")).size();
		for (int i=0;i<count;i++)
		{
		//	String text = driver.findElements(By.cssSelector("td[class='old day']")).get(i).getText();
		//	System.out.println(text);
			String text1 = driver.findElements(By.className("day")).get(i).getText();
			
			if(text1.equalsIgnoreCase("10")) 
			{
				
				driver.findElements(By.className("day")).get(i).click();
				break;
				
			}
		}
	}

}
