package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p>Profile default : URL to intimate death claim</p>
     */
    public static Object G_IntimationUrl
     
    /**
     * <p>Profile default : URL to register and approve death claim</p>
     */
    public static Object G_ClaimPortalUrl
     
    /**
     * <p></p>
     */
    public static Object G_ShrilifeUrl
     
    /**
     * <p>Profile default : Defined time for page to load</p>
     */
    public static Object G_PageTimeout
     
    /**
     * <p>Profile default : Defined test data path </p>
     */
    public static Object G_testDataPath
     
    /**
     * <p></p>
     */
    public static Object G_ScreenshotDir
     
    /**
     * <p></p>
     */
    public static Object G_ReportPath
     
    /**
     * <p>Profile default : Defined to capture reference number created after claim intimation</p>
     */
    public static Object G_ReferenceNo
     
    /**
     * <p></p>
     */
    public static Object G_TestCaseID
     
    /**
     * <p></p>
     */
    public static Object G_Date
     
    /**
     * <p></p>
     */
    public static Object G_Time
     
    /**
     * <p></p>
     */
    public static Object G_SSCount
     
    /**
     * <p></p>
     */
    public static Object G_ExecutionTime
     
    /**
     * <p></p>
     */
    public static Object G_Status
     
    /**
     * <p></p>
     */
    public static Object G_DownloadPath
     
    /**
     * <p></p>
     */
    public static Object G_BatchID
     
    /**
     * <p></p>
     */
    public static Object G_PlanName
     
    /**
     * <p></p>
     */
    public static Object G_LaDOB
     
    /**
     * <p></p>
     */
    public static Object G_Gender
     
    /**
     * <p></p>
     */
    public static Object G_Age
     
    /**
     * <p></p>
     */
    public static Object G_DOC
     
    /**
     * <p></p>
     */
    public static Object G_SumAssured
     
    /**
     * <p></p>
     */
    public static Object G_PaidUpSA
     
    /**
     * <p></p>
     */
    public static Object G_PremiumTerm
     
    /**
     * <p></p>
     */
    public static Object G_PolicyTerm
     
    /**
     * <p></p>
     */
    public static Object G_Mode
     
    /**
     * <p></p>
     */
    public static Object G_InstallmentPremium
     
    /**
     * <p></p>
     */
    public static Object G_RiderPremium
     
    /**
     * <p></p>
     */
    public static Object G_ExtraPremium
     
    /**
     * <p></p>
     */
    public static Object G_BasicPremium
     
    /**
     * <p></p>
     */
    public static Object G_InstallmentNumber
     
    /**
     * <p></p>
     */
    public static Object G_FUP
     
    /**
     * <p></p>
     */
    public static Object G_DivisionName
     
    /**
     * <p></p>
     */
    public static Object G_LoanAmount
     
    /**
     * <p></p>
     */
    public static Object G_LoanInterest
     
    /**
     * <p></p>
     */
    public static Object G_Unpaid_SB
     
    /**
     * <p></p>
     */
    public static Object G_Outstanding_Deposit
     
    /**
     * <p></p>
     */
    public static Object G_Disability_Benefit
     
    /**
     * <p></p>
     */
    public static Object G_Fund_Value_Interest
     
    /**
     * <p></p>
     */
    public static Object G_Advance_Premium_Deposit
     
    /**
     * <p></p>
     */
    public static Object G_Unclaimed_Amount
     
    /**
     * <p></p>
     */
    public static Object G_Reversal_Charges
     
    /**
     * <p></p>
     */
    public static Object G_Outstanding_Premium_Due
     
    /**
     * <p></p>
     */
    public static Object G_Outstanding_Premium_Interest
     
    /**
     * <p></p>
     */
    public static Object G_Interest_on_Difference_Premium
     
    /**
     * <p></p>
     */
    public static Object G_Balance_Premium
     
    /**
     * <p></p>
     */
    public static Object G_XCharge
     
    /**
     * <p></p>
     */
    public static Object G_Survival_Benefit_Paid
     
    /**
     * <p></p>
     */
    public static Object G_NB_Conversion_Amount
     
    /**
     * <p></p>
     */
    public static Object G_Basic_Death_Claim
     
    /**
     * <p></p>
     */
    public static Object G_Net_Payable_Amount
     
    /**
     * <p></p>
     */
    public static Object G_AB_Rider_SA
     
    /**
     * <p></p>
     */
    public static Object G_FIB_Rider_SA
     
    /**
     * <p></p>
     */
    public static Object G_Interim_Bonus
     
    /**
     * <p></p>
     */
    public static Object G_USER
     
    /**
     * <p></p>
     */
    public static Object G_STEPUP_Rider_SA
     
    /**
     * <p></p>
     */
    public static Object G_EIC_Rider_SA
     
    /**
     * <p></p>
     */
    public static Object G_StepUp_Rider_Amount
     
    /**
     * <p></p>
     */
    public static Object G_EIC_Rider_Amount
     
    /**
     * <p></p>
     */
    public static Object G_AB_Rider_Amount
     
    /**
     * <p></p>
     */
    public static Object G_FIB_Rider_Amount
     
    /**
     * <p></p>
     */
    public static Object G_Annualized_Premium
     
    /**
     * <p></p>
     */
    public static Object G_Vested_Bonus
     
    /**
     * <p></p>
     */
    public static Object G_Calculation_Status
     
    /**
     * <p></p>
     */
    public static Object G_Calculation_Remarks
     
    /**
     * <p></p>
     */
    public static Object G_OnePercentOfSA_Amount
     
    /**
     * <p></p>
     */
    public static Object G_OneTimePaymentAmount
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
    
            G_IntimationUrl = selectedVariables['G_IntimationUrl']
            G_ClaimPortalUrl = selectedVariables['G_ClaimPortalUrl']
            G_ShrilifeUrl = selectedVariables['G_ShrilifeUrl']
            G_PageTimeout = selectedVariables['G_PageTimeout']
            G_testDataPath = selectedVariables['G_testDataPath']
            G_ScreenshotDir = selectedVariables['G_ScreenshotDir']
            G_ReportPath = selectedVariables['G_ReportPath']
            G_ReferenceNo = selectedVariables['G_ReferenceNo']
            G_TestCaseID = selectedVariables['G_TestCaseID']
            G_Date = selectedVariables['G_Date']
            G_Time = selectedVariables['G_Time']
            G_SSCount = selectedVariables['G_SSCount']
            G_ExecutionTime = selectedVariables['G_ExecutionTime']
            G_Status = selectedVariables['G_Status']
            G_DownloadPath = selectedVariables['G_DownloadPath']
            G_BatchID = selectedVariables['G_BatchID']
            G_PlanName = selectedVariables['G_PlanName']
            G_LaDOB = selectedVariables['G_LaDOB']
            G_Gender = selectedVariables['G_Gender']
            G_Age = selectedVariables['G_Age']
            G_DOC = selectedVariables['G_DOC']
            G_SumAssured = selectedVariables['G_SumAssured']
            G_PaidUpSA = selectedVariables['G_PaidUpSA']
            G_PremiumTerm = selectedVariables['G_PremiumTerm']
            G_PolicyTerm = selectedVariables['G_PolicyTerm']
            G_Mode = selectedVariables['G_Mode']
            G_InstallmentPremium = selectedVariables['G_InstallmentPremium']
            G_RiderPremium = selectedVariables['G_RiderPremium']
            G_ExtraPremium = selectedVariables['G_ExtraPremium']
            G_BasicPremium = selectedVariables['G_BasicPremium']
            G_InstallmentNumber = selectedVariables['G_InstallmentNumber']
            G_FUP = selectedVariables['G_FUP']
            G_DivisionName = selectedVariables['G_DivisionName']
            G_LoanAmount = selectedVariables['G_LoanAmount']
            G_LoanInterest = selectedVariables['G_LoanInterest']
            G_Unpaid_SB = selectedVariables['G_Unpaid_SB']
            G_Outstanding_Deposit = selectedVariables['G_Outstanding_Deposit']
            G_Disability_Benefit = selectedVariables['G_Disability_Benefit']
            G_Fund_Value_Interest = selectedVariables['G_Fund_Value_Interest']
            G_Advance_Premium_Deposit = selectedVariables['G_Advance_Premium_Deposit']
            G_Unclaimed_Amount = selectedVariables['G_Unclaimed_Amount']
            G_Reversal_Charges = selectedVariables['G_Reversal_Charges']
            G_Outstanding_Premium_Due = selectedVariables['G_Outstanding_Premium_Due']
            G_Outstanding_Premium_Interest = selectedVariables['G_Outstanding_Premium_Interest']
            G_Interest_on_Difference_Premium = selectedVariables['G_Interest_on_Difference_Premium']
            G_Balance_Premium = selectedVariables['G_Balance_Premium']
            G_XCharge = selectedVariables['G_XCharge']
            G_Survival_Benefit_Paid = selectedVariables['G_Survival_Benefit_Paid']
            G_NB_Conversion_Amount = selectedVariables['G_NB_Conversion_Amount']
            G_Basic_Death_Claim = selectedVariables['G_Basic_Death_Claim']
            G_Net_Payable_Amount = selectedVariables['G_Net_Payable_Amount']
            G_AB_Rider_SA = selectedVariables['G_AB_Rider_SA']
            G_FIB_Rider_SA = selectedVariables['G_FIB_Rider_SA']
            G_Interim_Bonus = selectedVariables['G_Interim_Bonus']
            G_USER = selectedVariables['G_USER']
            G_STEPUP_Rider_SA = selectedVariables['G_STEPUP_Rider_SA']
            G_EIC_Rider_SA = selectedVariables['G_EIC_Rider_SA']
            G_StepUp_Rider_Amount = selectedVariables['G_StepUp_Rider_Amount']
            G_EIC_Rider_Amount = selectedVariables['G_EIC_Rider_Amount']
            G_AB_Rider_Amount = selectedVariables['G_AB_Rider_Amount']
            G_FIB_Rider_Amount = selectedVariables['G_FIB_Rider_Amount']
            G_Annualized_Premium = selectedVariables['G_Annualized_Premium']
            G_Vested_Bonus = selectedVariables['G_Vested_Bonus']
            G_Calculation_Status = selectedVariables['G_Calculation_Status']
            G_Calculation_Remarks = selectedVariables['G_Calculation_Remarks']
            G_OnePercentOfSA_Amount = selectedVariables['G_OnePercentOfSA_Amount']
            G_OneTimePaymentAmount = selectedVariables['G_OneTimePaymentAmount']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
