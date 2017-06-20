package com.perfecto.sample.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.perfecto.sample.components.TaskComponent;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;

public class TasklistTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "tasklist.cmp.tasks")
	private List<TaskComponent> tasklistCmpTasks;
	
	@FindBy(locator = "tasklist.map.targetPlace")
	private QAFWebElement tasklistMapTargetPlace;


	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public List<TaskComponent> getTasklistCmpTasks() {
		return tasklistCmpTasks;
	}
	
	public QAFWebElement getTasklistMapTargetPlace(String place) {
		QAFExtendedWebElement tasklistMapTargetPlace=new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getPropertyValue("tasklist.map.targetPlace"), place));
		return tasklistMapTargetPlace;
	}

	public void printListofItems() {
		System.out.println("Number of components: " + getTasklistCmpTasks().size());

		int i = 0;

		for (TaskComponent testpage : getTasklistCmpTasks()) {
			i++;
			System.out.println("name " + testpage.getTaskLnkName(i).getText() + "\n Description : "
					+ testpage.getTaskLblDescription(i).getText() + "\n distance"
					+ testpage.getTaskLblDistance(i).getText() + "\n");

		}
	}

	
	public Map<String, String> getDistance() {
		System.out.println("Number of components: " + getTasklistCmpTasks().size());

		int i = 0;
		Map<String, String> s=new HashMap<>();
		for (TaskComponent testpage : getTasklistCmpTasks()) {
			i++;
			System.out.println("\n distance"
					+ testpage.getTaskLblDistance(i).getText() + "\n"+"name " + testpage.getTaskLnkName(i).getText());
			s.put( testpage.getTaskLblDistance(i).getText(),testpage.getTaskLnkName(i).getText());

		}
		return s;
		
	}
	
public void VerifyUpdatedDistance(Map<String, String> previousLst, Map<String, String> updatedLst){
	if(!previousLst.equals(updatedLst)){
		System.out.println("location has been updated");
	}else{
		System.out.println("location has not been updated");
	}
}
	

	public void selectFirstTask() {
		getTasklistCmpTasks().get(0).getTaskLnkName(1).click();
	
	}
	
	public String getTaskName() {
		return getTasklistCmpTasks().get(0).getTaskLnkName(1).getText();
	}
	
	public String getTaskDescription() {
		return getTasklistCmpTasks().get(0).getTaskLblDescription(1).getText();
	}

	public void zoomIn(String place) {
		((AppiumDriver)driver.getUnderLayingDriver()).zoom(getTasklistMapTargetPlace(place));
	}

	
}
