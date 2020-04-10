package utilities.testNG;

import java.lang.reflect.Method;

import org.testng.ITest;
import org.testng.annotations.BeforeMethod;

import utilities.testNG.TestCase.UseAsTestName;


/**
 * @author Nitin
 */
public class TestBase implements ITest {
	private String testInstanceName = "";

	private void setTestName(String anInstanceName) {
		testInstanceName = anInstanceName;
	}

	public String getTestName() {
		return testInstanceName;
	}

	@BeforeMethod(alwaysRun = true)
	public void extractTestNameFromParameters(Method method, Object[] parameters) {

		if ((method != null) && (parameters != null)) {
			String methodname = method.getName();			
			setTestName(method.getName());
			UseAsTestName useAsTestName = method.getAnnotation(UseAsTestName.class);
			if (useAsTestName != null) {
				if (useAsTestName.idx() > parameters.length - 1) {
					// throw new IllegalArgumentException(
					// format("We have been asked to use an incorrect parameter
					// as a Test Case ID. The {0} annotation on method {1} is
					// asking us to use the parameter at index {2} in the array
					// and there are only {3} parameters in the array.",
					// UseAsTestName.class.getSimpleName(),
					// method.getName(), useAsTestName.idx(),
					// parameters.length));
				}
				Object parmAsObj = parameters[useAsTestName.idx()];
				if (!String.class.isAssignableFrom(parmAsObj.getClass())) {
					// throw new IllegalArgumentException(
					// format("We have been asked to use a parameter of an
					// incorrect type as a Test Case Name. The {0} annotation on
					// method {1} is asking us to use the parameter at index {2}
					// in the array that parameter is not usable as a string. It
					// is of type {3}",
					// UseAsTestName.class.getSimpleName(),
					// method.getName(), useAsTestName.idx(),
					// parmAsObj.getClass().getSimpleName()));
				}
				String testCaseId = (String) parameters[useAsTestName.idx()];
				testCaseId= methodname+"_"+testCaseId;
				setTestName(testCaseId);
				
				
//				if (useAsTestName.idx() < parameters.length - 1) {
//					Object parmAsObj = parameters[useAsTestName.idx()];
//					if (String.class.isAssignableFrom(parmAsObj.getClass())) {
//						String testCaseId = (String) parameters[useAsTestName.idx()];
//						testCaseId = methodname + "_" + testCaseId;
//						setTestName(testCaseId);
//					}
//				}
			}
		}
	}
}
