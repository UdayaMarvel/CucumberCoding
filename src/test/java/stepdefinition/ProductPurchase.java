package stepdefinition;


import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import project.repositary.ProductPurchasePage;
import project.resource.CommonActions;

public class ProductPurchase extends ProductPurchasePage{
	CommonActions ca = new CommonActions();
	ProductPurchasePage pom = new ProductPurchasePage();

@Given("user launch application")
public void user_launch_application() {
	try {
		ca.chromelaunch("https://mytoys.de/");
		Thread.sleep(5000);
		WebElement reject = driver.findElement(By.xpath("//span[@id='onetrust-reject-link']"));
		//WebElement rejectCookies = driver.findElement((By)pom.getRejectCookies());
		ca.click(reject);
		
		}catch(Exception e) {
			System.out.println(e);
		}
}

@When("user select product")
public void user_select_product() {
	try {
		Thread.sleep(2000);
	//WebElement toysModule = driver.findElement((By)pom.getModuleToys());
		WebElement toys = driver.findElement(By.xpath("//span[@data-base64='L3NwaWVsemV1Zy1zcGllbGUv']"));
    ca.moveToElement(toys);
    ca.click(toys);
	}catch(Exception e) {
		System.out.println(e);
	}
}

@When("user select single product")
public void user_select_single_product() {
	try {
		Thread.sleep(3000);
	 //  ca.scrolldown(getScrollUpToElement(), 1);
	WebElement srcollUp = driver.findElement(By.xpath("//div[@class='fl w20 pa3'][1]"));
	ca.scrollup(srcollUp, 0);
	
	ca.presenceOfElement(20, "//a[@class='prod-tile__link js-prodlink'][1]");
	//WebElement product = driver.findElement(By.xpath());
	}catch (Exception e) {
		System.out.println(e);
	}
	
}

@Then("user addToCart")
public void user_addToCart() throws InterruptedException {
	String parentWindow = driver.getWindowHandle();
	   Set<String> childWindow = driver.getWindowHandles();
	   for(String x : childWindow) {
		   if (!parentWindow.equals(x)) {
			   driver.switchTo().window(x);
		}
	   }
	   Thread.sleep(3000);
	   //WebElement addToCart = driver.findElement((By)pom.getAddToCart());
	   WebElement addToCart = driver.findElement(By.xpath("//button[@data-base64='L2NoZWNrb3V0L2FkZFRvQmFza2V0LzE0MzYzMTIx']"));
	   ca.click(addToCart);
	}
}


