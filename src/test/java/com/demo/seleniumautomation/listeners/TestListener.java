package com.demo.seleniumautomation.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.demo.seleniumautomation.utils.ExtentManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class TestListener implements ITestListener {

    private static final ExtentReports extent = ExtentManager.getExtentReports();
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        //Start Execution
        System.out.println("Test Suite Started: " + context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        String description = result.getMethod().getDescription();

        ExtentTest extentTest = extent.createTest(testName, description);
        extentTest.assignCategory(result.getTestClass().getName());

        test.set(extentTest);

        test.get().info("Test Started: " + testName);

        //Logging parameters
        if (result.getParameters().length > 0) {
            test.get().info("Parameters: " + Arrays.toString(result.getParameters()));
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail("Test FAILED");
        test.get().fail(result.getThrowable()); // logs stacktrace
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("Test SKIPPED");
        if (result.getThrowable() != null) {
            test.get().skip(result.getThrowable());
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush(); //Writes report
        System.out.println("Test Suite Finished: " + context.getName());
    }
}