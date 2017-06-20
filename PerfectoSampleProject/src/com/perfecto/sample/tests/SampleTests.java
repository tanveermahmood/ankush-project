package com.perfecto.sample.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.perfecto.sample.pages.LoginscrTestPage;
import com.perfecto.sample.pages.TaskdetailsTestPage;
import com.perfecto.sample.pages.TasklistTestPage;
import com.perfecto.sample.utils.PerfectoUtilities;

import static com.qmetry.qaf.automation.core.ConfigurationManager.*;

import java.util.List;
import java.util.Map;
/**
 * 
 * @author ankush.agrawal
 *
 */
public class SampleTests {
	LoginscrTestPage loginPage;
	String taskName, taskDesc;

	// @Test
	// public void VerifyListOfItems() {
	//
	// LoginscrTestPage loginPage = new LoginscrTestPage();
	// loginPage.doLogin(getBundle().getString("login.user.email"),
	// getBundle().getString("login.user.password"));
	//
	// TasklistTestPage testpage = new TasklistTestPage();
	// testpage.printListofItems();
	// taskName=testpage.getTaskName();
	// taskDesc=testpage.getTaskDescription();
	// testpage.selectFirstTask();
	// testpage.zoomIn("Cairo");
	// QAFTestBase.pause(5000);

	// TaskdetailsTestPage taskdetailsTestPage=new TaskdetailsTestPage();
	// taskdetailsTestPage.verifyNameAndDescription(taskName,taskDesc);
	// taskdetailsTestPage.addNote();
	// taskdetailsTestPage.assignToMe();
	// }
/**
 * 
 * *
 * Test method start for here
 * *
 */
	@Test(enabled=true, description="Set device location using perfecto command and Verify distance",priority=1)
	public void LocationSet(){
	PerfectoUtilities.setDeviceLocationByAddress("Pune");
	PerfectoUtilities.openApplication("FieldService");
	loginPage = new LoginscrTestPage();
	loginPage.doLogin(getBundle().getString("login.user.email"), getBundle().getString("login.user.password"));	
	TasklistTestPage testpage = new TasklistTestPage();
	testpage.printListofItems();
	Map<String, String> previousLst=testpage.getDistance();
	taskName=testpage.getTaskName();
	taskDesc=testpage.getTaskDescription();	  

	PerfectoUtilities.closeApplication("FieldService");
    PerfectoUtilities.setDeviceLocationByAddress("Ahmedabad, Gujrat");
   
    PerfectoUtilities.openApplication("FieldService");
	loginPage.doLogin(getBundle().getString("login.user.email"), getBundle().getString("login.user.password"));	
	Map<String, String> updatedLst=testpage.getDistance();
	testpage.printListofItems();
	taskName=testpage.getTaskName();
	taskDesc=testpage.getTaskDescription();
	testpage.VerifyUpdatedDistance(previousLst, updatedLst);
  	
}
	
	@Test(description="Add Note by taking camera picture",priority=2)
	public void Test2(){
		PerfectoUtilities.openApplication("FieldService");
		LoginscrTestPage loginPage = new LoginscrTestPage();
		loginPage.doLogin(getBundle().getString("login.user.email"), getBundle().getString("login.user.password"));	
		TasklistTestPage tasklistTestPage=new TasklistTestPage();
		tasklistTestPage.selectFirstTask();
		TaskdetailsTestPage taskdetailsTestPage=new TaskdetailsTestPage();
		taskdetailsTestPage.verifyTaskDetailsPage();
		taskdetailsTestPage.attachPhoto();
		//taskdetailsTestPage.assignToMe();
		taskdetailsTestPage.start();
		
	}
}
