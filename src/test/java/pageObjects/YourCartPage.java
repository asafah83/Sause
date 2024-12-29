package pageObjects;

import io.qameta.allure.Step;
import org.aspectj.apache.bcel.generic.FieldGen;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class YourCartPage extends BasePage {
    @FindBy(css = "#checkout")
    WebElement checkoutButton;
    @FindBy(css = ".btn.btn_secondary.btn_small.cart_button")
    WebElement removeButton;
    @FindBy(css = "#continue-shopping")
    WebElement continueShoppingButton;
    @FindBy(css = "[class='title']")
    WebElement yourCartPageTitle;

    public YourCartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on the 'Checkout' button")
    public void clickCheckOut() throws InterruptedException {
        click(checkoutButton);
        sleep(500);
    }

    @Step("Click on the 'Continue Shopping' button")
    public void clickContinueShopping() {
        click(continueShoppingButton);
    }

    @Step("Click on the 'Remove' button")
    public void clickRemove() {
        click(removeButton);
    }

    @Step("Verify that you are in the 'Your Cart' page")
    public void verifyPageTitle(String expectedPageTitle) {
        String actualPageTitle = getText(yourCartPageTitle);
        Assert.assertEquals(actualPageTitle, expectedPageTitle);
    }

}
