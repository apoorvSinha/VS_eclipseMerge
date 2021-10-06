package GooglePageTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
@SuppressWarnings("unused")


public class LoginGmailCrossBrowser {
	WebDriver driver;
	
	
	@BeforeTest
	public void OpenBrowser() {
		WebDriverManager.chromedriver().setup();
		WebDriverManager.edgedriver().setup();
//		driver = new EdgeDriver();
		driver = new ChromeDriver();
	}

	@Test
	public void Login() {
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Best browser to use");
		driver.close();
	}
	
	@Test
	public void PrintAllSuggestions() throws InterruptedException {
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Best browser to use");
		Thread.sleep(4000);
		List<WebElement> results =driver.findElements(By.xpath("//ul[@role='listbox']/li/descendant::div[@class='wM6W7d']"));
		System.out.println("Number of results are : "+ results.size());
		int i =1;
		for(WebElement result: results) {
			System.out.println("Result number "+i+" is :"+ result.getText());
			i++;
		}
		driver.close();
	}
	
	@Test
	public void ClickResult() throws InterruptedException {
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Best browser to use");
		Thread.sleep(4000);
		List<WebElement> results =driver.findElements(By.xpath("//ul[@role='listbox']/li/descendant::div[@class='wM6W7d']"));
		System.out.println("Number of results are : "+ results.size());
		System.out.println("The last search result is : "+ results.get(results.size()-1).getText());
		driver.close();
	}
	
	
	@AfterTest
	public void TearDown() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();
	}

}
