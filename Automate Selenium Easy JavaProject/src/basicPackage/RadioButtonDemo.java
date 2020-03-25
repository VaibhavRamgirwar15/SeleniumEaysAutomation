package basicPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RadioButtonDemo {

	public static void main(String[] args) throws Exception {
		
		/*1. Open a chrome browser*/
		System.setProperty("webdriver.chrome.driver", "/home/vaibhav/Browser_Driver/chromedriver_linux64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		/*2. Navigate to the URL*/
		driver.get("https://www.seleniumeasy.com/test/");
		
		/* Drag and drop to the Start Practicing */
		Actions action = new Actions(driver);
		
		WebElement source = driver.findElement(By.xpath("//div[@class='navbar-brand navbar-brand-centered']//a[text()='Demo Home']"));
		WebElement target = driver.findElement(By.xpath("//a[@id='btn_basic_example']"));
		
		action.dragAndDrop(source, target);
		
		Thread.sleep(5000);
		/*3. Click on Start Session button*/
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='btn_basic_example']"))).click();
		
		/*4. Select RadioButton Demo Form*/
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='list-group']//a[text()='Radio Buttons Demo']"))).click();
		
		/*5. Click on radio button male*/
		//driver.findElement(By.xpath("//input[@type='radio' and @value='Male' and @name='optradio']")).click();
		
		List<WebElement> element= driver.findElements(By.xpath("//input[@type='radio' and @name='optradio']"));
		
		for(int i=0; i<element.size(); i++)
		{
			WebElement locElement= element.get(i);
			
			String strGender=locElement.getAttribute("Value");
			
			if(strGender.equalsIgnoreCase("male"))
			{
				locElement.click();
				System.out.println("Clicked On Male Radio Button");
			}
			
		}
	
		/*6 Click on Get Checked Value button*/
		driver.findElement(By.xpath("//button[text()='Get Checked value']")).click();
		
		/*7 Click on radio button demo*/
		List<WebElement> gElement= driver.findElements(By.xpath("//input[@type='radio' and @name='gender']"));
		
		for(int i=0; i<gElement.size(); i++)
		{
			WebElement gender = gElement.get(i);
			
			String strGender= gender.getAttribute("Value");
			

			if(strGender.equalsIgnoreCase("female"))
			{
				gender.click();
				System.out.println("Selected Sex");
			}
			
		}
		
		List<WebElement> ageElements = driver.findElements(By.xpath("//input[@type='radio' and @name='ageGroup']"));
		
		for(int i=0; i<ageElements.size(); i++)
		{
			WebElement oneAgeELe= ageElements.get(i);
			
			String strAge= oneAgeELe.getAttribute("Value");
			
			if(strAge.equalsIgnoreCase("5 - 15"))
			{
				oneAgeELe.click();
				System.out.println("Clicked on Age Elemets");
			}
			
		}
		
		driver.findElement(By.xpath("//button[@type='button' and text()='Get values']")).click();
		
		/* Close Instance*/
		Thread.sleep(10000);
		driver.close();
	}

}
