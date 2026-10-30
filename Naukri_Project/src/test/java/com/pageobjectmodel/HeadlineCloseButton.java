package com.pageobjectmodel;

import com.base.Base_Class;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeadlineCloseButton extends Base_Class implements com.interfaceelements.HeadlineCloseButton {
    @FindBy(xpath = closeButton_xpath)
    public static WebElement closeButton;

    public HeadlineCloseButton() {
        PageFactory.initElements(driver,this);
    }
    public static void headlineCloseButton(){
        implicitlyWait(10);
        elementClick(closeButton);
    }
}
