package firstSample;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LocalDriverFactory {
	private static RemoteWebDriver driver = null;
	private static DesiredCapabilities capability = null;

	public enum browserCode {
		FF, IE, GC
	}

	private static void setDriverManager() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().setSize(new Dimension(1024, 768));
	}

	static RemoteWebDriver createInstance(browserCode browserName, String gridURL) throws MalformedURLException {
		switch (browserName) {
		case FF:
			capability = DesiredCapabilities.firefox();
			capability.setBrowserName("firefox");
			capability.setPlatform(org.openqa.selenium.Platform.ANY);

			driver = new RemoteWebDriver(new URL(gridURL), capability);
			setDriverManager();
			return driver;
		case IE:
			File fileIEDriver = new File("d:/ParallelWebDriver/tools/iedriver/IEDriverServer.exe");
			File fileIELog = new File("d:/ParallelWebDriver/tools/iedriver/IEDriverServer.log");
			System.setProperty("webdriver.ie.driver", fileIEDriver.getAbsolutePath());
			System.setProperty("webdriver.ie.driver.logfile", fileIELog.getAbsolutePath());
			System.setProperty("webdriver.ie.driver.loglevel", "WARN");

			capability = DesiredCapabilities.internetExplorer();
			capability.setBrowserName("internet explorer");
			capability.setPlatform(org.openqa.selenium.Platform.WINDOWS);
			capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capability.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);

			driver = new RemoteWebDriver(new URL(gridURL), capability);
			setDriverManager();
			return driver;
		case GC:
			File fileGCDriver = new File("d:/ParallelWebDriver/tools/chromedriver/chromedriver.exe");
			File fileGCLog = new File("d:/ParallelWebDriver/tools/chromedriver/chromedriver.log");
			System.setProperty("webdriver.chrome.driver", fileGCDriver.getAbsolutePath());
			System.setProperty("webdriver.chrome.logfile", fileGCLog.getAbsolutePath());

			capability = DesiredCapabilities.chrome();

			driver = new RemoteWebDriver(new URL(gridURL), capability);
			setDriverManager();
			return driver;
		default:
			throw new RuntimeException("Browser type is NOT supported!");
		}
	}
}
