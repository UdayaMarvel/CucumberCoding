package project.repositary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import project.resource.CommonActions;

public class ProductPurchasePage extends CommonActions{
	public ProductPurchasePage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[@id='onetrust-reject-link']")
	private WebElement rejectCookies;
		
	@FindBy(xpath = "//span[@data-base64='L3NwaWVsemV1Zy1zcGllbGUv']")
	private WebElement moduleToys;
	
	@FindBy(xpath = "//div[@class='fl w20 pa3'][1]")
	private WebElement scrollUpToElement;
	
	@FindBy(xpath = "//a[@class='prod-tile__link js-prodlink'][1]")
	private WebElement product;
	
	@FindBy(xpath = "//button[@data-base64='L2NoZWNrb3V0L2FkZFRvQmFza2V0LzE0MzYzMTIx']")
	private WebElement addToCart;

	public WebElement getRejectCookies() {
		return rejectCookies;
	}

	public WebElement getModuleToys() {
		return moduleToys;
	}

	public WebElement getScrollUpToElement() {
		return scrollUpToElement;
	}

	public WebElement getProduct() {
		return product;
	}

	public WebElement getAddToCart() {
		return addToCart;
	}

	}

