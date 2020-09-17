package seleniumProgs;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddingItemstoCart {

	public static void main(String[] args) {
		
				
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\USHA\\Desktop\\MyWork\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait w = new WebDriverWait(driver, 5);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] veggies = { "Brocolli", "Cucumber", "Carrot" };
	//	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		addItems(driver,veggies);
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='promoCode']")));
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
//		WebDriverWait w = new WebDriverWait(driver, 5);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Code applied ..!')]")));
		System.out.println(driver.findElement(By.xpath("//span[contains(text(),'Code applied ..!')]")).getText());
	}
	
	public static void addItems(WebDriver driver,String[] veggies )
	{
		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector(".product-name"));
		for (int i = 0; i < products.size(); i++) {
			String[] items = products.get(i).getText().split("-");
			String formatteditem = items[0].trim();
			List itemsneeded = Arrays.asList(veggies);
			if (itemsneeded.contains(formatteditem)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == veggies.length) {
					break;
				}
			}
		}
	}
}
