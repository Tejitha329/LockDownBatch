package com.erp.customer_scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.erp.utilities.BaseClass;
import com.erp.utilities.ExcelOperation;
import com.erp.webpages.ActiveProjectsAndCustomersPage;
import com.erp.webpages.AddNewCustomerPage;
import com.erp.webpages.OpenTaskPage;

public class CreateCustomer extends BaseClass {
@Test
	public void testCreateCustomer() throws EncryptedDocumentException, InvalidFormatException, IOException
    {
	 String customerName=ExcelOperation.readData("Sheet1",0,0);
	   log.info("**********Customer Name is fected from Excel*********");
	 OpenTaskPage otp=new OpenTaskPage();
	 otp.ClickOnProjectsandCustomersLink();
	   log.info("**********Projects And Customers Link is Clicked**********");
	 ActiveProjectsAndCustomersPage apcp=new ActiveProjectsAndCustomersPage();
     apcp.clickOnAddNewCustomerButton();
     log.info("**********Add New Customer Button is Clicked**********");
     AddNewCustomerPage ancp=new AddNewCustomerPage();
     ancp.enterCustomerName(customerName);
     log.info("**********Customer Name is Entered**********");
     ancp.clickOnCreateCustomerButton();
     log.info("**********Create Customer Button is Clicked**********");
     String s=apcp.retriveSuccessMessage();
     log.info("**********Success Message is retrived**********");
		System.out.println(s);
    }
	
}
