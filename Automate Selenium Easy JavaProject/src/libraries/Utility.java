package libraries;

import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	public static void capturedScreenShot(WebDriver driver, String screenShotName)
	{
		try {
			TakesScreenshot screenShot = (TakesScreenshot)driver;
			File source = screenShot.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(source, new File("./ScreenShots/"+screenShotName+".png"));
		} catch (Exception e) {
			System.out.println("Error while capturing Screenshot :"+e.getMessage());
		}
	}
}
