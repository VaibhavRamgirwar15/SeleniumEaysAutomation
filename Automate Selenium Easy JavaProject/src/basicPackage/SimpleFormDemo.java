package basicPackage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SimpleFormDemo {
	
	public WebDriver createChromDriverInstance() {
		
		System.setProperty("webdriver.chrome.driver", "/home/vaibhav/Browser_Driver/chromedriver_linux64/chromedriver");
		WebDriver chromeDriver = new ChromeDriver();
		
		chromeDriver.manage().window().maximize();
		chromeDriver.manage().deleteAllCookies();
		
		return chromeDriver;
	}
	
	public void getURL(WebDriver lDriver, String url) throws InterruptedException
	{
		lDriver.get(url);
		Thread.sleep(2000);
	}

	public static void main(String[] args) throws InterruptedException {
		
	/*
	 * System.setProperty("webdriver.chrome.driver", "/home/vaibhav/Browser_Driver/chromedriver_linux64/chromedriver");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
	*/
	SimpleFormDemo form= new SimpleFormDemo();
	WebDriver driver= form.createChromDriverInstance();
	
	//1.Navigate to the Link
	form.getURL(driver, "https://www.seleniumeasy.com/test");
	
	//Thread.sleep(5000);
	
	//2. click on Start session button
	WebDriverWait wait = new WebDriverWait(driver, 10);
	WebElement startSessionButton= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='btn_basic_example']")));
	startSessionButton.click();
	
	//3. Navigate to the Simple form demo page
	WebElement waitForSimpleForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='list-group']//a[contains(text(),'Simple Form Demo')]")));
	waitForSimpleForm.click();
	
	//4. Input this value
	driver.findElement(By.id("user-message")).sendKeys("Hello Vaibhav..!! Concentrate on Your Goal :)");
	
	//5. Click on button
	driver.findElement(By.xpath("//button[@type='button' and text()='Show Message']")).click();
	
	//6. Enter Value a
	driver.findElement(By.xpath("//label[text()='Enter a']//following::input[1]")).sendKeys("10");
	
	//7. Enter Value b
	driver.findElement(By.xpath("//label[text()='Enter b']//following::input")).sendKeys("30");
	
	//8. Get Total
	driver.findElement(By.xpath("//button[@class='btn btn-default' and text()='Get Total']")).click();
	
	System.out.println("Simple form Automated Succesfully");
	// Close
	Thread.sleep(10000);
	driver.close();
	}

}
