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

import internal.GlobalVariable
import methods.FetchExcelData

public class CaptureScreenshot {

	@Keyword
	static def capture(String pageName) {

		String fileName = String.format("%03d_%s.png", GlobalVariable.G_SSCount, pageName)
		String fullPath = GlobalVariable.G_ScreenshotDir + '/' + fileName
		WebUI.takeScreenshot(fullPath)
		GlobalVariable.G_SSCount++

		return fullPath
	}

	@Keyword
	static def screenshotDir(String tcID) {

		Map data = FetchExcelData.getData("Death", tcID)
		GlobalVariable.G_PlanName = data['ProductName']
		GlobalVariable.G_TestCaseID = tcID
		GlobalVariable.G_Date = new Date().format('dd-MM-yyyy')
		GlobalVariable.G_Time = new Date().format('HH-mm-ss')

		GlobalVariable.G_ScreenshotDir = GlobalVariable.G_ScreenshotDir + "$GlobalVariable.G_Date/$GlobalVariable.G_PlanName/$GlobalVariable.G_TestCaseID" + "_" + data['PolicyNumber'] + "_" + "$GlobalVariable.G_Time"

		new File(GlobalVariable.G_ScreenshotDir).mkdirs()

		//	    return GlobalVariable.screenshotDir
	}
}
