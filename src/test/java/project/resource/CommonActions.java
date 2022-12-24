package project.resource;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonActions {
	public static WebDriver driver;
	public void chromelaunch(String url) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
		driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public void screenshot(String path) throws IOException {
		TakesScreenshot sc = (TakesScreenshot)driver;
		File source = sc.getScreenshotAs(OutputType.FILE);
		File destination = new File(path);
		FileUtils.copyFile(source, destination);
	}
	public void doubleClick(WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).build().perform();
	}
	public void click(WebElement element) {
		element.click();
	}
	public void rightClick() {
		Actions a = new Actions(driver);
		a.contextClick().build().perform();
	}
	public void dragAndDrop(WebElement element1,WebElement element2) {
		Actions a = new Actions(driver);
		a.dragAndDrop(element1, element2);
	}
	public void moveToElement(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).build().perform();
	}
	
	public void scrollup(WebElement element,int index) {
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments["+index+"].scrollIntoView(true)",element);
		}
	public void scrolldown(WebElement element,int index) {
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments["+index+"].scrollIntoView(false)",element);
			}
	//public static String rejectCookies = "//font[contains(text(),'reject cookies')]";
	
	public void presenceOfElement(long seconds,String Element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		WebElement until = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Element)));
		until.click();
	}
	
	
	
	
	
	
	
	
	
	
	
}
