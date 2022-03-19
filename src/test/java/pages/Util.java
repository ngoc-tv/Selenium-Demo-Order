package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Util {
public static final String PROJECT_PATH = System.getProperty("user.dir");
	
	public static final String BASE_URL = "https://aspireapp.odoo.com/web/login";
	
	public static final int WAIT_TIME = 30; 
	
	public static final String USER_NAME ="user@aspireapp.com";
	public static final String PASSWD ="@sp1r3app";
	
	public static boolean waitForElementDisplay(WebDriver driver, By by, 
            int waitInSecond) {
        for (int i = 0; i < waitInSecond / 2 + 1; i++) {
            try {
                if (driver.findElement(by).isDisplayed()) {
                    return true;
                }
                Thread.sleep(2 * 1000);
            } catch (Exception e) {
                System.out.println("waiting element for display...");
            }
        }
        return false;
    }
}
