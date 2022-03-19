package test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.Util;

public class Login {
	static WebDriver driver = null;
	/**
     * 
     * @author Ngoc Vu
     *        ************** 
     *        This is for login
     *     
     */		
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
	public static void login() {
		
		LoginPage loginOjb = new LoginPage(driver);
		HomePage homePage = loginOjb.login(Util.USER_NAME, Util.PASSWD);
		if (homePage.isDisplayed()) {
            System.out.println("Login Successfully!");
            homePage.clickInventory();
        } else {
            System.out.println("Login Fail!");
        }
	}

	@AfterTest
	public static void tearDownTest() {
		driver.quit();
	}
}
