package com.pageobjectmodel;

import com.base.Base_Class;
import org.openqa.selenium.support.PageFactory;

public class TerminateBrowser extends Base_Class {


    public TerminateBrowser() {
        PageFactory.initElements(driver,this);
    }

    public static void terminateBrowser(){
        driver.quit();
    }
}
