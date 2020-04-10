package utilities.extent;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import selenium.execution.ExecutionHelper;
import utilities.common.Common;
import utilities.email.EmailHelper;

public class ExtentTestNGIReporterListener implements IReporter {

	public ExtentReports extent;

//    @Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		init(outputDirectory);

		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();

			for (ISuiteResult r : result.values()) {
				if (r.getTestContext().getName().contains("TDD")) {
					ITestContext context = r.getTestContext();

					buildTestNodes(context.getFailedTests(), Status.FAIL, context.getName());
					buildTestNodes(context.getSkippedTests(), Status.SKIP, context.getName());
					buildTestNodes(context.getPassedTests(), Status.PASS, context.getName());
				}
			}
		}
		extent.flush();
//	EmailHelper email = new EmailHelper();
//		email.sendMail();

	}

	private void init(String outputDirectory) {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
				outputDirectory + File.separator + ExecutionHelper.reportName);
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Call One");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setReportUsesManualConfiguration(true);
		extent.setSystemInfo("user", System.getProperty("user.name"));
		extent.setSystemInfo("os", "Windows 8");
		extent.setSystemInfo("URL", ExecutionHelper.url);
		extent.setSystemInfo("Environment", ExecutionHelper.envn);
		extent.setSystemInfo("Build Version", "1.0.0");
		extent.setSystemInfo("App Build Version", "1.0.0");

	}

	private void buildTestNodes(IResultMap tests, Status status, String con) {
		ExtentTest test;

		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				test = extent.createTest(result.getName(), result.getMethod().getDescription());
				for (String group : result.getMethod().getGroups())
					test.assignAuthor(group);
				test.assignCategory(con);
				String path = result.getAttribute("imagePath").toString();
				String errorAtr = result.getAttribute("error").toString();
				String[] list = Common.stringSepratedByTilde(errorAtr);
				for (String s : list) {
					if (!s.isEmpty()) {
						String[] logE = Common.stringSepratedByPercentage(s);
						if (logE[1].equals("pass"))
							test.log(Status.PASS, logE[0]);
						else if (logE[1].equals("fail"))
							test.log(Status.FAIL, logE[0]);
						else if (logE[1].equals("fatal"))
							test.log(Status.FATAL, logE[0]);
						else if (logE[1].equals("error"))
							test.log(Status.ERROR, logE[0]);
						else if (logE[1].equals("warning"))
							test.log(Status.WARNING, logE[0]);
						else if (logE[1].equals("info"))
							test.log(Status.INFO, logE[0]);
						else if (logE[1].equals("skip"))
							test.log(Status.SKIP, logE[0]);
					}
				}
				try {
					test.addScreenCaptureFromPath(path);
				} catch (IOException e) {
				}
				if (result.getThrowable() != null) {
					test.log(status, result.getThrowable());
				} else {
					test.log(status, "Test " + status.toString().toLowerCase() + "ed");
				}

				test.getModel().setStartTime(getTime(result.getStartMillis()));
				test.getModel().setEndTime(getTime(result.getEndMillis()));
			}
		}
	}

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
}
