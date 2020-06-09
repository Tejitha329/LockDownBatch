package com.erp.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.erp.utilities.BaseClass;

public class ActiveProjectsAndCustomersPage {

 @FindBy(xpath="//input[@value='Add New Customer']")
 private WebElement addNewCustomerButton;
	
 @FindBy(xpath="//input[@value='Add New Project']")
 private WebElement addNewProjectButton;
 
 
 @FindBy(className="successmsg")
private	WebElement successMessage;
	
	public ActiveProjectsAndCustomersPage()
	{
		PageFactory.initElements(BaseClass.driver,this);
	}
	
	
	public void clickOnAddNewCustomerButton()
	{
		addNewCustomerButton.click();
	}
	
	
	public String retriveSuccessMessage()
	{
		String s=successMessage.getText();	
		return s;
	}

	
	public  void clickOnAddNewProjectButton()
	{
		
	 addNewProjectButton.click();	
	}
}