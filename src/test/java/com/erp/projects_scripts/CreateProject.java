package com.erp.projects_scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.erp.utilities.BaseClass;
import com.erp.utilities.ExcelOperation;
import com.erp.webpages.ActiveProjectsAndCustomersPage;
import com.erp.webpages.AddNewProjectPage;
import com.erp.webpages.OpenTaskPage;

public class CreateProject extends BaseClass {
	@Test
	public void testCreateProject() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
	  String customername=ExcelOperation.readData("Sheet1",0,0);
	   log.info("**********Customer Name is fetched from Excel**********");
	  String projectname=ExcelOperation.readData("Sheet1",0,1);
	   log.info("**********Project Name is Fetched from Excel**********");
	OpenTaskPage otp=new OpenTaskPage();
	otp.ClickOnProjectsandCustomersLink();
	   log.info("**********Projects and Customers Link is Clicked**********");
	ActiveProjectsAndCustomersPage apcp=new ActiveProjectsAndCustomersPage();
	apcp.clickOnAddNewProjectButton();
	   log.info("**********Add New Project Button is Clicked**********");
	AddNewProjectPage anpp=new AddNewProjectPage();
	anpp.selectCustomerFromDropdown(customername);
	   log.info("**********Customer is Selected from the dropdown**********");
	anpp.enterProjectName(projectname);
	   log.info("**********Project Name is entered**********");
	anpp.clickOnCreateProjectButton();
	   log.info("**********Create Project Button is clicked**********");
	String s=apcp.retriveSuccessMessage();
	   log.info("**********Success Message is retrived**********");
	System.out.println(s);
	
	}
	
}
	
	

