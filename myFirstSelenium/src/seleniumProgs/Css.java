package seleniumProgs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Css {

	public static void main(String[] args) {
		
		// xpath = //tagName[@attribute='value']
		//css = tagName[attribute='value'] (or) [attribute='value']
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\USHA\\Desktop\\MyWork\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://login.salesforce.com/?locale=in");//hit url on the browser
	//	driver.findElement(By.cssSelector("input[id='username']")).sendKeys("Myowncss");
		driver.findElement(By.cssSelector("[class='input r4 wide mb16 mt8 username']")).sendKeys("MyOwnCss");

	}

}
