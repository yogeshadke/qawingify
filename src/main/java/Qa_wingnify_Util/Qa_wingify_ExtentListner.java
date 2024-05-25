package Qa_wingnify_Util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Qa_wingify_ExtentListner implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getName() + " Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getName() + " Test Execute Successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getName() + " Test Failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(result.getName() + " Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println(result.getName() + " Test Failed but within success percentage");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println(context.getName() + " Started");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println(context.getName() + " Finished");
    }
}
