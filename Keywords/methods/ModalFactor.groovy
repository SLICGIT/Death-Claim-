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

public class ModalFactor {

	@Keyword
	static def getModalFactor() {

		Map data = FetchExcelData.getModalFactor("ModalFactor", GlobalVariable.G_PlanName)

		double factor = 0.0

		//		switch (true) {
		//
		//			case GlobalVariable.G_PlanName.toString().toUpperCase().contains("NEW SHRILIFE PLAN"):

		switch (GlobalVariable.G_Mode.toString().toUpperCase()) {
			case 'HALF YEARLY':
				factor = data['Half_Yearly_Factor'].toString().replaceAll(",", "").toBigDecimal()
				break

			case 'QUARTERLY':
				factor = data['Quarterly_Factor'].toString().replaceAll(",", "").toBigDecimal()
				break

			case 'MONTHLY':
				factor = data['Monthly_Factor'].toString().replaceAll(",", "").toBigDecimal()
				break

			default:
				factor = data['Yearly_Factor'].toString().replaceAll(",", "").toBigDecimal()
				break
		}

		//				break
		//
		//			default:
		//				break
		//		}

		WebUI.comment("Modal Factor is : " + factor)
		return factor
	}
}
