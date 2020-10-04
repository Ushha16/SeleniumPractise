package seleniumProgs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownAutoSuggestive {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\USHA\\Desktop\\MyWork\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.apsrtconline.in/oprs-web/");
	//	driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	
		driver.findElement(By.id("fromPlaceName")).sendKeys("chir");
		Thread.sleep(3000L);
		driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);
		
		
		//JavaScript DOM can extract hidden elements
		//because selenium can not identify hidden elements - (Ajax implementation)
		//investigate the properties of object if it has any hidden text
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		String fromplace= "return document.getElementById(\"fromPlaceName\").value;";
		String text=(String) js.executeScript(fromplace);
		System.out.println(text);
		
		int i=0;
		 while(!text.equalsIgnoreCase("CHIrala"))
		 {
			 i++;
			 driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);
			 text=(String) js.executeScript(fromplace);	
			 System.out.println(text);
			 
			 if(i>10)
			 {
				 break;
			 }
		 }
		
		 if(i>10)
		 {
			 System.out.println("Element Not Found");
		 }
		 else
		 {
			 System.out.println("Element Found");
		 }
	}

}
