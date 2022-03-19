package test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import pages.HomePage;
import pages.InventoryPage;
import pages.LoginPage;
import pages.Util;

public class Order {
	/**
     * 
     * @author Ngoc Vu
     *   ************** 
     *  1. Login to web application
		2. Navigate to `Inventory` feature
		3. From the top-menu bar, select `Products -> Products` item, then create a new
		product
		4. Update the quantity of new product is more than 10
		5. From top-left page, click on `Application` icon
		6. Navigate to `Manufacturing` feature, then create a new Manufacturing Order item
		for the created Product on step #3
		7. Update the status of new Orders to “Done” successfully
		8. Validate the new Manufacturing Order is created with corrected information.
     *     
     */		
	static WebDriver driver = null;
	
	@BeforeTest
	public static void setUpTest() {
		System.setProperty("webdriver.chrome.driver", Util.PROJECT_PATH + "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts()
		.implicitlyWait(Util.WAIT_TIME, TimeUnit.SECONDS);
		driver.get(Util.BASE_URL);
		driver.manage().window().maximize();
	}
	
	@Test
	public static void order() {
		
		LoginPage loginOjb = new LoginPage(driver);
		HomePage homePage = loginOjb.login(Util.USER_NAME, Util.PASSWD);
		if (homePage.isDisplayed()) {
            System.out.println("Login Successfully!");
            InventoryPage in = homePage.clickInventory();
            if (in.isDisplayed()) {
            	in.createProduct();
            }
        } else {
            System.out.println("Login Fail!");
        }
	}

	@AfterTest
	public static void tearDownTest() {
		driver.quit();
	}
}
