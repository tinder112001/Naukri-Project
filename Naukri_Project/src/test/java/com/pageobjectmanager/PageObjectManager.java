package com.pageobjectmanager;

import com.interfaceelements.ResumeUpdateInterfaceElements;
import com.pageobjectmodel.*;
import com.utility.FileReaderManager;

public class PageObjectManager {



    private FileReaderManager fileReaderManager;
    private static PageObjectManager pageObjectManager;
    public LoginPage loginPage;
    public ResumeHeadline resumeHeadline;
    public ResumeUpdate resumeUpdate;
    public KeySkills keySkills;
    public EmployementUpdate employementUpdate;
    public ITSkillsUpdate itSkillsUpdate;
    public ProfileSummaryUpdate profileSummaryUpdate;
    public PersonalDetails personalDetails;
    public Logout logout;
    public TerminateBrowser terminateBrowser;

    public TerminateBrowser getTerminateBrowser() {
        if(terminateBrowser==null){
            terminateBrowser=new TerminateBrowser();
        }
        return terminateBrowser;
    }




    public Logout getLogout() {
        if(logout==null){
            logout=new Logout();
        }
        return logout;
    }



    public PersonalDetails getPersonalDetails() {
        if(personalDetails==null){
            personalDetails=new PersonalDetails();
        }
        return personalDetails;
    }



    public ProfileSummaryUpdate getProfileSummaryUpdate() {
        if(profileSummaryUpdate==null){
            profileSummaryUpdate=new ProfileSummaryUpdate();
        }
        return profileSummaryUpdate;
    }



    public ITSkillsUpdate getItSkillsUpdate() {
        if(itSkillsUpdate==null){
            itSkillsUpdate=new ITSkillsUpdate();
        }
        return itSkillsUpdate;
    }



    public EmployementUpdate getEmployementUpdate() {
        if(employementUpdate==null){
            employementUpdate=new EmployementUpdate();
        }
        return employementUpdate;
    }



    public HeadlineCloseButton getHeadlineCloseButton() {
        if(headlineCloseButton==null){
            headlineCloseButton=new HeadlineCloseButton();
        }
        return headlineCloseButton;
    }

    public HeadlineCloseButton headlineCloseButton;

    public ViewAndUpdate getViewAndUpdate() {
        if(viewAndUpdate==null){
            viewAndUpdate=new ViewAndUpdate();
        }
        return viewAndUpdate;
    }

    public ViewAndUpdate viewAndUpdate;




    public KeySkills getKeySkills() {
        if(keySkills==null){
            keySkills=new KeySkills();
        }
        return keySkills;
    }



    public ResumeUpdate getResumeUpdate() {
        if(resumeUpdate==null){
            resumeUpdate=new ResumeUpdate();
        }
        return resumeUpdate;
    }




    public ResumeHeadline getResumeHeadline() {
        if(resumeHeadline==null){
            resumeHeadline=new ResumeHeadline();
        }
        return resumeHeadline;
    }




    public FileReaderManager getFileReaderManager() {
        if (fileReaderManager == null) {
        fileReaderManager = new FileReaderManager();
    }
        return fileReaderManager;
    }

    public static PageObjectManager getPageObjectManager() {
        if(pageObjectManager == null){
            pageObjectManager = new PageObjectManager();
        }
        return pageObjectManager;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }


}
