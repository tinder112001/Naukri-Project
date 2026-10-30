package com.pageobjectmodel;

import com.base.Base_Class;
import com.interfaceelements.PersonalDetailsInterfaceElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalDetails extends Base_Class implements PersonalDetailsInterfaceElements {

    @FindBy(xpath = editButton_xpath)
    public static WebElement editButton;

    @FindBy(xpath = gender_xpath)
    public static WebElement gender;

    @FindBy(xpath = maritalStatus_xpath)
    public static WebElement maritalStatus;

    @FindBy(id = dobDD_id)
    public static WebElement dobDD;

    @FindBy(id = dobMM_id)
    public static WebElement dobMM;

    @FindBy(id = dobYYYY_id)
    public static WebElement dobYYYY;

    @FindBy(id = workPermit_id)
    public static WebElement workPermit;

    @FindBy(id = permanentAddress_id)
    public static WebElement permanentAddress;

    @FindBy(id = homeTown_id)
    public static WebElement homeTown;

    @FindBy(id = pincode_id)
    public static WebElement pincode;

    @FindBy(xpath = addLanguage_xpath)
    public static WebElement addLanguage;

    @FindBy(xpath = selectLanguage_xpath)
    public static WebElement selectLanguage;

    @FindBy(xpath = selectProiciency_xpath)
    public static WebElement selectProiciency;

    @FindBy(xpath = readCheckBox_xpath)
    public static WebElement readCheckBox;

    @FindBy(xpath = writeCheckBox_xpath)
    public static WebElement writeCheckBox;

    @FindBy(xpath = speakCheckBox_xpath)
    public static WebElement speakCheckBox;

    @FindBy(xpath = saveButton_xpath)
    public static WebElement saveButton;

    public PersonalDetails() {
        PageFactory.initElements(driver,this);
    }

    public static void personalDetails() throws InterruptedException {
        implicitlyWait(10);
        elementClick(editButton);
        Thread.sleep(2000);
        isSelected(gender);
        isSelected(maritalStatus);
        elementClick(dobDD);
        passInput(dobDD,"8");
        actionsArrowKey(dobDD,"down",1);
        actionsPressEnter();
        elementClick(dobMM);
        passInput(dobMM,"sep");
        actionsArrowKey(dobMM,"down",1);
        actionsPressEnter();
        elementClick(dobYYYY);
        passInput(dobYYYY,"2000");
        actionsArrowKey(dobYYYY,"down",1);
        actionsPressEnter();
        elementClick(workPermit);
        passInput(workPermit,"india");
        actionsArrowKey(workPermit,"down",1);
        actionsPressEnter();
        clear(permanentAddress);
        passInput(permanentAddress,"saligramam");
        clear(homeTown);
        passInput(homeTown,"chennai");
        clear(pincode);
        passInput(pincode,"600093");
        elementClick(addLanguage);
        elementClick(selectLanguage);
        passInput(selectLanguage,"english");
        actionsArrowKey(selectLanguage,"down",1);
        actionsPressEnter();
        elementClick(selectProiciency);
        passInput(selectProiciency,"expert");
        actionsArrowKey(selectProiciency,"down",1);
        actionsPressEnter();
        isSelected(readCheckBox);
        isSelected(writeCheckBox);
        isSelected(speakCheckBox);
        elementClick(saveButton);



    }
}
