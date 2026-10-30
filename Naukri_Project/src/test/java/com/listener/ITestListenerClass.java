package com.listener;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.base.Base_Class;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class ITestListenerClass extends Base_Class implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        try {
            ExtentReport_Test.extenttest.pass(result.getMethod().getMethodName() + " : " + "Test Pass",
                    MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot1()).build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            ExtentReport_Test.extenttest.fail(result.getMethod().getMethodName() + " : " + "Test Fail",
                    MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot1()).build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
