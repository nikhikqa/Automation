package selenium.execution;

import java.io.File;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.cucumber.listener.ExtentProperties;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import utilities.common.Common;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/features/", glue = "step_definitions", plugin = {
		"com.cucumber.listener.ExtentCucumberFormatter:" }, tags = { "@SmokeTest" })

public class ExecutionManager extends AbstractTestNGCucumberTests {
	@BeforeClass
	@Parameters({ "baseURL", "env", "suite" })
	public static void setup(String baseURL, String env, String suite) throws InterruptedException {

		ExecutionHelper.url = baseURL;
		ExecutionHelper.envn = env;
		String d = Common.getCurrentDateTime();
		ExecutionHelper.testoutput = "testng_output_" + d;
		String testOutputPath = ".//" + ExecutionHelper.testoutput;
		ExecutionHelper.startTime = Common.getCurrentDateTime("yyyy-MM-dd HH:mm:ss");
		new File(testOutputPath).mkdir();
		String output = ExecutionHelper.testoutput + "/" + ExecutionHelper.reportName;
		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
		extentProperties.setReportPath(output);
	}

	@AfterClass
	public static void tearDown() {

		System.out.println("Test cases are finished");

	}
}
