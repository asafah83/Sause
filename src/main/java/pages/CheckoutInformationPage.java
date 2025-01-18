package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CheckoutInformationPage extends BasePage {
    @FindBy(css = "#first-name")
    WebElement firstNameField;
    @FindBy(css = "#last-name")
    WebElement lastNameField;
    @FindBy(css = "#postal-code")
    WebElement postalCodeField;
    @FindBy(css = "#continue")
    WebElement continueButton;
    @FindBy(css = "#cancel")
    WebElement cancelButton;
    @FindBy(css = "[class='title']")
    WebElement pageTitle;

    public CheckoutInformationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Fill in the user's information")
    public void fillInformation(String firstNameValue, String lastNameValue, String zipCode) throws InterruptedException {
        fillText(firstNameField, firstNameValue);
        fillText(lastNameField, lastNameValue);
        fillText(postalCodeField, zipCode);
    }

    @Step("Verify the user in the 'Checkout: Your Information' page")
    public void verifyPageTitle(String expectedPageTitle) {
        String actualPageTitle = getText(pageTitle);
        Assert.assertEquals(actualPageTitle, expectedPageTitle);
    }

    @Step("Click the 'Continue' button")
    public void clickContinue() {
        click(continueButton);
        sleep(500);
    }

    @Step("Click the 'Cancel' button")
    public void cancel() {
        click(cancelButton);
    }
}
