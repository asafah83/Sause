package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestListener;

import java.time.Duration;
import java.util.List;

public class BasePage implements ITestListener {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        // we will add, into the constructor, the page factory, once.
        PageFactory.initElements(driver, this);
    }

    public void waitForElement(WebElement el) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(el));
    }
    public void selectSpecificValueFromList(String element, String textValue) {
        List<WebElement> list = driver.findElements(By.cssSelector(element));
        for (WebElement el : list) {
            waitForElement(el);
            if (el.getText().equalsIgnoreCase(textValue)) {
                click(el);
                break;
            }
        }
    }
    public void fillText(WebElement el, String text) {
        waitForElement(el);
        highlightElement(el, "yellow");
        el.clear();
        el.sendKeys(text);
    }

    public void click(WebElement el) {
        waitForElement(el);
        highlightElement(el, "yellow");
        el.click();
    }

    public String getText(WebElement el) {
        waitForElement(el);
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
    public void getAlertOk() {
        driver.switchTo().alert().accept(); // click OK in alert
    }

    public void getAlertCancel() {
        driver.switchTo().alert().dismiss(); // click cancel in alert
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

//    public void assertion(WebElement element, String actualValue, String expectedValue) {
//        actualValue = getText(element);
//        Assert.assertEquals(actualValue, expectedValue);
//    }


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
