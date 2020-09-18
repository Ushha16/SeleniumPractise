package seleniumProgs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\USHA\\Desktop\\MyWork\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
		
		
		Select s = new Select(driver.findElement(By.id("Adults")));
		s.selectByValue("2");
		
		Select s1 =new Select (driver.findElement(By.id("Childrens")));
		s1.selectByValue("2");
		
		driver.findElement(By.id("DepartDate")).click();
		driver.findElement(By.id("DepartDate")).sendKeys(Keys.ENTER);
	//	driver.findElement(By.cssSelector("ui-state-default.ui-state-highlight.ui-state-active")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.id("MoreOptionsLink")).click();
		Select s2 = new Select(driver.findElement(By.id("Class")));
		s2.selectByValue("Business");
		
		driver.findElement(By.id("AirlineAutocomplete")).sendKeys("SpiceJet (SG)");
		driver.findElement(By.id("SearchBtn")).click();
		
		System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());
		
		}
	

}
