package com.pageobjectmodel;

import com.base.Base_Class;
import com.interfaceelements.ITSkillsInterfaceElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ITSkillsUpdate extends Base_Class implements ITSkillsInterfaceElements {

    @FindBy(xpath = itSkillEditButton_xpath)
    public static WebElement itSkillEditButton;

    @FindBy(id = softwareName_id)
    public static WebElement softwareName;

    @FindBy(xpath = softwareVersion_xpath)
    public static WebElement softwareVersion;

    @FindBy(xpath = lastUsed_xpath)
    public static WebElement lastUsed;

    @FindBy(xpath = experience_xpath)
    public static WebElement experience;

    @FindBy(xpath = months_xpath)
    public static WebElement months;

    @FindBy(xpath = saveButton_xpath)
    public static WebElement saveButton;

    public ITSkillsUpdate() {
        PageFactory.initElements(driver,this);
    }

    public static void itSkills() throws InterruptedException {
        implicitlyWait(10);
        elementClick(itSkillEditButton);
        Thread.sleep(2000);
        passInput(softwareName,"java");
        actionsArrowKey(softwareName,"down",1);
        actionsPressEnter();
        Thread.sleep(2000);
        passInput(softwareVersion,"4.11");
        passInput(lastUsed,"2023");
        Thread.sleep(2000);
        actionsArrowKey(lastUsed,"down",1);
        actionsPressEnter();
        passInput(experience,"2 years");
        Thread.sleep(2000);
        actionsArrowKey(experience,"down",1);
        actionsPressEnter();
        passInput(months,"2 Months");
        Thread.sleep(2000);
        actionsArrowKey(months,"down",1);
        actionsPressEnter();
        elementClick(saveButton);
    }
}
