package Genericutility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;




public class Listenerimplementatation implements ITestListener{

	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String metohdName = result.getMethod().getMethodName();
		System.out.println(metohdName+"->@Test Execution started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String metohdName = result.getMethod().getMethodName();
		System.out.println(metohdName+"->@Test is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String metohdName = result.getMethod().getMethodName();
		System.out.println(metohdName+"->@Test is fail");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String metohdName = result.getMethod().getMethodName();
		System.out.println(metohdName+"->@Test is skip");
		//capture the exception
		System.out.println(result.getThrowable());
		
		
		//capturescreenshot
		
		SeleniumUtility s=new SeleniumUtility();
		JavaUtility j=new JavaUtility();
		String ScreenshotName=metohdName+"-"+j.getSystemDateInFormat();
		
		
			try {
				s.captureScreenShot(BaseClass.driver, ScreenshotName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		}
	}
	
	
	

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
	
		System.out.println("Suite Execution started");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Suite Execution finished");
	}

	
	

	

}
