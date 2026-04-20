package utils

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

import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.Cookie

import java.net.HttpURLConnection
import java.net.URL
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption


import internal.GlobalVariable

public class PdfDownloader {
	
	
	@Keyword
		def downloadPdfWithSession(String fileUrl, String savePath) {
	
			Files.createDirectories(Paths.get(savePath).getParent())
	
			def driver = DriverFactory.getWebDriver()
			String cookies = driver.manage().getCookies()
					.collect { Cookie c -> "${c.getName()}=${c.getValue()}" }
					.join("; ")
	
			HttpURLConnection conn = (HttpURLConnection) new URL(fileUrl).openConnection()
			conn.setRequestMethod("GET")
			conn.setRequestProperty("Cookie", cookies)
			conn.setRequestProperty("User-Agent", "Mozilla/5.0")
	
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("PDF download failed. HTTP " + conn.getResponseCode())
			}
	
			Files.copy(conn.getInputStream(),
					   Paths.get(savePath),
					   StandardCopyOption.REPLACE_EXISTING)
	
			conn.disconnect()
		}
		
	
}
