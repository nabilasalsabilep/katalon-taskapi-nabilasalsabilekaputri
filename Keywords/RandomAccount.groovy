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

public class RandomAccount {
	@Keyword
	def generateRandomUsername(String prefix = "testuser") {
		Random rand = new Random()
		int randomNumber = rand.nextInt(1000) + 100
		String username = "${prefix}@${randomNumber}"
		return username
	}
	
	@Keyword
	def generateValidPassword(int length = 10) {
        String upper = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
        String lower = 'abcdefghijklmnopqrstuvwxyz'
        String digits = '0123456789'
        String all = upper + lower + digits

        Random rand = new Random()

        String password = ''
        password += upper.charAt(rand.nextInt(upper.length()))
        password += lower.charAt(rand.nextInt(lower.length()))
        password += digits.charAt(rand.nextInt(digits.length()))

        for (int i = 3; i < length; i++) {
            password += all.charAt(rand.nextInt(all.length()))
        }

        return password.toList().sort { rand.nextInt() }.join()
    }
}
