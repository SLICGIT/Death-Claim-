package eft

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

import java.nio.file.Files
import java.nio.file.Paths
import java.net.URL
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.By

import internal.GlobalVariable

public class getPRF {

	@Keyword
	static def downloadPRF(String policyNo) {

		WebDriver driver = DriverFactory.getWebDriver()

		WebElement pdf = driver.findElement(By.cssSelector("iframe"));

		String pdfUrl = pdf.getAttribute("src");

		WebUI.comment(pdfUrl)

		// Change path as needed
		String downloadPath = GlobalVariable.G_ScreenshotDir + "/" + policyNo + "_PRF.pdf"

		URL url = new URL(pdfUrl)
		InputStream inputStream = url.openStream()
		Files.copy(inputStream, Paths.get(downloadPath))
		inputStream.close()

		println "PDF downloaded successfully at: " + downloadPath
	}
}
