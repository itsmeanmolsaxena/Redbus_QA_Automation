package utility;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Run_with_Docker extends Redbus_BaseTest {

	public static RemoteWebDriver remotedriver;
	
	public static RemoteWebDriver docker_run() throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setBrowserName(BrowserType.FIREFOX);

		remotedriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);

		remotedriver.get(prop.getProperty("BaseUrl"));
		
		return remotedriver;

	}

}
