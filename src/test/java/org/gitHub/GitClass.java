package org.gitHub;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GitClass {
	public static String text2 = "";
	public static WebDriver driver;

	@BeforeClass
	public static void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Test
	public void test1() {
		driver.get("https://www.amazon.in/");

	}

	@Test
	public void test2() throws Throwable {
		Thread.sleep(3000);
		WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		search.sendKeys("Oneplus mobiles", Keys.ENTER);
	}

	@Test
	public void test4() throws Throwable {
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement mobile2 = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		mobile2.click();
		String parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		for (String s : child) {
			if (!parent.equals(s)) {
				driver.switchTo().window(s);
				WebElement mob2 = driver.findElement(By.xpath("//span[@id='productTitle']"));
				text2 = mob2.getText();
				System.out.println(text2);

			}

		}

	}

}
