package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import utils.Utils;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    WebDriver driver;
    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Utils.readProperty("url"));
    }
 //   @BeforeClass
//    public void setup() {
//        //System.setProperty("Webdriver.chrome.driver","C:\\Automation\\drivers");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//       // Utils utils = new Utils(); its because we made the Utils method as static
//        driver.get(Utils.readProperty("url"));
//    }


    @AfterClass
    public void tearDown() throws InterruptedException {
        driver.quit();
        Thread.sleep(1500);
    }
    /*
     * This method will run after each test,
     * it will take screenshot only for tests that failed
     */
    @AfterMethod
    public void onTestFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File srcFile = ts.getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(srcFile, new File("./ScreenShots/" + result.getName() + ".jpg"));
                System.out.println("Screenshot saved for test case: " + result.getName());
            } catch (IOException e) {
                System.err.println("Failed to save screenshot: " + e.getMessage());
            }
        }
    }
}
