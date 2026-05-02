package methods

import java.time.*
import java.time.format.TextStyle
import java.util.Locale
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.annotation.Keyword

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

public class select_Date {

	@Keyword
	static def selectCurrentDate() {


		LocalDate today = LocalDate.now()

		int day = today.getDayOfMonth()
		String monthName = today.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH)
		int year = today.getYear()

		String expectedMonthYear = monthName + " " + year

		while (true) {
			String displayedMonthYear = WebUI.getText(
					findTestObject('Object Repository/Calendar/calendarTitle')
					)

			if (displayedMonthYear.equalsIgnoreCase(expectedMonthYear)) {
				break
			}

			WebUI.click(findTestObject('Object Repository/Calendar/nextMonthArrow'))
			WebUI.delay(1)
		}
	}
}
