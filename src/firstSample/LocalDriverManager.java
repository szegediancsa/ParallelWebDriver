package firstSample;

import org.openqa.selenium.remote.RemoteWebDriver;

public class LocalDriverManager {
	private static ThreadLocal<RemoteWebDriver> webDriver = new ThreadLocal<RemoteWebDriver>();

	public static RemoteWebDriver getDriver() {
		return webDriver.get();
	}

	static void setWebDriver(RemoteWebDriver driver) {
		webDriver.set(driver);
	}
}
