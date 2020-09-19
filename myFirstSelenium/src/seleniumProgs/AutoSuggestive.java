package seleniumProgs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class AutoSuggestive {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\USHA\\Desktop\\MyWork\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		//driver.get("https://google.com");
	//	driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys("hyd");
		//WebElement we = driver.findElement(By.id("fromCity"));
		//we.sendKeys("Hyderabad");
		//we.sendKeys(Keys.ARROW_DOWN,Keys.TAB);
		//driver.findElement(By.xpath("//input[@id='toCity']")).click();

		/*
		 * WebElement we = driver.findElement(By.xpath("//input[@name='q']"));
		 * we.sendKeys("Testing"); we.sendKeys(Keys.ARROW_DOWN);
		 * we.sendKeys(Keys.ENTER);
		 */
	//we.click();
	//we.sendKeys(Keys.ENTER);
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys("del");		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		List<WebElement> suggestions = driver.findElements(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']//div[@class='pushRight font14 lightGreyText latoBold'][contains(text(),'DEL')]"));
		
		for (WebElement suggest : suggestions) {
			if (suggest.getText().equalsIgnoreCase("delhi, India"));{
				suggest.click();
			}
			
		}
		
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("che");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		 List<WebElement> suggestions1 = driver.findElements(By.xpath("//p[contains(text(),'Chennai, India')]"));
		
		for (WebElement sugg : suggestions1) {
			System.out.println(sugg.getText().equalsIgnoreCase("che"));
			sugg.click();
		}
		driver.close();
	}


}
