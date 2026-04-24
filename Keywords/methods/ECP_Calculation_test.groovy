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

public class ECP_Calculation_test {

	@Keyword
	static def verifyDataPoints() {

		Map data = FetchExcelData.getData("Death", GlobalVariable.G_TestCaseID)
		BigDecimal basicDeathClaim
		BigDecimal netPayableAmount
		BigDecimal totalPremPaid
		int age

		switch (true) {

			case GlobalVariable.G_PlanName.toString().toUpperCase().contains("EARLY CASH PLAN"):

				def baseSA = GlobalVariable.G_SumAssured.toString().replaceAll(",", "").toBigDecimal()
				def tenTimesAP = GlobalVariable.G_Annualized_Premium.toString().replaceAll(",", "").toBigDecimal() * 10
				totalPremPaid = GlobalVariable.G_BasicPremium.toString().replaceAll(",", "").toBigDecimal() * GlobalVariable.G_InstallmentNumber.toString().replaceAll(",", "").toBigDecimal()
				age = GlobalVariable.G_Age.toString().toInteger()
				WebUI.comment("Age : " + age)

				if (data['DeathCause'].toString().contains('Suicide')) {
					basicDeathClaim = totalPremPaid * 80/100
				} else if (age < 18) {
					basicDeathClaim = totalPremPaid
				} else {
					basicDeathClaim = (baseSA.compareTo(tenTimesAP) > 0) ? baseSA : tenTimesAP
				}

				netPayableAmount = basicDeathClaim + additions() - deductions()

				WebUI.comment("Calculated Basic Death Claim : " + basicDeathClaim)
				WebUI.comment("Calculated net payable amount : " + netPayableAmount)

				boolean verifyBasicClaim =  WebUI.verifyEqual(basicDeathClaim, GlobalVariable.G_Basic_Death_Claim, FailureHandling.OPTIONAL)
				boolean verifyNetPayable =  WebUI.verifyEqual(netPayableAmount, GlobalVariable.G_Net_Payable_Amount, FailureHandling.OPTIONAL)

				if(verifyBasicClaim && verifyNetPayable) {
					GlobalVariable.G_Calculation_Remarks = ("Calculation is correct.\nExpected basic death claim = " + basicDeathClaim + "\nActual basic death claim = " + GlobalVariable.G_Basic_Death_Claim
							+ "\nExpected net payable amount = " + netPayableAmount + "\nActual net payable amount = " + GlobalVariable.G_Net_Payable_Amount).toString()

					WebUI.comment(GlobalVariable.G_Calculation_Remarks.toString())
					GlobalVariable.G_Calculation_Status = 'PASSED'
				} else {
					GlobalVariable.G_Calculation_Remarks = ("Calculation is incorrect.\nExpected basic death claim = " + basicDeathClaim + "\nActual basic death claim = " + GlobalVariable.G_Basic_Death_Claim
							+ "\nExpected net payable amount = " + netPayableAmount + "\nActual net payable amount = " + GlobalVariable.G_Net_Payable_Amount).toString()

					WebUI.comment(GlobalVariable.G_Calculation_Remarks.toString())
					GlobalVariable.G_Calculation_Status = 'FAILED'
				}

				break

			default:
				break
		}
	}


	@Keyword
	static def additions() {

		def unpaidSB = GlobalVariable.G_Unpaid_SB.toString().replaceAll(",", "").toBigDecimal()
		def outstnDeposit = GlobalVariable.G_Outstanding_Deposit.toString().replaceAll(",", "").toBigDecimal()
		def outstnDisBenefit = GlobalVariable.G_Disability_Benefit.toString().replaceAll(",", "").toBigDecimal()
		def fundValueInterest = GlobalVariable.G_Fund_Value_Interest.toString().replaceAll(",", "").toBigDecimal()
		def advPremDeposit = GlobalVariable.G_Advance_Premium_Deposit.toString().replaceAll(",", "").toBigDecimal()
		def unclmAmount = GlobalVariable.G_Unclaimed_Amount.toString().replaceAll(",", "").toBigDecimal()
		def interimBonus = GlobalVariable.G_Interim_Bonus.toString().replaceAll(",", "").toBigDecimal()
		def vestedBonus = GlobalVariable.G_Vested_Bonus.toString().replaceAll(",", "").toBigDecimal()

		def total = unpaidSB + outstnDeposit + outstnDisBenefit + fundValueInterest + advPremDeposit + unclmAmount + interimBonus + vestedBonus

		return total
	}

	@Keyword
	static def deductions() {

		def outstnPremDue = GlobalVariable.G_Outstanding_Premium_Due.toString().replaceAll(",", "").toBigDecimal()
		def outPremInterest = GlobalVariable.G_Outstanding_Premium_Interest.toString().replaceAll(",", "").toBigDecimal()
		def diffPremInterest = GlobalVariable.G_Interest_on_Difference_Premium.toString().replaceAll(",", "").toBigDecimal()
		def loanAmount = GlobalVariable.G_LoanAmount.toString().replaceAll(",", "").toBigDecimal()
		def loanInterest = GlobalVariable.G_LoanInterest.toString().replaceAll(",", "").toBigDecimal()
		def balancePremium = GlobalVariable.G_Balance_Premium.toString().replaceAll(",", "").toBigDecimal()
		def xCharge = GlobalVariable.G_XCharge.toString().replaceAll(",", "").toBigDecimal()
		def SBPaidAfterDeath = GlobalVariable.G_Survival_Benefit_Paid.toString().replaceAll(",", "").toBigDecimal()
		def NBConversionAmount = GlobalVariable.G_NB_Conversion_Amount.toString().replaceAll(",", "").toBigDecimal()

		def total = outstnPremDue + outPremInterest + diffPremInterest + loanAmount + loanInterest + balancePremium + xCharge + SBPaidAfterDeath + NBConversionAmount

		return total
	}
}
