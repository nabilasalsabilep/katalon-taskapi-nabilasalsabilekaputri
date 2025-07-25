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

def response = WS.sendRequest(findTestObject('GetListOfBooks'))

WS.verifyResponseStatusCode(response, 200)

def books = new JsonSlurper().parseText(response.getResponseBodyContent())

assert books.size() >= 3 : "Expected at least 3 books but got ${json.size()}"

def firstBook = books[0]

assert firstBook.title != null : "Title is null"

assert firstBook.bookId != null : "bookId is null"

assert firstBook.author != null : "Author is null"

assert firstBook.price > 0 : "Price is invalid"

assert firstBook.category != null : "Category is null"

GlobalVariable.bookId = firstBook.bookId

GlobalVariable.bookTitle = firstBook.title

GlobalVariable.bookPrice = firstBook.price

GlobalVariable.bookAuthor = firstBook.author

GlobalVariable.bookCategory = firstBook.category

return books