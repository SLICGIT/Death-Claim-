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
import methods.CaptureScreenshot as SS
import methods.ModalFactor


import internal.GlobalVariable

public class CaptureValues {

	@Keyword
	static def getDataPointValues() {


		GlobalVariable.G_LaDOB = WebUI.getText(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data Points/DOB'))

		GlobalVariable.G_Gender = WebUI.getText(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data Points/Gender'))

		GlobalVariable.G_Age = WebUI.getText(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data Points/Age'))

		GlobalVariable.G_DOC = WebUI.getText(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data Points/DOC'))

		//		GlobalVariable = WebUI.getText(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data Points/Plan'))

		String baseSA = WebUI.getText(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data Points/SA'))

		GlobalVariable.G_SumAssured = baseSA.substring(4)

		String paidUpSA = WebUI.getText(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data Points/PaidUpSA'))

		GlobalVariable.G_PaidUpSA = paidUpSA.substring(4)

		GlobalVariable.G_PolicyTerm = WebUI.getText(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data Points/Policy Term'))

		GlobalVariable.G_PremiumTerm = WebUI.getText(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data Points/Premium Term'))

		GlobalVariable.G_Mode = WebUI.getText(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data Points/Mode'))

		String premium = WebUI.getText(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data Points/InstallmentPremium'))

		GlobalVariable.G_InstallmentPremium = premium.substring(4)

		String riderPremium = WebUI.getText(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data Points/riderPremium'))

		GlobalVariable.G_RiderPremium = riderPremium.substring(4)

		String extraPremium = WebUI.getText(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data Points/ExtraPremium'))

		GlobalVariable.G_ExtraPremium = extraPremium.substring(4)

		def inst  = GlobalVariable.G_InstallmentPremium.toString().replaceAll(",", "").toBigDecimal()
		def rider = GlobalVariable.G_RiderPremium.toString().replaceAll(",", "").toBigDecimal()
		def extra = GlobalVariable.G_ExtraPremium.toString().replaceAll(",", "").toBigDecimal()
		def basic = inst - rider - extra

		GlobalVariable.G_BasicPremium = basic.toString()

		//Calculate Annualized Premium
		//		def modalFactor = ModalFactor.getModalFactor()
		//		def AP = (basic/modalFactor)
		//
		//		GlobalVariable.G_Annualized_Premium = String.format("%.2f", AP)
		//		WebUI.comment(GlobalVariable.G_Annualized_Premium)

		GlobalVariable.G_InstallmentNumber = WebUI.getText(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data Points/InstallmentPaid'))

		GlobalVariable.G_FUP = WebUI.getText(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data Points/FUPDate'))

		GlobalVariable.G_DivisionName = WebUI.getText(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data Points/Division Name'))

		if(WebUI.waitForElementPresent(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data points/Interim_Bonus'), 4)) {
			GlobalVariable.G_Interim_Bonus = WebUI.getAttribute(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data points/Interim_Bonus'), 'textContent').trim()
		}

		if(WebUI.waitForElementPresent(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data points/VestedBonus'), 3)) {
			GlobalVariable.G_Vested_Bonus = WebUI.getAttribute(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data points/VestedBonus'), 'textContent').trim()
		}


		WebUI.delay(1)

		WebUI.scrollToElement(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/PolicyInfo1'), 2)

		SS.capture("Policy_Info1")

		WebUI.scrollToElement(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/PolicyInfo2'), 2)

		SS.capture("Policy_Info2")

		WebUI.enhancedClick(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/claimPayment/Close-PolicyInfo'))

		WebUI.waitForPageLoad(GlobalVariable.G_PageTimeout)

		if(WebUI.waitForElementPresent(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data Points/StepUpRiderPayable'), 2, FailureHandling.OPTIONAL)){

			GlobalVariable.G_StepUp_Rider_Amount= WebUI.getText(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data Points/StepUpRiderPayable'))
		}

		if(WebUI.waitForElementPresent(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data Points/ABRiderPayable'), 2, FailureHandling.OPTIONAL)){

			GlobalVariable.G_AB_Rider_Amount= WebUI.getText(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data Points/ABRiderPayable'))
		}

		if(WebUI.waitForElementPresent(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data Points/FIBRiderPayable'), 2, FailureHandling.OPTIONAL)){

			GlobalVariable.G_FIB_Rider_Amount= WebUI.getText(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data Points/FIBRiderPayable'))
		}

		if(WebUI.waitForElementPresent(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data Points/EICRiderPayable'), 2, FailureHandling.OPTIONAL)){

			GlobalVariable.G_EIC_Rider_Amount= WebUI.getText(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data Points/EICRiderPayable'))
		}

		if(WebUI.waitForElementPresent(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data Points/One_percent_of_SA'), 2, FailureHandling.OPTIONAL)){

			GlobalVariable.G_OnePercentOfSA_Amount= WebUI.getText(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data Points/One_percent_of_SA'))
		}

		if(WebUI.waitForElementPresent(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data Points/One_Time_payment'), 2, FailureHandling.OPTIONAL)){

			GlobalVariable.G_OneTimePaymentAmount= WebUI.getText(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data Points/One_Time_payment'))
		}

		GlobalVariable.G_Outstanding_Premium_Due = WebUI.getText(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data points/Outstanding Premium Due'))

		GlobalVariable.G_Outstanding_Premium_Interest = WebUI.getText(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data points/Interest on Premium'))

		GlobalVariable.G_Interest_on_Difference_Premium = WebUI.getText(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data points/Interest on Difference Premium'))

		GlobalVariable.G_LoanAmount = WebUI.getText(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data points/Loan amount'))

		GlobalVariable.G_LoanInterest = WebUI.getAttribute(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data points/Interest on Outstanding Loan'), 'textContent').trim()

		GlobalVariable.G_Balance_Premium = WebUI.getText(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data points/Balance Premium'))

		GlobalVariable.G_XCharge = WebUI.getText(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data points/XCharge'))

		GlobalVariable.G_Survival_Benefit_Paid = WebUI.getText(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data points/Survival Benefit Paid After Death'))

		GlobalVariable.G_NB_Conversion_Amount = WebUI.getText(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data points/Conversion Amount'))

		GlobalVariable.G_Basic_Death_Claim = WebUI.getText(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data Points/Basic_Death_Claim'))

		//		String Other_Add = WebUI.getText(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data points/Other Additions'))

		//		String Other_Deduction = WebUI.getText(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data points/Other Deduction'))

		GlobalVariable.G_Net_Payable_Amount = WebUI.getAttribute(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data points/Net Amount Payable'), 'value')

		GlobalVariable.G_Unpaid_SB = WebUI.getText(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data Points/Unpaid_SB'))

		GlobalVariable.G_Outstanding_Deposit = WebUI.getText(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data Points/Outstanding_Deposit'))

		GlobalVariable.G_Disability_Benefit = WebUI.getText(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data Points/Outstanding_Disability_Benefit'))

		GlobalVariable.G_Fund_Value_Interest = WebUI.getText(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data Points/Discontinuace_Fund_Value'))

		GlobalVariable.G_Advance_Premium_Deposit = WebUI.getAttribute(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data Points/Advance_Premium_Deposit'), 'textContent').trim()

		GlobalVariable.G_Unclaimed_Amount = WebUI.getText(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data Points/Unclaimed_Amount'))

		//		GlobalVariable.G_Reversal_Charges = WebUI.getText(findTestObject('Object Repository/shrilifeadmission/claimpaymentApproval/Data Points/Reversal_Charges'))

		//		WebUI.comment(GlobalVariable.G_LaDOB)
		//		WebUI.comment(GlobalVariable.G_Gender)
		//		WebUI.comment(GlobalVariable.G_Age)
		//		WebUI.comment(GlobalVariable.G_DOC)
		//		WebUI.comment(GlobalVariable.G_SumAssured)
		//		WebUI.comment(GlobalVariable.G_PaidUpSA)
		//		WebUI.comment(GlobalVariable.G_PolicyTerm)
		//		WebUI.comment(GlobalVariable.G_PremiumTerm)
		//		WebUI.comment(GlobalVariable.G_Mode)
		//		WebUI.comment(GlobalVariable.G_InstallmentPremium)
		//		WebUI.comment(GlobalVariable.G_RiderPremium)
		//		WebUI.comment(GlobalVariable.G_ExtraPremium)
		//		WebUI.comment(GlobalVariable.G_InstallmentNumber)
		//		WebUI.comment(GlobalVariable.G_FUP)
		//		WebUI.comment(GlobalVariable.G_DivisionName)
		//		WebUI.comment(GlobalVariable.G_BasicPremium)

		//		WebUI.comment(GlobalVariable.G_Unpaid_SB)
		//		WebUI.comment(GlobalVariable.G_Outstanding_Deposit)
		//		WebUI.comment(GlobalVariable.G_Disability_Benefit)
		WebUI.comment(GlobalVariable.G_Advance_Premium_Deposit)
		WebUI.comment(GlobalVariable.G_LoanInterest)
		//		WebUI.comment(GlobalVariable.G_PaidUpSA)
		//		WebUI.comment(GlobalVariable.G_PolicyTerm)
		//		WebUI.comment(GlobalVariable.G_PremiumTerm)
		//		WebUI.comment(GlobalVariable.G_Mode)
		//		WebUI.comment(GlobalVariable.G_InstallmentPremium)
		//		WebUI.comment(GlobalVariable.G_RiderPremium)
		//		WebUI.comment(GlobalVariable.G_ExtraPremium)
		//		WebUI.comment(GlobalVariable.G_InstallmentNumber)
		//		WebUI.comment(GlobalVariable.G_FUP)
		//		WebUI.comment(GlobalVariable.G_DivisionName)
		//		WebUI.comment(GlobalVariable.G_BasicPremium)
	}
}
