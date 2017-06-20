package com.perfecto.sample.components;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class TaskComponent extends QAFWebComponent {

	public TaskComponent(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}

	@FindBy(locator = "task.lnk.name")
	private QAFWebElement taskLnkName;
	@FindBy(locator = "task.lbl.description")
	private QAFWebElement taskLblDescription;
	@FindBy(locator = "task.lbl.distance")
	private QAFWebElement taskLblDistance;

	
	public QAFWebElement getTaskLnkName(int num) {
		QAFExtendedWebElement taskLnkName=new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getPropertyValue("task.lnk.name"), num));
		return taskLnkName;
	}

	public QAFWebElement getTaskLblDescription(int num) {
		QAFExtendedWebElement taskLblDescription=new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getPropertyValue("task.lbl.description"),num));

		
		return taskLblDescription;
	}

	public QAFWebElement getTaskLblDistance(int num) {
		QAFExtendedWebElement taskLblDistance=new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getPropertyValue("task.lbl.distance"),num));

		
		return taskLblDistance;
	}

}
