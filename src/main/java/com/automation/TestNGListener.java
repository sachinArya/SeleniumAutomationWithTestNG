package com.automation;

import com.enums.TestSummary;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.ArrayList;

public class TestNGListener implements ITestListener {

    ArrayList<TestSummary> passedTest = new ArrayList<>();
    ArrayList<TestSummary> failedTest = new ArrayList<>();
    ArrayList<TestSummary> skippedTest = new ArrayList<>();


    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestContext testContext = result.getTestContext();
        testContext.getCurrentXmlTest().getSuite().getName();

        passedTest.add(new TestSummary(result.getMethod().getDescription(),
                result.getTestClass().toString(),
                result.getMethod().getMethodName(),
                (result.getStartMillis()-result.getEndMillis())/1000,
                "PASS",
                testContext.getCurrentXmlTest().getSuite().getName(),
                testContext.getCurrentXmlTest().getSuite().getFileName()));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestContext testContext = result.getTestContext();
        testContext.getCurrentXmlTest().getSuite().getName();

        failedTest.add(new TestSummary(result.getMethod().getDescription(),
                result.getTestClass().toString(),
                result.getMethod().getMethodName(),
                (result.getStartMillis()-result.getEndMillis())/1000,
                "FAIL",
                testContext.getCurrentXmlTest().getSuite().getName(),
                testContext.getCurrentXmlTest().getSuite().getFileName()));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestContext testContext = result.getTestContext();
        testContext.getCurrentXmlTest().getSuite().getName();

        skippedTest.add(new TestSummary(result.getMethod().getDescription(),
                result.getTestClass().toString(),
                result.getMethod().getMethodName(),
                (result.getStartMillis()-result.getEndMillis())/1000,
                "SKIP",
                testContext.getCurrentXmlTest().getSuite().getName(),
                testContext.getCurrentXmlTest().getSuite().getFileName()));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
