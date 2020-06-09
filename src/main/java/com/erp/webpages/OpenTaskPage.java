package com.erp.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.erp.utilities.BaseClass;

public class OpenTaskPage {

	
@FindBy(linkText="Projects & Customers")	
private	WebElement projectsAndCustomersLink;
	
	

public OpenTaskPage()
{
	PageFactory.initElements(BaseClass.driver,this);
}
	
	
	
	
	public void ClickOnProjectsandCustomersLink()
	{
		projectsAndCustomersLink.click();
	}

}
