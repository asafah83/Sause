package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CheckoutCompletePage extends BasePage {
    @FindBy(css = "[id='back-to-products']")
    WebElement backToProductButton;
    @FindBy(css = "[class='title']")
    WebElement checkoutCompletedPageTitle;
//    @FindBy(css = "")
//    WebElement el;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public void printAllMessage() {
        String thanksMessage = getText(driver.findElement(By.cssSelector(".complete-header")));
        String orderMessage = getText(driver.findElement(By.cssSelector(".complete-text")));
        String completedMessage = getText(driver.findElement(By.cssSelector("title")));
        System.out.println(thanksMessage);
        System.out.println(orderMessage);
        System.out.println(completedMessage);
    }

    public void verifyPageTitle(String expectedPageTitle) {
        String actualPageTitle = getText(checkoutCompletedPageTitle);
        Assert.assertEquals(actualPageTitle, expectedPageTitle);
    }

    @Step("Click on the 'Back Home' button")
    public void backToHome() throws InterruptedException {
        click(backToProductButton);
        sleep(1500);
    }
}
