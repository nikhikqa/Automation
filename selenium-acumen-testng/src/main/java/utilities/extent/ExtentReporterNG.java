/*package utilities.extent;
//package utilities.entent;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
//import org.testng.IReporter;
//import org.testng.IResultMap;
//import org.testng.ISuite;
//import org.testng.ISuiteResult;
//import org.testng.ITestContext;
//import org.testng.ITestResult;
//import org.testng.xml.XmlSuite;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//
//import utilities.common.Common;
//
////import com.relevantcodes.extentreports.ExtentReports;
////import com.relevantcodes.extentreports.ExtentTest;
////import com.relevantcodes.extentreports.LogStatus;
//
////import net.cloudsmartz.common.Common;
//
///**
// * @author amit.kapilas
// 
public class ExtentReporterNG implements IReporter {
	private ExtentReports extent;

//	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
//		extent = new ExtentReports(outputDirectory + File.separator + "PEN_GUI_Automation_Report.html", true);
//		extent.loadConfig(new File(".\\extent\\extent-config.xml"));
//		extent.addSystemInfo("Selenium Version", "3.4");
//		extent.addSystemInfo("Environment", env);
//		extent.addSystemInfo("Created By", "CloudSmartz");
//		for (ISuite suite : suites) {
//			Map<String, ISuiteResult> result = suite.getResults();
//			for (ISuiteResult r : result.values()) {
//				ITestContext context = r.getTestContext();
//				String errorFailed = buildTestConfigurations(context.getFailedConfigurations());
//				String errorSkipped = buildTestConfigurations(context.getSkippedConfigurations());
//				if ((!errorFailed.isEmpty()) && (!errorSkipped.isEmpty())) {
//					error = errorSkipped + "; " + errorFailed;
//				} else if (!errorSkipped.isEmpty())
//					error = errorSkipped;
//				else if (!errorFailed.isEmpty())
//					error = errorFailed;
//
//				buildTestNodes(context.getPassedTests(), LogStatus.PASS, context.getName());
//				buildTestNodes(context.getFailedTests(), LogStatus.FAIL, context.getName());
//				buildTestNodes(context.getSkippedTests(), LogStatus.SKIP, context.getName());
//			}
//		}
//		extent.flush();
//		extent.close();
//		EmailHelper mail = new EmailHelper();
//		mail.sendMailToManagement();
//	}
//
//	private void buildTestNodes(IResultMap tests, LogStatus status, String con) {
//		ExtentTest test;
//		for (ITestResult result : tests.getAllResults()) {
//			test = extent.startTest(result.getName(), result.getMethod().getDescription());
//			test.setStartedTime(getTime(result.getStartMillis()));
//			test.setEndedTime(getTime(result.getEndMillis()));
//			for (String group : result.getMethod().getGroups())
//				test.assignAuthor(group);
//			test.assignCategory(con);
//			String path = result.getAttribute("imagePath").toString();
//			String errorAtr = result.getAttribute("error").toString();
//			String[] list = Common.stringSepratedByTilde(errorAtr);
//			for (String s : list) {
//				if (!s.isEmpty()) {
//					String[] logE = Common.stringSepratedByPercentage(s);
//					if (logE[1].equals("pass"))
//						test.log(LogStatus.PASS, logE[0], "Step Passed");
//					else if (logE[1].equals("fail"))
//						test.log(LogStatus.FAIL, logE[0], "Step Failed");
//					else if (logE[1].equals("fatal"))
//						test.log(LogStatus.FATAL, logE[0], "Step Fatal");
//					else if (logE[1].equals("error"))
//						test.log(LogStatus.ERROR, logE[0], "Step Error");
//					else if (logE[1].equals("warning"))
//						test.log(LogStatus.WARNING, logE[0], "Step Warned");
//					else if (logE[1].equals("info"))
//						test.log(LogStatus.INFO, logE[0], "Step Info");
//					else if (logE[1].equals("skip"))
//						test.log(LogStatus.SKIP, logE[0], "Step Skipped");
//				}
//			}
//			String image = test.addScreenCapture(path);
//			if (result.getStatus() == ITestResult.FAILURE)
//				test.log(status, image, result.getThrowable());
//			else if (result.getStatus() == ITestResult.SKIP) {
//				if (error.isEmpty())
//					test.log(status, "Test skipped ");
//				else
//					test.log(status, error);
//
//			} else
//				test.log(status, image, "Test passed ");
//			extent.endTest(test);
//		}
//	}
//
////	private String buildTestConfigurations(IResultMap tests) {
////		String error = "";
////		for (ITestResult result : tests.getAllResults()) {
////			if (result.getThrowable() != null) {
////				error = "" + result.getThrowable();
////				error = Common.stringSepratedByColonAndGetSecondChild(error);
////			}
////		}
////		return error;
////	}
////
////	private Date getTime(long millis) {
////		Calendar calendar = Calendar.getInstance();
////		calendar.setTimeInMillis(millis);
////		return calendar.getTime();
////	}
////	}
//}
*/