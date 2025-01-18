package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CheckoutOverviewPage extends BasePage {
    @FindBy(css = "#finish")
    WebElement finishButton;
    @FindBy(css = "#cancel")
    WebElement cancelButton;
    @FindBy(css = "[class='title']")
    WebElement overviewPageTitle;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on the 'Finish' button")
    public void clickFinish() {
        sleep(500);
        click(finishButton);
    }

    @Step("Click on the 'Cancel' button")
    public void clickCancel() {
        click(finishButton);
    }

    @Step("Verify that this is the Overview page")
    public void verifyPageTitle(String expectedPageTitle) {
        String actualPageTitle = getText(overviewPageTitle);
        Assert.assertEquals(actualPageTitle, expectedPageTitle);
    }
}