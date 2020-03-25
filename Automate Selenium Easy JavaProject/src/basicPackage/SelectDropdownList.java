package basicPackage;

import java.awt.RenderingHints.Key;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdownList {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/home/vaibhav/Browser_Driver/chromedriver_linux64/chromedriver");
		//WebDriver driver = new ChromeDriver();
		ChromeDriver driver1 = new ChromeDriver();
		//Open Link
		driver1.get("https://www.seleniumeasy.com/test/");
		driver1.manage().window().maximize();
		driver1.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("=====Step1: Open Seleniumeasy test site sucessfully completed.=====");
		
		Actions action = new Actions(driver1);
		
		//Perform Drag Drop Operation
		WebElement source = driver1.findElement(By.linkText("Demo Home"));
		WebElement target = driver1.findElement(By.xpath("//a[@id='btn_basic_example']"));
		
		action.dragAndDrop(source, target).build().perform();
		System.out.println("=====Step2: Drag and Drop Sucessfully completed.=====");
		Thread.sleep(5000);
		target.click();
		
		//Hover to Select Dropdown List element and then click
		WebElement eleDropdownList = driver1.findElement(By.xpath("//div[@class='list-group']//a[text()='Select Dropdown List']")); 
		//action.moveToElement(eleDropdownList).build().perform();
		eleDropdownList.click();
		System.out.println("=====Step3: HoverOver to the element and Click sucesfully completed.=====");
		
		//Select Dropdown
		
		WebElement element = driver1.findElement(By.xpath("//select[@id='select-demo']"));
		Select dropdownList = new Select(element);
		dropdownList.selectByValue("Sunday");
		dropdownList.selectByVisibleText("Monday");
		System.out.println("=====Step4: Succesfully selected single dropdown");
		Thread.sleep(5000);
		
		WebElement eleSize = driver1.findElement(By.xpath("//select[@id='multi-select']"));

		Select states = new Select(eleSize);
		action.keyDown(Keys.CONTROL);
		states.selectByIndex(1);
		states.selectByIndex(3);
		states.selectByIndex(5);
		action.keyUp(Keys.CONTROL);
		
		driver1.findElement(By.id("printAll")).click();
		Thread.sleep(2000);
		driver1.findElement(By.id("printMe")).click();
		Thread.sleep(2000);
		System.out.println("=====Step5: Multiple dropdown selected successfully=====");
		
		//Close the Browser
		System.out.println("=====Step6: Close the Browser=====");
		//driver1.close();
	}
	
	public void intialiseBrowser(){}

}
