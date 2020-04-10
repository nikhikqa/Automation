//package selenium.execution;
//
//import java.io.File;
//import java.util.List;
//
//import org.apache.log4j.PropertyConfigurator;
//import org.testng.TestNG;
//import com.beust.jcommander.internal.Lists;
//
//import app.services.employee.EmployeeUserDetails;
//import utilities.common.Common;
//import utilities.common.ReadWritePropertiesFile;
//import utilities.thread.ThreadDemo;
//
//
////import org.openqa.selenium.Platform;
////import org.openqa.selenium.chrome.ChromeDriver;
////import org.openqa.selenium.chrome.ChromeOptions;
////import org.openqa.selenium.remote.DesiredCapabilities;
////import org.openqa.selenium.remote.RemoteWebDriver;
////
////import java.net.MalformedURLException;
////import java.net.URL;
//
//
//
//
//public class MainClass {
//
//	public static void main(String args[]) {
////		
////		String s1="hello"; 
////		String s2 = "";
////		char[] ch=s1.toCharArray();  
////		for(int i=0;i<ch.length;i++)  
////		System.out.println(ch[i]); 
////		for( int j = ch.length-1;j>=0;j--){
////			s2 += ch[j];
////		}
////		System.out.println(s2);
//			
////		ThreadDemo T1 = new ThreadDemo( "Thread-1");
////	      T1.start();
//	     
////	      ThreadDemo T2 = new ThreadDemo( "Thread-2");
////	      T2.start();
////		EmployeeUserDetails emp = new EmployeeUserDetails();
////		emp.getEmployeeUserDetails("komalemp_test7@aquacomms.loc");
//
////		// PdfRead.readPDF();
////		try {
//////			File file = new File("D:\\Workspace\\selenium-acumen-testng\\driver\\chromedriver.exe");
//////			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
//////			System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
////		     
////			String URL = "http://www.DemoQA.com";
////			String Node = "http://192.168.0.101:4444/wd/hub";
////			DesiredCapabilities capa = DesiredCapabilities.chrome();
////			
////			capa.setBrowserName("chrome");
////			capa.setPlatform(Platform.WIN10);
//////			driver = new ChromeDriver();
////
////			driver = new RemoteWebDriver(new URL(Node), capa);
////
////			driver.navigate().to(URL);
////			Thread.sleep(5000);
////			driver.quit();
////		} catch (Exception e) {
////			System.out.println(e);
////		}
//
//
//
////		String d = Common.getCurrentDateTime();
////		String testoutput = "testng_output_" + d;
////		String testOutputPath = ".//" + testoutput;
////		ExecutionHelper.testoutput = testOutputPath;
////		new File(testOutputPath).mkdir();
////		TestNG testng = new TestNG();
////		PropertyConfigurator.configure("src/main/resources/log4j.properties");
////		testng.setOutputDirectory(testOutputPath);
////		ReadWritePropertiesFile.setTestOutPutProperty("testng_output", testoutput);
////		List<String> suites = Lists.newArrayList();
////		suites.add(".//testng.xml");
////		testng.setTestSuites(suites);
////		testng.run();
//
//		
//		
//		
//		}
//
//}
