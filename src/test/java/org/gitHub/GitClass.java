package org.gitHub;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GitClass { 
	public static WebDriver driver;
	@Test
	public  void test1() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https:/www.ajio.com/");
	}
	@Test
	public void test2() {
		WebElement search = driver.findElement(By.xpath("//a[@title='MEN']"));
		search.click();
	}
	@Test
	public void test3() {
		driver.close();


	}
}

