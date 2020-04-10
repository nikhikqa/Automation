package utilities.testNG;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import selenium.browser.BrowserDriver;
import selenium.browser.Browsers;
import selenium.execution.ExecutionHelper;
import utilities.common.Common;
import utilities.common.ReadWritePropertiesFile;
import utilities.extent.ReportLogs;


public class TestListener implements ITestListener {
	final static Logger logger = Logger.getLogger(TestListener.class);

	public void onFinish(ITestContext arg0) {
		logger.info("Test Cases Execution Finished ");
	}

	public void onStart(ITestContext arg0) {		
		ExecutionHelper.startTime = Common.getCurrentDateTime("yyyy-MM-dd HH:mm:ss");
		logger.info("Test Cases Execution Started");		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

	public void onTestFailure(ITestResult arg0) {
		String methodName = arg0.getName().toString().trim();
		String path = takeScreenShot(false);
		arg0.setAttribute("imagePath", path);
		arg0.setAttribute("error", ReportLogs.error);	
		String notes = methodName + " Test Case failed";
		logger.info(notes);
	}

	public void onTestSkipped(ITestResult arg0) {
		String methodName = arg0.getName().toString().trim();
		String path = takeScreenShot(false);
		arg0.setAttribute("imagePath", path);
		arg0.setAttribute("error", ReportLogs.error);	
		String notes = methodName + " Test Case skipped";
		logger.info(notes);

	}

	public void onTestStart(ITestResult arg0) {
//		ReportLogs.error = "";
		logger.info(arg0.getName().toString().trim() + " Test Case started");

	}

	public void onTestSuccess(ITestResult arg0) {
		String methodName = arg0.getName().toString().trim();
		String path = takeScreenShot(true);
		arg0.setAttribute("imagePath", path);
		arg0.setAttribute("error", ReportLogs.error);	
		String notes = methodName + " Test Case passed";
//		 TestlinkAPIClient.reportResult(testLinkURL, devKeyUser, project,
//		 testPlan, build, methodName, notes, result);
		logger.info(notes);
	}

	private String takeScreenShot(boolean isSuccess) {
		String methodName = "CloudSmartz";
		String filePath = "";
		String current = "";
		try {
			WebDriver driver = null;	
			driver = BrowserDriver.driver;
			if (driver != null) {
				
				String browserName = getBrowserName(driver);
				String d = Common.getCurrentDateTime();

				if (isSuccess)
					filePath = ".\\screenshots\\success\\" + browserName + "\\" + methodName + d + ".png";
				else
					filePath = ".\\screenshots\\failures\\" + browserName + "\\" + methodName + d + ".png";

				if (driver != null) {
					File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(scrFile, new File(filePath));
					current = ReadWritePropertiesFile.getIISProperty();
					filePath = Common.getFolderName(filePath);
					filePath = current + filePath;
				}
			}

		} catch (IOException e) {
			logger.info("error in takeScreenShot", e);

		}
		return filePath;

	}

	private String getBrowserName(WebDriver driver) {
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		if (browserName.equals(Browsers.IEXPLORER.getValue()))
			browserName = "internetexplorer";
		return browserName;
	}

//	private void startVideoRecording(String methodName) {
//		if (isRecordingAllowed) {
//			videoReord.startRecording(methodName);
//		}
//
//	}

//	private void stopVideoRecording() {
//		if (isRecordingAllowed) {
//			try {
//				Thread.sleep(10000);
//				videoReord.stopRecording();
//			} catch (InterruptedException e) {
//				logger.info("error in stopVideoRecording", e);
//			}
//		}
//	}

}

