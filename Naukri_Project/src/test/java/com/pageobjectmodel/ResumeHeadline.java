package com.pageobjectmodel;

import com.base.Base_Class;
import com.interfaceelements.ResumeHeadlineInterfaceElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResumeHeadline extends Base_Class implements ResumeHeadlineInterfaceElements {


    @FindBy(xpath = resumeHeadlineButton_xpath)
    public static WebElement resumeHeadlineButton;

    @FindBy(name = resumeHeadlineText_name)
    public static WebElement resumeHeadlineText;

    @FindBy(xpath = saveButton_xpath)
    public static WebElement saveButton;

    @FindBy(xpath = closeButton_xpath)
    public static WebElement closeButton;



    public ResumeHeadline() {
        PageFactory.initElements(driver,this);
    }

    public static void resumeHeadline() throws InterruptedException {
        //implicitlyWait(10);

        elementClick(resumeHeadlineButton);
        clear(resumeHeadlineText);
        passInput(resumeHeadlineText,"Software Engineer with MCA currently living in Chennai");
        elementClick(saveButton);
        Thread.sleep(5);
        handlePopup(closeButton);
        //elementClick(closeButton);

    }
}
