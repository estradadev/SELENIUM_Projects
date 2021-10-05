package Test;

import org.testng.ITestListener;
import org.testng.ITestResult;

//ITestListener interface which implements Testng listeners
public class Listeners implements ITestListener {
	
	@Override
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("Success execited Listeners Pass code");
		
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		//screenshot code
		//response if API is failed
		System.out.println("Failure execited Listeners Pass code " + result.getName());
		
	}	

}
