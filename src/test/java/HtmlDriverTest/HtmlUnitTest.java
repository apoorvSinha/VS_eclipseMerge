package HtmlDriverTest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

@SuppressWarnings("unused")
public class HtmlUnitTest {
	@Test
	public void sampleTest() {
		HtmlUnitDriver driver = new HtmlUnitDriver();
		driver.get("https://www.google.co.in/");
		driver.findElement(By.name("q")).sendKeys("something special");
		driver.findElement(By.name("q")).submit();
		System.out.println("Page title is: "+driver.getTitle());
	}
}
