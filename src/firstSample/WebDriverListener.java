package firstSample;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import firstSample.LocalDriverFactory.browserCode;

public class WebDriverListener implements IInvokedMethodListener {
	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		if (method.isTestMethod()) {
			String browserName = method.getTestMethod().getXmlTest().getLocalParameters().get("browserName");
			String gridURL = method.getTestMethod().getXmlTest().getLocalParameters().get("gridURL");
			try {
				RemoteWebDriver driver = LocalDriverFactory.createInstance(browserCode.valueOf(browserName), gridURL);
				LocalDriverManager.setWebDriver(driver);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		if (method.isTestMethod()) {
			RemoteWebDriver driver = LocalDriverManager.getDriver();
			if (driver != null) {
				driver.quit();
			}
		}
	}
}
