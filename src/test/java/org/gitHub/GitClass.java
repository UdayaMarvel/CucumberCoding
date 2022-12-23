package org.gitHub;

import java.util.Set;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class GitClass {                                                                                                                                                                                                                                                           
	
	public static WebDriver driver;
	@Test
	public  void test1() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https:/www.snapdeal.com");
	}
	@Test
	public void test2() {
		WebElement search = driver.findElement(By.xpath("//input[@class='col-xs-20 searchformInput keyword']"));
		search.sendKeys("mens tshirt",Keys.ENTER);
		
	}
	@Test
	public void test3() {
		
		driver.findElement(By.xpath("(//a[@class='dp-widget-link noUdLine hashAdded'])[1]")).click();
		String parent = driver.getWindowHandle();
		Set<String> childs = driver.getWindowHandles();
		for (String x : childs) {
			if(!parent.equals(x)) {
				driver.switchTo().window(x);
				driver.findElement(By.xpath("//div[text()='M']")).click();
				driver.findElement(By.xpath("//span[text()='add to cart']")).click();
	}
	
		}
	}
	
	


}
