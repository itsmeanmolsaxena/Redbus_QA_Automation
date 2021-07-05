package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {
	public static String takeScreenShot(WebDriver driver, String testcasename) {
		String screenshotFileName = System.getProperty("user.dir") + "/Screenshots/TestScreenshot.jpg";

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(screenshotFileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenshotFileName ;
	}
}

