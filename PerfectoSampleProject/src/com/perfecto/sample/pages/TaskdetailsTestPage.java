package com.perfecto.sample.pages;

import org.hamcrest.Matchers;
import org.testng.Reporter;

import com.google.inject.matcher.Matcher;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

import io.appium.java_client.AppiumDriver;

public class TaskdetailsTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "taskDetails.lbl.name")
	private QAFWebElement taskDetailsLblName;
	@FindBy(locator = "taskDetails.lbl.description")
	private QAFWebElement taskDetailsLblDescription;
	@FindBy(locator = "taskDetails.txtbox.note")
	private QAFWebElement taskDetailsTxtboxNote;
	@FindBy(locator = "taskDetails.btn.assign")
	private QAFWebElement taskDetailsBtnAssign;
	@FindBy(locator = "taskDetails.header.lbl.details")
	private QAFWebElement taskDetailsHeaderLblDetails;
	@FindBy(locator = "taskDetails.btn.addPhoto")
	private QAFWebElement taskdetailsBtnAddphoto;
	@FindBy(locator = "taskDetails.btn.takePhoto")
	private QAFWebElement taskdetailsBtnTakephoto;
	@FindBy(locator = "taskDetails.btn.clickoncamera")
	private QAFWebElement taskdetailsBtnClickoncamera;
	@FindBy(locator = "taskDetails.btn.usePhoto")
	private QAFWebElement taskdetailsBtnUsephoto;
	@FindBy(locator = "taskDetails.img.verifyImg")
	private QAFWebElement taskdetailsImgVerifyimg;
	
	@FindBy(locator = "taskDetails.btn.Start")
	private QAFWebElement startBtn;
	
	

	public QAFWebElement getStartBtn() {
		return startBtn;
	}

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getTaskDetailsLblName() {
		return taskDetailsLblName;
	}

	public QAFWebElement getTaskDetailsLblDescription() {
		return taskDetailsLblDescription;
	}

	public QAFWebElement getTaskDetailsTxtboxNote() {
		return taskDetailsTxtboxNote;
	}

	public QAFWebElement getTaskDetailsBtnAssign() {
		return taskDetailsBtnAssign;
	}

	public QAFWebElement getTaskDetailsHeaderLblDetails() {
		return taskDetailsHeaderLblDetails;
	}

	public boolean verifyTaskDetailsPage() {
		return getTaskDetailsHeaderLblDetails().verifyVisible();
	}

	public void verifyNameAndDescription(String taskName, String taskDescription) {

		Validator.verifyThat("verifying the actual task name ", getTaskDetailsLblName().getText().trim(),
				Matchers.containsString(taskName));
		Validator.verifyThat("verifying the actual task description", getTaskDetailsLblDescription().getText().trim(),
				Matchers.containsString(taskDescription));

	}

	public void addNote() {
		getTaskDetailsTxtboxNote().clear();
		getTaskDetailsTxtboxNote().sendKeys("Assignment is done");
		//((AppiumDriver)driver.getUnderLayingDriver()).hideKeyboard();
	}

	public void attachPhoto(){
		getTaskdetailsBtnAddphoto().click();
		getTaskdetailsBtnTakephoto().click();
		getTaskdetailsBtnClickoncamera().click();
		getTaskdetailsBtnUsephoto().click();
		getTaskdetailsImgVerifyimg().isPresent();
		getTaskdetailsImgVerifyimg().waitForPresent();
		com.qmetry.qaf.automation.util.Reporter.logWithScreenShot("Image has been added succesfully");
		//Reporter.log("Image has been added succesfully");
		
	}
	public void assignToMe() {
		getTaskDetailsBtnAssign().click();
		
	}

	public void start() {
		getStartBtn().click();
		
	}

	public QAFWebElement getTaskdetailsBtnAddphoto() {
		return taskdetailsBtnAddphoto;
	}

	public QAFWebElement getTaskdetailsBtnTakephoto() {
		return taskdetailsBtnTakephoto;
	}

	public QAFWebElement getTaskdetailsBtnClickoncamera() {
		return taskdetailsBtnClickoncamera;
	}

	public QAFWebElement getTaskdetailsBtnUsephoto() {
		return taskdetailsBtnUsephoto;
	}

	public QAFWebElement getTaskdetailsImgVerifyimg() {
		return taskdetailsImgVerifyimg;
	}

}
