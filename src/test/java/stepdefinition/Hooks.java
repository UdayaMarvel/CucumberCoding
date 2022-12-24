package stepdefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import project.resource.CommonActions;

public class Hooks extends CommonActions{
	CommonActions ca = new CommonActions();
	@Before
	public void beforeMethods() {
		System.out.println("browser launched");
	}
	
	@After
	public void browserClosed(Scenario scenario) {
		
		if (scenario.isFailed()) {
			final byte[] screenshotAs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshotAs, "image/png");
		}else {
			byte[] screenshotAs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshotAs, "image/png");
		}
//		driver.close();
//		driver.quit();
		System.out.println("Browser closed");
	}

}
