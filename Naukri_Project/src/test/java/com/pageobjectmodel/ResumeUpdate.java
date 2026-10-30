package com.pageobjectmodel;

import com.base.Base_Class;
import com.interfaceelements.ResumeUpdateInterfaceElements;
import com.pageobjectmanager.PageObjectManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ResumeUpdate extends Base_Class implements ResumeUpdateInterfaceElements {


    @FindBy(xpath =resumeUpdateButton_xpath )
    public static WebElement resumeUpdateButton;

    public ResumeUpdate() {
        PageFactory.initElements(driver,this);
    }

    public static void resumeUpdate() throws InterruptedException {
        elementClick(resumeUpdateButton);
        uploadFile(PageObjectManager.getPageObjectManager().getFileReaderManager().getProperty("Resume"));
    }
}
