package com.pageobjectmodel;

import com.base.Base_Class;
import com.interfaceelements.LogoutInterfaceElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout extends Base_Class implements LogoutInterfaceElements {

    @FindBy(xpath = profileButton_xpath)
    public static WebElement profileButton;

    @FindBy(xpath = logout_xpath)
    public static WebElement logout;

    public Logout() {
        PageFactory.initElements(driver,this);
    }

    public static void logout(){
        elementClick(profileButton);
        elementClick(logout);
    }
}
