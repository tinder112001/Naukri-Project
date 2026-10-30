package com.pageobjectmodel;

import com.base.Base_Class;
import com.interfaceelements.LoginPageInterfaceElements;
import com.pageobjectmanager.PageObjectManager;
import com.utility.ExcelUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends Base_Class implements LoginPageInterfaceElements {

    @FindBy(id=username_id)
    public static WebElement username;

    @FindBy(id=password_id)
    public static WebElement password;

    @FindBy(xpath=loginbutton_xpath)
    public static WebElement loginButton;


    public LoginPage() {
        PageFactory.initElements(driver,this);
    }

    public static void validLogin() throws IOException, InterruptedException {

        implicitlyWait(10);
        screenSize("maximize");
        passInput(username, PageObjectManager.getPageObjectManager().getFileReaderManager().getProperty("username"));
        passInput(password, PageObjectManager.getPageObjectManager().getFileReaderManager().getProperty("password"));
        elementClick(loginButton);
    }
}
