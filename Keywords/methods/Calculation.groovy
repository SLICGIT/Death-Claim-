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

import java.math.RoundingMode

import internal.GlobalVariable
import methods.FetchExcelData

public class Calculation {


	@Keyword
	static def verifyDataPoints() {

		Map data = FetchExcelData.getData("Death", GlobalVariable.G_TestCaseID)
		BigDecimal basicDeathClaim
		BigDecimal netPayableAmount
		BigDecimal totalPremPaid
		BigDecimal abRiderPayable
		BigDecimal fibRiderPayable
		BigDecimal stepRiderPayable
		int age

		switch (true) {

			case GlobalVariable.G_PlanName.toString().toUpperCase().contains("NEW SHRILIFE PLAN"):

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
					basicDeathClaim = basicDeathClaim.setScale(0, RoundingMode.HALF_UP)
					abRiderPayable = GlobalVariable.G_AB_Rider_SA.toString().replaceAll(",", "").toBigDecimal()
					fibRiderPayable = GlobalVariable.G_FIB_Rider_SA.toString().replaceAll(",", "").toBigDecimal() *1/100
					stepRiderPayable = GlobalVariable.G_STEPUP_Rider_SA.toString().replaceAll(",", "")
				}

				matchValues(basicDeathClaim, abRiderPayable, fibRiderPayable, stepRiderPayable)

				break
				
				//Early Cash Plan
				case GlobalVariable.G_PlanName.toString().toUpperCase().contains("EARLY CASH PLAN"):
				
				def baseSA = GlobalVariable.G_SumAssured.toString().replaceAll(",", "").toBigDecimal()
				def tenTimesAP = GlobalVariable.G_Annualized_Premium.toString().replaceAll(",", "").toBigDecimal() * 10
				totalPremPaid = GlobalVariable.G_BasicPremium.toString().replaceAll(",", "").toBigDecimal() * GlobalVariable.G_InstallmentNumber.toString().replaceAll(",", "").toBigDecimal()
				age = GlobalVariable.G_Age.toString().toInteger()

				if(age >= 50) {
					tenTimesAP = GlobalVariable.G_Annualized_Premium.toString().replaceAll(",", "").toBigDecimal() * 7
				}



				WebUI.comment("Age : " + age)

				if (data['DeathCause'].toString().contains('Suicide')) {
					basicDeathClaim = totalPremPaid * 80/100
				} else if (age < 18) {
					basicDeathClaim = totalPremPaid
				} else {
					basicDeathClaim = (baseSA.compareTo(tenTimesAP) > 0) ? baseSA : tenTimesAP
					basicDeathClaim = basicDeathClaim.setScale(0, RoundingMode.HALF_UP)
					abRiderPayable = GlobalVariable.G_AB_Rider_SA.toString().replaceAll(",", "").toBigDecimal()
					fibRiderPayable = GlobalVariable.G_FIB_Rider_SA.toString().replaceAll(",", "").toBigDecimal() *1/100
					stepRiderPayable = GlobalVariable.G_STEPUP_Rider_SA.toString().replaceAll(",", "")
				}

				matchValues(basicDeathClaim, abRiderPayable, fibRiderPayable, stepRiderPayable)

				break
				
				
				

			//Super Income Plan calculation logic
			case GlobalVariable.G_PlanName.toString().toUpperCase().contains("SUPER INCOME PLAN"):

				def tenTimesAP = GlobalVariable.G_Annualized_Premium.toString().replaceAll(",", "").toBigDecimal() * 10
				totalPremPaid = GlobalVariable.G_BasicPremium.toString().replaceAll(",", "").toBigDecimal() * GlobalVariable.G_InstallmentNumber.toString().replaceAll(",", "").toBigDecimal()
				def premPaid_105Times = totalPremPaid * 105/100

				if (data['DeathCause'].toString().contains('Suicide')) {
					basicDeathClaim = totalPremPaid * 80/100
				} else {
					basicDeathClaim = (tenTimesAP.compareTo(premPaid_105Times) > 0) ? tenTimesAP : premPaid_105Times
					basicDeathClaim = basicDeathClaim.setScale(0, RoundingMode.HALF_UP)
					abRiderPayable = GlobalVariable.G_AB_Rider_SA.toString().replaceAll(",", "").toBigDecimal()
					fibRiderPayable = GlobalVariable.G_FIB_Rider_SA.toString().replaceAll(",", "").toBigDecimal() *1/100
					stepRiderPayable = GlobalVariable.G_STEPUP_Rider_SA.toString().replaceAll(",", "")
				}

				matchValues(basicDeathClaim, abRiderPayable, fibRiderPayable, stepRiderPayable)

				break

			default:
				break
		}
	}


	@Keyword
	static def matchValues(def basicDeathClaim, def abRiderPayable, def fibRiderPayable, def stepRiderPayable) {

		BigDecimal netPayableAmount

		netPayableAmount = basicDeathClaim + additions() - deductions()
		netPayableAmount = netPayableAmount.toString().replaceAll(",", "").toBigDecimal().setScale(0, RoundingMode.HALF_UP)

		WebUI.comment("Calculated Basic Death Claim : " + basicDeathClaim)
		WebUI.comment("Calculated net payable amount : " + netPayableAmount)
		WebUI.comment("Calculated AB rider amount : " + abRiderPayable)
		WebUI.comment("Calculated FIB rider amount : " + fibRiderPayable)
		WebUI.comment("Calculated Step-up rider amount : " + stepRiderPayable)

		//Round off Actual Values
		BigDecimal roundBasicClaim = GlobalVariable.G_Basic_Death_Claim.toString().replaceAll(",", "").toBigDecimal().setScale(0, RoundingMode.HALF_UP)
		BigDecimal roundNetPayable = GlobalVariable.G_Net_Payable_Amount.toString().replaceAll(",", "").toBigDecimal().setScale(0, RoundingMode.HALF_UP)

		//Verify Expected and Actual Values
		boolean verifyBasicClaim =  WebUI.verifyEqual(basicDeathClaim, roundBasicClaim, FailureHandling.OPTIONAL)
		boolean verifyNetPayable =  WebUI.verifyEqual(netPayableAmount, roundNetPayable, FailureHandling.OPTIONAL)
		boolean verifyABRider =  WebUI.verifyEqual(abRiderPayable, GlobalVariable.G_AB_Rider_Amount, FailureHandling.OPTIONAL)
		boolean verifyFIBRider =  WebUI.verifyEqual(fibRiderPayable, GlobalVariable.G_FIB_Rider_Amount, FailureHandling.OPTIONAL)
		boolean verifyStepUpRider =  WebUI.verifyEqual(stepRiderPayable, GlobalVariable.G_StepUp_Rider_Amount, FailureHandling.OPTIONAL)

		//Check if calculation is correct or not
		if(verifyBasicClaim && verifyNetPayable/* && verifyABRider && verifyFIBRider && verifyStepUpRider*/) {
			GlobalVariable.G_Calculation_Remarks = ("Calculation is correct.\nExpected basic death claim = " + basicDeathClaim + "\nActual basic death claim = " + roundBasicClaim
					+ "\nExpected net payable amount = " + netPayableAmount + "\nActual net payable amount = " + roundNetPayable).toString()

			WebUI.comment(GlobalVariable.G_Calculation_Remarks.toString())
			GlobalVariable.G_Calculation_Status = 'PASSED'
		} else {
			GlobalVariable.G_Calculation_Remarks = ("Calculation is incorrect.\nExpected basic death claim = " + basicDeathClaim + "\nActual basic death claim = " + roundBasicClaim
					+ "\nExpected net payable amount = " + netPayableAmount + "\nActual net payable amount = " + roundNetPayable).toString()

			WebUI.comment(GlobalVariable.G_Calculation_Remarks.toString())
			GlobalVariable.G_Calculation_Status = 'FAILED'
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
		def accidentBenefit = GlobalVariable.G_AB_Rider_Amount.toString().replaceAll(",", "").toBigDecimal()
		def fibBenefit = GlobalVariable.G_FIB_Rider_Amount.toString().replaceAll(",", "").toBigDecimal()
		def stepRiderBenefit = GlobalVariable.G_StepUp_Rider_Amount.toString().replaceAll(",", "").toBigDecimal()

		def total = unpaidSB + outstnDeposit + outstnDisBenefit + fundValueInterest + advPremDeposit + unclmAmount + interimBonus + vestedBonus + accidentBenefit + fibBenefit + stepRiderBenefit

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
