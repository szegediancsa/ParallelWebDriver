package firstSample;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ThreadLocalDemo {
	@Test
	@Parameters("browserName")
	public void testMethod1(String browserName) {
		invokeBrowser("http://www.twitter.com", browserName);
	}

	@Test
	@Parameters("browserName")
	public void testMethod2(String browserName) {
		invokeBrowser("http://www.facebook.com", browserName);

	}

	private void invokeBrowser(String url, String browserName) {
		System.out.println("Thread id = " + Thread.currentThread().getId());
		System.out.println("Hashcode of webDriver instance = " + LocalDriverManager.getDriver().hashCode());
		System.out.println("Browser name of webDriver instance = " + browserName);
		LocalDriverManager.getDriver().get(url);
	}
}
