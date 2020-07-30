package basicPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import libraries.Utility;

public class CheckboxDemo {

	public static void main(String[] args) throws InterruptedException, Exception {
		/*1. Open a chrome browser*/
		System.setProperty("webdriver.chrome.driver", "/home/vaibhav/Browser_Driver/chromedriver_linux64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		/*2. Navigate to the URL*/
		driver.navigate().to("https://www.seleniumeasy.com/test/");
		Utility.capturedScreenShot(driver, "Selenium Easy");
		
		/*3. Click on Start Session button*/
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("btn_basic_example"))).click();
		Utility.capturedScreenShot(driver, "startSession");
		
		/*4. Select checkbox demo form*/
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='list-group']//a[text()='Check Box Demo']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("isAgeSelected"))).click();
		
		
		/*5. Select two checkbox*/
		driver.findElement(By.xpath("//label[text()='Option 1']")).click();
		driver.findElement(By.xpath("//label[text()='Option 3']")).click();
		
		Utility.capturedScreenShot(driver, "select2Checkbox");
		
		/*6. Click on CheckAll button*/
		driver.findElement(By.xpath("//input[@id='check1']")).click();
		Thread.sleep(5000);
		Utility.capturedScreenShot(driver, "checkAll");
		/*7. Click on unchecAll button*/
		driver.findElement(By.xpath("//input[@id='check1']")).click();
		Utility.capturedScreenShot(driver, "UncheckAll");
		/*8. close driver instance*/
		Thread.sleep(10000);
		driver.close();
		
		/*For Git mearch practice entering Lines*/
		System.out.println("This is first line");
		System.out.println("This is my second line");
	}

}
