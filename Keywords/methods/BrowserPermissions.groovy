package methods

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import org.openqa.selenium.chrome.ChromeOptions
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
//import com.kms.katalon.core.webui.driver.DriverFactory
//import org.openqa.selenium.chrome.ChromeDriver
//import org.openqa.selenium.chrome.ChromeOptions


import internal.GlobalVariable

public class BrowserPermissions {

	//	private ChromeDriver driver
	//	private final String origin = "https://slicuatr.shriramlife.in"

	@Keyword
	static def openChromeWithOptions() {
		ChromeOptions options = new ChromeOptions()

		// ---- Preferences: disable password manager & notifications
		Map<String, Object> prefs = new HashMap<>()
		prefs.put("credentials_enable_service", false)
		prefs.put("profile.password_manager_enabled", false)
		// 2 = block notifications
		prefs.put("profile.default_content_setting_values.notifications", 2)
		// Ensure Chrome doesn't restore last session or open custom startup pages
		// 0 = open New Tab page (we'll override with about:blank via args)
		prefs.put("restore_on_startup", 0)

		options.setExperimentalOption("prefs", prefs)

		// ---- Arguments: clean startup, no extensions, no bubbles
		options.addArguments("--incognito")
		options.addArguments("--no-first-run")
		options.addArguments("--no-default-browser-check")
		options.addArguments("--disable-extensions")
		options.addArguments("--disable-notifications")
		options.addArguments("--disable-infobars")
		options.addArguments("--disable-save-password-bubble")
		options.addArguments("--disable-password-manager-reauthentication")
		options.addArguments("--disable-features=PasswordLeakDetection")
		options.addArguments("--disable-component-update")
		options.addArguments("--disable-features=PasswordManagerOnboarding")
		options.addArguments("--homepage=about:blank")
		options.addArguments("--new-window")
		options.addArguments("--start-maximized")


		// Use your clean profile folder (it can be anywhere)
		//        options.addArguments("--user-data-dir=C:/KatalonProfile")

		WebDriver driver = new ChromeDriver(options)
		DriverFactory.changeWebDriver(driver)
	}

	@Keyword
	static def shrilifePermission() {

		//		ChromeOptions options = new ChromeOptions()
		//
		//		// Optional: add your usual arguments (headless, etc.)
		//
		//		ChromeDriver Driver = new ChromeDriver(options)
		//
		//		options.addArguments("--disable-notifications")
		//
		//		DriverFactory.changeWebDriver(new ChromeDriver(options))
		//
		//		DriverFactory.changeWebDriver(Driver)

		//		ChromeDriver driver = (ChromeDriver) DriverFactory.getWebDriver()

		//		Map<String, Object> grantParams = new HashMap<>()
		//
		//		String origin = "https://slicuatr.shriramlife.in"
		//
		//		grantParams.put("origin", origin)
		//
		//		// The key permission for the dialog in your screenshot is "localNetwork"
		//
		//		grantParams.put("permissions", Arrays.asList("localNetwork"))
		//
		//		driver.executeCdpCommand("Browser.grantPermissions", grantParams)


		ChromeOptions options = new ChromeOptions()
		options.addArguments('--disable-features=LocalNetworkAccessChecks')

		// (Optional) run without extensions or with a dedicated temp profile to keep the env clean
		options.addArguments('--disable-extensions')
		options.addArguments('--no-first-run')

		DriverFactory.changeWebDriver(new org.openqa.selenium.chrome.ChromeDriver(options))
		//		WebUI.navigateToUrl('https://slicuatc.shriramlife.in/shrilife/SLReceipts/rmChequeStatus.aspx')
	}
}
