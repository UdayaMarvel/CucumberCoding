package org.gitHub;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GitClass {                                                                                                                                                                                                                                                           

		public static WebDriver driver;
		@BeforeClass
		public static void test1() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://www.flipkart.com");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		}

		@AfterClass
		public static void Close() {
			driver.close();
		}
		static long startTime;
		@Before
		public void startTime() {
			startTime = System.currentTimeMillis();
		}
		@After
		public void endTime() {
			long endTime = System.currentTimeMillis();
			System.out.println("Total Duration Taken ="+(endTime-startTime));
		}
	}

