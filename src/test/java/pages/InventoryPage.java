package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {
	WebDriver driver;
	
	private By byInventory = By.xpath("//a[contains(text(),'Inventory')]"); 
	
	@FindBy (xpath = "//span[contains(text(),'Products')]")
	WebElement productMenu;
	
	@FindBy (xpath = "//a[contains(text(),'Products')]")
	WebElement productItem;
	
	@FindBy (xpath = "//button[contains(text(),'Create')]")
	WebElement btnCreateProduct;
	
	@FindBy (name = "name")
	WebElement productName;
	
	@FindBy (xpath = "//span[contains(text(),'Update Quantity')]")
	WebElement updateQuantity;
	
	@FindBy (css = ".btn.btn-primary.o_list_button_add") 
	WebElement btnCreateQuantity;
	// WebElement btnCreateQuantity = driver.findElement(By.cssSelector(".btn.btn-primary.o_list_button_add"));
	
	@FindBy (name = "inventory_quantity")
	WebElement txtInventoryQuantity;

	@FindBy (xpath = "//button[contains(text(),'Save')]")
	WebElement btnSave;
	
	
	
	public InventoryPage(WebDriver driver) {
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
	public void createProduct() {
		productMenu.click();
		productItem.click();
		btnCreateProduct.click();
		productName.sendKeys("CHEESE20");
		updateQuantity.click();
		btnCreateQuantity.click();
		// TODO btnCreateQuantity.click() returns a new page
		txtInventoryQuantity.click();
		txtInventoryQuantity.sendKeys("12");
		btnSave.click();
	}
}
