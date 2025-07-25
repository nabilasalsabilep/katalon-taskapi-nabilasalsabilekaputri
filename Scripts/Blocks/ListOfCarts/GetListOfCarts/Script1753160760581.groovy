import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
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
import groovy.json.JsonSlurper


def response = WS.sendRequest(findTestObject('GetListOfCarts'))

WS.verifyResponseStatusCode(response, 200)

def carts = new JsonSlurper().parseText(response.getResponseBodyContent())

assert carts instanceof List : "Response is not a list"

assert carts.size() >= 0 : "Cart response is empty or invalid"

carts.each { item ->
	assert item.book != null : "Book object is null"
	assert item.book.bookId != null : "Book ID is missing"
	assert item.book.title != null : "Book title is missing"
	assert item.book.author != null : "Book author is missing"
	assert item.book.price > 0 : "Book price is invalid"
	assert item.quantity >= 0 : "Quantity should be >= 0"
}

if (carts.size() > 0) {
	GlobalVariable.bookId = carts[0].book.bookId
	GlobalVariable.bookTitle = carts[0].book.title
	GlobalVariable.bookAuthor = carts[0].book.author
	GlobalVariable.bookPrice = carts[0].book.price
	GlobalVariable.bookQty = carts[0].quantity
	println("✅ bookId stored: ${GlobalVariable.bookId}")
	println("✅ bookTitle stored: ${GlobalVariable.bookTitle}")
	println("✅ bookTitle stored: ${GlobalVariable.bookAuthor}")
	println("✅ bookTitle stored: ${GlobalVariable.bookPrice}")
	println("✅ bookTitle stored: ${GlobalVariable.bookQty}")
}
