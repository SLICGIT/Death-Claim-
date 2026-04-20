package calendar


import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ObjectRepository as OR

import java.time.LocalDate
import java.time.format.DateTimeFormatter


class DateSelector {

	@Keyword
	def selectTodayDate(TestObject dateFieldObject) {
		// Get today's date
		LocalDate today = LocalDate.now()

		// Format date as DD/MM/YYYY
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
		String formattedDate = today.format(formatter)

		// Set value in the input field
		WebUI.setText(dateFieldObject, formattedDate)
	}
}