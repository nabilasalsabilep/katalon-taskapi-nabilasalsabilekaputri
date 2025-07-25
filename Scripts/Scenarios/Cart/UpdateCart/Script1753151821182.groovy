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
import groovy.json.JsonSlurper as JsonSlurper

WebUI.callTestCase(findTestCase('Blocks/ListOfCarts/GetListOfCarts'), [:], FailureHandling.STOP_ON_FAILURE)

def response = WS.sendRequest(findTestObject('UpdateCart'))

WS.verifyResponseStatusCode(response, 200)

def cartAfter = new JsonSlurper().parseText(response.getResponseBodyContent())

assert GlobalVariable.bookId == cartAfter[0].book.bookId

assert GlobalVariable.bookTitle == cartAfter[0].book.title

assert (GlobalVariable.bookAuthor) == cartAfter[0].book.author

assert (GlobalVariable.bookPrice) == cartAfter[0].book.price

def targetBookAfter = cartAfter.find({ 
        it.book.bookId == GlobalVariable.bookId
    })

int quantityAfter

assert quantityAfter == (GlobalVariable.bookQty - 1)

println("✅ Quantity successfully reduced from $GlobalVariable.bookQty to $quantityAfter")

