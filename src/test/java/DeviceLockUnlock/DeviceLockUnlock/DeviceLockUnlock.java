package DeviceLockUnlock.DeviceLockUnlock;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DeviceLockUnlock 
{
	public static void main(String args[]) throws MalformedURLException, InterruptedException 
	{
		AndroidDriver driver;
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("androidDeviceName");
		options.setCapability("forceAppLaunch", true);
		options.setCapability("autoGrantPermissions", true);
		options.setCapability("unlockType", "pin");
		options.setCapability("unlockKey", "123456");
		
		options.setCapability("unlockType", "pattern");
		options.setCapability("unlockKey", "123456");
		
		options.setCapability("unlockType", "password");
		options.setCapability("unlockKey", "123456");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		if(driver.isDeviceLocked())
		{
			driver.unlockDevice();			
		}
		else
		{
			driver.lockDevice();			
		}
		
		Thread.sleep(4000);
		driver.quit();
	}
	
}
