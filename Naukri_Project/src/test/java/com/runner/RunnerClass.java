package com.runner;

import com.base.Base_Class;
import com.listener.ExtentReport_Test;
import com.listener.ITestListenerClass;
import com.pageobjectmanager.PageObjectManager;
import org.testng.annotations.*;

import java.io.IOException;
@Listeners(ITestListenerClass.class)
public class RunnerClass extends Base_Class {

    @BeforeClass
    public void propertySetup() {
        launchBrowser(PageObjectManager.getPageObjectManager().getFileReaderManager().getProperty("browser"));
        launchURL(PageObjectManager.getPageObjectManager().getFileReaderManager().getProperty("url"));
    }

    @Test(priority = 1)
    public void validLoginTest() throws InterruptedException, IOException {
        ExtentReport_Test.extenttest = extentReports.createTest("Valid Login Test" + " : " + Thread.currentThread().getStackTrace()[1].getMethodName().toString()).info("Naukri Web Application Testing");

        PageObjectManager.getPageObjectManager().getLoginPage().validLogin();
    }

    @Test(priority = 2)
    public void viewAndUpdateTest() throws IOException, InterruptedException {
        PageObjectManager.getPageObjectManager().getViewAndUpdate().viewAndUpdate();
    }

    @Test(priority = 3)
    public void resumeUpdateTest() throws InterruptedException {
        PageObjectManager.getPageObjectManager().getResumeUpdate().resumeUpdate();
    }

    @Test(priority = 4)
    public void resumeHeadlineTest() throws InterruptedException {
        PageObjectManager.getPageObjectManager().getResumeHeadline().resumeHeadline();
    }


    @Test(priority = 5)
    public void keySkillsTest() throws InterruptedException {
        PageObjectManager.getPageObjectManager().getKeySkills().keySkills();
    }

    @Test(priority = 6)
    public void employementUpdateTest() throws InterruptedException {
        PageObjectManager.getPageObjectManager().getEmployementUpdate().employementUpdate();
    }


    @Test(priority = 7)
    public void itSkillsUpdateTest() throws InterruptedException {
        PageObjectManager.getPageObjectManager().getItSkillsUpdate().itSkills();
    }

    @Test(priority = 8)
    public void profileSummaryUpdateTest() throws InterruptedException {
        PageObjectManager.getPageObjectManager().getProfileSummaryUpdate().profileSummaryUpdate();
    }

    @Test(priority = 9)
    public void personalDetailsUpdateTest() throws InterruptedException {
        PageObjectManager.getPageObjectManager().getPersonalDetails().personalDetails();
    }

    @Test(priority = 10)
    public void logoutTest() throws InterruptedException {
        PageObjectManager.getPageObjectManager().getLogout().logout();
    }


    @AfterClass
    public void terminateBrowserTest(){
        PageObjectManager.getPageObjectManager().getTerminateBrowser().terminateBrowser();

    }

//    @AfterClass()
//    public void terminateBrowser() {
//        browserTermination();
//    }

    @BeforeSuite
    public void extentReportStart() {
        extentReportStart(PageObjectManager.getPageObjectManager().getFileReaderManager().getProperty("start"));
    }

    @AfterSuite
    public void extentReportEnd() throws IOException {
        extentReportTearDown(PageObjectManager.getPageObjectManager().getFileReaderManager().getProperty("end"));
    }

}
