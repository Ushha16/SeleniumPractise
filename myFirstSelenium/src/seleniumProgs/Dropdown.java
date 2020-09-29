package seleniumProgs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\USHA\\Desktop\\MyWork\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("going to ping url");
		driver.get("https://www.spicejet.com/");
		Thread.sleep(3000L);
		driver.manage().window().maximize();
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000L);
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_Adult']")).click();
		Select s = new Select(driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_Adult']")));
		s.selectByValue("2");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_Child']")).click();
		Select s1 = new Select(driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_Child']")));
		s1.selectByValue("2");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_Infant']")).click();
		Select s2 = new Select(driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_Infant']")));
		s2.selectByIndex(1);
		Thread.sleep(2000L);
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		driver.close();

	}

}
