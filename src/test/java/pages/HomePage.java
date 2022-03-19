package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;
	private static WebElement element = null;
	
	private static final String XPATH_INVENTORY = "//div[contains(text(),'Inventory')]";
	private By byInventory = By.xpath(XPATH_INVENTORY);
 
	@FindBy (xpath = XPATH_INVENTORY)
	WebElement inventory;

	@FindBy (xpath = "//div[contains(text(),'Manufacturing')]")
	WebElement manufacturing;
	
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
 
    public boolean isDisplayed() {
        if (Util.waitForElementDisplay(driver, byInventory, 10)) {
            return true;
        } else {
            return false;
        }
    }
    
    public InventoryPage clickInventory() {
    	inventory.click();
		// return Inventory page
        return new InventoryPage(this.driver);
    }
    
    public void clickManufacturing() {
		manufacturing.click();;
	}
}
