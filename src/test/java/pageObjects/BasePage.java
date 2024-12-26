package pageObjects;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.IOException;

public class BasePage implements ITestListener {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        // we will add, into the constructor, the page factory, once.
        PageFactory.initElements(driver, this);
    }

    public void fillTesxt(WebElement el, String text) {
        highlightElement(el, "yellow");
        el.clear();
        el.sendKeys(text);
    }

    public void click(WebElement el) {
        highlightElement(el, "yellow");
        el.click();
    }

    public String getText(WebElement el) {
        highlightElement(el, "yellow");
        return el.getText();
    }

    public void sleep(long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    private void highlightElement(WebElement element, String color) {
        //keep the old style to change it back
        String originalStyle = element.getAttribute("style");
        String newStyle = "background-color: yellow;border: 1px solid " + color + ";" + originalStyle;
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Change the style
        js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '" + newStyle + "');},0);",
                element);

        // Change the style back after few miliseconds
        js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
                + originalStyle + "');},400);", element);

    }



//    @AfterMethod
//    public void onTestFailure(ITestResult result) {
//        if (result.getStatus() == ITestResult.FAILURE) {
//            TakesScreenshot ts = (TakesScreenshot) driver;
//            File srcFile = ts.getScreenshotAs(OutputType.FILE);
//            try {
//                FileUtils.copyFile(srcFile, new File("./ScreenShots/" + result.getName() + ".jpg"));
//                System.out.println("Screenshot saved for test case: " + result.getName());
//            } catch (IOException e) {
//                System.err.println("Failed to save screenshot: " + e.getMessage());
//            }
//        }
//    }


}
