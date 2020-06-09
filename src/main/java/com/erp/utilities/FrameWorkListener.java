package com.erp.utilities;


	
	import java.io.File;
import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Date;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.support.events.EventFiringWebDriver;
	import org.testng.ITestContext;
	import org.testng.ITestResult;
	import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.Status;
	import com.aventstack.extentreports.markuputils.ExtentColor;
	import com.aventstack.extentreports.markuputils.MarkupHelper;
	import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
	import com.aventstack.extentreports.reporter.configuration.Theme;






	public class FrameWorkListener extends TestListenerAdapter{
		//STep 1 create reef variables
		ExtentHtmlReporter reporter;//Declaration
		ExtentReports extent;
		ExtentTest test;
		
		
		public void onStart(ITestContext rv)
		{
		 //step 2 define report name 
		String date=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String reportName= "Test-Report"+date+".html";
		//STep 3 define report location---we should object of ExtentHtmlReporter, inside the object we 
	    //we should define the location
		reporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"//test-output//"+reportName);
		//Step 4 define the report title
		reporter.config().setDocumentTitle("DemoTitle");
		//STep 5 define the report name
		reporter.config().setReportName("Build 1 result");
		//step 6 set the theme
		reporter.config().setTheme(Theme.DARK);
		//step 7 give the report access to ExtentReports Class
		extent =new ExtentReports();
		extent.attachReporter(reporter);
		//step 8 enter the user details inside the report
		extent.setSystemInfo("QA","Sira");
		extent.setSystemInfo("Browser","Chrome 58");
		extent.setSystemInfo("OS","Win10");
		
		
	}
		 public void onFinish(ITestContext rv)
		 {
	     //step 14 save the changes
			 extent.flush();		 
		 }
		 public void onTestStart(ITestResult rv)
		 {
		    //STep 9 enter the test method name inside the report
			 test=extent.createTest(rv.getName());
			 
			 
		 }
		 public void onTestSuccess(ITestResult rv)
		 {
			 //sTEp 10:if method is pass enter the status and message inside the report
		 test.log(Status.PASS,MarkupHelper.createLabel("Successfully Executed", ExtentColor.GREEN));
		 }
		public void onTestFailure(ITestResult rv)
		{//step 11: if method is failed enter the status and message inside the report
			
			test.log(Status.FAIL,MarkupHelper.createLabel("method failed",ExtentColor.RED));
			
		//Step 12 take the SS, attach the SS inside the report
			EventFiringWebDriver efw=new EventFiringWebDriver(BaseClass.driver);
			File f1 = efw.getScreenshotAs(OutputType.FILE);
			String date=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			String path=System.getProperty("user.dir")+"//screenshots//"+date+".jpg";
			File f2=new File(path);
			
			try {
				FileUtils.copyFile(f1,f2);
		       test.addScreenCaptureFromPath(path);		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		 public void onTestSkipped(ITestResult rv)
		 {
			 //STep 13: if method skips add the status and message inside the report
			 test.log(Status.SKIP,MarkupHelper.createLabel("Method is skipped",ExtentColor.ORANGE));
		 }



}
