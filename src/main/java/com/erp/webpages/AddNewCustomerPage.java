package com.erp.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.erp.utilities.BaseClass;

public class AddNewCustomerPage {
  
     @FindBy(name="name")
	private WebElement customerNameTextfield;
	
	
     @FindBy(name="createCustomerSubmit")
	private WebElement createCustomerButton;
	
	
	
	public AddNewCustomerPage()
	{
		PageFactory.initElements(BaseClass.driver,this);
	}
	public void enterCustomerName(String customerName)
	{
		customerNameTextfield.sendKeys(customerName);
		
	}
	
	public void clickOnCreateCustomerButton()
	{
		createCustomerButton.click();
	}
}