package com.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Base_Class {
    public static WebDriver driver;

    public static ExtentReports extentReports;

    public static File file;

    protected static WebDriver launchBrowser(String browser){

        try{
            if(browser.equalsIgnoreCase(("chrome"))){
                driver = new ChromeDriver();
            } else if ((browser.equalsIgnoreCase(("edge")))) {
                driver = new EdgeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            }
        }
        catch (Exception e) {
            Assert.fail("ERROR: OCCURE DURING THE BROWSER LAUNCH");
        }
        return driver;

    }

    protected static void launchURL(String url){
        try{
            driver.get(url);
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURE DURING THE URL LAUNCH");
        }
    }

    protected static void passInput(WebElement element,String value){
        try{
            element.sendKeys(value);
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURE DURING THE VALUE PASSING");
        }
    }

//    protected static void elementClick(WebElement element){
//        try{
//            implicitlyWait(10);
//            element.click();
//        } catch (Exception e) {
//            Assert.fail("ERROR: OCCURE DURING THE ELEMENT CLICK");
//        }
//    }

    protected static void elementClick(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // 1. Scroll element into view first
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);

            // 2. Wait until it is clickable and click
            WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));
            clickableElement.click();

        } catch (Exception e) {
            // Fallback to JavaScript click if standard click gets intercepted
            try {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", element);
            } catch (Exception ex) {
                Assert.fail("ERROR: OCCURRED DURING THE ELEMENT CLICK: " + ex.getMessage());
            }
        }
    }

