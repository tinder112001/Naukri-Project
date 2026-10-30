package com.pageobjectmodel;

import com.base.Base_Class;
import com.interfaceelements.EmployementInterfaceElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployementUpdate extends Base_Class implements EmployementInterfaceElements {

    @FindBy(xpath = employementEditButton_xpath)
    public static WebElement employementEditButton;

    @FindBy(xpath = companyName_xpath)
    public static WebElement companyName;

    @FindBy(xpath = jobTitle_xpath)
    public static WebElement jobTitle;

    @FindBy(xpath = joiningDate_xpath)
    public static WebElement joiningDate;

    @FindBy(xpath = joiningMonth_xpath)
    public static WebElement joiningMonth;

    @FindBy(xpath = endingDate_xpath)
    public static WebElement endingDate;

    @FindBy(xpath = endingMonth_xpath)
    public static WebElement endingMonth;

    @FindBy(id = jobProfile_id)
    public static WebElement jobProfile;

    @FindBy(id = saveButton_id)
    public static WebElement saveButton;

    public EmployementUpdate() {
        PageFactory.initElements(driver,this);
    }

    public static void employementUpdate() throws InterruptedException {
        implicitlyWait(10);
        elementClick(employementEditButton);
        clear(companyName);
        Thread.sleep(2000);
        passInput(companyName,"zoho");
        Thread.sleep(2000);
        actionsArrowKey(companyName,"down",1);
        actionsPressEnter();
        clear(jobTitle);
        passInput(jobTitle,"Software Tester");
        Thread.sleep(2000);
        actionsArrowKey(jobTitle,"down",1);
        actionsPressEnter();
        passInput(joiningDate,"2023");
        actionsArrowKey(joiningDate,"down",1);
        actionsPressEnter();
        passInput(joiningMonth,"Jan");
        actionsArrowKey(joiningMonth,"down",1);
        actionsPressEnter();
        passInput(endingDate,"2026");
        actionsArrowKey(endingDate,"down",1);
        actionsPressEnter();
        passInput(endingMonth,"Sep");
        actionsArrowKey(endingMonth,"down",1);
        actionsPressEnter();
        passInput(jobProfile,"Software Tester");
        elementClick(saveButton);

    }
}
