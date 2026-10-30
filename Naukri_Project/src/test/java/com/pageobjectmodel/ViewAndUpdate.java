package com.pageobjectmodel;

import com.base.Base_Class;
import com.interfaceelements.ViewAndUpdateInterfaceElements;
import com.utility.ExcelUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ViewAndUpdate extends Base_Class implements ViewAndUpdateInterfaceElements {

    @FindBy(xpath = profileButton_xpath)
    public static WebElement profileButton;

    @FindBy(xpath = viewAndUpdateButton_xpath)
    public static WebElement viewAndUpdateButton;

    @FindBy(xpath=title_xpath)
    public static WebElement title;

    @FindBy(xpath=text_xpath)
    public static WebElement text;


    public ViewAndUpdate() {
        PageFactory.initElements(driver,this);
    }

    public static void viewAndUpdate() throws IOException, InterruptedException {

        implicitlyWait(10);
        elementClick(profileButton);
        elementClick(viewAndUpdateButton);
        Thread.sleep(2000);
        validation(title, ExcelUtility.getCellValue("DATA","ID","Title"));
    }
}