//    protected static void checkButton(WebElement element, String activeClassAttribute) {
//        try {
//            // 1. Get the class attribute of the element (for custom buttons/chips)
//            String classValue = element.getAttribute("class");
//
//            // 2. Check if it's already selected/active via class or standard isSelected() method
//            boolean isAlreadySelected = (classValue != null && classValue.contains(activeClassAttribute))
//                    || (element.isSelected());
//
//            if (!isAlreadySelected) {
//                element.click();
//                System.out.println("Element clicked and selected successfully.");
//            } else {
//                System.out.println("Element is already selected, skipping click.");
//            }
//        } catch (Exception e) {
//            Assert.fail("ERROR OCCURRED DURING THE ELEMENT CLICK: " + e.getMessage());
//        }
//    }

    protected static void browserTermination(){
        try{
            driver.quit();
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURE DURING THE BROWSER TERMINATION");
        }
    }

    protected static void browserClose(){
        try{
            driver.close();
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURE DURING THE BROWSER CLOSE");
        }
    }

    protected static void windowsHandling(int num){
        try{
            List<String> allwindows = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window((allwindows.get(num)));
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURE DURING THE WINDOWS HANDLING");
        }
    }

    protected static void selectOptions(WebElement element, String type, String value){
        Select select = new Select(element);
        try{
            if(type.equalsIgnoreCase("value")){
                select.selectByValue(value);
            } else if (type.equalsIgnoreCase("index")) {
                select.selectByIndex(Integer.parseInt(value));
            }else if (type.equalsIgnoreCase("visibletext")){
                select.selectByVisibleText(value);
            }
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURE DURING THE VALUE SELECTION");
        }
    }

    protected static void deselectOptions(WebElement element, String type, String value){
        Select select = new Select(element);
        try{
            if(type.equalsIgnoreCase("value")){
                select.deselectByValue(value);
            } else if (type.equalsIgnoreCase("index")) {
                select.deselectByIndex(Integer.parseInt(value));
            }else if (type.equalsIgnoreCase("visibletext")){
                select.deselectByVisibleText(value);
            }
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURE DURING THE VALUE DESELECTION");
        }
    }

    protected static void implicitlyWait(int num){
        try{
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(num));
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURE DURING THE IMPLICITLY WAIT");
        }
    }

    protected static void navigateTo(String url){
        try{
            driver.navigate().to(url);
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURE DURING THE NAVIGATE TO");
        }
    }

    protected static void navigateType(String type){
        try{
            if(type.equalsIgnoreCase("forward")){
                driver.navigate().forward();
            } else if (type.equalsIgnoreCase("back")) {
                driver.navigate().back();
            } else if (type.equalsIgnoreCase("refresh")) {
                driver.navigate().refresh();
            }

        } catch (Exception e) {
            Assert.fail("ERROR: OCCURE DURING THE NAVIGATE TYPE");
        }
    }

    protected static void alert(){

        try{
            Alert a=driver.switchTo().alert();
            a.accept();
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURE DURING THE ALERT HANDLING");
        }
    }

    protected static void promptAlert(String value, String type ){

        try{
            if(type.equalsIgnoreCase("accept")){
            Alert alert=driver.switchTo().alert();
            alert.sendKeys(value);
            alert.accept();
            } else if (type.equalsIgnoreCase("dismiss")) {
                Alert alert=driver.switchTo().alert();
                alert.sendKeys(value);
                alert.dismiss();
            }
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURE DURING THE PromptAlert HANDLING");
        }
    }

    protected static void actionsType(WebElement element,String type){

        Actions action=new Actions(driver);
        try{
            if(type.equalsIgnoreCase("click")){
                action.click(element).build().perform();
            } else if (type.equalsIgnoreCase("double click")){
                action.doubleClick(element).build().perform();
            } else if (type.equalsIgnoreCase("right click")){
                action.contextClick(element).build().perform();
            }

        } catch (Exception e) {
            Assert.fail("ERROR: OCCURE DURING THE ACTIONS TYPE");
        }
    }

    protected static void actionsSendKeysAndEnter(WebElement element, String text) {
        Actions action = new Actions(driver);
        try {
            action.sendKeys(element, text).sendKeys(Keys.ENTER).build().perform();
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURE DURING SENDKEYS AND ENTER ACTION");
        }
    }

    protected static void actionsArrowKey(WebElement element, String direction, int times) {
        Actions action = new Actions(driver);
        try {
            Keys keyToPress = null;

            if (direction.equalsIgnoreCase("up")) {
                keyToPress = Keys.ARROW_UP;
            } else if (direction.equalsIgnoreCase("down")) {
                keyToPress = Keys.ARROW_DOWN;
            } else if (direction.equalsIgnoreCase("left")) {
                keyToPress = Keys.ARROW_LEFT;
            } else if (direction.equalsIgnoreCase("right")) {
                keyToPress = Keys.ARROW_RIGHT;
            }

            if (keyToPress != null) {
                for (int i = 0; i < times; i++) {
                    if (element != null) {
                        action.sendKeys(element, keyToPress).build().perform();
                    } else {
                        action.sendKeys(keyToPress).build().perform();
                    }
                }
            }

        } catch (Exception e) {
            Assert.fail("ERROR: OCCURE DURING THE ARROW KEY ACTIONS");
        }
    }

    protected static void actionsPressEnter() {
        Actions action = new Actions(driver);
        try {
            action.sendKeys(Keys.ENTER).build().perform();
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURE DURING THE ENTER KEY ACTION");
        }
    }

    protected static void dragAndDrop(WebElement source, WebElement target){

        Actions action=new Actions(driver);
        try{
            action.dragAndDrop(source,target).build().perform();

        } catch (Exception e) {
            Assert.fail("ERROR: OCCURE DURING THE dragAndDrop");
        }
    }

    protected static void getCurrentURL(){

        try{
            String currentURL=driver.getCurrentUrl();
            System.out.println("Current URL: "+currentURL);

        } catch (Exception e) {
            Assert.fail("ERROR: OCCURE DURING THE GET CURRENT URL");
        }
    }

    protected static void getTitle(){

        try{
            String title=driver.getTitle();
            System.out.println("Title: "+title);

        } catch (Exception e) {
            Assert.fail("ERROR: OCCURE DURING THE GET TITLE ");
        }
    }

    protected static void getText(WebElement element){

        try{
            String text=element.getText();
            System.out.println("Text: "+text);


        } catch (Exception e) {
            Assert.fail("ERROR: OCCURE DURING THE GET TEXT ");
        }
    }

    protected static void checkBox(WebElement element){

        try{
            if(!element.isSelected()) {
                element.click();
            }
            else{
                System.out.println(" Checkbox is already selected");
            }

        } catch (Exception e) {
            Assert.fail("ERROR: OCCURE DURING THE CHECKBOX ");
        }
    }

    protected static void takeScreenShot(String name){
        TakesScreenshot ts = (TakesScreenshot) driver;
        try{
            String dateTime = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date());
            File source=ts.getScreenshotAs(OutputType.FILE);
            File destination=new File("C:\\Users\\gbala\\IdeaProjects\\Naukri_Project\\Screenshot\\"+name+dateTime+".png");
            FileHandler.copy(source,destination);
        }
        catch (Exception e) {
            Assert.fail("ERROR: OCCURE DURING THE SCREENSHOT ");
        }

    }

    protected static void screenSize(String type){
        try{
            if(type.equalsIgnoreCase("maximize")){
                driver.manage().window().maximize();
            } else if (type.equalsIgnoreCase("minimize")) {
                driver.manage().window().minimize();
            }
        }
        catch (Exception e) {
            Assert.fail("ERROR: OCCURE DURING THE SCREEN SIZE ");
        }
    }

    protected static void radioButton(WebElement element) {
        try {
            if (!element.isSelected()) {
                element.click();
            }
            else{
                System.out.println("Radio Button is already selected");
            }
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURE DURING RADIO BUTTON SELECTION");
        }
    }

    protected static void isSelected(WebElement element) {
        try {
            if (!element.isSelected()) {
                element.click();
            }
            else{
                System.out.println("isSelected is already selected");
            }
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURE DURING ISSELECTED");
        }
    }

    protected static void isMultiple(WebElement element){
        try {
            element.clear();;
            }
         catch (Exception e) {
            Assert.fail("ERROR: OCCURE DURING ISSELECTED");
        }
    }
    protected static void clear(WebElement element){
        try{
            element.clear();
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURE DURING THE GET CLEAR ");
        }
    }

    protected static void isDisplayed(WebElement element){
        try{
            element.isDisplayed();
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURE DURING THE ISDISPLAYED ");
        }
    }

    protected static void isEnable(WebElement element){
        try{
            element.isEnabled();
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURE DURING THE ISENABLE ");
        }
    }

    protected static void frame(String type, WebElement element, int index, String name) {
        try {
            if (type.equalsIgnoreCase("switchtoframebyelement")) {
                driver.switchTo().frame(element);
            } else if (type.equalsIgnoreCase("switchtoframebyindex")) {
                driver.switchTo().frame(index);
            } else if (type.equalsIgnoreCase("switchtoframebyname")) {
                driver.switchTo().frame(name);
            }
        } catch (Exception e) {
            Assert.fail("ERROR : OCCURE DURING FRAME ");
        }
    }

    protected static void scroll(String type) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            if (type.equalsIgnoreCase("scrolldown")) {
                js.executeScript("window.scrollBy(0,1000);");
            } else if (type.equalsIgnoreCase("scrollup")) {
                js.executeScript("window.scrollBy(0,-2000);");
            }
        } catch (Exception e) {
            Assert.fail("ERROR : OCCURE DURING SCROLL");
        }
    }

    protected static void validation(WebElement element,String excepted){
        try {
            String text=element.getText();
            System.out.println(text);
            Assert.assertEquals(excepted,element.getText());

        } catch (Exception e) {
            Assert.fail("ERROR : OCCURE DURING THE VALIDATION");
        }

    }

    public static void extentReportStart(String location) {
        extentReports = new ExtentReports();
        file = new File(location);
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
        extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
    }

    public static void extentReportTearDown(String location) throws IOException {
        extentReports.flush();
        file = new File(location);
        Desktop.getDesktop().browse(file.toURI());
    }

    public String takeScreenshot1() throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File scrfile = screenshot.getScreenshotAs(OutputType.FILE);
        File destfile = new File("Screenshot\\.png" + "_"+timeStamp + ".png");
        FileHandler.copy(scrfile, destfile);
        return destfile.getAbsolutePath();

    }

    protected static void uploadFile(String filePath) {

        try {
            Robot r=new Robot();
            StringSelection ss=new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
            r.delay(2000);
            r.keyPress(KeyEvent.VK_CONTROL);
            r.keyPress(KeyEvent.VK_V);
            r.keyRelease(KeyEvent.VK_V);
            r.keyRelease(KeyEvent.VK_CONTROL);
            r.delay(2000);
            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
            System.out.println("File uploaded successfully: " + filePath);
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURE DURING THE FILE UPLOAD " );
        }
    }

    protected static void handlePopup(WebElement element) {
        try {
            // Use a very short wait so it doesn't slow down tests if there's no popup
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(element));
            closeButton.click();
            System.out.println("Popup closed successfully.");
        } catch (Exception e) {
            // If no popup appears within 3 seconds, it safely ignores it and continues
            System.out.println("No popup found or already closed.");
        }
    }




}
