package com.pageobjectmodel;

import com.base.Base_Class;
import com.interfaceelements.KeySkillsInterfaceElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KeySkills extends Base_Class implements KeySkillsInterfaceElements {

    @FindBy (xpath =keySkillButton_xpath)
    public static WebElement keySkillButton;

    @FindBy (xpath =addSkills_xpath)
    public static WebElement addSkills;

    @FindBy (xpath =saveButton_xpath)
    public static WebElement saveButton;


    public KeySkills() {
        PageFactory.initElements(driver,this);
    }

    public static void keySkills() throws InterruptedException {

        implicitlyWait(10);
        elementClick(keySkillButton);
        passInput(addSkills,"Mysql");
        actionsArrowKey(addSkills,"down",1);
        actionsPressEnter();
        elementClick(saveButton);
        //scroll("down");

    }
}
