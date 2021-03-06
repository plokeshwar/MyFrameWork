package com.overture.npc.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.overture.npc.common.PageControls;

public class QuestionsPage extends PageControls {
	
	WebDriver driver;
	 public QuestionsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}


	public By QUESTION_TABLE = By.xpath("//table[@id='categoryTable']");
	 public By STUDENT_INFORMATION_LINK = By.xpath("//table[@id='categoryTable']//a[contains(.,'Student Information')]");
	 public By PARENT_HOUSEHOLD_LINK = By.xpath("//table[@id='categoryTable']//a[contains(.,'Parent Household')]");
	 public By PARENT_INCOME_LINK = By.xpath("//table[@id='categoryTable']//a[contains(.,'Parent Income')]");
	 public By PARENT_ASSET_LINK = By.xpath("//table[@id='categoryTable']//a[contains(.,'Parent Assets')]");
	 public By STUDENT_FINANCES_LINK = By.xpath("//table[@id='categoryTable']//a[contains(.,'Student Finances')]");
	 public By MANAGE_CUSTOM_BUTTON = By.xpath("//a[contains(.,'Manage Custom Lists')]");
	
	 public String assertText(String expected, String actual, By by) {
			ReporterTextBold("Actual ["+actual+"] : Expected ["+expected+"]");
			if (expected.equalsIgnoreCase(actual)) {
				return captureElementScreenShot(by);
			} else {
				return captureDriverScreenShot();
			}
		}
	 
	 public void clickManageCustomButton(){
		 click(MANAGE_CUSTOM_BUTTON);
		 ReporterText("Clicked on Manage Custom Button.");
	 }
	 
	 public StudentInformationPage clickStudentInformationLink(){
		 click(STUDENT_INFORMATION_LINK);
		 ReporterText("Clicked on Student Information Link.");
		 return new StudentInformationPage(driver);
	 }
	 
	 public void clickParentHouseholdLink(){
		 click(PARENT_HOUSEHOLD_LINK);
		 ReporterText("Clicked on Parent Household Link.");
	 }
	 
	 public void clickParentIncomeLink(){
		 click(PARENT_INCOME_LINK);
		 ReporterText("Clicked on Parent Income Link.");
	 }
	
	 public void clickParentAssetLink(){
		 click(PARENT_ASSET_LINK);
		 ReporterText("Clicked on Parent Assets Link.");
	 }
	 
	 public void clickStudentFinancesLink(){
		 click(STUDENT_FINANCES_LINK);
		 ReporterText("Clicked on Student Finances Link.");
	 }
	 
	 public ArrayList<String> getExpectedArrayList(String text){
			return createArrayList(text);
		}
    
	 public ArrayList<String> getAllQuestionTableLinks(){
			return getAllLinksByClass(QUESTION_TABLE);
		}
	 
}
