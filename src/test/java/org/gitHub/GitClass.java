package org.gitHub;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GitClass {                                                                                                                                                                                                                                                           
	
	static WebDriver driv;
	static String mobile3inner = "";
	static String mobile3outer = "";

	@Test
	public void test1() {

		WebDriverManager.chromedriver().setup();
		driv = new ChromeDriver();
		driv.manage().window().maximize();
		driv.get("https://www.flipkart.com");
	}

	 @Test
	public void test2() {
		WebElement user = driv.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']"));
		user.sendKeys("mani@gmail.com");
		WebElement pass = driv.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']"));
		pass.sendKeys("123454");
		WebElement login = driv.findElement(By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']"));
		login.click();
		driv.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
	}

	@Test
	public void test3() {
		driv.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		WebElement search = driv.findElement(By.xpath("//input[@name='q']"));
		search.sendKeys("mobiles", Keys.ENTER);

	}

	
	@Test
	public void test4() {

		driv.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		List<WebElement> mobilenames = driv.findElements(By.xpath("//*[@class='_4rR01T']"));

		File f = new File("C:\\Users\\Administrator\\Desktop\\mobilenamelist.xlsx");
		Workbook w = new XSSFWorkbook();
		Sheet s = w.createSheet("sheet1");
		for (int i = 0; i < mobilenames.size(); i++) {
			WebElement singlemobile = mobilenames.get(i);
			String text = singlemobile.getText();
			Row r = s.createRow(i);
			Cell c = r.createCell(0);
			c.setCellValue(text);
		}
		FileOutputStream out;
		try {
			out = new FileOutputStream(f);
			w.write(out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	@Test
	public void test5() throws Throwable {

	//	driv.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement mobile3 = driv.findElement(By.xpath("(//div[@class='col col-7-12'])[3]"));
		mobile3.click();
		String parent = driv.getWindowHandle();
		Set<String> childs = driv.getWindowHandles();
		for (String x : childs) {
			if (!parent.equals(x)) {
				driv.switchTo().window(x);
				WebElement mobin = driv.findElement(By.xpath("//span[@class='B_NuCI']"));
				 mobile3inner = mobin.getText();
			}

		}
		FileWriter mobile3name = new FileWriter("C:\\Users\\Administrator\\Desktop\\mobile3name.txt");
		mobile3name.write(mobile3inner);
		mobile3name.close();
		
	}


}

