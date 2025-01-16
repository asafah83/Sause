package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage {
    @FindBy(css = "#user-name")
    WebElement userNameField;
    @FindBy(css = "#password")
    WebElement passwordField;
    @FindBy(css = "[type='submit']")
    WebElement submitButton;
    @FindBy(css = "[data-test='error']")
    WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String userNameValue, String passwordValue) throws InterruptedException {
        fillText(userNameField, userNameValue);
        fillText(passwordField, passwordValue);
        click(submitButton);
        sleep(1500);
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }
    public void verifyTheErrorMessage(String expectedMessage) {
        String actualMessage = getText(errorMessage);
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}




