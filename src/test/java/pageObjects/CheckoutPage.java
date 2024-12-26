package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {
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
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void fillInfoAndContinue(String firstNameValue, String lastNameValue, String zipCode) throws InterruptedException {
        fillText(firstNameField, firstNameValue);
        fillText(lastNameField, lastNameValue);
        fillText(postalCodeField, zipCode);
        click(continueButton);
        sleep(1500);
    }

    public void cancel() {
        click(cancelButton);
    }
}
