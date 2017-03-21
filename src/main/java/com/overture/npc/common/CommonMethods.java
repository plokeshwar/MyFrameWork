package com.overture.npc.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class CommonMethods extends Reporting {
	
	public void closeBrowser(){
		WebDriverManager.removeWebDriver();
	}
	
	public String generateRandomString(){
		return "Random"+String.valueOf(System.currentTimeMillis());
	}

	public ArrayList<String> getColumnHeaderByTable(WebElement table) {
		ArrayList<String> stringList=null;
		List<WebElement> anchors = table.findElements(By.tagName("th"));
		 Iterator<WebElement> i = anchors.iterator(); 
		 stringList = new ArrayList<String>();
		 while(i.hasNext()) { 
			 WebElement anchor = i.next(); 
			 stringList.add(anchor.getText());
		 }
	ReporterText("Actual Link List : "+stringList);
	return stringList;
	}
	
}
