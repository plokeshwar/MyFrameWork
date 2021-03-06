package com.overture.npc.pages;

import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.overture.npc.common.PageControls;

public class SchoolPreviewPage extends PageControls {
	WebDriver driver;
	
	public SchoolPreviewPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}
	 
	public By ADD_TEST_CASE_BUTTON = By.xpath("//input[@id='addTestCase']");
	public By HEADER_TEXT = By.xpath("//div[@class='subHeader']");
	public By PREVIEW_TABLE = By.xpath("//table[@id='preview-list']");
	public By PREVIEW_EDIT_CANCEL_BUTTON = By.xpath("//form[@id='testFile']//input[@value='Cancel']");
	
	public By NAME_EDIT_BOX = By.xpath("//form[@id='testFile']//input[@id='name']");
	public By CANCEL_BUTTON = By.xpath("//form[@id='testFile']//input[@value='Cancel']");
	public By SAVE_BUTTON = By.xpath("//form[@id='testFile']//input[@value='Save']");
	public By ERROR_MESSAGE = By.xpath("//form[@id='testFile']//span[@id='name.errors']");
	public By DELETE_BUTTON = By.xpath("//input[@value='Delete']");
	 
	 
	public void enterTestCaseName(String testData){
		type(NAME_EDIT_BOX, testData);
		ReporterText("Entered test case name = "+testData);
	}
	
	public void clickCancelButton(){
		click(CANCEL_BUTTON);
		ReporterText("Clicked on Cancel Button.");
	}
	
	public void clickSaveButton(){
		click(SAVE_BUTTON);
		ReporterText("Clicked on Save Button.");
	}
	
	public void clickDeleteButton(){
		click(DELETE_BUTTON);
		ReporterText("Clicked on Delete Button.");
	}
	
	public void clickAddTestCase(){
		click(ADD_TEST_CASE_BUTTON);
		ReporterText("Clicked on Add Test Case Button.");
	}
	
	public String getHeaderText(){
		String tmp = getText(HEADER_TEXT);
		ReporterText("Getting Sub Header Text = "+tmp);
		return tmp;
	}
	
	public String getMessageText(){
		String tmp = getText(ERROR_MESSAGE);
		ReporterText("Getting Message Text = "+tmp);
		return tmp;
	}
	
	public ArrayList<String> generateArrayList(String testdata){
		return createArrayList(testdata);
	}
	
	public ArrayList<String> getColumnHeader(){
		return getColumnHeaderByTable(waitForElement(PREVIEW_TABLE));
	}
	
	public String assertText(String expected, String actual, By by) {
		ReporterTextBold("Actual ["+actual+"] : Expected ["+expected+"]");
		if (expected.equalsIgnoreCase(actual)) {
			return captureElementScreenShot(by);
		} else {
			return captureDriverScreenShot();
		}
	}
	
	public String assertText(String expected, String actual) {
		ReporterTextBold("Actual ["+actual+"] : Expected ["+expected+"]");
		if (expected.equalsIgnoreCase(actual)) {
			return captureDriverScreenShot();
		}
		return null;
	}
	
	public String assertText(String expected, String actual, WebElement el) {
		ReporterTextBold("Actual ["+actual+"] : Expected ["+expected+"]");
		if (expected.equalsIgnoreCase(actual)) {
			return captureElementScreenShot(el);
		} else {
			return captureDriverScreenShot();
		}
	}
    
	public String assertText(ArrayList<String> expected, ArrayList<String> actual, By by) {
		ReporterTextBold("Actual ["+actual+"] : Expected ["+expected+"]");
		if (expected.contains(actual)) {
			return captureElementScreenShot(by);
		} else {
			return captureDriverScreenShot();
		}
	}
	
	public String getAlertPopupText(){
		return getAlertText();
	}

	public void acceptAlertPopup(){
		acceptAlert();
	}
	
	public void dismissAlertPopup(){
		dismissAlert();
	}
}
