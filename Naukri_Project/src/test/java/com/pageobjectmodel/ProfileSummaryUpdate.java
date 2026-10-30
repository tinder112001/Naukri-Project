package com.pageobjectmodel;

import com.base.Base_Class;
import com.interfaceelements.ProfileSummaryInterfaceElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfileSummaryUpdate extends Base_Class implements ProfileSummaryInterfaceElements {
    @FindBy(xpath = editButton_xpath)
    public static WebElement editButton;

    @FindBy(id = textArea_id)
    public static WebElement textArea;

    @FindBy(xpath = saveButton_xpath)
    public static WebElement saveButton;

    @FindBy(xpath = closeButton_xpath)
    public static WebElement closeButton;


    public ProfileSummaryUpdate() {
        PageFactory.initElements(driver,this);
    }
    public static void profileSummaryUpdate(){
        implicitlyWait(10);
        elementClick(editButton);
        clear(textArea);
        passInput(textArea,"Profile Synopsis Detail-oriented Software Engineer with hands-on experience in designing, developing, and testing scalable WCF service applications for mobile and enterprise systems using C# and SQL Server. Skilled in API validation with Postman, backend development in Visual Studio, and optimizing SQL stored procedures for performance and data accuracy. Proven ability to collaborate with cross-functional teams to troubleshoot issues, improve system reliability, and streamline backend data workflows. Passionate about delivering high- quality, efficient solutions in fast-paced, agile environments. Professional Summary About 1.3 years of experience in RESTful APIs, HTML, XML and JSON Web Services Testing Postman, Visual Studio, Microsoft SQL Server in Dattice Computer Consultancy. Designed and executed comprehensive API test collections in Postman, using JSON format to validate WCF service endpoints supporting C# mobile applications. Collaborated with mobile and backend teams to trouble");
        elementClick(saveButton);
        scroll("scrolldown");
        handlePopup(closeButton);
    }
}
