package ExtentReport;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentTestNGITestListener implements ITestListener  {

		private static ExtentReports extent = ExtentManager.createInstance("extent.html");
		private static ThreadLocal parentTest = new ThreadLocal();
	    private static ThreadLocal test = new ThreadLocal();
		
	    @Override
		public synchronized void onStart(ITestContext context) {
	    	ExtentTest parent = extent.createTest(getClass().getName());
	        parentTest.set(parent);
		}

		@Override
		public synchronized void onFinish(ITestContext context) {
			extent.flush();
		}
		
		@Override
		public synchronized void onTestStart(ITestResult result) {
			ExtentTest child = parentTest.get().createNode(result.getMethod().getMethodName());
	        test.set(child);
		}

		@Override
		public synchronized void onTestSuccess(ITestResult result) {
			test.get().pass("Test passed");
		}

		@Override
		public synchronized void onTestFailure(ITestResult result) {
			test.get().fail(result.getThrowable());
		}

		@Override
		public synchronized void onTestSkipped(ITestResult result) {
			test.get().skip(result.getThrowable());
		}

		@Override
		public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			
		}
	

	
	}


